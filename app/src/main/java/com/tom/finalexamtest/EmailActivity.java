package com.tom.finalexamtest;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class EmailActivity extends AppCompatActivity {

    private EditText edemail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);

    }
    public void topassword(View view){
        edemail = findViewById(R.id.wemail);
        String email1 = edemail.getText().toString();
        if (email1.equals("")){
            new AlertDialog.Builder(EmailActivity.this)
                    .setTitle("衝三小")
                    .setMessage("媽媽勒不會打字是否")
                    .setPositiveButton("Fuck",null)
                    .show();
        }else {
            String email = edemail.getText().toString();
            SharedPreferences pref = getSharedPreferences("test", MODE_PRIVATE);
            pref.edit()
                    .putString("email", email)
                    .commit();
            Log.d("12", "topassword: " + pref);
            Intent intent = new Intent(EmailActivity.this, PasswordActivity.class);
            startActivity(intent);
            finish();
        }
    }
}
