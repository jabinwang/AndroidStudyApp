package cnc.cad.rxjavatestapp.splash;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * @author :wangjm1
 * @version :1.0
 * @package : cnc.cad.rxjavatestapp.splash
 * @class : ${CLASS_NAME}
 * @time : 2017/2/17 ${ITME}
 * @description :TODO
 */
public class SplashActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //调用welcomeActivity
        startActivity(new Intent(SplashActivity.this, WelcomeActivity.class));
        this.finish();
    }
}
