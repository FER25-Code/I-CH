package com.test.ich.User;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;

import com.test.ich.R;

public class User extends AppCompatActivity {

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
    }

   /* public void signout(View view) {
        // [START auth_sign_out]
        FirebaseAuth.getInstance().signOut();
        Intent Acceuil = new Intent(ProfeilActivity.this, AcceuilActivity.class);
        startActivity(Acceuil);
        // [END auth_sign_out]
        final SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(ProfeilActivity.this);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putBoolean("Registered", false);
        editor.apply();
    }*/
 /*  public void showProfil() {
       FirebaseUser user = mAuth.getCurrentUser();
       mDatabaseReference = FirebaseDatabase.getInstance().getReference().child("Profail").child(user.getUid());
       mDatabaseReference.addValueEventListener(new ValueEventListener() {
           @Override
           public void onDataChange(@androidx.annotation.NonNull DataSnapshot dataSnapshot) {

               if (dataSnapshot.exists()) {
                   String gender = dataSnapshot.child("gender").getValue().toString();
                   String nameprofil = dataSnapshot.child("nameprofil").getValue().toString();
                   String numtel = dataSnapshot.child("numtel").getValue().toString();
                   String typtV = dataSnapshot.child("typtV").getValue().toString();
                   String imagID = dataSnapshot.child("imagID").getValue().toString();
                   String notep = dataSnapshot.child("note").getValue().toString();
                   nameP.setText(nameprofil);
                   telp.setText(numtel);
                   type.setText(typtV);
                   note.setText(notep + " Point");
                   Log.e("Tag", " Commit ...... " + imagID);
                   Log.e("Tag", " Commit ...................... " + nameprofil);
                   Log.e("Tag", " Commit ...................... " + numtel);
                   Uri i = Uri.parse(imagID);
                   Picasso.get().load(i).into(img);
                   //    Toast.makeText(ProfeilActivity.this, "C"+gender+"..."+nameprofil, Toast.LENGTH_LONG).show();


                   //     Toast.makeText(ProfeilActivity.this, "no data ", Toast.LENGTH_SHORT).show();
               }
           }

           @Override
           public void onCancelled(@androidx.annotation.NonNull DatabaseError databaseError) {

           }
       });


   }*/
}
