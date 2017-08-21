package com.len.constellation;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.len.constellation.adapter.ConstellationAdapter;
import com.len.constellation.db.ConstellationLoveImpl;
import com.len.constellation.model.Constellation;
import com.len.constellation.model.ConstellationLove;
import com.len.constellation.model.ConstellationLoveInfo;
import com.len.constellation.utils.XmlPullParserUtil;
import com.len.constellation.widget.ConstellationLoveWidget;
import com.len.constellation.widget.ListViewForScrollView;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.tv_lucky_num)
    TextView tvLuckyNum;
    @BindView(R.id.tv_shortcoming)
    TextView tvShortcoming;
    @BindView(R.id.tv_merit)
    TextView tvMerit;
    @BindView(R.id.tv_performance)
    TextView tvPerformance;
    @BindView(R.id.tv_character)
    TextView tvCharacter;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.toolbar_layout)
    CollapsingToolbarLayout collapsingToolbarLayout;
    @BindView(R.id.iv_left)
    ImageView ivLeft;
    @BindView(R.id.iv_right)
    ImageView ivRight;
    @BindView(R.id.btn_pair)
    Button btnPair;
    @BindView(R.id.app_bar)
    AppBarLayout appBar;
    @BindView(R.id.lv_constellation)
    ListViewForScrollView lvConstellation;

    private ArrayList<Constellation> constellations;
    private ConstellationAdapter constellationAdapter;
    private ConstellationLove constellationLoveLeft;
    private ConstellationLove constellationLoveRight;
    private ArrayList<ConstellationLove> constellationLoves;
    private MyHandler myHandler;
    private boolean loveflag = true;
    private ScheduledExecutorService scheduledExecutorService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        myHandler = new MyHandler(this);
        initData();
        initEvent();
    }

    private void initData() {

        try {
            constellations = XmlPullParserUtil.readDataXml(getAssets().open("data.xml"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        int random = new Random().nextInt(12);
        if (constellations != null && constellations.size() > 0) {
            Constellation constellation = constellations.get(random);
            setValue(constellation);
        }

        constellationLoves = new ConstellationLove().getData();
        int randomLeft = new Random().nextInt(12);
        int randomRight = new Random().nextInt(12);
        ivLeft.setImageResource(constellationLoves.get(randomLeft).getImgid());
        ivLeft.setImageResource(constellationLoves.get(randomRight).getImgid());

        constellationAdapter = new ConstellationAdapter(this, constellations);
        lvConstellation.setAdapter(constellationAdapter);
    }

    private void setValue(Constellation constellation) {
        appBar.setExpanded(true);
        collapsingToolbarLayout.setTitle(constellation.getName());
        tvLuckyNum.setText(constellation.getLuckynum());
        tvShortcoming.setText(constellation.getShortcoming());
        tvMerit.setText(constellation.getMerit());
        tvPerformance.setText(constellation.getPerformance());
        tvCharacter.setText(constellation.getCharacter());
    }

    private void initEvent() {
        lvConstellation.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                setValue((Constellation) adapterView.getItemAtPosition(i));
            }
        });
    }

    @OnClick(R.id.btn_pair)
    public void onClick() {
        if (loveflag) {
            loveflag = false;
            btnPair.setText("停止");
            scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
            scheduledExecutorService.scheduleAtFixedRate(new MyTask(), 300, 100, TimeUnit.MILLISECONDS);
        } else {
            loveflag = true;
            btnPair.setText("开始");
            scheduledExecutorService.shutdown();
            ConstellationLoveImpl constellationLoveImpl = ConstellationLoveImpl.getIntance(this);
            ConstellationLoveInfo constellationLoveInfo = constellationLoveImpl.findInfoById(String.valueOf(constellationLoveLeft.getId()), String.valueOf(constellationLoveRight.getId()));
            ConstellationLoveWidget constellationLoveWidget = ConstellationLoveWidget.getIntance();
            String title = constellations.get(constellationLoveInfo.getMid()).getName().substring(0, 2) + "&" + constellations.get(constellationLoveInfo.getWid()).getName().substring(0, 2);
            constellationLoveWidget.create(this, title, constellationLoveInfo.getContent());
        }
    }

    class MyHandler extends Handler {
        WeakReference<MainActivity> weakReference;

        public MyHandler(MainActivity mainActivity) {
            weakReference = new WeakReference<>(mainActivity);
        }

        @Override
        public void handleMessage(Message msg) {
            int[] randoms = (int[]) msg.obj;
            constellationLoveLeft = constellationLoves.get(randoms[0]);
            constellationLoveRight = constellationLoves.get(randoms[1]);
            //更新UI
            ivLeft.setImageResource(constellationLoveLeft.getImgid());
            ivRight.setImageResource(constellationLoveRight.getImgid());
            super.handleMessage(msg);
        }
    }

    private class MyTask implements Runnable {
        @Override
        public void run() {
            Message msg = Message.obtain();
            int left = new Random().nextInt(12);
            int right = new Random().nextInt(12);
            int[] randoms = new int[]{left, right};
            msg.obj = randoms;
            myHandler.sendMessage(msg);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.meun_about) {
            startActivity(new Intent(this, AboutActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy() {
        if (scheduledExecutorService != null) {
            scheduledExecutorService.shutdown();
            scheduledExecutorService = null;
        }
        super.onDestroy();
    }
}
