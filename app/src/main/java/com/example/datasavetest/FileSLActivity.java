package com.example.datasavetest;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Created by lifb on 2015/5/3.
 */
public class FileSLActivity extends BaseActivity {

    private EditText _txtFileName;
    private EditText _txtFileContent;
    private Button _btnFileSave;
    private Button _btnFileLoad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.filesaveload);

        _txtFileName = (EditText)findViewById(R.id.input_file_title);
        _txtFileContent = (EditText)findViewById(R.id.input_file_content);
        _btnFileSave = (Button)findViewById(R.id.btn_save_file);
        _btnFileLoad = (Button)findViewById(R.id.btn_load_file);

        _btnFileSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = _txtFileName.getText().toString();
                String content = _txtFileContent.getText().toString();

                if(!TextUtils.isEmpty(title)){
                    saveFile(title,content);
                }else{
                    Toast.makeText(FileSLActivity.this,"File Title is error!",Toast.LENGTH_SHORT).show();
                }

            }
        });

        _btnFileLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = _txtFileName.getText().toString();
                String content = _txtFileContent.getText().toString();
                String inputText = loadFile(title);
                if (!TextUtils.isEmpty(inputText)){
                    _txtFileContent.setText(inputText);
                    _txtFileContent.setSelection(inputText.length());
                    Toast.makeText(FileSLActivity.this,"Load file succeeded",Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    public void saveFile(String fileName,String content){
        FileOutputStream out = null;
        BufferedWriter writer = null;
        try{
            out = openFileOutput(fileName, Context.MODE_PRIVATE);
            writer = new BufferedWriter(new OutputStreamWriter(out));
            writer.write(content);
        }catch (IOException e){
            e.printStackTrace();
        } finally {
            try{
                if(writer!=null){
                    writer.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }

        }
    }

    public String loadFile(String fileName){
        FileInputStream in = null;
        BufferedReader reader = null;
        StringBuilder strContent = new StringBuilder();
        try{
            in = openFileInput(fileName);
            reader = new BufferedReader(new InputStreamReader(in));
            String line = "";
            while((line=reader.readLine())!=null){
                strContent.append(line);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(reader!=null){
                try{
                    reader.close();
                }catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }

        return  strContent.toString();

    }
}
