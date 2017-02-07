package com.android.jh.basiclist;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by JH on 2017-01-31.
 */

public class RecyclerCustomAdapter extends RecyclerView.Adapter<RecyclerCustomAdapter.CustomViewHolder>{
    ArrayList<User> datas;
    int itemLayout;
    public RecyclerCustomAdapter(ArrayList<User> datas,int itemLayout){
        this.datas = datas;
        this.itemLayout = itemLayout;
    }
    //view를 생성해서 홀더에 저장하는역할
    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(itemLayout,parent,false);
        CustomViewHolder cvh = new CustomViewHolder(view);
        return cvh;
    }

    // listView 에서의 getview를 대체 하는 함수
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        User user = datas.get(position);

    }
    //데이터 총 개수
    @Override
    public int getItemCount() {
        return 0;
    }
    public class CustomViewHolder extends RecyclerView.ViewHolder{
        TextView txtId,txtName,txtAge;
        public CustomViewHolder(View view) {
            super(view);
            //생성자가 호출되는 순간
        }
    }
}