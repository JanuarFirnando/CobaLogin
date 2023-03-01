package com.mdp.cobalogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private EditText et_username, et_password;
    private Button btn_login;
    private String username, password;
    KendaliLogin Kl = new KendaliLogin();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        et_username = findViewById(R.id.et_username);
        et_password = findViewById(R.id.et_password);
        btn_login = findViewById(R.id.btn_login);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username = et_username.getText().toString();
                password = et_password.getText().toString();

                if (username.trim().equals(""))
                {
                    et_username.setError("Username tidak boleh kosong");
                }
                if (password.trim().equals(""))
                {
                    et_password.setError("Password tidak boleh kosong");
                }
                else {
                    if(username.equals("janu") && password.equals("sakana"))
                    {
                        Kl.setPref(LoginActivity.this, MainActivity.keySP, username);
                        startActivity(new Intent(LoginActivity.this, MainActivity.class));
                        finish();
                    }
                    else {
                        Toast.makeText(LoginActivity.this, "Username dan Password tidak tepat", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
}