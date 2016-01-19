package davidwang.tm.dwcorephoto;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import davidwang.tm.adapter.MainListAdapter;
import davidwang.tm.model.MainInfo;

public class MainActivity extends BaseActivity implements  AdapterView.OnItemClickListener{

    private ListView main_list;
    private MainListAdapter adapter;
    private ArrayList<MainInfo> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findID();
        inData();
        adapter = new MainListAdapter(this,data);
        main_list.setAdapter(adapter);
        AddToolbar();
    }

    protected void findID(){
        main_list = (ListView)findViewById(R.id.main_list);
        main_list.setOnItemClickListener(this);
    }

    protected void inData() {
        data = new ArrayList<MainInfo>();
        MainInfo info = new MainInfo();
        info.content = "SingleShow";
        data.add(info);

        MainInfo info1 = new MainInfo();
        info1.content = "TableViewShow";
        data.add(info1);

        MainInfo info2 = new MainInfo();
        info2.content = "CollectionShow";
        data.add(info2);

        MainInfo info3 = new MainInfo();
        info3.content = "MixShow";
        data.add(info3);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = null;
        switch (position){
            case 0:
                intent = new Intent(MainActivity.this,SingleShow.class);
                intent.putExtra("title",data.get(0).content);
                break;
            case 1:
                intent = new Intent(MainActivity.this,ListViewActivity .class);
                intent.putExtra("title",data.get(1).content);
                break;
            case 2:
                intent = new Intent(MainActivity.this,GridViewActivity.class);
                intent.putExtra("title",data.get(2).content);
                break;
            case 3:
                intent = new Intent(MainActivity.this,MixShowActivity.class);
                intent.putExtra("title",data.get(3).content);
                break;
        }
        if (intent != null)
            startActivity(intent);
    }

}
