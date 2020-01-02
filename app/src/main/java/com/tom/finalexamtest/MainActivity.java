package com.tom.finalexamtest;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_CODE_REGISTER = 110;
    boolean register = false;

    private EditText edusername;
    private EditText edemail;
    private EditText edpassword;
    int check;

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
                            String userid = getSharedPreferences("test", MODE_PRIVATE)
                                    .getString("name", "");
                            edusername.setText(userid);
                            String emailid = getSharedPreferences("test", MODE_PRIVATE)
                                    .getString("email", "");
                            edemail.setText(emailid);
                            String passwordid = getSharedPreferences("test", MODE_PRIVATE)
                                    .getString("password", "");
                            edpassword.setText(passwordid);
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

        }else{

        }
    }
}


