package com.android.jh.basiclist;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {

//xml 파일 메모리올라가면 무조건 자바파일로 xml파일 ->자바 코드로 바꿔주는게 inflater // setContentView가 객체로 올려서 해주는데 getView는 안됨
    //getVIew에서 행 하나하나를 클래스로 만들어주는 역할이 inflater

    LayoutInflater inflater;
    String datas[];

    public CustomAdapter(String datas[], Context context) {
        //getView 레이아웃을 객체로 전환해 주는 inflater를 가져온다

        inflater =  (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.datas =datas;
    }

    @Override
    public int getCount() {
        return datas.length;
    }

    @Override
    public Object getItem(int position) {
        return datas[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    //시스템이 호출, 화면에서 월이란 글자를 데이터 가져와서 getView를 통해서 뷰 하나를 가져오는 것
    //리스트 아답터에서 뷰는 한 행단위이다.
    // 한 행단위를 개발자가 직접 만들어서 시스템에 넘겨줘야 한다.
    public View getView(int position, View convertView, ViewGroup parent) {

        //1.한행에 해당하는 레이아웃 xml을 객체로 반환한다
        if(convertView == null) //한번 화면에 세팅했던 햄은 convertView에 담겨져서 돌아온다
            convertView = inflater.inflate(R.layout.list_item,null);


        // 2.inflater 된 뷰를 통해서 findviewbyid 함수 사용한다
        TextView txtNo = (TextView)convertView.findViewById(R.id.txtNumber);
        TextView txtDay = (TextView)convertView.findViewById(R.id.txtDay);

        //3. inflate 된 뷰의 위젯에 값을 세팅한다.
        txtNo.setText((position + 1) +"");
        txtDay.setText(datas[position]);
        // 4.완성된 한행의 뷰를 시스템에 넘겨준다.

        return convertView;
    }
}
