package com.example.test2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class imgActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imgv);

        ImageView imgv;
        imgv=findViewById(R.id.imageView);
        imgv.setImageResource(R.drawable.imgv1);


        imgv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (imgv.getDrawable().getConstantState().equals(getDrawable(R.drawable.imgv2).getConstantState())) {
                    imgv.setImageResource(R.drawable.imgv1);
                }else {
                    Log.e("mytag",imgv.getDrawable().getConstantState()+"");
                    imgv.setImageResource(R.drawable.imgv2);
                }
            }
        });
    }
}