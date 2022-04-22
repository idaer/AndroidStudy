package com.example.test2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private String mytag="tag";

    Button btn1;
    Button btn2;

    ConstraintLayout cons2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent=getIntent();
        Bundle bundle=intent.getBundleExtra("bundle");
        String name=bundle.getString("name");

        setContentView(R.layout.two_button);

        btn1=findViewById(R.id.btn1);
        cons2=findViewById(R.id.layout);

        btn2=new Button(this);
        btn2.setText(name);

        btn2.setTag("2");
        btn1.setTag("1");

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);

        cons2.addView(btn2);



    }


    @Override
    public void onClick(View view) {
        Button btn=(Button)view;

        if (btn.getTag().equals("2")) {
            Log.e(mytag,"已按下按钮"+btn.getTag());
            btn.setVisibility(View.INVISIBLE);
        }
        if (btn.getTag().equals("1")) {
            Log.e(mytag,"已按下按钮"+btn.getTag());
            btn2.setVisibility(View.VISIBLE);
        }

    }
}