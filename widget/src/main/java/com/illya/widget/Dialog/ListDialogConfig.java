package com.illya.widget.Dialog;

import android.widget.AdapterView;
import android.widget.ListAdapter;

/**
 * Created by illya on 2017/7/23.v1
 */

public class ListDialogConfig {
    String title;
    ListAdapter adapter;
    AdapterView.OnItemClickListener listener;
    public static class Builder{
        private String title;
        private ListAdapter adapter;
        private AdapterView.OnItemClickListener listener;

        public Builder setTitle(String title){
            this.title = title;
            return this;
        }

        public Builder setAdapter(ListAdapter adapter){
            this.adapter = adapter;
            return this;
        }

        public Builder setOnItemClickListener(AdapterView.OnItemClickListener listener){
            this.listener = listener;
            return this;
        }

        private void applyConfig(ListDialogConfig config){
            config.title = title;
            config.adapter = adapter;
            config.listener = listener;
        }

        public ListDialogConfig builder(){
            ListDialogConfig config = new ListDialogConfig();
            applyConfig(config);
            return config;
        }
    }
}
