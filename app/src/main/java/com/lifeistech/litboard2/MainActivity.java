package com.lifeistech.litboard2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference regMsg = database.getReference("massage");


    ListView mLisyView;
    Button mBotton;
    TextView mTextView;
    TextView mTextView2;


    ArrayList<post> items;

    int randomNum;

    int count;  //要素数


    postAdapter postAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLisyView = (ListView) findViewById(R.id.list_view);
        mBotton = (Button) findViewById(R.id.button);
        mTextView = (TextView) findViewById(R.id.textView);
        mTextView2 = (TextView) findViewById(R.id.textView2);


//        mButton.setOnClickListener(this);

        count = 0;
        randomNum = 0;

        items = new ArrayList<post>();
        // items.add(new post("Res", "Pssoss"));
        postAdapter = new postAdapter(this, R.layout.listview_item_post, items);


        regMsg.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                post value = dataSnapshot.getValue(post.class);


                items.add(value);

                //  items.add(new post("a","b"));
                mLisyView.setAdapter(postAdapter);

               /* postAdapter.clear();
                postAdapter.addAll(items);
                postAdapter.notifyDataSetChanged();

*/
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {


            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


        //要素数
        regMsg.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                count=(int)dataSnapshot.getChildrenCount();

            }


            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public void back(View v) {
        Intent intent = new Intent(this, postActivity.class);
        startActivity(intent);
    }

    public void pick(View v) {



        Random random = new Random();
        if (count != 0) randomNum = random.nextInt(count);

        regMsg.orderByChild("number").equalTo(randomNum).addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                post value = dataSnapshot.getValue(post.class);

                Intent intent = new Intent(MainActivity.this, teniActivity.class);
                intent.putExtra("scarlet", value.userName);
                intent.putExtra("mafumafu", value.messenge);

                startActivity(intent);


                mTextView.setText(value.userName);
                mTextView2.setText(value.messenge);

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}

