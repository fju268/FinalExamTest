package com.tom.finalexamtest;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class UsernameActivity extends AppCompatActivity {

    private EditText edname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_username);
        edname = findViewById(R.id.wname);

    }

    public void toemail(View view){
        String mame1 = edname.getText().toString();
        if (mame1.equals("")){
            new AlertDialog.Builder(UsernameActivity.this)
                    .setTitle("衝三小")
                    .setMessage("媽媽勒不會打字是否")
                    .setPositiveButton("Fuck",null)
                    .show();
        }  else {
            String name = edname.getText().toString();
            SharedPreferences pref = getSharedPreferences("test", MODE_PRIVATE);
            pref.edit()
                    .putString("name", name)
                    .commit();
            Intent intent = new Intent(UsernameActivity.this, EmailActivity.class);
            startActivity(intent);
            UsernameActivity.this.setResult(RESULT_OK);
            finish();
        }
    }

}
