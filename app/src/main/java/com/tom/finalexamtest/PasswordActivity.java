package com.tom.finalexamtest;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.util.prefs.PreferenceChangeEvent;

public class PasswordActivity extends AppCompatActivity {

    private EditText edpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);
    }
    public void tohome(View view){
        edpassword = findViewById(R.id.wpassword);
        String password1 = edpassword.getText().toString();
        if (password1.equals("")){
            new AlertDialog.Builder(PasswordActivity.this)
                    .setTitle("衝三小")
                    .setMessage("媽媽勒不會打字是否")
                    .setPositiveButton("Fuck",null)
                    .show();
        }else {
            String password = edpassword.getText().toString();
            SharedPreferences pref = getSharedPreferences("test", MODE_PRIVATE);
            pref.edit()
                    .putString("password", password)
                    .commit();
            finish();
        }
    }
}
