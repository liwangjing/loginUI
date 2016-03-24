package com.example.jing.broadcastpractice;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends BaseActivity {
    private EditText userText;
    private EditText passwordText;
    private Button loginButton;
    private CheckBox checkBox;
    private SharedPreferences pre;
    private SharedPreferences.Editor editor;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginlayout);

        userText = (EditText)findViewById(R.id.userText);
        passwordText = (EditText)findViewById(R.id.passwordText);
        checkBox = (CheckBox)findViewById(R.id.checkBox);
        loginButton = (Button)findViewById(R.id.loginButton);

        pre = PreferenceManager.getDefaultSharedPreferences(this);

        boolean isRemembered = pre.getBoolean("remember_password",false);
        if (isRemembered) {
            String name = pre.getString("userName", "");
            String password = pre.getString("password", "");
            userText.setText(name);
            passwordText.setText(password);
            checkBox.setChecked(true);
        }

        loginButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                String account = userText.getText().toString();
                String password = passwordText.getText().toString();

                if(account.equals("jing")&&password.equals("123456")) {
                    if(checkBox.isChecked()){
                        editor = pre.edit();
                        editor.putString("userName", account);
                        editor.putString("password", password);
                        editor.putBoolean("remember_password", true);
                    }else {
                        editor.clear();
                    }
                    editor.commit();
                    Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                }else {
                    Toast.makeText(LoginActivity.this, "account or password is invalid",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
