package com.example.test2;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
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
    Switch autologin;
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



        SharedPreferences fsp=getSharedPreferences("config", MODE_PRIVATE);
        boolean ischeck=fsp.getBoolean("ischecked",false);
        if (ischeck) {
            switch_btn.setChecked(true);
            username.setText(fsp.getString("username",""));
            password.setText(fsp.getString("password",""));



        }



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

        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String user=username.getText().toString();
                String pwd=password.getText().toString();

                if (user.equals("bssb")&&pwd.equals("123")) {
                    // name 会帮助我们生成一个xml文件
                    SharedPreferences sp=getSharedPreferences("config", MODE_PRIVATE);
                    // 2、获取sp的编辑器
                    SharedPreferences.Editor editor=sp.edit();
                    if (switch_btn.isChecked()) {



                        editor.putString("username", user);
                        editor.putString("password", pwd);


                    }
                    editor.putBoolean("ischecked",switch_btn.isChecked());
                    editor.commit();
                    Log.e(mytag,"successfully! autologin is"+fsp.getBoolean("ischecked",false));

                    Intent intent=new Intent();
                    Bundle bundle=new Bundle();
                    bundle.putString("name","bssb");
                    intent.putExtra("bundle",bundle);
                    intent.setClass(getApplicationContext(),MainActivity.class);
                    startActivity(intent);
                }
                else  Log.e(mytag, String.valueOf(username.getText().equals("bssb")&&password.getText().equals("123")));
            }
        });


    }
}
