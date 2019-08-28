package com.example.mytasks;

import android.app.Activity;
import android.content.SharedPreferences;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class NewMainActivity extends Activity {

    SharedPreferences pref;
    SharedPreferences.Editor editor;
    LinearLayout linearLayout;

    int i = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linearLayout = findViewById(R.id.second_layout_tab1);


        ImageButton addBtn = findViewById(R.id.add_btn_tab1);
        pref = getApplicationContext().getSharedPreferences("pref", MODE_PRIVATE);
        while (pref.getString(String.valueOf(i), null) != null) {
            TextView task = new TextView(NewMainActivity.this);
            task.setText(pref.getString(String.valueOf(i), null));
            linearLayout.addView(task);
            i++;
        }
        editor = pref.edit();
        // editor.putString("task", "val");
        //editor.commit();
        i = 0;

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText et1 = findViewById(R.id.edit_txt_tab1);
                editor.putString(String.valueOf(i), et1.getText().toString());
                TextView task = new TextView(NewMainActivity.this);
                task.setText(et1.getText().toString());
                linearLayout.addView(task);
                et1.setText("");
                editor.commit();
                i++;
            }
        });

    }


}
