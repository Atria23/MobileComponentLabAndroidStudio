package com.informatika.mobilecomponentdanu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.informatika.mobilecomponentdanu.alarm.AlarmActivity;
import com.informatika.mobilecomponentdanu.recyclerview.RecyclerViewActivity;
import com.informatika.mobilecomponentdanu.roomdb.RoomActivity;
import com.informatika.mobilecomponentdanu.sharedprefs.SharedPrefsActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn1 = findViewById(R.id.btnPrefs);
        Button btn2 = findViewById(R.id.btnRecycler);
        Button btn3 = findViewById(R.id.btnRoom);
        Button btn4 = findViewById(R.id.btnAlarm);

        btn1.setOnClickListener(v -> startActivity(new Intent(this, SharedPrefsActivity.class)));
        btn2.setOnClickListener(v -> startActivity(new Intent(this, RecyclerViewActivity.class)));
        btn3.setOnClickListener(v -> startActivity(new Intent(this, RoomActivity.class)));
        btn4.setOnClickListener(v -> startActivity(new Intent(this, AlarmActivity.class)));
    }
}
