package cnc.cad.rxjavatestapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

/**
 * @author :wangjm1
 * @version :1.0
 * @package : cnc.cad.rxjavatestapp
 * @class : ${CLASS_NAME}
 * @time : 2017/2/20 ${ITME}
 * @description :TODO
 */
public class SimpleExampleCoordinator extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_coordinator);


        CollapsingToolbarLayout collapsingToolbarLayout
            = (CollapsingToolbarLayout) findViewById(R.id.simple_ctb);

        collapsingToolbarLayout.setTitle("simple example coordinator");

        Toolbar toolbar = (Toolbar) findViewById(R.id.simple_tb);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

    }

    public static void start(Context context){
        context.startActivity(new Intent(context, SimpleExampleCoordinator.class));
    }
}
