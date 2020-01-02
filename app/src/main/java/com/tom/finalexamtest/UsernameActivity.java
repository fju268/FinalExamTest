package com.tom.finalexamtest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class UsernameActivity extends AppCompatActivity {

    private EditText edname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_username);

    }
    public void toemail(View view){

        edname = findViewById(R.id.wname);
        String name = edname.getText().toString();
        SharedPreferences pref = getSharedPreferences("test",MODE_PRIVATE);
        pref.edit()
                .putString("name",name)
                .commit();
        Log.d("12", "toemail: "+pref);

        Intent intent = new Intent(UsernameActivity.this,EmailActivity.class);
        startActivity(intent);
    }

}
