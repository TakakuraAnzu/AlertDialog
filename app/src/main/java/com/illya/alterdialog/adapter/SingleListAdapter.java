package com.illya.alterdialog.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.illya.alterdialog.R;


/**
 * Created by illya on 2017/7/23.v1
 */

public class SingleListAdapter extends BaseAdapter {
    private String[] content;
    private Context context;

    public SingleListAdapter(Context context, String[] content){
        this.content = content;
        this.context = context;
    }

    @Override
    public int getCount() {
        return content.length;
    }

    @Override
    public String getItem(int i) {
        return content[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final ViewHolder viewHolder;
        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.single_list_item, null);
            viewHolder = new ViewHolder();
            viewHolder.name = view.findViewById(R.id.tv_name);
            view.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) view.getTag();
        }

        viewHolder.name.setText(content[i]);
        return view;
    }

    class ViewHolder{
        TextView name;
    }
}
