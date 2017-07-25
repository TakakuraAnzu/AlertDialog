package com.illya.widget.Dialog;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.widget.ListView;
import android.widget.TextView;

import com.illya.widget.R;


/**
 * Created by illya on 2017/7/21.v1
 */

public class ListDialog extends MDialog {

    private ListDialogConfig config;

    private ListView listView;
    private TextView Title;

    public ListDialog(@NonNull Context context, ListDialogConfig config){
        super(context);

        this.config = config;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_dialog);

        listView = findViewById(R.id.list);
        Title = findViewById(R.id.title_text);

        Title.setText(config.title);
        listView.setAdapter(config.adapter);
        if(config.listener != null){
            listView.setOnItemClickListener(config.listener);
        }
    }
}
