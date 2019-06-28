package com.example.pertemuan1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    ImageView gambar;
    EditText username2, password2;
    Button btn1, btn2;
    TextView tampil;
    CheckBox unhide;
    String username = "admin";
    String password = "admin";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gambar = (ImageView) findViewById(R.id.gmbr);
        username2 = (EditText) findViewById(R.id.username2);
        password2 = (EditText) findViewById(R.id.password2);
        btn1 = (Button) findViewById(R.id.button);
        btn2 = (Button) findViewById(R.id.button2);
        tampil = (TextView) findViewById(R.id.tampil);
        unhide = (CheckBox) findViewById(R.id.boxx);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        unhide.setOnCheckedChangeListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                String user = username2.getText().toString();
                String pass = password2.getText().toString();
                if (username.equals(user)&&password.equals(pass)) {
                    Toast.makeText(this, "Login", Toast.LENGTH_SHORT).show();
                    Intent pindah = new Intent(this, Main2Activity.class);
                    startActivity(pindah);
                    finish();
                }
                else {
                    Toast.makeText(this, "Gagal", Toast.LENGTH_SHORT).show();
                }

                break;
            case R.id.button2:
                Toast.makeText(this, "Register", Toast.LENGTH_SHORT).show();
                break;
        }

    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (!isChecked) {
            password2.setTransformationMethod(PasswordTransformationMethod.getInstance());
        } else {
            password2.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
        }
    }
}

