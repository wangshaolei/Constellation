package com.len.constellation.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.len.constellation.R;
import com.len.constellation.model.Constellation;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ru on 2016/10/15.
 */
public class ConstellationAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Constellation> list;

    public ConstellationAdapter(Context context, ArrayList<Constellation> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_constellation, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Constellation constellation = (Constellation) getItem(position);
        viewHolder.tvName.setText(constellation.getName());
        viewHolder.tvDate.setText(constellation.getDate());
        viewHolder.tvCharacter.setText(constellation.getCharacter());
        switch (constellation.getId()) {
            case 0:
                viewHolder.ivIcon.setImageResource(R.drawable.aries01);
                viewHolder.tvName.setTextColor(context.getResources().getColor(R.color.aries));
                viewHolder.tvDate.setTextColor(context.getResources().getColor(R.color.aries));
                viewHolder.tvCharacter.setTextColor(context.getResources().getColor(R.color.aries));
                break;
            case 1:
                viewHolder.ivIcon.setImageResource(R.drawable.taurus01);
                viewHolder.tvName.setTextColor(context.getResources().getColor(R.color.taurus));
                viewHolder.tvDate.setTextColor(context.getResources().getColor(R.color.taurus));
                viewHolder.tvCharacter.setTextColor(context.getResources().getColor(R.color.taurus));
                break;
            case 2:
                viewHolder.ivIcon.setImageResource(R.drawable.gemini01);
                viewHolder.tvName.setTextColor(context.getResources().getColor(R.color.gemini));
                viewHolder.tvDate.setTextColor(context.getResources().getColor(R.color.gemini));
                viewHolder.tvCharacter.setTextColor(context.getResources().getColor(R.color.gemini));
                break;
            case 3:
                viewHolder.ivIcon.setImageResource(R.drawable.cancer01);
                viewHolder.tvName.setTextColor(context.getResources().getColor(R.color.cancer));
                viewHolder.tvDate.setTextColor(context.getResources().getColor(R.color.cancer));
                viewHolder.tvCharacter.setTextColor(context.getResources().getColor(R.color.cancer));
                break;
            case 4:
                viewHolder.ivIcon.setImageResource(R.drawable.leo01);
                viewHolder.tvName.setTextColor(context.getResources().getColor(R.color.leo));
                viewHolder.tvDate.setTextColor(context.getResources().getColor(R.color.leo));
                viewHolder.tvCharacter.setTextColor(context.getResources().getColor(R.color.leo));
                break;
            case 5:
                viewHolder.ivIcon.setImageResource(R.drawable.virgo01);
                viewHolder.tvName.setTextColor(context.getResources().getColor(R.color.virgo));
                viewHolder.tvDate.setTextColor(context.getResources().getColor(R.color.virgo));
                viewHolder.tvCharacter.setTextColor(context.getResources().getColor(R.color.virgo));
                break;
            case 6:
                viewHolder.ivIcon.setImageResource(R.drawable.libra01);
                viewHolder.tvName.setTextColor(context.getResources().getColor(R.color.libra));
                viewHolder.tvDate.setTextColor(context.getResources().getColor(R.color.libra));
                viewHolder.tvCharacter.setTextColor(context.getResources().getColor(R.color.libra));
                break;
            case 7:
                viewHolder.ivIcon.setImageResource(R.drawable.scorpio01);
                viewHolder.tvName.setTextColor(context.getResources().getColor(R.color.scorpio));
                viewHolder.tvDate.setTextColor(context.getResources().getColor(R.color.scorpio));
                viewHolder.tvCharacter.setTextColor(context.getResources().getColor(R.color.scorpio));
                break;
            case 8:
                viewHolder.ivIcon.setImageResource(R.drawable.sagittarius01);
                viewHolder.tvName.setTextColor(context.getResources().getColor(R.color.sagittarius));
                viewHolder.tvDate.setTextColor(context.getResources().getColor(R.color.sagittarius));
                viewHolder.tvCharacter.setTextColor(context.getResources().getColor(R.color.sagittarius));
                break;
            case 9:
                viewHolder.ivIcon.setImageResource(R.drawable.capricorn01);
                viewHolder.tvName.setTextColor(context.getResources().getColor(R.color.capricorn));
                viewHolder.tvDate.setTextColor(context.getResources().getColor(R.color.capricorn));
                viewHolder.tvCharacter.setTextColor(context.getResources().getColor(R.color.capricorn));
                break;
            case 10:
                viewHolder.ivIcon.setImageResource(R.drawable.aquarius01);
                viewHolder.tvName.setTextColor(context.getResources().getColor(R.color.aquarius));
                viewHolder.tvDate.setTextColor(context.getResources().getColor(R.color.aquarius));
                viewHolder.tvCharacter.setTextColor(context.getResources().getColor(R.color.aquarius));
                break;
            case 11:
                viewHolder.ivIcon.setImageResource(R.drawable.pisces01);
                viewHolder.tvName.setTextColor(context.getResources().getColor(R.color.pisces));
                viewHolder.tvDate.setTextColor(context.getResources().getColor(R.color.pisces));
                viewHolder.tvCharacter.setTextColor(context.getResources().getColor(R.color.pisces));
                break;
        }
        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.iv_icon)
        ImageView ivIcon;
        @BindView(R.id.tv_name)
        TextView tvName;
        @BindView(R.id.tv_date)
        TextView tvDate;
        @BindView(R.id.tv_character)
        TextView tvCharacter;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
