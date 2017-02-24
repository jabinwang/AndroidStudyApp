package cnc.cad.rxjavatestapp.rxjava;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import cnc.cad.rxjavatestapp.R;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * @author :wangjm1
 * @version :1.0
 * @package : cnc.cad.rxjavatestapp.rxjava
 * @class : ${CLASS_NAME}
 * @time : 2017/2/21 ${ITME}
 * @description :TODO
 */
public class MapRxJava extends Activity implements View.OnClickListener {

    private TextView mText;
    private Button mBtn;
    private TextView mEdit;
    private Integer [] number={1,2,3,4,5,6};
    private ImageView mShow;

    private static final String PATH="https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1487657547554&di=614083a629c511d98f853b7edda5ec6f&imgtype=0&src=http%3A%2F%2Fimg0.ph.126.net%2FY3AM_Lxfz4fonBDQpNlkSQ%3D%3D%2F6597234693400985046.jpg";

    private static final String TAG = "MapRxJava";
    //
    private OkHttpClient mOkHttpClient;

    private static final long MAXLENGTH = 5*1024*1024*1024;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.layout2);

        initView();
    }

    private void initView(){
        mText= (TextView) findViewById(R.id.text1);
        mEdit= (TextView) findViewById(R.id.edit1);
        mBtn= (Button) findViewById(R.id.button);
        mBtn.setText("判断数组中的小于3的数");
        mEdit.setText("输入Integer(int)：1,2,3,4,5,6 \n"+"\n"+"输出：type:true/false \n");

        mShow = (ImageView) findViewById(R.id.showIv);

        mOkHttpClient = new OkHttpClient();

        mBtn.setOnClickListener(this);
        mText.setOnClickListener(this);
        mEdit.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.text1:
                break;
            case R.id.edit1:
                break;
            case R.id.button:
                if(mText.getText().toString()!=null ||mText.getText().toString().length()>0){
                    mText.setText("");
                }
                start(PATH);
                break;
        }
    }

    private void start(final String path) {

        Observable.just(path)
            .map(new Func1<String, Bitmap>() {
                @Override
                public Bitmap call(String s) {
                    try {
                        return createBitmapFromPath(path);
                    } catch (IOException e) {
                        e.printStackTrace();
                        return null;
                    }
                }
            }).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(new Subscriber<Bitmap>() {
                @Override
                public void onCompleted() {
                    mText.append("onCompleted\n");
                }

                @Override
                public void onError(Throwable e) {

                }

                @Override
                public void onNext(Bitmap bitmap) {
                    mText.append("onNext\n");
                    showBitmap(bitmap);
                }
            });
    }

    private Bitmap createBitmapFromPath(String path) throws IOException {
        Bitmap bitmap = downBitmap(path);

        if(bitmap != null){
            return bitmap;
        }
        return null;
    }


    private Bitmap downBitmap(String path) throws IOException {
        if(mOkHttpClient == null){
            mOkHttpClient = new OkHttpClient();
        }

        Request request = new Request.Builder().url(path).build();

        Response response  = mOkHttpClient.newCall(request).execute();
        if(response.isSuccessful()){
            //转化成bitmap
            InputStream inputStream = response.body().byteStream();
            byte[] data = readFromInputStream(inputStream);
            Bitmap bitmap = BitmapFactory.decodeByteArray(data, 0, data.length);
            return bitmap;
        }
        return null;
    }

    private byte[] readFromInputStream(InputStream in) throws IOException {
        byte[] buffer = new byte[1024];
        int len = 0;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        while((len = in.read(buffer)) != -1){
            Log.e(TAG, "down from network Byte:"+len);
            bos.write(buffer, 0 , len);
        }
        bos.close();
        return bos.toByteArray();
    }

    private void showBitmap(Bitmap bitmap){

        mShow.setImageBitmap(bitmap);
    }
}
