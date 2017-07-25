package com.illya.widget.Dialog;


import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;

import com.illya.widget.Dialog.Animation.OptAnimationLoader;
import com.illya.widget.R;

/**
 * Created by illya on 2017/7/13.v1
 */

class MDialog extends Dialog {

    private View mDialogView;
    private AnimationSet mModalInAnim;
    private AnimationSet mModalOutAnim;

    MDialog(@NonNull Context context) {
        super(context, R.style.alert_dialog);

        mDialogView = getWindow().getDecorView().findViewById(android.R.id.content);
        mModalInAnim = (AnimationSet) OptAnimationLoader.loadAnimation(getContext(), R.anim.modal_in);
        mModalOutAnim = (AnimationSet) OptAnimationLoader.loadAnimation(getContext(), R.anim.modal_out);
        mModalOutAnim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                mDialogView.setVisibility(View.GONE);
                mDialogView.post(new Runnable() {
                    @Override
                    public void run() {
                        MDialog.super.dismiss();
                    }
                });
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        mDialogView.clearAnimation();
    }

    @Override
    protected void onStart() {
        //super.onStart();
        mDialogView.startAnimation(mModalInAnim);
    }

    @Override
    public void cancel() {
        //super.cancel();
        dismiss();
    }

    @Override
    public void dismiss() {
        //super.dismiss();
        mDialogView.startAnimation(mModalOutAnim);
    }
}
