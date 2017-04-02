package com.krunal.rxdialog;

import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import com.kevadiyakrunalk.rxdialog.DialogType;
import com.kevadiyakrunalk.rxdialog.RxAlertDialog;
import com.kevadiyakrunalk.rxdialog.RxProgressDialog;
import com.kevadiyakrunalk.rxdialog.RxPromptDialog;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.internal.util.SubscriptionList;

public class MainActivity extends AppCompatActivity {

    private SubscriptionList subscriptionList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        subscriptionList = new SubscriptionList();
    }

    @Override
    protected void onDestroy() {
        subscriptionList.unsubscribe();
        super.onDestroy();
    }

    public void onPromptInfo(View view) {
        subscriptionList.add(
                new RxPromptDialog.Builder(MainActivity.this)
                        .title(R.string.dialog_title)
                        .message(R.string.dialog_message)
                        .singleButton(R.string.dialog_cancel)
                        .cancellable(Boolean.TRUE)
                        .type(DialogType.INFO)
                        .canceledOnTouchOutside(Boolean.FALSE)
                        .setDefaultAnimation(true)
                        .toObservable()
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Action1<Integer>() {
                            @Override
                            public void call(Integer which) {
                                Log.e("Alert", "Which->" + which);
                            }
                        }));
    }

    public void onPromptHelp(View view) {
        subscriptionList.add(
                new RxPromptDialog.Builder(MainActivity.this)
                        .title(R.string.dialog_title)
                        .message(R.string.dialog_message)
                        .singleButton(R.string.dialog_cancel)
                        .cancellable(Boolean.TRUE)
                        .type(DialogType.HELP)
                        .canceledOnTouchOutside(Boolean.FALSE)
                        .setDefaultAnimation(false)
                        .toObservable()
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Action1<Integer>() {
                            @Override
                            public void call(Integer which) {
                                Log.e("Alert", "Which->" + which);
                            }
                        }));
    }

    public void onPromptSuccess(View view) {
        subscriptionList.add(
                new RxPromptDialog.Builder(MainActivity.this)
                        .title(getString(R.string.dialog_title))
                        .message(getString(R.string.dialog_message))
                        .doubleButton(getString(R.string.dialog_ok), getString(R.string.dialog_cancel))
                        .cancellable(Boolean.FALSE)
                        .type(DialogType.SUCCESS)
                        .canceledOnTouchOutside(Boolean.FALSE)
                        .setDefaultAnimation(false)
                        .toObservable()
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Action1<Integer>() {
                            @Override
                            public void call(Integer which) {
                                Log.e("Alert", "Which->" + which);
                            }
                        }));
    }

    public void onPromptWrong(View view) {
        subscriptionList.add(
                new RxPromptDialog.Builder(MainActivity.this)
                        .title(getString(R.string.dialog_title))
                        .message(getString(R.string.dialog_message))
                        .doubleButton(getString(R.string.dialog_ok), getString(R.string.dialog_cancel))
                        .cancellable(Boolean.FALSE)
                        .type(DialogType.WRONG)
                        .canceledOnTouchOutside(Boolean.FALSE)
                        .setDefaultAnimation(false)
                        .toObservable()
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Action1<Integer>() {
                            @Override
                            public void call(Integer which) {
                                Log.e("Alert", "Which->" + which);
                            }
                        }));
    }

    public void onAlertMsg(View view) {
        subscriptionList.add(
                new RxAlertDialog.Builder(MainActivity.this)
                        .title(R.string.dialog_title)
                        .message(R.string.dialog_message)
                        .singleButton(R.string.dialog_cancel)
                        .cancellable(Boolean.FALSE)
                        .canceledOnTouchOutside(Boolean.FALSE)
                        .setDefaultAnimation(true)
                        .toObservable()
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Action1<Integer>() {
                            @Override
                            public void call(Integer which) {
                                Log.e("Alert", "Which->" + which);
                            }
                        }));
    }

    public void onAlertImage(View view) {
        subscriptionList.add(
                new RxAlertDialog.Builder(MainActivity.this)
                        .title(R.string.dialog_title)
                        .image(R.drawable.sample_img)
                        .singleButton(R.string.dialog_cancel)
                        .cancellable(Boolean.FALSE)
                        .canceledOnTouchOutside(Boolean.FALSE)
                        .setDefaultAnimation(true)
                        .toObservable()
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Action1<Integer>() {
                            @Override
                            public void call(Integer which) {
                                Log.e("Alert", "Which->" + which);
                            }
                        }));
    }

    public void onAlertMsgImage(View view) {
        subscriptionList.add(
                new RxAlertDialog.Builder(MainActivity.this)
                        .title(getString(R.string.dialog_title))
                        .message(getString(R.string.dialog_message))
                        .image(ContextCompat.getDrawable(MainActivity.this, R.drawable.sample_img))
                        .doubleButton(getString(R.string.dialog_ok), getString(R.string.dialog_cancel))
                        .cancellable(Boolean.TRUE)
                        .canceledOnTouchOutside(Boolean.FALSE)
                        .setDefaultAnimation(false)
                        .toObservable()
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Action1<Integer>() {
                            @Override
                            public void call(Integer which) {
                                Log.e("Alert", "Which->" + which);
                            }
                        }));
    }

    public void onAlertView(View view) {
        View view1 = LayoutInflater.from(MainActivity.this).inflate(R.layout.custom_dialog, null);
        subscriptionList.add(
                new RxAlertDialog.Builder(MainActivity.this)
                        .title(getString(R.string.dialog_title))
                        .view(view1)
                        .singleButton(getString(R.string.dialog_cancel))
                        .cancellable(Boolean.TRUE)
                        .canceledOnTouchOutside(Boolean.FALSE)
                        .setDefaultAnimation(false)
                        .toObservable()
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Action1<Integer>() {
                            @Override
                            public void call(Integer which) {
                                Log.e("Alert", "Which->" + which);
                            }
                        }));
    }

    public void onAlertViewRes(View view) {
        subscriptionList.add(
                new RxAlertDialog.Builder(MainActivity.this)
                        .title(R.string.dialog_title)
                        .view(R.layout.custom_dialog)
                        .doubleButton(R.string.dialog_ok, R.string.dialog_cancel)
                        .cancellable(Boolean.TRUE)
                        .canceledOnTouchOutside(Boolean.TRUE)
                        .setDefaultAnimation(false)
                        .toObservable()
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Action1<Integer>() {
                            @Override
                            public void call(Integer which) {
                                Log.e("Alert", "Which->" + which);
                            }
                        }));
    }

    public void onProgress(View view) {
        Observable<String> zipObservable = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(final Subscriber<? super String> subscriber) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        subscriber.onNext("Dismiss dialog");
                        subscriber.unsubscribe();
                    }
                }, 5000);
            }
        });

        new RxProgressDialog.Builder(MainActivity.this)
                .message("Please Wait…")
                .cancellable(false)
                .toObservable(zipObservable)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<String>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("RESULT", e.toString());
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e("RESULT", s);
                    }
                });
    }
}
