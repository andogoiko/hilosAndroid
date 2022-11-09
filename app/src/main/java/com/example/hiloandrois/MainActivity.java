package com.example.hiloandrois;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.hiloandrois.hilos.HiloIncr;

public class MainActivity extends AppCompatActivity {

    Button bCont;
    TextView tvCont;
    int cont = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bCont = (Button) findViewById(R.id.bCont);
        tvCont = (TextView) findViewById(R.id.tvCont);

        HiloIncr hilinyo = new HiloIncr(cont, tvCont, this, new Handler());

        bCont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hilinyo.contar();
            }
        });


    }




}