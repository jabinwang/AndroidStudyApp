package cnc.cad.rxjavatestapp.meizi.rx.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import cnc.cad.rxjavatestapp.R;

/**
 * @author :wangjm1
 * @version :1.0
 * @package : cnc.cad.rxjavatestapp.meizi.ui
 * @class : ${CLASS_NAME}
 * @time : 2017/2/24 ${ITME}
 * @description :TODO
 */
public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_about:
                return false;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
