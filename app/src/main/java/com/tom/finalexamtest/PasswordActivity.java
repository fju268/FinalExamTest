package com.tom.finalexamtest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.util.prefs.PreferenceChangeEvent;

public class PasswordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);
    }
    public void tohome(View view){
        setResult(RESULT_OK);
        EditText edpassword = findViewById(R.id.wpassword);
        String password = edpassword.getText().toString();
        SharedPreferences pref = getSharedPreferences("test",MODE_PRIVATE);
        pref.edit()
                .putString("email",password)
                .commit();
        Log.d("12", "tohome: "+pref);
        Intent intent = new Intent(PasswordActivity.this,MainActivity.class);
        startActivityForResult(intent,RESULT_OK);
    }
}
