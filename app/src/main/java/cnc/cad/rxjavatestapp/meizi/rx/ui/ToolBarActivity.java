package cnc.cad.rxjavatestapp.meizi.rx.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.Toolbar;

import cnc.cad.rxjavatestapp.R;

/**
 * @author :wangjm1
 * @version :1.0
 * @package : cnc.cad.rxjavatestapp.meizi.ui
 * @class : ${CLASS_NAME}
 * @time : 2017/2/24 ${ITME}
 * @description :TODO
 */
public abstract class ToolBarActivity extends BaseActivity {

    private static final String TAG = "ToolBarActivity";

    protected abstract int provideContentViewId();

    protected AppBarLayout mAppBarLayout;
    protected Toolbar mToolbar;

    public void onToolbarClick() {
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(provideContentViewId());

        mAppBarLayout = (AppBarLayout) findViewById(R.id.app_bar_layout);
        mToolbar = (Toolbar) findViewById(R.id.tb_title_base);

        if (mToolbar == null || mAppBarLayout == null) {
            throw new IllegalStateException(
                "The subclass of ToolbarActivity must contain a toolbar.");
        }

//        mToolbar.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });

        mToolbar.setOnClickListener(view -> onToolbarClick());
        setSupportActionBar(mToolbar);



    }
}
