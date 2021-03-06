package inami.myapplication;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;

import com.anandmuralidhar.simplearandroid.R;

public class MainActivity extends AppCompatActivity {


    ImageButton logbtn1;
    ImageButton logbtn2;
    ImageButton logbtn3;
    Handler handler;
    Animation fade_in;
    ProgressDialog dialog;
    Handler DialogHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainpage_activity);
        handler = new Handler();
        fade_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fadein);

        findViewById(R.id.logbtn1).setOnClickListener(
                new ImageButton.OnClickListener() {
                    public void onClick(View v) {

                        dialog = ProgressDialog.show(MainActivity.this, "", "로그인 중 입니다.", true);
                        dialog.show();
                        EndDialog endDialog = new EndDialog();
                        endDialog.start();
//                        new Thread(new Runnable() {
//                            @Override
//                            public void run() {
//                                    handler.post(new Runnable() {
//                                        @Override
//                                        public void run() {
//                                            Intent intent1 = new Intent(MainActivity.this, SearchActivity.class);
//                                            startActivity(intent1);
//                                            overridePendingTransition(R.anim.fadein, R.anim.fadeout);
//
//                                        }
//                                    });
//                            }
//                        }).start();

                    }
                }
        );

        findViewById(R.id.logbtn2).setOnClickListener(
                new ImageButton.OnClickListener() {
                    public void onClick(View v) {
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                handler.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        Intent intent1 = new Intent(MainActivity.this, SearchActivity.class);
                                        startActivity(intent1);
                                        overridePendingTransition(R.anim.fadein, R.anim.fadeout);

                                    }
                                });
                            }
                        }).start();

                    }
                }
        );

        findViewById(R.id.logbtn3).setOnClickListener(
                new ImageButton.OnClickListener() {
                    public void onClick(View v) {
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                handler.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        Intent intent1 = new Intent(MainActivity.this, SearchActivity.class);
                                        startActivity(intent1);
                                        overridePendingTransition(R.anim.fadein, R.anim.fadeout);

                                    }
                                });
                            }
                        }).start();

                    }
                }
        );




        DialogHandler = new Handler (){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);

                dialog.dismiss();
                Intent intent=new Intent(MainActivity.this,SearchActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);

//            startActivity(intent);
            }
        };
    }


    class EndDialog extends Thread {
        public void run(){

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

//            Intent intent1 = new Intent(MainActivity.this, SearchActivity.class);
//            startActivity(intent1);
//            overridePendingTransition(R.anim.fadein, R.anim.fadeout);

            DialogHandler.sendEmptyMessage(0);
        }
    }

}
