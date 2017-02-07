package com.android.jh.basiclist;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

/**
 * Created by Min on 2017-01-31.
 */

public class ListActivity extends AppCompatActivity{
    ListView listView;

    String array[] = {"월","화","수","목","금","토","일"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        //1.리스트뷰를 가져온다
        listView = (ListView) findViewById(R.id.listview);
        //2. 아답터를 정의한다.
        CustomAdapter adapter = new CustomAdapter(array, this);
        //3. 리스트뷰에 아답터를 세팅한다.
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(listener);

    }
    AdapterView.OnItemClickListener listener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
            //1. detailActivity로 변환하기 위해 인텐트 생성
            Intent intent= new Intent(ListActivity.this,DetailActivity.class);

            intent.putExtra("no", position + 1);
            intent.putExtra("day",array[position]);
            startActivity(intent);

        }
    };
}
