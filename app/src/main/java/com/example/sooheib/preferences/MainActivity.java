package com.example.sooheib.preferences;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.preference.PreferenceManager;
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

    public void OpenSettings(View view) {
        Intent intent = new Intent(this, Preferences.class);
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences settings= PreferenceManager.getDefaultSharedPreferences(this);
        boolean red = settings.getBoolean("red", false);
        boolean green = settings.getBoolean("green", false);
        boolean black = settings.getBoolean("black", false);
        StringBuffer color=new StringBuffer();
        color.append("#");
        if(red){
            color.append("FF");
        } else {
            color.append("00");
        }

        if(green){
            color.append("FF");
        } else {
            color.append("00");
        }

        if(black){
            color.append("FF");
        } else {
            color.append("00");
        }
        View layout=findViewById(R.id.layoutMain);
        layout.setBackgroundColor(Color.parseColor(color.toString()));





    }
}
