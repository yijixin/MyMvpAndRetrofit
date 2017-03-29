package vp.com.mysecondmvpdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.List;

import vp.com.mysecondmvpdemo.adapter.ChinaAdapter;
import vp.com.mysecondmvpdemo.bean.ChinaPro;
import vp.com.mysecondmvpdemo.presenter.CityPresenter;
import vp.com.mysecondmvpdemo.view.CityView;

public class CityActivity extends AppCompatActivity implements CityView{

    private RecyclerView mRcyCityView;
    private int id;

    private CityPresenter mCityPresenter = new CityPresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city);
        initView();
        id = getIntent().getIntExtra("id",-1);
        if (id!=-1) {
            mCityPresenter.loadCityData(id);
        }
    }

    private void initView() {
        mRcyCityView = (RecyclerView) findViewById(R.id.rcy_city_view);
        mRcyCityView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void loadCityData(final List<ChinaPro> pros) {
        ChinaAdapter chinaAdapter = new ChinaAdapter(CityActivity.this,pros);
        mRcyCityView.setAdapter(chinaAdapter);

        chinaAdapter.setOnItemClickListener(new ChinaAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(CityActivity.this,ChinaCityActivity.class);
                intent.putExtra("id",id);
                intent.putExtra("city",pros.get(position).getId());
                startActivity(intent);
            }
        });
    }

    @Override
    public void xiaZaiFail() {
        Toast.makeText(this, "数据下载失败！！！！", Toast.LENGTH_SHORT).show();
    }
}
