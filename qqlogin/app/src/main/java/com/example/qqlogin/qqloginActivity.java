package com.example.qqlogin;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class qqloginActivity  extends Activity implements View.OnClickListener {
EditText useredit,pwdedit;
Switch remswtich;
Button loginbtn;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.login);
        useredit=findViewById(R.id.useredit);
        pwdedit=findViewById(R.id.pwdedit);
        remswtich=findViewById(R.id.remswitch);
        loginbtn=findViewById(R.id.loginbtn);
//        loginbtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });
        loginbtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        String user=useredit.getText().toString();
        String pwd=pwdedit.getText().toString();
        boolean ischecked=remswtich.isChecked();

        if(user.equals("bs")&&pwd.equals("123"))

        {
            //Toast.makeText(this,"pwdok",Toast.LENGTH_LONG).show();

         if(ischecked)
         {
             SharedPreferences sp=this.getPreferences(MODE_PRIVATE);
             SharedPreferences.Editor editor=sp.edit();
             editor.putString("user",user);
             editor.putString("password",pwd);
             editor.commit();//commit提交

         }

//            Intent intent=new Intent();
//         Bundle bundle= new Bundle();
//         bundle.putString("zusername",user);
//         intent.putExtra("zjextra",bundle);
//         intent.setClass(this,MainActivity.class);
//         startActivity(intent);

            Intent intent=new Intent();
            intent.setAction("com.example.qqlogin.threeActivity");
            startActivity(intent);
        }

    }
}
