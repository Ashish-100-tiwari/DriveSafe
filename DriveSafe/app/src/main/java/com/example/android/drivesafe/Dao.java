package com.example.android.drivesafe;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;

public class Dao {
    private  DatabaseReference databaseReference;
    private static DecimalFormat df = new DecimalFormat("0.00");
    public Dao(){

        String formattedDate;
        Date date = new Date();  // to get the date
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        formattedDate = df.format(date.getTime());
        FirebaseDatabase db= FirebaseDatabase.getInstance();
        databaseReference=db.getReference(formattedDate);
    }
    public Task<Void> add(Driver db){
        return databaseReference.push().setValue(db);
    }
}
