package com.illya.widget.Dialog;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.illya.widget.R;

/**
 * Created by illya on 2017/7/20.v1
 */

public class WarnDialog extends MDialog implements View.OnClickListener {

    private DialogConfig config;

    private FrameLayout mWarningFrame;

    private TextView Title;
    private TextView cancel;
    private TextView confirm;

    public WarnDialog(@NonNull Context context, DialogConfig config) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.warn);
    }

    private void init(){
        mWarningFrame = findViewById(R.id.warning_frame);
        Title = findViewById(R.id.title_text);
        cancel = findViewById(R.id.cancel);
        confirm = findViewById(R.id.confirm);

        Title.setText(config.Title);
        cancel.setText(config.cancelText);
        confirm.setText(config.confirmText);

        cancel.setOnClickListener(this);
        confirm.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.cancel){
            if(config.cancelClick != null){
                config.cancelClick.onClick(WarnDialog.this);
            }
        }else if(view.getId() == R.id.confirm){
            if(config.confirmClick != null){
                config.confirmClick.onClick(WarnDialog.this);
            }
        }
    }
}
