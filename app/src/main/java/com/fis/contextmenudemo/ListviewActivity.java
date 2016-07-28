package com.fis.contextmenudemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ListviewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
//
//        int[] imageId = new int[]{R.drawable.bear,R.drawable.dog,R.drawable.cat,R.drawable.girl,R.drawable.pig};
//        String[] title = new String[]{"bear","dog","cat","girl","pig"};
//
//        List<Map<String,Object>> listitems = new ArrayList<Map<String,Object>>();
//
//        for (int i = 0; i <imageId.length ; i++) {
//            Map<String,Object> map = new HashMap<String,Object>();
//            map.put("image",imageId[i]);
//            map.put("title",title[i]);
//            listitems.add(map);
//
//        }
//
//        ListView listview = (ListView) findViewById(R.id.listView);
//
//        SimpleAdapter adapter = new SimpleAdapter(ListviewActivity.this,listitems,R.layout.items,new String[]{"title","image"},new int[]{R.id.title,R.id.image});
//        listview.setAdapter(adapter);
        final EditText editText = (EditText) findViewById(R.id.editText);
        final EditText editText2 = (EditText) findViewById(R.id.editText2);




        Button button9 =  (Button) findViewById(R.id.button9);
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListviewActivity.this,DetailActivity.class);
                intent.putExtra("username",editText.getText().toString());
                intent.putExtra("password",editText2.getText().toString());
                startActivity(intent);
            }
        });
    }
}
