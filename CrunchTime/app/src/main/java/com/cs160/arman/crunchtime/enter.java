package com.cs160.arman.crunchtime;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.HashMap;

public class enter extends AppCompatActivity {

    private int getValue(EditText et) {
        try {
            return Integer.parseInt(et.getText().toString());
        }
        catch(NumberFormatException e) {
            System.out.println("Could not parse " + et.getText().toString());
            return -1;
        }
    }

    public static HashMap<String,String> set_Exercises(){
        HashMap<String, String> h = new HashMap<String, String>();
        h.put("pushup", "reps");
        h.put("situp", "reps");
        h.put("jumping_jack", "minutes");
        h.put("jogging", "minutes");
        h.put("squat", "reps");
        h.put("leglift", "minutes");
        h.put("plank", "minutes");
        h.put("pullup", "reps");
        h.put("cycling", "minutes");
        h.put("walking", "minutes");
        h.put("swimming", "minutes");
        h.put("stair_climbing", "minutes");
        return h;
    }

    final HashMap<String, String> units = new HashMap<String, String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter);
        final HashMap<String, String> units = set_Exercises();
        Intent intent = getIntent();
        final String exercise = intent.getStringExtra("exercise");
        String type = null;
        if (units.containsKey(exercise)){
            type = units.get(exercise);
        }else{
            System.out.println("u dun fcked");
        }

        TextView tv = (TextView) findViewById(R.id.textView3);
        if (type == "minutes"){
            tv.setText("How many minutes do you plan to work out for?");
        }else{
            tv.setText("How many repititions do you plan to do?");
        }

        final SeekBar seek = (SeekBar) findViewById(R.id.seekBar);
        Button calc = (Button) findViewById(R.id.button5);
        calc.getBackground().setAlpha(128);
        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText ed = (EditText) findViewById(R.id.editText2);
                int amount = getValue(ed);
                Intent intent = new Intent(v.getContext(), cal_count.class);
                intent.putExtra("exercise", exercise);
                intent.putExtra("amount", amount);
                intent.putExtra("weight", seek.getProgress());
                v.getContext().startActivity(intent);
            }
        });
    }


}
