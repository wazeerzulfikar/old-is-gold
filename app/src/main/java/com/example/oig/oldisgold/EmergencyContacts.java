package com.example.oig.oldisgold;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

public class EmergencyContacts extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency_contacts);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveContact();
            }
        });

        }

    public void saveContact(){
        EditText editname = (EditText) findViewById(R.id.editname);
        String name = editname.getText().toString();
        EditText editnumber = (EditText) findViewById(R.id.editnumber);
        String stringnumber = editnumber.getText().toString();
        DBHelper db = new DBHelper(this);
        db.addContact(new Contact(name,stringnumber));
        printContacts();
    }

    public void printContacts(){
        DBHelper db = new DBHelper(this);
        List<Contact> contacts = db.getAllContacts();


    }

    }


