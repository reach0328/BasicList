package com.android.jh.basiclist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class RecycleActivity extends AppCompatActivity {
    ArrayList<User> datas = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle);
        Data data = new Data();
        datas = data.getDatas();
        //1. Recycler view 가져오기
        RecyclerView rv = (RecyclerView)findViewById(R.id.recyclerView);
        // Adapter 생성
        RecyclerCustomAdapter rca =  new RecyclerCustomAdapter(datas,R.id.listHolderView);
        // recycler View에 adapter세팅

        // Recycler view 매니저 등록하기 ( 뷰모양을 결정, 그리드, 일반리스트, 비대칭,)
    }
}
