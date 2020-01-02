package com.tom.finalexamtest;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_CODE_REGISTER = 110;
    private EditText edusername;
    private EditText edemail;
    private EditText edpassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edusername = findViewById(R.id.username);
        edemail = findViewById(R.id.email);
        edpassword = findViewById(R.id.password);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
                if (requestCode==REQUEST_CODE_REGISTER){
                        if (resultCode==RESULT_OK){
                            edusername.setText(getSharedPreferences("test", MODE_PRIVATE)
                                    .getString("name", ""));
                            edemail.setText(getSharedPreferences("test", MODE_PRIVATE)
                                    .getString("email", ""));
                            edpassword.setText( getSharedPreferences("test", MODE_PRIVATE)
                                    .getString("password", ""));
                        }
                }
    }

    public void regist(View view){
        String sting_username = edusername.getText().toString();
        String sting_email = edemail.getText().toString();
        String sting_password = edpassword.getText().toString();
        if (sting_username.equals("")&&sting_email.equals("")&&sting_password.equals("")){
            Intent intent = new Intent(MainActivity.this,UsernameActivity.class);
            startActivityForResult(intent,REQUEST_CODE_REGISTER);
        }else if(sting_username.equals("")||sting_email.equals("")||sting_password.equals("")){

        }else{
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("註冊成功")
                    .setMessage("恭喜成為丁級英文的會員")
                    .setPositiveButton("OK",null)
                    .show();
        }
    }
}


