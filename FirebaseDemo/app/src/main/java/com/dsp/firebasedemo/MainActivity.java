package com.dsp.firebasedemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.dsp.firebasedemo.ui.Utils;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private EditText name, email, passwd, username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Utils.blackIconStatusBar(MainActivity.this, R.color.light_background);

        this.name = (EditText) findViewById(R.id.name);
        this.email = (EditText) findViewById(R.id.email);
        this.username = (EditText) findViewById(R.id.username);
        this.passwd = (EditText) findViewById(R.id.passwd);
    }

    public void saveRecord(View view) {

        if(this.name.getText().toString().equals(""))
        {
            Toast.makeText(this, "Name can't be empty.", Toast.LENGTH_SHORT).show();
            return;
        }

        if(this.email.getText().toString().equals(""))
        {
            Toast.makeText(this, "Email can't be empty.", Toast.LENGTH_SHORT).show();
            return;
        }

        if(this.passwd.getText().toString().equals(""))
        {
            Toast.makeText(this, "Password can't be empty.", Toast.LENGTH_SHORT).show();
            return;
        }

        if(this.username.getText().toString().equals(""))
        {
            Toast.makeText(this, "Username can't be empty.", Toast.LENGTH_SHORT).show();
            return;
        }

        HashMap<String, Object> data = new HashMap<>();
        data.put("name", this.name.getText().toString());
        data.put("email", this.email.getText().toString());
        data.put("password", this.passwd.getText().toString());
        data.put("username", this.username.getText().toString());


        this.addUser(data);
    }
    public void addUser(HashMap<String, Object> dataTobeInserted)
    {
        Database db = new Database();
        db.databaseReference.push().updateChildren(dataTobeInserted).addOnCompleteListener(MainActivity.this, new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful())
                {
                    Toast.makeText(MainActivity.this, "Data has been inserted!", Toast.LENGTH_SHORT).show();
                    name.setText("");
                    email.setText("");
                    username.setText("");
                    passwd.setText("");
                }
                else
                    Toast.makeText(MainActivity.this, "Error: Data can not be inserted.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}