package com.dsp.firebasedemo.models;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;

public interface GetAsyncData {
        public void onStart();
        public void onSuccess(DataSnapshot data);
        public void onFailed(DatabaseError databaseError);
}
