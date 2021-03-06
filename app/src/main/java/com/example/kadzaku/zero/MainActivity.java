package com.example.kadzaku.zero;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private String correctPasswd = "PojPoj";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button readPasswd = (Button) findViewById(R.id.btnReadPasswd);
        final MediaPlayer enterSound = MediaPlayer.create(this, R.raw.tr3);
        ((EditText)findViewById(R.id.editText9)).requestFocus();

        readPasswd.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String pswd = ((EditText)findViewById(R.id.editText9)).getText().toString();
                if (pswd.equals(correctPasswd)) {
                    enterSound.start();
                    startActivity(new Intent(MainActivity.this, EnterToSystem.class));
                } else {
                    startActivity(new Intent(MainActivity.this, Error.class));
                }
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}
