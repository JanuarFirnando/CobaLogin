package com.mdp.cobalogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tv_sesi, tv_nama;
    private Button btn_logout;
    KendaliLogin KL = new KendaliLogin();
    public static String keySP= "Fu2Xjaka9dE$jkkkS_username";
    public static String keySPName= "Fu2Xjaka9dE$jkkkS_name";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (KL.isLogin(MainActivity.this,keySP) == true) {
            setContentView(R.layout.activity_main);
            tv_nama = findViewById(R.id.tv_nama);
            tv_sesi = findViewById(R.id.tv_sesi);
            btn_logout = findViewById(R.id.btn_logout);

            tv_sesi.setText(KL.getPref(MainActivity.this, keySP));
            tv_nama.setText(KL.getPref(MainActivity.this,keySPName));

            btn_logout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    KL.setPref(MainActivity.this, keySP, null);
                    KL.setPref(MainActivity.this,keySPName, null);
                    startActivity(new Intent(MainActivity.this, LoginActivity.class));
                    finish();

                }
            });
        }
        else {
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();

        }







    }
}