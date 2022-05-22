package com.dsp.firebasedemo;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

class Database
{
    private String USER_REF = "users";
    public FirebaseDatabase firebaseDatabase;
    public DatabaseReference databaseReference;

    public Database() {
        this.firebaseDatabase = FirebaseDatabase.getInstance();
        this.databaseReference = firebaseDatabase.getReference(this.USER_REF);
    }
}