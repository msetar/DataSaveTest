package com.example.datasavetest;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by lifb on 2015/5/6.
 */
public class SQLiteActivity extends BaseActivity {
    private MyDatabaseHelper dbHelpher;
    private Button _btnCreateTable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sql_lite);
        dbHelpher = new MyDatabaseHelper(this,"BookStore.db",null,1);

        _btnCreateTable = (Button)findViewById(R.id.btn_create_table);
        _btnCreateTable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHelpher.getWritableDatabase();
            }
        });


    }
}
