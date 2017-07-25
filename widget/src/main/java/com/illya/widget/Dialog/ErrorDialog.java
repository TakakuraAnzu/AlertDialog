package com.illya.widget.Dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.illya.widget.Dialog.Animation.OptAnimationLoader;
import com.illya.widget.R;

import java.util.List;

/**
 * Created by illya on 2017/7/13.v1
 */

public class ErrorDialog extends MDialog implements View.OnClickListener {

    private Animation mErrorInAnim;
    private AnimationSet mErrorXInAnim;

    private DialogConfig config;

    private FrameLayout ErrorFrame;
    private ImageView ErrorX;
    private TextView Title;
    private TextView cancel;
    private TextView confirm;

    public ErrorDialog(@NonNull Context context, DialogConfig config) {
        super(context);

        this.config = config;

        mErrorInAnim = OptAnimationLoader.loadAnimation(getContext(), R.anim.error_frame_in);
        mErrorXInAnim = (AnimationSet)OptAnimationLoader.loadAnimation(getContext(), R.anim.error_x_in);
        List<Animation> childAnims = mErrorXInAnim.getAnimations();
        int idx = 0;
        for (;idx < childAnims.size();idx++) {
            if (childAnims.get(idx) instanceof AlphaAnimation) {
                break;
            }
        }
        if (idx < childAnims.size()) {
            childAnims.remove(idx);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.error);

        init();
    }

    private void init(){
        ErrorFrame = findViewById(R.id.error_frame);
        ErrorX = findViewById(R.id.error_x);
        Title = findViewById(R.id.title_text);
        cancel = findViewById(R.id.cancel);
        confirm = findViewById(R.id.confirm);

        ErrorFrame.clearAnimation();
        ErrorX.clearAnimation();

        Title.setText(config.Title);
        cancel.setText(config.cancelText);
        confirm.setText(config.confirmText);

        cancel.setOnClickListener(this);
        confirm.setOnClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        ErrorFrame.startAnimation(mErrorInAnim);
        ErrorX.startAnimation(mErrorXInAnim);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.cancel){
            if(config.cancelClick != null){
                config.cancelClick.onClick(ErrorDialog.this);
            }
        }else if(view.getId() == R.id.confirm){
            if(config.confirmClick != null){
                config.confirmClick.onClick(ErrorDialog.this);
            }
        }
    }
}
