package com.cs160.arman.crunchtime;

import android.content.Intent;
import android.content.SyncAdapterType;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.nio.DoubleBuffer;
import java.util.ArrayList;
import java.util.HashMap;

public class cal_count extends AppCompatActivity {


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


    private HashMap<String, Double> get_map(){
        HashMap<String,Double> h = new HashMap<String,Double>();
        h.put("pushup", (Double) 100.0/350.0);
        h.put("situp", (Double) 100.0/200.0);
        h.put("jumping_jack", 100.0/10.0);
        h.put("jogging", 100.0/12.0);
        h.put("squat", 100.0/225.0);
        h.put("leglift", 100.0/25.0);
        h.put("plank", 100.0/25.0);
        h.put("pullup", 100.0/100.0);
        h.put("cycling", 100.0/12.0);
        h.put("walking", 100.0/20.0);
        h.put("swimming", 100.0/13.0);
        h.put("stair_climbing", 100.0/15.0);
        return h;

    }

    private HashMap<String, String> varToString(){
        HashMap<String,String> h = new HashMap<String,String>();
        h.put("pushup","pushups");
        h.put("situp", "situps");
        h.put("jumping_jack", "jumping jacks");
        h.put("jogging", "jogging");
        h.put("squat", "squating");
        h.put("leglift", "leg-lifts");
        h.put("plank", "planks");
        h.put("pullup", "pullups");
        h.put("cycling", "cycling");
        h.put("walking", "walking");
        h.put("swimming", "swimming");
        h.put("stair_climbing", "stair climbing");
        return h;
    }

    public double caloriesToTime(double calories, double ratio, double weight){
        return calories * 1.0/(ratio * weight);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cal_count);
        Intent intent = getIntent();
        String exercise = intent.getStringExtra("exercise");
        double weight = intent.getIntExtra("weight", 50);
        System.out.println(weight);
        double multiplier = Math.pow(3.5, (weight - 50)/100);
        int amount = intent.getIntExtra("amount", -1);
        if (amount == -1){
            System.out.println("u gun fcked");
        }
        HashMap<String, Double> map = get_map();
        Double ratio = 0.0;
        if (map.containsKey(exercise)){
            ratio = map.get(exercise);
        }else{
            System.out.println("u fked");
        }
        System.out.println(multiplier);
        double val = new Double(ratio * amount * multiplier);
        TextView tv = (TextView) findViewById(R.id.textView4);

        tv.setText(String.format("%.1f calories", val));

        StringBuilder sb = new StringBuilder("That's equivalent to:\n");
        ArrayList<String> lst = new ArrayList<String>(map.keySet());

        HashMap<String, String> type_map = set_Exercises();
        HashMap<String, String> var_map = varToString();
        for (String s: lst){
            if (s != exercise) {
                String spec_cal = Integer.toString((int) caloriesToTime(val, map.get(s), multiplier));
                sb.append(spec_cal + " " + type_map.get(s) + " of " + var_map.get(s) + "\n");
            }
        }
        TextView long_tv = (TextView) findViewById(R.id.textView5);
        long_tv.setText(sb.toString());


        Button back = (Button) findViewById(R.id.button6);
        back.getBackground().setAlpha(128);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), myActivity.class);
                v.getContext().startActivity(intent);
            }
        });



    }


}
