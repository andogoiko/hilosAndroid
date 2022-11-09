package com.example.hiloandrois.hilos;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Log;
import android.widget.TextView;

import com.example.hiloandrois.MainActivity;

public class HiloIncr /*implements Runnable*/{

    private HandlerThread ht;
    private Handler handler;
    private int cont;
    private TextView tvCont;
    private MainActivity mainActivity;
    private Handler handlerExternal;

    public HiloIncr(int cont, TextView tvCont, MainActivity mainActivity,Handler handlerExternal){
        this.cont = cont;
        this.tvCont = tvCont;
        this.mainActivity = mainActivity;
        this.handlerExternal = handlerExternal;

        ht = new HandlerThread("contador");
        ht.start();
        Looper looper = ht.getLooper();
        handler = new Handler(looper);

    }

    public void contar(){
        handler.post(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    cont++;

                    handlerExternal.post(new Runnable() {
                        @Override
                        public void run() {
                            tvCont.setText("Valor actual: " + cont);
                        }
                    });

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    /*@Override
    public void run() {
        while (true){
            cont++;

            mainActivity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    tvCont.setText("Valor actual: " + cont);
                }
            });

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }*/
}
