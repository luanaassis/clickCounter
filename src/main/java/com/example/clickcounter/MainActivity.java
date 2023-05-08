package com.example.clickcounter;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int mCountH;
    private int mCountL;
    private TextView mContadorH;
    private TextView mContadorL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContadorH = findViewById(R.id.countH);
        mContadorL = findViewById(R.id.countL);
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            return super.onKeyDown(keyCode, event);
        }
        if (keyCode == KeyEvent.KEYCODE_VOLUME_UP) {
            maisUm(findViewById(R.id.btn_hemacia));
        } else if (keyCode == KeyEvent.KEYCODE_VOLUME_DOWN){
            maisUm(findViewById(R.id.btn_leucocito));
        }
        return super.onKeyDown(keyCode, event);
    }
    public void maisUm(View view) {

        switch (view.getId()) {
            case R.id.btn_hemacia:
                mCountH++;
                mContadorH.setText(Integer.toString(mCountH));
                break;
            case R.id.btn_leucocito:
                mCountL++;
                mContadorL.setText(Integer.toString(mCountL));
                break;
            case R.id.btn_clr:
                mCountH = 0;
                mCountL = 0;
                mContadorH.setText(Integer.toString(mCountH));
                mContadorL.setText(Integer.toString(mCountL));
        }
    }
}