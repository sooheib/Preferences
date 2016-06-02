package com.example.sooheib.preferences;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {


    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText= (EditText) findViewById(R.id.editText);

        SharedPreferences preferences=getSharedPreferences("MyPrefs",MODE_PRIVATE);
        editText.setText(preferences.getString("username",""));
    }

    public void SaveName(View view) {

        SharedPreferences preferences=getSharedPreferences("MyPrefs",MODE_PRIVATE);
        SharedPreferences.Editor editor=preferences.edit();
        editor.putString("username",editText.getText().toString());
        editor.commit();

    }
}
