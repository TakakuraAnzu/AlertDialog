package com.illya.alterdialog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Toast;

import com.illya.alterdialog.adapter.SingleListAdapter;
import com.illya.widget.Dialog.ClickListener;
import com.illya.widget.Dialog.DialogConfig;
import com.illya.widget.Dialog.ErrorDialog;
import com.illya.widget.Dialog.ListDialog;
import com.illya.widget.Dialog.ListDialogConfig;
import com.illya.widget.Dialog.NormalDialog;

public class MainActivity extends AppCompatActivity {
    private NormalDialog normalDialog;
    private ErrorDialog errorDialog;
    private ListDialog listDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button normal = findViewById(R.id.normal);
        Button error = findViewById(R.id.error);
        Button list = findViewById(R.id.list);

        normal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                normalDialog.show();
            }
        });

        error.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                errorDialog.show();
            }
        });

        list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listDialog.show();
            }
        });

        //正常的提示Dialog显示
        DialogConfig normalConfig = new DialogConfig.Builder()
                .setTitle("这里是标题")
                .setContext("这里是内容。。。。")
                .setCancelText("取消")
                .setConfirmText("确定")
                .setCancelClick(new ClickListener<NormalDialog>() {
                    @Override
                    public void onClick(NormalDialog dialog) {
                        dialog.dismiss();
                    }
                })
                .setConfirmClick(new ClickListener<ErrorDialog>() {
                    @Override
                    public void onClick(ErrorDialog dialog) {
                        dialog.dismiss();
                    }
                })
                .builder();
        normalDialog = new NormalDialog(this, normalConfig);

        //包含错误信息的Dialog显示
        DialogConfig errorConfig = new DialogConfig.Builder()
                .setTitle("这里是错误提示")
                .setCancelText("取消")
                .setConfirmText("确定")
                .setCancelClick(new ClickListener<ErrorDialog>() {
                    @Override
                    public void onClick(ErrorDialog dialog) {
                        dialog.dismiss();
                    }
                })
                .setConfirmClick(new ClickListener<ErrorDialog>() {
                    @Override
                    public void onClick(ErrorDialog dialog) {
                        dialog.dismiss();
                    }
                })
                .builder();
        errorDialog = new ErrorDialog(this, errorConfig);

        //包含ListView的Dialog显示
        final String[] arrayString = new String[]{"示例1", "示例2", "示例3", "示例4", "示例5"};
        ListDialogConfig listConfig = new ListDialogConfig.Builder()
                .setTitle("材质")
                .setAdapter(new SingleListAdapter(this, arrayString))
                .setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Toast.makeText(MainActivity.this, "Item " + "i" + " is click", Toast.LENGTH_SHORT).show();
                        listDialog.dismiss();
                    }
                })
                .builder();
        listDialog = new ListDialog(this, listConfig);
    }
}
