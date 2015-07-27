package com.uestc.mymoa;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nothisboy on 2015/7/26.
 */
public class NewsCategoryGridAdapter extends BaseAdapter {

    private List<String> list;
    private Context context;
    private LayoutInflater inflater;
    private LinearLayout itemLinear;

    public NewsCategoryGridAdapter(Context context) {
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        list = getListData();
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return itemLinear;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_news_category, null);
            itemLinear = (LinearLayout) convertView;
        }
        TextView newsCategoryText = (TextView) convertView.findViewById(R.id.newsCategoryText);
        newsCategoryText.setText(list.get(position));

        AdapterView.LayoutParams params = new AdapterView.LayoutParams(
                (((MainActivity) context).getResources().getDisplayMetrics().widthPixels-4*3)/3,
                (((MainActivity) context).getResources().getDisplayMetrics().widthPixels-4*3)/3);

        convertView.setLayoutParams(params);
        return convertView;
    }

    private List<String> getListData() {
        List<String> list = new ArrayList<>();
        list.add("本地");
        list.add("娱乐");
        list.add("科技");
        list.add("亮黄色");
        return list;
    }
}
