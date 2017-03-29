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
import vp.com.mysecondmvpdemo.presenter.SuccessPresenter;
import vp.com.mysecondmvpdemo.view.SuccessView;

public class SuccessFulActivity extends AppCompatActivity implements SuccessView{

    private RecyclerView mRycView;
    private ChinaAdapter mChinaAdapter;

    private SuccessPresenter mSuccessPresenter = new SuccessPresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success_ful);
        initView();
        mSuccessPresenter.loadChinaProData();
    }

    private void initView() {
        mRycView = (RecyclerView) findViewById(R.id.ryc_view);
        mRycView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void loadChinaProData(final List<ChinaPro> pros) {
        mChinaAdapter = new ChinaAdapter(SuccessFulActivity.this,pros);
        mRycView.setAdapter(mChinaAdapter);

        mChinaAdapter.setOnItemClickListener(new ChinaAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(SuccessFulActivity.this,CityActivity.class);
                intent.putExtra("id",pros.get(position).getId());
                startActivity(intent);
            }
        });
    }

    @Override
    public void xiaFail() {
        Toast.makeText(this, "数据下载失败！！！！", Toast.LENGTH_SHORT).show();
    }
}
