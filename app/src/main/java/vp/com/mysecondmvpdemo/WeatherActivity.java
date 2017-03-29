package vp.com.mysecondmvpdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import vp.com.mysecondmvpdemo.bean.Weather;
import vp.com.mysecondmvpdemo.presenter.WeatherPresenter;
import vp.com.mysecondmvpdemo.view.WeatherView;

public class WeatherActivity extends AppCompatActivity implements WeatherView{

    private TextView mTvWeatherCity;
    private TextView mTvWeatherCond;
    private TextView mTvWeatherWindDir;
    private TextView mTvWeatherWindSc;
    private TextView mTvWeatherSport;

    private String cityId;
    private String key = "bc0418b57b2d4918819d3974ac1285d9";

    private WeatherPresenter mWeatherPresenter = new WeatherPresenter(this);
    private Button mBtnPic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        initView();
        cityId = getIntent().getStringExtra("cityId");
        mWeatherPresenter.loadWeatherData(cityId,key);
    }

    private void initView() {
        mTvWeatherCity = (TextView) findViewById(R.id.tv_weather_city);
        mTvWeatherCond = (TextView) findViewById(R.id.tv_weather_cond);
        mTvWeatherWindDir = (TextView) findViewById(R.id.tv_weather_wind_dir);
        mTvWeatherWindSc = (TextView) findViewById(R.id.tv_weather_wind_sc);
        mTvWeatherSport = (TextView) findViewById(R.id.tv_weather_sport);
        mBtnPic = ((Button) findViewById(R.id.btn_pic));
        mBtnPic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WeatherActivity.this,ImageActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void loadWeatherData(Weather weather) {
        mTvWeatherCity.setText(weather.getHeWeather().get(0).getBasic().getCity());
        mTvWeatherCond.setText(weather.getHeWeather().get(0).getNow().getCond().getTxt());
        mTvWeatherWindDir.setText(weather.getHeWeather().get(0).getNow().getWind().getDir());
        mTvWeatherWindSc.setText(weather.getHeWeather().get(0).getNow().getWind().getSc());
        mTvWeatherSport.setText(weather.getHeWeather().get(0).getSuggestion().getSport().getTxt());
    }

    @Override
    public void loadFail() {
        Toast.makeText(this, "数据下载失败！！！！", Toast.LENGTH_SHORT).show();
    }
}
