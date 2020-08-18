package com.lgj.myapplication;

import android.os.Bundle;
import android.webkit.WebView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.lgj.myapplication.R;
import com.lgj.myapplication.adapter.MyAdapter;
import com.lgj.myapplication.bean.PersonBean;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 刘桂杰
 * @package com.lgj.myapplication
 * @date 2020/8/14 11:10
 * @description $
 */
public class OneActivity extends AppCompatActivity {

    private WebView webView;
    private MyAdapter adapter;
    private List<PersonBean> list;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_layout);
        RecyclerView recycler = findViewById(R.id.recycler);
        initData();
        adapter = new MyAdapter(this);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if (adapter.getItemViewType(position)==PersonBean.itemTypeDate){
                    return 2;
                }
                return 1;
            }
        });

        recycler.setLayoutManager(gridLayoutManager);
        recycler.setAdapter(adapter);
        adapter.setData(list);
    }

    private void initData() {
        list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            PersonBean dateBean=new PersonBean("2020.8.1"+i,PersonBean.itemTypeDate);
            list.add(dateBean);
            if (i %2==0) {
                for (int j = 0; j < 3; j++) {
                    PersonBean ImageBean=new PersonBean("https://dss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=1151900487,4024660079&fm=26&gp=0.jpg",PersonBean.itemTypeImage);
                    list.add(ImageBean);
                }
            }else {
                PersonBean ImageBean=new PersonBean("https://dss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=1151900487,4024660079&fm=26&gp=0.jpg",PersonBean.itemTypeImage);
                list.add(ImageBean);
            }
        }
    }
}
