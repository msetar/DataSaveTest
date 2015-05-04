package com.example.datasavetest;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by lifb on 2015/5/3.
 */
public class FileSLActivity extends BaseActivity {

    private EditText input_file_title;
    private EditText input_file_content;
    private Button btn_file_save;
    private Button btn_file_load;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.filesaveload);

        input_file_title = (EditText)findViewById(R.id.input_file_title);
        input_file_content = (EditText)findViewById(R.id.input_file_content);
        btn_file_save = (Button)findViewById(R.id.btn_save_file);
        btn_file_load = (Button)findViewById(R.id.btn_load_file);



    }
}
