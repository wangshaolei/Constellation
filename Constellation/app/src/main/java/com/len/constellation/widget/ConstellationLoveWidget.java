package com.len.constellation.widget;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.len.constellation.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ConstellationLoveWidget {

    private static ConstellationLoveWidget constellationLoveWidget;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_value)
    TextView tvValue;
    @BindView(R.id.tv_ok)
    TextView tvOk;

    private ConstellationLoveWidget() {
    }

    public static ConstellationLoveWidget getIntance() {
        if (constellationLoveWidget == null) {
            constellationLoveWidget = new ConstellationLoveWidget();
        }
        return constellationLoveWidget;
    }

    public void create(final Context context, String title, String value) {
        final Dialog dialog = new Dialog(context, R.style.popup_dialog_style);
        dialog.setContentView(R.layout.widget_constellation_love);
        ButterKnife.bind(this, dialog);
        Window window = dialog.getWindow();
        window.setGravity(Gravity.CENTER);
        WindowManager mWindowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        window.setWindowManager(mWindowManager, null, null);
        dialog.setCanceledOnTouchOutside(true);
        window.setWindowAnimations(R.style.DialogAnimationPreview);
        dialog.show();
        tvTitle.setText(title);
        tvValue.setText(value);
        tvOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
    }

}
