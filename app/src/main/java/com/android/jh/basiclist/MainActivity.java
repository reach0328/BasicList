package com.android.jh.basiclist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnList, btnHolder, btnRecycle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnList= (Button)findViewById(R.id.btnList);
        btnHolder =(Button)findViewById(R.id.btnHolder);
        btnRecycle= (Button)findViewById(R.id.btnRecycle);

        btnList.setOnClickListener(listener);
        btnHolder.setOnClickListener(listener);
        btnRecycle.setOnClickListener(listener);

    }

    //1. 리스너를 정의한다
    View.OnClickListener listener = new View.OnClickListener() {

        @Override
        public void onClick(View view) {
            Intent intent = null;

            switch (view.getId()) {
                case R.id.btnList:
                    intent = new Intent(MainActivity.this, ListActivity.class);
                    startActivity(intent);
                    break;
                case R.id.btnHolder:
                    intent = new Intent(MainActivity.this, ListHolderActivity.class);
                    startActivity(intent);
                    break;
                case R.id.btnRecycle:
                    intent = new Intent(MainActivity.this, RecycleActivity.class);
                    startActivity(intent);
                    break;
            }
        }
    };
}