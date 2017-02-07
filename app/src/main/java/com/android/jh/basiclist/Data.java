package com.android.jh.basiclist;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by JH on 2017-01-31.
 */

public class Data {
    private ArrayList<User> datas;
    public Data(){
        datas = new ArrayList<>();
        load();
    }
    public ArrayList<User> getDatas(){
        return datas;
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

}
