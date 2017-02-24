package cnc.cad.rxjavatestapp.retrofitdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cnc.cad.rxjavatestapp.R;
import cnc.cad.rxjavatestapp.retrofitdemo.adapter.MoiveAdapter;
import cnc.cad.rxjavatestapp.retrofitdemo.entity.Subject;
import cnc.cad.rxjavatestapp.retrofitdemo.http.HttpMethods;
import cnc.cad.rxjavatestapp.retrofitdemo.subscribers.ProgressSubscriber;
import cnc.cad.rxjavatestapp.retrofitdemo.subscribers.SubscriberOnNextListener;

/**
 * @author :wangjm1
 * @version :1.0
 * @package : cnc.cad.rxjavatestapp.retrofitdemo
 * @class : ${CLASS_NAME}
 * @time : 2017/2/21 ${ITME}
 * @description :TODO
 */
public class TestRetrofitDemoActivity extends AppCompatActivity{

    @BindView(R.id.click_me_BN)
    Button clickMeBN;

//    @BindView(R.id.result_TV)
//    TextView resultTV;

    @BindView(R.id.showMovieRv)
    RecyclerView mRecyclerView;

    private SubscriberOnNextListener getTopMovieOnNext;
    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerView.Adapter mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_retrofit_display);

        ButterKnife.bind(this);



        getTopMovieOnNext = new SubscriberOnNextListener<List<Subject>>() {
            @Override
            public void onNext(List<Subject> subjects) {
//                resultTV.setText(subjects.toString());

                initData(subjects);
            }
        };
    }

    private void initData(List<Subject> data){
        mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new MoiveAdapter(data, this);
        mRecyclerView.setAdapter(mAdapter);
    }

    @OnClick(R.id.click_me_BN)
    public void onClick() {
        getMovie();
    }

    //进行网络请求
    private void getMovie(){
        HttpMethods.getInstance().getTopMovie(
            new ProgressSubscriber(getTopMovieOnNext, TestRetrofitDemoActivity.this), 0, 10);
    }
}
