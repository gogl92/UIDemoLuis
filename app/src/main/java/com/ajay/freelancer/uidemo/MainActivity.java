package com.ajay.freelancer.uidemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
Button meesagesButton,settings1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        meesagesButton=(Button)findViewById(R.id.messagesButton);
        meesagesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, MessagesActivity.class);
                startActivity(i);
            }
        });

        settings1=(Button)findViewById(R.id.settings1);
        settings1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,Settings1Activity.class);
                startActivity(i);
            }
        });
    }
}
