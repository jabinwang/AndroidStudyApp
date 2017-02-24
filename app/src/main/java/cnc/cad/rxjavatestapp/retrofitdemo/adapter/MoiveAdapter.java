package cnc.cad.rxjavatestapp.retrofitdemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cnc.cad.rxjavatestapp.R;
import cnc.cad.rxjavatestapp.retrofitdemo.entity.Subject;

/**
 * @author :wangjm1
 * @version :1.0
 * @package : cnc.cad.rxjavatestapp.retrofitdemo.adapter
 * @class : ${CLASS_NAME}
 * @time : 2017/2/22 ${ITME}
 * @description :TODO
 */
public class MoiveAdapter extends RecyclerView.Adapter<MoiveAdapter.ViewHolder>{

    private List<Subject> dataList;
    private Context mContext;

    public MoiveAdapter(List<Subject> dataList, Context context){
        this.dataList = dataList;
        this.mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.item_movie_display, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Picasso.with(mContext)
            .load(((dataList.get(position).getImages().getLarge())))
            .into(holder.mImageView);
        holder.mTitleTv.setText(dataList.get(position).getTitle());
        holder.mTitleEnTv.setText(dataList.get(position).getOriginal_title());
        holder.mTimeTv.setText(dataList.get(position).getYear());
    }

    @Override
    public int getItemCount() {
        return dataList == null? 0: dataList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.movieImgIv)
        ImageView mImageView;

        @BindView(R.id.titleTv)
        TextView mTitleTv;

        @BindView(R.id.titleEnTv)
        TextView mTitleEnTv;

        @BindView(R.id.timeTv)
        TextView mTimeTv;

        public ViewHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);
        }
    }
}
