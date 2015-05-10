package com.example.datasavetest;

import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lifb on 2015/5/8.
 */
public class ContactActivity extends BaseActivity {
    ListView contactsView;
    ArrayAdapter<String> adapter;
    List<String> contactsList = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_listview);

        contactsView = (ListView)findViewById(R.id.contacts_view);
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,contactsList);
        contactsView.setAdapter(adapter);
        readContacts();

    }

    private void readContacts(){
        Cursor cursor = null;
        try{
            cursor =getContentResolver().query(
                    ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null,null,null,null
            );
            while(cursor.moveToNext()){
                String displayName = cursor.getString(cursor.getColumnIndex(
                        ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME
                ));
                String number = cursor.getString(cursor.getColumnIndex(
                        ContactsContract.CommonDataKinds.Phone.NUMBER));
                contactsList.add(displayName+"\n"+number);
            }
        }catch(Exception e){
            e.printStackTrace();
        } finally {
            if(cursor!=null){
                cursor.close();
            }
        }

    }
}
