package com.example.myapplication.fragments;

import static android.app.Activity.RESULT_OK;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;

import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.myapplication.LoginActivity;
import com.example.myapplication.MainActivity;
import com.example.myapplication.Post;
import com.example.myapplication.R;
import com.example.myapplication.UserProfile;
import com.google.android.material.textview.MaterialTextView;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SaveCallback;

import java.io.File;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the  factory method to
 * create an instance of this fragment.
 */
public class ProfileFragment extends Fragment {

    public static final String TAG = "ProfileFragment";
    private MaterialTextView tvUsername;
    private ImageView ivSelfie;
    private MaterialTextView tvDateJoined;
    private MaterialTextView tvName;
    private MaterialTextView tvHeight;
    private MaterialTextView tvWeight;
    private Button logOut;
    private Button btnSave;
    ParseUser currentUser;

    public ProfileFragment() {
        // Required empty public constructor
    }

    // The onCreateView method is called when Fragment should create its View object hierarchy,
    // either dynamically or via XML layout inflation.


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    // This event is triggered soon after onCreateView().
    // Any view setup should occur here.  E.g., view lookups and attaching view listeners.
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        currentUser = ParseUser.getCurrentUser();

        tvUsername = view.findViewById(R.id.tvUsername);
        ivSelfie = view.findViewById(R.id.ivSelfie);
        tvDateJoined = view.findViewById(R.id.tvDateJoined);
        tvName = view.findViewById(R.id.tvName);
        tvWeight = view.findViewById(R.id.tvWeight);
        tvHeight = view.findViewById(R.id.tvHeight);
        logOut = view.findViewById(R.id.logOut2);
        Log.e(TAG, "onViewCreated: ProfileFragment");

        tvUsername.setText("@" + currentUser.getUsername());
        //tvName.setText(currentUser.getString());


        /* btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ParseUser.btnSave();
                ParseUser currentUser = ParseUser.getCurrentUser(); // this will now be null
                Toast.makeText(getContext(), "Saved", Toast.LENGTH_SHORT).show() ;
            }

        });
        */

        logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ParseUser.logOut();
                ParseUser currentUser = ParseUser.getCurrentUser(); // this will now be null
                Toast.makeText(getContext(), "Logged out!", Toast.LENGTH_SHORT).show() ;
                goLoginActivity();
            }

        });

    }

/*
    protected void queryUserProfile(){
        ParseQuery<UserProfile> query = ParseQuery.getQuery(UserProfile.class);
        query.include(UserProfile.KEY_USER);
        query.setLimit(20);
        query.addDescendingOrder(UserProfile.KEY_CREATED_KEY);
        query.findInBackground(new FindCallback<UserProfile>() {
            @Override
            public void done(List<UserProfile> UserProfiles, ParseException e) {
                if (e != null) {
                    Log.e(TAG, "Issue with getting UserProfile", e);
                    return;
                }


                for (UserProfile UserProfile :  UserProfiles) {
                    Log.i(TAG, "UserProfile: " + UserProfile.getDescription() + " , username: " + UserProfile.getUser().getUsername());
                }
                UserProfiles.addAll(UserProfiles);
                public void bind(UserProfile UserProfiles.get(0)) {
                    // Bind the post data to the view elements
                    tvDescription.setText(UserProfile.getDescription());
                    tvUsername.setText(post.getUser().getUsername());
                    ParseFile image = post.getImage();
                    if(image != null){
                        Glide.with(context).load(post.getImage().getUrl()).into(ivImage);
                    }

                }
            }
        });
    }

*/

    private void goLoginActivity() {
        Intent i  = new Intent(getContext(), LoginActivity.class);
        startActivity(i);
        getActivity().finish();
    }

}