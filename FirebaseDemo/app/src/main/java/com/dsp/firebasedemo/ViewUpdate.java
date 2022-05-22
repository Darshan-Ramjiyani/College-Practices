package com.dsp.firebasedemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.dsp.firebasedemo.models.GetAsyncData;
import com.dsp.firebasedemo.models.User;
import com.dsp.firebasedemo.ui.Utils;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class ViewUpdate extends AppCompatActivity {

    EditText name, email, passwd, username;
    ArrayList<User> users;
    int currentUserId = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_update);
        Utils.blackIconStatusBar(ViewUpdate.this, R.color.light_background);
        name = (EditText) findViewById(R.id.name);
        email = (EditText) findViewById(R.id.email);
        username = (EditText) findViewById(R.id.username);
        passwd = (EditText) findViewById(R.id.passwd);
        users = new ArrayList<>();

        this.fetchAllUsers(new GetAsyncData() {
            ProgressDialog pb;
            @Override
            public void onStart() {
                pb = new ProgressDialog(ViewUpdate.this);
                pb.setMessage("Getting Data...");
                pb.setIndeterminate(true);
                pb.setTitle("App Says...");
                pb.show();
            }

            @Override
            public void onSuccess(DataSnapshot data) {
                pb.setMessage("Done.");
                pb.setIndeterminate(false);
                pb.setProgress(100);
                pb.dismiss();

                if(data.getChildrenCount() == 0)
                {
                    Toast.makeText(ViewUpdate.this, "Record not available! Please insert records first.", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(ViewUpdate.this, MainActivity.class));
                }

                for (DataSnapshot ds : data.getChildren())
                {
                    User user = ds.getValue(User.class);
                    user.setId(ds.getKey());
                    users.add(user);
                }
                updateUI(users.get(0));
                currentUserId = 0;
            }

            @Override
            public void onFailed(DatabaseError databaseError) {
                pb.dismiss();
            }
        });
    }

    public void showPreviousRecord(View view) {
        int previousRecordId;

        if(users.size() == 0)
        {
            Toast.makeText(ViewUpdate.this, "No records found!", Toast.LENGTH_SHORT).show();
            return;
        }

        if(currentUserId == 0)
        {
            previousRecordId = users.size() - 1;
        }
        else
        {
            previousRecordId = currentUserId - 1;
        }
        currentUserId = previousRecordId;
        this.updateUI(users.get(currentUserId));
    }

    public void showNextRecord(View view) {
        int nextRecordId;

        if(users.size() == 0)
        {
            Toast.makeText(ViewUpdate.this, "No records found!", Toast.LENGTH_SHORT).show();
            return;
        }

        if(currentUserId == users.size() - 1)
            nextRecordId = 0;
        else
            nextRecordId = currentUserId + 1;

        currentUserId = nextRecordId;
        this.updateUI(users.get(currentUserId));
    }

    public void saveChanges(View view) {

        if(name.getText().toString().equals(""))
        {
            Toast.makeText(this, "Name can't be empty.", Toast.LENGTH_SHORT).show();
            return;
        }

        if(email.getText().toString().equals(""))
        {
            Toast.makeText(this, "Email can't be empty.", Toast.LENGTH_SHORT).show();
            return;
        }

        if(passwd.getText().toString().equals(""))
        {
            Toast.makeText(this, "Password can't be empty.", Toast.LENGTH_SHORT).show();
            return;
        }

        if(username.getText().toString().equals(""))
        {
            Toast.makeText(this, "Username can't be empty.", Toast.LENGTH_SHORT).show();
            return;
        }

        HashMap<String, Object> data = new HashMap<>();
        data.put("name", name.getText().toString());
        data.put("email", email.getText().toString());
        data.put("password", passwd.getText().toString());
        data.put("username", username.getText().toString());

        Database database = new Database();

        database.databaseReference.child(users.get(currentUserId).getId()).updateChildren(data).addOnCompleteListener(this, new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful())
                {
                    Toast.makeText(ViewUpdate.this, "Data has been updated.", Toast.LENGTH_SHORT).show();

                    users.get(currentUserId).setEmail(email.getText().toString());
                    users.get(currentUserId).setName(name.getText().toString());
                    users.get(currentUserId).setPassword(passwd.getText().toString());
                    users.get(currentUserId).setUsername(username.getText().toString());

                }

                else
                    Toast.makeText(ViewUpdate.this, "Data can not be update at this moment.", Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void updateUI(User newUserData)
    {
        name.setText(newUserData.getName());
        email.setText(newUserData.getEmail());
        passwd.setText(newUserData.getPassword());
        username.setText(newUserData.getUsername());
    }

    public void fetchAllUsers(GetAsyncData asyncThread)
    {
        Database database = new Database();
        asyncThread.onStart();
        database.databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                asyncThread.onSuccess(snapshot);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                asyncThread.onFailed(error);
            }
        });
    }

    public void deleteRecords(View view) {
        Database database = new Database();
        database.databaseReference.child(users.get(currentUserId).getId()).removeValue();
        users.remove(currentUserId);
        showNextRecord(view);
    }
}