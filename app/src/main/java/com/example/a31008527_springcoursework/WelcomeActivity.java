package com.example.a31008527_springcoursework;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        // Initialise
        // Declaring firebase variables and android widgets
        FirebaseAuth auth = FirebaseAuth.getInstance();
        TextView userEmailTxt = findViewById(R.id.txt_user_signed_in);
        Button btn_logout = findViewById(R.id.btn_logout);

        // get the user signed in
        FirebaseUser user = auth.getCurrentUser();
        // If no user
        if (user == null) {
            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(intent);
            finish();
        }
        else {
            // Get the users email
            userEmailTxt.setText(userEmailTxt.getText() + user.getEmail());

        }
        

        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Sign out the user
                FirebaseAuth.getInstance().signOut();
                // Close this activity and open login activity
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}