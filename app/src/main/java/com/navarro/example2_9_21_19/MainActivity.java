package com.navarro.example2_9_21_19;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText etUser, etPwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etUser = findViewById(R.id.editText4);
        etPwd = findViewById(R.id.editText3);
    }
    public void saveData(View view){
        SharedPreferences sp = getSharedPreferences("myData", MODE_PRIVATE );
        SharedPreferences.Editor editor = sp.edit();
        String user = etUser.getText().toString();
        String pwd = etPwd.getText().toString();
        editor.putString("user",user);
        editor.putString("password", pwd);
        editor.commit();
        Toast.makeText(this, "data was saved...", Toast.LENGTH_LONG).show();
    }
    public void validate(View view){
        SharedPreferences sp = getSharedPreferences("myData", MODE_PRIVATE );
        String userSP = sp.getString("user",null);
        String pwdSP = sp.getString("password",null);
        String user = etUser.getText().toString();
        String pwd = etPwd.getText().toString();
        if (user.equals(userSP) && pwd.equals(pwdSP)){
            Toast.makeText(this, "user is valid...", Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(this, "invalid user...", Toast.LENGTH_LONG).show();
        }


    }
}
