package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class loginActivity extends AppCompatActivity {

    EditText usertext;
    EditText password;

    RadioButton remenber;
    RadioButton autologin;
    Button login_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        usertext=findViewById(R.id.userText);
        password=findViewById(R.id.passText);



        //保存密码和自动登录
        SharedPreferences sp=getSharedPreferences("message",MODE_PRIVATE);
        if (sp.getBoolean("autologin",false)==true) {
            sp.edit().putBoolean("autologin",false);
            Intent intent=new Intent();
            intent.setClass(getApplicationContext(),MainActivity.class);
            startActivity(intent);
        }
        if (sp.getBoolean("ischeck",false)==true) {
            usertext.setText(sp.getString("username",""));
            password.setText(sp.getString("password",""));
        }

        remenber=findViewById(R.id.remenber);
        login_btn=findViewById(R.id.login_btn);
        autologin=findViewById(R.id.autologin);


        //按下登录
        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String userString=usertext.getText().toString();
                String passString=password.getText().toString();

                SharedPreferences sp=getSharedPreferences("message",MODE_PRIVATE);
                SharedPreferences.Editor edt=sp.edit();

                Log.e("mytag",userString);
                if ("bssb".equals(userString)&&"123".equals(passString)) {
                    edt.putString("username",userString);
                    edt.putString("password",passString);
                    edt.putBoolean("ischeck",remenber.isChecked());
                    edt.putBoolean("autologin",autologin.isChecked());


                    edt.commit();

                    Intent intent=new Intent();
                    intent.setClass(getApplicationContext(),ListViewActivity.class);
                    startActivity(intent);
                }
            }

//            //取消按钮选中
//            remenber.setOnClickListener()
        });


    }
}
