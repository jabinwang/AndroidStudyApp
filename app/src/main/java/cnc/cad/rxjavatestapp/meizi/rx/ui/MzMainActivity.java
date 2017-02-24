package cnc.cad.rxjavatestapp.meizi.rx.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;
import cnc.cad.rxjavatestapp.R;

/**
 * @author :wangjm1
 * @version :1.0
 * @package : cnc.cad.rxjavatestapp.meizi.ui
 * @class : ${CLASS_NAME}
 * @time : 2017/2/24 ${ITME}
 * @description :TODO
 */
public class MzMainActivity extends SwipeRefreshBaseActivity {


    @BindView(R.id.recyv_list)
    RecyclerView mRecyclerView;


    @Override
    protected int provideContentViewId() {
        return R.layout.activity_mz_main;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTheme(R.style.MzAppTheme);
        ButterKnife.bind(this);


    }
}
