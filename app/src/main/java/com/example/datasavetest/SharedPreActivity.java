package com.example.datasavetest;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by lifb on 2015/5/5.
 */
public class SharedPreActivity extends BaseActivity {
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;
    private EditText editAccount;
    private EditText editPassword;
    private CheckBox chkRememberPass;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        editAccount = (EditText)findViewById(R.id.input_account);
        editPassword = (EditText)findViewById(R.id.input_password);
        chkRememberPass = (CheckBox)findViewById(R.id.chk_remember_pass);
        btnLogin = (Button)findViewById(R.id.btn_login);

        pref = PreferenceManager.getDefaultSharedPreferences(this);
        Boolean isRemember = pref.getBoolean("remember_password",false);
        if(isRemember){
            String strAccount = pref.getString("account","");
            String strPassword = pref.getString("password","");
            editAccount.setText(strAccount);
            editPassword.setText(strPassword);
            chkRememberPass.setChecked(true);
        }

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String account = editAccount.getText().toString();
                String password = editPassword.getText().toString();
                if(account.equals("admin")&&password.equals("888888")){
                    editor = pref.edit();
                    if(chkRememberPass.isChecked()){
                        editor.putBoolean("remember_password", true);
                        editor.putString("account",account);
                        editor.putString("password",password);
                    } else {
                        editor.clear();
                    }
                    editor.commit();
                    Toast.makeText(SharedPreActivity.this,"Login is succeed",Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(SharedPreActivity.this,"account or password is invalid!",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
