package com.example.jing.broadcastpractice;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends BaseActivity {
    private EditText userText;
    private EditText passwordText;
    private Button loginButton;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginlayout);

        userText = (EditText)findViewById(R.id.userText);
        passwordText = (EditText)findViewById(R.id.passwordText);
        loginButton = (Button)findViewById(R.id.loginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                String account = userText.getText().toString();
                String password = passwordText.getText().toString();

                if(account.equals("jing")&&password.equals("123456")) {
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
