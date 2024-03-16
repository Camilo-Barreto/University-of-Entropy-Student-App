package com.example.a31008527_springcoursework.taskbarFragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.example.a31008527_springcoursework.LoginActivity;
import com.example.a31008527_springcoursework.R;
import com.google.firebase.auth.FirebaseAuth;

public class ProfilePageFragment extends Fragment {

    public ProfilePageFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview = inflater.inflate(R.layout.fragment_profile_page, container, false);

        // Initialise
        // Declaring firebase variables and android widgets
        Button btn_logout = rootview.findViewById(R.id.btn_logout);

        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Sign out the user
                FirebaseAuth.getInstance().signOut();
                // Close this activity and open login activity
                Intent intent = new Intent(getContext(), LoginActivity.class);
                startActivity(intent);
                // Check if the activity is not null before finishing
                if (getActivity() != null) {
                    getActivity().finish();
                }
            }
        });

        return rootview;
    }
}