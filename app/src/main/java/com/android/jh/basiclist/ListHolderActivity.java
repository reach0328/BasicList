package com.android.jh.basiclist;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Random;

public class ListHolderActivity extends AppCompatActivity {

    ArrayList<User> datas = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_holder);
        load();
        ListView listView = (ListView) findViewById(R.id.listHolderView);
        CustomHolderAdapter adapter = new CustomHolderAdapter(datas,this);
        listView.setAdapter(adapter);
    }

    private void load(){
        Random random = new Random();

        //datas에
        for(int i =0;i<100;i++){
            User user = new User();
            user.id = i+1;
            user.name = "홍길동"+user.id;
            user.age = random.nextInt(80);

            datas.add(user);
        }
    }
    class CustomHolderAdapter extends BaseAdapter{
        ArrayList<User> datas;
        LayoutInflater inflater ;
        public CustomHolderAdapter(ArrayList<User> datas, Context context) {
            this.datas = datas;
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return datas.size();
        }

        @Override
        public Object getItem(int i) {
            return datas.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            /*Holder holder;
            //뷰행이 화면에 보여져서 생산된 적이 있다면 재사용

            if(view == null){
                view = inflater.inflate(R.layout.activity_list_holder,null);
                holder = new Holder();
                //생성한 위젯을 담아놓기 위한 임시 공간
                holder.txtNo = (TextView)view.findViewById(R.id.txtNo);
                holder.txtName = (TextView)view.findViewById(R.id.txtName);
                holder.txtAge = (TextView) view.findViewById(R.id.txtAge);

                view.setTag(holder);
            }else {
                Holder holder = (Holder)view.getTag();
            }
            User user =  datas.get(i);
            holder.txtNo.setText(user.id +"");
            holder.txtName.setText(user.name);
            holder.txtAge.setText(user.age+"");
            */
            return view;
        }

    }
}

