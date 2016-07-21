package com.fis.contextmenudemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.widget.Toast.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showListView();
    }

    /**
     * 设置list显示内容
     */
    private void showListView(){
        ListView listView =  (ListView) findViewById(R.id.listView);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,getData());

        listView.setAdapter(adapter);
//        为listView创建上下文菜单
        this.registerForContextMenu(listView);
    }

//    创建上下文菜单内容
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("文件操作");
        menu.setHeaderIcon(R.mipmap.ic_launcher);

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main,menu);
    }

//    重写ContextMenu点击事件
    @Override
    public boolean onContextItemSelected(MenuItem item) {
       //
        switch(item.getItemId()){
            case R.id.context_menu_item1:
                Toast.makeText(MainActivity.this, "点击复制", LENGTH_SHORT).show();
                break;
            case R.id.context_menu_item2:
                Toast.makeText(MainActivity.this, "点击黏贴", Toast.LENGTH_SHORT).show();
                break;


            case R.id.context_menu_item3:
                Toast.makeText(MainActivity.this, "点击复制", LENGTH_SHORT).show();
                 break;
             case R.id.context_menu_item4:
                 Toast.makeText(MainActivity.this, "点击黏贴", Toast.LENGTH_SHORT).show();
                 break;
        }
        return super.onContextItemSelected(item);

    }

    private ArrayList<String> getData() {
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 5; i++) {
            list.add("菜单"+i);
        }
            return list;
    }
    //实现list菜单
    //实现注册
    //添加长按点击事件
    //设置Toast事件
}
