package com.example.datasavetest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by lifb on 2015/5/3.
 */
public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Button btn_fileSL = (Button)findViewById(R.id.btn_fileSL);
        btn_fileSL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,FileSLActivity.class);
                startActivity(intent);
            }
        });

        Button btnSharedpre = (Button)findViewById(R.id.btn_sharedPre);
        btnSharedpre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,SharedPreActivity.class);
                startActivity(intent);
            }
        });
    }
}
