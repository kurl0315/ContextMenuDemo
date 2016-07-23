package com.fis.contextmenudemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListviewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);

        int[] imageId = new int[]{R.drawable.bear,R.drawable.dog,R.drawable.cat,R.drawable.girl,R.drawable.pig};
        String[] title = new String[]{"bear","dog","cat","girl","pig"};

        List<Map<String,Object>> listitems = new ArrayList<Map<String,Object>>();

        for (int i = 0; i <imageId.length ; i++) {
            Map<String,Object> map = new HashMap<String,Object>();
            map.put("image",imageId[i]);
            map.put("title",title[i]);
            listitems.add(map);

        }

        ListView listview = (ListView) findViewById(R.id.listView);

        SimpleAdapter adapter = new SimpleAdapter(ListviewActivity.this,listitems,R.layout.items,new String[]{"title","image"},new int[]{R.id.title,R.id.image});
        listview.setAdapter(adapter);
    }
}
