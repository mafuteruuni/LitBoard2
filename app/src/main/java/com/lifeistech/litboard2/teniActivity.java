package com.lifeistech.litboard2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class teniActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teni);

        Intent intent = this.getIntent();
        String text = intent.getStringExtra("scarlet");
        TextView textView = (TextView)findViewById(R.id.username);
        textView.setText(text);

        String text2 = intent.getStringExtra("mafumafu");
        TextView textView2 = (TextView)findViewById(R.id.message);
        textView2.setText(text2);

    }

    public void back (View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


}