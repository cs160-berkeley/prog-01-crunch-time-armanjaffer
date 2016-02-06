package com.cs160.arman.crunchtime;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.HashMap;

public class myActivity extends AppCompatActivity {

    private int getValue(EditText et) {
        try {
            return Integer.parseInt(et.getText().toString());
        }
        catch(NumberFormatException e) {
            System.out.println("Could not parse " + et.getText().toString());
            return -1;
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
//
//        ActionBar actionBar = getActionBar();
//        actionBar.hide();

        final HashMap<Button, String> button_map = new HashMap<Button, String>();
        ArrayList<Button> buttonList = new ArrayList<Button>();

        Button pushup = (Button) findViewById(R.id.button);
        button_map.put(pushup, "pushup");
        Button situps = (Button) findViewById(R.id.button2);
        button_map.put(situps, "situp");
        Button jumping_jacks = (Button) findViewById(R.id.button3);
        button_map.put(jumping_jacks, "jumping_jack");
        Button jogging = (Button) findViewById(R.id.button4);
        button_map.put(jogging, "jogging");
        Button squat = (Button) findViewById(R.id.button6);
        button_map.put(squat, "squat");
        Button leglift = (Button) findViewById(R.id.button7);
        button_map.put(leglift, "leglift");
        Button plank = (Button) findViewById(R.id.button8);
        button_map.put(plank, "plank");
        Button pullup = (Button) findViewById(R.id.button9);
        button_map.put(pullup, "pullup");
        Button cycling = (Button) findViewById(R.id.button10);
        button_map.put(cycling, "cycling");
        Button walking = (Button) findViewById(R.id.button11);
        button_map.put(walking, "walking");
        Button swimming = (Button) findViewById(R.id.button12);
        button_map.put(swimming, "swimming");
        Button stair_climbing = (Button) findViewById(R.id.button13);
        button_map.put(stair_climbing, "stair_climbing");
        buttonList.add(stair_climbing);


        ArrayList<Button> bList = new ArrayList<Button>(button_map.keySet());
        for (final Button b: bList){
            b.getBackground().setAlpha(128);
            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), enter.class);
                    intent.putExtra("exercise", button_map.get(b));
                    v.getContext().startActivity(intent);
                }
            });
        }
//
//
//        pushup.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(v.getContext(), enter.class);
//                intent.putExtra("exercise", "pushup");
//                v.getContext().startActivity(intent);
//            }
//        });
//
//        situps.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(v.getContext(), enter.class);
//                intent.putExtra("exercise", "situp");
//                v.getContext().startActivity(intent);
//            }
//        });
//
//        jumping_jacks.setOnClickListener(new View.OnClickListener(){
//            public void onClick(View v) {
//                Intent intent = new Intent(v.getContext(), enter.class);
//                intent.putExtra("exercise", "jumping_jack");
//                v.getContext().startActivity(intent);
//            }
//        });
//
//        jogging.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(v.getContext(), enter.class);
//                intent.putExtra("exercise", "jogging");
//                v.getContext().startActivity(intent);
//
//            }
//        });
//
//        squat.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(v.getContext(), enter.class);
//                intent.putExtra("exercise", "squat");
//                v.getContext().startActivity(intent);
//
//            }
//        });
//
//        leglift.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(v.getContext(), enter.class);
//                intent.putExtra("exercise", "leglift");
//                v.getContext().startActivity(intent);
//
//            }
//        });
//
//        leglift.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(v.getContext(), enter.class);
//                intent.putExtra("exercise", "leglift");
//                v.getContext().startActivity(intent);
//
//            }
//        });
//
//        plank.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(v.getContext(), enter.class);
//                intent.putExtra("exercise", "plank");
//                v.getContext().startActivity(intent);
//
//            }
//        });
//
//        pullup.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(v.getContext(), enter.class);
//                intent.putExtra("exercise", "pullup");
//                v.getContext().startActivity(intent);
//
//            }
//        });
//
//        cycling.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(v.getContext(), enter.class);
//                intent.putExtra("exercise", "cycling");
//                v.getContext().startActivity(intent);
//
//            }
//        });
//
//        walking.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(v.getContext(), enter.class);
//                intent.putExtra("exercise", "walking");
//                v.getContext().startActivity(intent);
//
//            }
//        });
//
//
//        swimming.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(v.getContext(), enter.class);
//                intent.putExtra("exercise", "swimming");
//                v.getContext().startActivity(intent);
//
//            }
//        });
//
//        stair_climbing.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(v.getContext(), enter.class);
//                intent.putExtra("exercise", "climbing");
//                v.getContext().startActivity(intent);
//
//            }
//        });



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
