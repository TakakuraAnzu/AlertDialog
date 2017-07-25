package com.illya.widget.Dialog;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

import com.illya.widget.R;

/**
 * Created by illya on 2017/7/20.v1
 */

public class NormalDialog extends MDialog implements View.OnClickListener {

    private DialogConfig config;

    private TextView Title;
    private TextView Content;
    private TextView cancel;
    private TextView confirm;

    public NormalDialog(@NonNull Context context, DialogConfig config) {
        super(context);
        this.config = config;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.normal);

        init();
    }

    private void init(){
        Title = findViewById(R.id.title_text);
        Content = findViewById(R.id.content_text);
        cancel = findViewById(R.id.cancel);
        confirm = findViewById(R.id.confirm);

        Title.setText(config.Title);
        Content.setText(config.context);
        cancel.setText(config.cancelText);
        confirm.setText(config.confirmText);

        cancel.setOnClickListener(this);
        confirm.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.cancel){
            if(config.cancelClick != null){
                config.cancelClick.onClick(NormalDialog.this);
            }
        }else if(view.getId() == R.id.confirm){
            if(config.confirmClick != null){
                config.confirmClick.onClick(NormalDialog.this);
            }
        }
    }
}
