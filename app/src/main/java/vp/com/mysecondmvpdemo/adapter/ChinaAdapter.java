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
import vp.com.mysecondmvpdemo.bean.ChinaPro;

/**
 * Created by Administrator on 2017/3/28.
 */

public class ChinaAdapter extends RecyclerView.Adapter<ChinaAdapter.MyViewHolder>{

    private Context mContext;
    private List<ChinaPro> datas;
    public OnItemClickListener mOnItemClickListener;
    public ChinaAdapter(Context mContext,List<ChinaPro> datas) {
        this.mContext = mContext;
        this.datas = datas;
    }

    public void setOnItemClickListener(OnItemClickListener mOnItemClickListener){
        this.mOnItemClickListener = mOnItemClickListener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_view_holder,parent,false);
        MyViewHolder myVieweHolder = new MyViewHolder(view);
        return myVieweHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        holder.tvId.setText(datas.get(position).getId()+"");
        holder.tvName.setText(datas.get(position).getName());
        if (mOnItemClickListener!=null){
            holder.llItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnItemClickListener.onItemClick(holder.itemView,position);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public interface OnItemClickListener{
        void onItemClick(View view,int position);
    }

   class MyViewHolder extends RecyclerView.ViewHolder{

       TextView tvId,tvName;
       LinearLayout llItem;
       
       public MyViewHolder(View itemView) {
           super(itemView);
           tvId = ((TextView) itemView.findViewById(R.id.tv_id));
           tvName = ((TextView) itemView.findViewById(R.id.tv_name));
           llItem = ((LinearLayout) itemView.findViewById(R.id.ll_item));
       }
   }
}
