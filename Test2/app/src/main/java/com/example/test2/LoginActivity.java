package com.example.test2;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class LoginActivity extends Activity {

    Switch switch_btn;
    String mytag="mytag";
    Button login_btn;

    EditText username;
    EditText password;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        switch_btn=findViewById(R.id.switch_btn);
        login_btn=findViewById(R.id.loginbtn);
        username=findViewById(R.id.Username);
        password=findViewById(R.id.Password);

        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e(mytag, String.valueOf(username.getText()));
                Log.e(mytag, String.valueOf(password.getText()));

                if (username.getText().toString().equals("bs") &&password.getText().toString().equals("123")) {
                    Toast.makeText(LoginActivity.this,"ok", Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(LoginActivity.this,"error", Toast.LENGTH_LONG).show();
                }
            }
        });


        switch_btn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Log.e(mytag,""+b
                );
            }
        });


    }
}
