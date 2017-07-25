package com.illya.widget.Dialog;

import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

/**
 * Created by illya on 2017/7/19.v1
 */

public class DialogConfig {
    //标题
    String Title;
    //主体内容
    String context = "";
    //取消按钮
    String cancelText = "取消";
    //确定按钮
    String confirmText = "确定";
    //取消按钮监听
    ClickListener cancelClick;
    //确定按钮监听
    ClickListener confirmClick;
    public static class Builder{
        private String Title;
        private String context = "";
        private String cancelText = "取消";
        private String confirmText = "确定";
        private ClickListener cancelClick;
        private ClickListener confirmClick;

        public Builder setTitle(String Title){
            this.Title = Title;
            return this;
        }

        public Builder setContext(String context){
            this.context = context;
            return this;
        }

        public Builder setCancelText(String cancelText){
            this.cancelText = cancelText;
            return this;
        }

        public Builder setConfirmText(String confirmText){
            this.confirmText = confirmText;
            return this;
        }

        public Builder setCancelClick(ClickListener cancelClick){
            this.cancelClick = cancelClick;
            return this;
        }

        public Builder setConfirmClick(ClickListener confirmClick){
            this.confirmClick = confirmClick;
            return this;
        }

        private void applyConfig(DialogConfig config){
            config.Title = this.Title;
            config.context = this.context;
            config.cancelText = this.cancelText;
            config.confirmText = this.confirmText;
            config.cancelClick = this.cancelClick;
            config.confirmClick = this.confirmClick;
        }

        public DialogConfig builder(){
            DialogConfig config = new DialogConfig();
            applyConfig(config);
            return config;
        }
    }
}
