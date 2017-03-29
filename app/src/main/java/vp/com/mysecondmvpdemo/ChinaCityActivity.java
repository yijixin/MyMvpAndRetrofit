package vp.com.mysecondmvpdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.List;

import vp.com.mysecondmvpdemo.adapter.ChinaCityAdapter;
import vp.com.mysecondmvpdemo.bean.ChinaCity;
import vp.com.mysecondmvpdemo.presenter.ChinaCityPresenter;
import vp.com.mysecondmvpdemo.view.ChinaCityView;

public class ChinaCityActivity extends AppCompatActivity implements ChinaCityView{

    private RecyclerView mRecyCityView;
    private int id,city;
    private ChinaCityAdapter mChinaCityAdapter;

    private ChinaCityPresenter mChinaCityPresenter = new ChinaCityPresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_china_city);
        initView();
        id=getIntent().getIntExtra("id",-1);
        city=getIntent().getIntExtra("city",-1);
        if (id!=-1&&city!=-1){
            mChinaCityPresenter.loadCityData(id,city);
        }
    }

    private void initView() {
        mRecyCityView = (RecyclerView) findViewById(R.id.recy_city_view);
        mRecyCityView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void loadCityData(final List<ChinaCity> pros) {
        mChinaCityAdapter = new ChinaCityAdapter(ChinaCityActivity.this,pros);
        mRecyCityView.setAdapter(mChinaCityAdapter);

        mChinaCityAdapter.setOnItemClickListener(new ChinaCityAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(ChinaCityActivity.this,WeatherActivity.class);
                intent.putExtra("cityId",pros.get(position).getWeather_id());
                startActivity(intent);
            }
        });
    }

    @Override
    public void xiaZaiFail() {
        Toast.makeText(this, "数据下载失败！！！！", Toast.LENGTH_SHORT).show();
    }
}
