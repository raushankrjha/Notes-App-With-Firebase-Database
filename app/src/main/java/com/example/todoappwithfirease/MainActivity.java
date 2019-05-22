package com.example.todoappwithfirease;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.todoappwithfirease.Model.Notes;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
EditText title,desc;
String titlesend,descsend;
    private DatabaseReference mDatabase;

     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        title=findViewById(R.id.title);
        desc=findViewById(R.id.desc);
         mDatabase = FirebaseDatabase.getInstance().getReference();

     }

    public void AddNotes(View view) {
        titlesend=title.getText().toString();
        descsend=desc.getText().toString();
        AddNotes(titlesend,descsend);

    }

    private void AddNotes(String titlesend, String descsend)
    {
        Notes notes = new Notes(titlesend, descsend);

        mDatabase.child("Notes").child(titlesend).setValue(notes).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                startActivity(new Intent(getApplicationContext(),HomeScreen.class));
            }
        });

    }
}
