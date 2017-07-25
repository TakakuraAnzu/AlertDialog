package com.illya.widget.Dialog;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.illya.widget.Dialog.Animation.OptAnimationLoader;
import com.illya.widget.Dialog.Animation.SuccessTickView;
import com.illya.widget.R;

/**
 * Created by illya on 2017/7/20.v1
 */

public class SuccessDialog extends MDialog implements View.OnClickListener {

    private DialogConfig config;

    private AnimationSet mSuccessLayoutAnimSet;
    private Animation mSuccessBowAnim;

    private FrameLayout mSuccessFrame;
    private SuccessTickView mSuccessTick;
    private View mSuccessLeftMask;
    private View mSuccessRightMask;
    private TextView Title;
    private TextView cancel;
    private TextView confirm;

    public SuccessDialog(@NonNull Context context, DialogConfig config) {
        super(context);
        this.config = config;

        mSuccessBowAnim = OptAnimationLoader.loadAnimation(getContext(), R.anim.success_bow_roate);
        mSuccessLayoutAnimSet = (AnimationSet) OptAnimationLoader.loadAnimation(getContext(), R.anim.success_mask_layout);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.success);

        init();
    }

    private void init(){
        mSuccessFrame = findViewById(R.id.success_frame);
        mSuccessTick = mSuccessFrame.findViewById(R.id.success_tick);
        mSuccessLeftMask = mSuccessFrame.findViewById(R.id.mask_left);
        mSuccessRightMask = mSuccessFrame.findViewById(R.id.mask_right);
        Title = findViewById(R.id.title_text);
        cancel = findViewById(R.id.cancel);
        confirm = findViewById(R.id.confirm);

        mSuccessTick.clearAnimation();
        mSuccessLeftMask.clearAnimation();
        mSuccessRightMask.clearAnimation();

        Title.setText(config.Title);
        cancel.setText(config.cancelText);
        confirm.setText(config.confirmText);

        cancel.setOnClickListener(this);
        confirm.setOnClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mSuccessTick.startTickAnim();
        mSuccessRightMask.startAnimation(mSuccessBowAnim);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.cancel){
            if(config.cancelClick != null){
                config.cancelClick.onClick(SuccessDialog.this);
            }
        }else if(view.getId() == R.id.confirm){
            if(config.confirmClick != null){
                config.confirmClick.onClick(SuccessDialog.this);
            }
        }
    }
}
