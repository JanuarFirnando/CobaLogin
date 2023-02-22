package com.mdp.cobalogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tv_sesi;
    private Button btn_logout;
    KendaliLogin KL = new KendaliLogin();
    public static String keySP= "spPadang";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (KL.isLogin(MainActivity.this,keySP) == true) {
            setContentView(R.layout.activity_main);
        }
        else {
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();

        }


        tv_sesi = findViewById(R.id.tv_sesi);
        btn_logout = findViewById(R.id.btn_logout);




    }
}