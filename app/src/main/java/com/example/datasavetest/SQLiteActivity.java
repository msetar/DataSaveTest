package com.example.datasavetest;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/**
 * Created by lifb on 2015/5/6.
 */
public class SQLiteActivity extends BaseActivity {
    private MyDatabaseHelper dbHelpher;
    private Button _btnCreateTable;
    private Button _btnAddDate;
    private Button _btnUpdateData;
    private Button _btnQueryData;
    private Button _btnContact;

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

        _btnAddDate = (Button)findViewById(R.id.btn_add_data);
        _btnAddDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dbHelpher.getWritableDatabase();
                ContentValues values = new ContentValues();

                values.put("name","The Da Vinci Code");
                values.put("author","Dan Brown");
                values.put("pages","454");
                values.put("price",16.96);
                db.insert("Book",null,values);
                values.clear();

                values.put("name","The Lost Symbol");
                values.put("author","Dan Brown");
                values.put("pages",510);
                values.put("price",19.95);
                db.insert("Book",null,values);
            }
        });

        _btnUpdateData = (Button)findViewById(R.id.btn_update_data);
        _btnUpdateData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dbHelpher.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put("price",10.99);
                db.update("Book",values,"name = ?",new String[]{"The Da Vinci Code"});
            }
        });

        _btnQueryData = (Button)findViewById(R.id.btn_query_data);
        _btnQueryData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dbHelpher.getWritableDatabase();
                Cursor cursor = db.query("Book",null,null,null,null,null,null);
                if(cursor.moveToFirst()){
                    do{
                        String name = cursor.getString(cursor.getColumnIndex("name"));
                        String author = cursor.getString(cursor.getColumnIndex("author"));
                        int pages = cursor.getInt(cursor.getColumnIndex("pages"));
                        double price = cursor.getDouble(cursor.getColumnIndex("price"));
                        Log.d("SQL",name+"\t"+author+"\t"+pages+"\t"+price+"\n");
                    }while(cursor.moveToNext());
                }
                cursor.close();
            }
        });

        _btnContact = (Button)findViewById(R.id.btn_contact);
        _btnContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SQLiteActivity.this,ContactActivity.class);
                startActivity(intent);
            }
        });


    }
}
