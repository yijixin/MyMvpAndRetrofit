package vp.com.mysecondmvpdemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import vp.com.mysecondmvpdemo.R;
import vp.com.mysecondmvpdemo.bean.ChinaCity;

/**
 * Created by Administrator on 2017/3/29.
 */

public class ChinaCityAdapter extends RecyclerView.Adapter<ChinaCityAdapter.MyViewHolder> {

    private Context mContext;
    private List<ChinaCity> mCities;
    private OnItemClickListener mOnItemClickListener;

    public ChinaCityAdapter(Context context, List<ChinaCity> cities) {
        mContext = context;
        mCities = cities;
    }

    public void setOnItemClickListener(OnItemClickListener mOnItemClickListener){
        this.mOnItemClickListener = mOnItemClickListener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_view_city_holder,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        holder.tvName.setText(mCities.get(position).getName());
        holder.tvWeatherId.setText(mCities.get(position).getWeather_id());

        holder.llCity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnItemClickListener.onItemClick(holder.itemView,position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mCities.size();
    }

    public interface OnItemClickListener{
        void onItemClick(View view,int position);
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tvName,tvWeatherId;
        LinearLayout llCity;

        public MyViewHolder(View itemView) {
            super(itemView);
            tvName = ((TextView) itemView.findViewById(R.id.tv_city_name));
            tvWeatherId = ((TextView) itemView.findViewById(R.id.tv_city_weather_id));
            llCity = ((LinearLayout) itemView.findViewById(R.id.ll_city_item));
        }
    }
}
