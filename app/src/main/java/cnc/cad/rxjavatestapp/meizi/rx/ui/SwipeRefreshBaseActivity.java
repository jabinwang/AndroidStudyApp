package cnc.cad.rxjavatestapp.meizi.rx.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import cnc.cad.rxjavatestapp.R;
import cnc.cad.rxjavatestapp.meizi.rx.SwipRefresh;
import cnc.cad.rxjavatestapp.meizi.rx.widget.MultiSwipeRefreshLayout;

/**
 * @author :wangjm1
 * @version :1.0
 * @package : cnc.cad.rxjavatestapp.meizi.rx.ui
 * @class : ${CLASS_NAME}
 * @time : 2017/2/24 ${ITME}
 * @description :TODO
 */
public class SwipeRefreshBaseActivity extends ToolBarActivity implements SwipRefresh{

    @BindView(R.id.srf_refresh)
    MultiSwipeRefreshLayout mMultiSwipeRefreshLayout;
    private boolean mIsRequestDataRefresh = false;

    @Override
    protected int provideContentViewId() {
        return 0;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
    }

    private void trySetupSwipeRefresh(){
        if(mMultiSwipeRefreshLayout != null){
            mMultiSwipeRefreshLayout.setColorSchemeResources(R.color.refresh_progress_1,
                R.color.refresh_progress_2, R.color.refresh_progress_3);
            mMultiSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                @Override
                public void onRefresh() {
                    requestDataRefresh();
                }
            });
        }
    }

    @Override
    public void requestDataRefresh() {
        mIsRequestDataRefresh = true;
    }

    @Override
    public void setRefresh(boolean refresh) {
        if(mMultiSwipeRefreshLayout == null)
            return;

        if(!refresh){
            mIsRequestDataRefresh = false;
            // TODO: 2017/2/24 这边可能需要修改
            mMultiSwipeRefreshLayout.setRefreshing(false);
        }else {
            mMultiSwipeRefreshLayout.setRefreshing(true);
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
