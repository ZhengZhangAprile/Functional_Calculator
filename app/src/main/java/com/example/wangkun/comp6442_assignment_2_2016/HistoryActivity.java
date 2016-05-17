package com.example.wangkun.comp6442_assignment_2_2016;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.*;



public class HistoryActivity extends AppCompatActivity {
    TextView textView;
    String filename = "myfile";
    String string = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        textView = (TextView) findViewById(R.id.textView_his);

        try {
            FileInputStream fin = openFileInput(filename);
            int length = fin.available();
            byte [] buffer = new byte[length];
            fin.read(buffer);
            string = new String(buffer,"UTF-8");
            fin.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        textView.setText(string);
    }
}
