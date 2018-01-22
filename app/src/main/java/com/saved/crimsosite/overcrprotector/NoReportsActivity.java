package com.saved.crimsosite.overcrprotector;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class NoReportsActivity extends AppCompatActivity {

    private Button mLogoutButton;
    private Button openMap;

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no_reports);

        mAuth = FirebaseAuth.getInstance();
        mAuthListener = new FirebaseAuth.AuthStateListener(){
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth){
                if (firebaseAuth.getCurrentUser() == null) {
                    startActivity( new Intent(NoReportsActivity.this, LoginActivity.class));
                }
            }
        };

        mLogoutButton = (Button) findViewById(R.id.Logout);
        openMap = (Button) findViewById(R.id.mapbtn);

        mLogoutButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public  void  onClick(View view){
                mAuth.signOut();
            }
        });

        openMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MapsActivity.class);
                startActivity(intent);
            }
        });
    }
}
