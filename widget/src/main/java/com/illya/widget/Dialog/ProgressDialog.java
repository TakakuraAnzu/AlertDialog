package com.illya.widget.Dialog;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.illya.widget.Dialog.Animation.ProgressHelper;
import com.illya.widget.R;
import com.pnikosis.materialishprogress.ProgressWheel;

/**
 * Created by illya on 2017/7/20.v1
 */

public class ProgressDialog extends MDialog implements View.OnClickListener {

    private DialogConfig config;

    private FrameLayout mProgressFrame;
    private ProgressHelper mProgressHelper;
    private ProgressWheel progress;

    private TextView Title;
    private TextView cancel;
    private TextView confirm;

    public ProgressDialog(@NonNull Context context, DialogConfig config){
        super(context);
        mProgressHelper = new ProgressHelper(context);
        this.config = config;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.progress);

        init();
    }

    private void init(){
        mProgressFrame = findViewById(R.id.progress_dialog);
        progress = findViewById(R.id.progressWheel);
        mProgressHelper.setProgressWheel((ProgressWheel) findViewById(R.id.progressWheel));

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
                config.cancelClick.onClick(ProgressDialog.this);
            }
        }else if(view.getId() == R.id.confirm){
            if(config.confirmClick != null){
                config.confirmClick.onClick(ProgressDialog.this);
            }
        }
    }
}
