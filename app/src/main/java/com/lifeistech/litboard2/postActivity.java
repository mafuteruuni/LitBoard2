package com.lifeistech.litboard2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class postActivity extends AppCompatActivity
        implements View.OnClickListener {

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference refMeg = database.getReference("massage");
    DatabaseReference countMeg = database.getReference("countmsg");


    EditText mUsernameText;
    EditText mpostText;
    Button mPostButton;
    int number;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        mUsernameText = (EditText) findViewById(R.id.username);
        mpostText = (EditText) findViewById(R.id.messenge);
        mPostButton = (Button) findViewById(R.id.post);

        mPostButton.setOnClickListener(this);

        number = 0;

        //データの取得
        refMeg.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                number=(int)dataSnapshot.getChildrenCount();
                /*for(int i = 0; i < dataSnapshot.getChildrenCount();i++){

                    number++;  //number = number + 1;
                }*/
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


    }

    @Override
    public void onClick(View v) {
        int id = v.getId();


        switch (id) {
            case R.id.post:

                String mesange = mpostText.getText().toString();
                String userName = mUsernameText.getText().toString();
                post post = new post(userName, mesange, number);


                refMeg.push().setValue(post);
                countMeg.push().setValue(number);

               Intent intent = new Intent(this,MainActivity.class);
               //intent.putExtra("number",number);
               startActivity(intent);
               finish();
                break;

        }

    }


}






