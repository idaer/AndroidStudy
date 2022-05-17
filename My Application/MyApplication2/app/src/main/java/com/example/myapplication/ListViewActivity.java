package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ListViewActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        ListView listView=findViewById(R.id.mylist);

        SimpleAdapter adapter=new SimpleAdapter(this,InitData(),R.layout.view_item,
                new String[]{"name","phone","address","image"},
                new int[]{R.id.nametext,R.id.phonetext,R.id.addresstext,R.id.imageView});
        listView.setAdapter(adapter);



    }
    private ArrayList<Map<String,Object>> InitData() {
        HashMap<String,Object> map1=new HashMap<>();
        map1.put("name","lck");
        map1.put("phone",123123);
        map1.put("address","asdadas");
        map1.put("image",R.drawable.ic_launcher_background);
        HashMap<String,Object> map2=new HashMap<>();
        map2.put("name","bsbs");
        map2.put("phone",123123);
        map2.put("address","asdadas");
        map2.put("image",R.drawable.ic_launcher_background);
        HashMap<String,Object> map3=new HashMap<>();
        map3.put("name","zjsb");
        map3.put("phone",123123);
        map3.put("address","asdadas");
        map3.put("image",R.drawable.ic_launcher_background);

        ArrayList<Map<String,Object>> arrayList=new ArrayList<>();
        arrayList.add(map1);
        arrayList.add(map2);
        arrayList.add(map3);

        return arrayList;
    }
}