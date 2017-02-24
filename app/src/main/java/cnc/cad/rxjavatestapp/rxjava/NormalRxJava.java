package cnc.cad.rxjavatestapp.rxjava;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import cnc.cad.rxjavatestapp.R;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;


/**
 * @author :wangjm1
 * @version :1.0
 * @package : cnc.cad.rxjavatestapp.rxjava
 * @class : ${CLASS_NAME}
 * @time : 2017/2/20 ${ITME}
 * @description :TODO
 */
public class NormalRxJava extends Activity implements View.OnClickListener {
    private TextView mText;
    private Button mBtn;
    private TextView mEdit;
    static String str = "hi, this is a  test for rxjava\n it is good\n ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout1);

        initView();
    }

    private void initView() {
        mText = (TextView) findViewById(R.id.text1);
        mEdit = (TextView) findViewById(R.id.edit1);
        mBtn = (Button) findViewById(R.id.button);
        mEdit.setText(str);


        mBtn.setOnClickListener(this);
        mText.setOnClickListener(this);
        mEdit.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.text1:
                break;
            case R.id.edit1:
                break;
            case R.id.button:
                if (mText.getText().toString() != null || mText.getText().toString().length() > 0) {
                    mText.setText("");
                }
                start();
                break;
        }
    }

    private void start() {

        //创建观察者 被观察者
        Observable<String> observable = createObservable();
        Subscriber<String> subscriber = createSubscriber();

        mText.append("rxjava begin...\n");
//        observable.subscribe(subscriber);

        //
        observable.subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                mText.append("action1\n");
                mText.append(s+"\n");
            }
        });
    }


    private Subscriber<String> createSubscriber() {
        // create
        Subscriber<String> subscriber = new Subscriber<String>() {
            @Override
            public void onCompleted() {
                mText.append("subscriber onComplete\n");
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                mText.append("subscriber onNext\n");
                mText.append(s + "\n");
            }
        };

        return subscriber;
    }


    private Observable<String> createObservable(){
//        Observable<String> observable = Observable.create(new Observable.OnSubscribe<String>() {
//            @Override
//            public void call(Subscriber<? super String> subscriber) {
//                subscriber.onNext("hi, this is a  test for rxjava");
//                subscriber.onNext("it is good");
//                subscriber.onCompleted();
//            }
//        });

//        Observable<String> observable = Observable.just("hi, this is a  test for rxjava", "it is good");
        String[] array = {"hi, this is a  test for rxjava", "it is good"};
        Observable<String> observable = Observable.from(array);
        return observable;
    }


}
