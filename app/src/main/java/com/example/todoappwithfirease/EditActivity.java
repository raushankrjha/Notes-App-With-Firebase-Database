package com.example.todoappwithfirease;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.todoappwithfirease.Model.Listdata;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class EditActivity extends AppCompatActivity {
EditText title,desc;
String titlesend,descsend;
private DatabaseReference mDatabase;
private Listdata listdata;
Button updates,delete;
     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        updates=findViewById(R.id.updatesbutton);
         delete=findViewById(R.id.deletedbutton);
        final Intent i=getIntent();

        String gettitle=i.getStringExtra("title");
         String getdesc=i.getStringExtra("desc");
         final String id=i.getStringExtra("id");
         title=findViewById(R.id.title);
        desc=findViewById(R.id.desc);
         mDatabase = FirebaseDatabase.getInstance().getReference();
            title.setText(gettitle);
            desc.setText(getdesc);
            updates.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getApplicationContext(),id,Toast.LENGTH_SHORT).show();
                    UpdateNotes(id);
                }
            });
         delete.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Toast.makeText(getApplicationContext(),id,Toast.LENGTH_SHORT).show();
                 deleteNote(id);
             }
         });
     }

    private void UpdateNotes(String id)
    {
        titlesend=title.getText().toString();
        descsend=desc.getText().toString();
        Listdata listdata = new Listdata(id,titlesend, descsend);
        mDatabase.child("Notes").child(id).setValue(listdata).
                addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                Toast.makeText(EditActivity.this, "Notes Updated", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(),HomeScreen.class));
            }
        });

    }

    private void deleteNote(String id) {
        mDatabase.child("Notes").child(id).removeValue()
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(EditActivity.this,"Note Updated",Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(),HomeScreen.class));

                    }
                });
    }
}
