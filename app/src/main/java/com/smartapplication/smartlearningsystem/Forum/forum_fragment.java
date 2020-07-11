package com.smartapplication.smartlearningsystem.Forum;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.smartapplication.smartlearningsystem.Activity.MainActivity;
import com.smartapplication.smartlearningsystem.R;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class forum_fragment extends Fragment {


    private static final int DEFAULT_MSG_LENGTH_LIMIT = 1000;
    private static final int RC_SIGN_IN = 1;
    private MessageAdapter mMessageAdapter;
    private EditText mMessageEditText;
    private Button mSendButton;
    private DatabaseReference mMessageDatabaseRefrence;
    private ForumAdapter forumAdapter;
    private ChildEventListener mChildEventListener;
    private FirebaseUser user;

    private String mUsername;

    public forum_fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.forum, container, false);

        ListView mMessageListView = (ListView) rootView.findViewById(R.id.messageListView);

        mMessageEditText = (EditText) rootView.findViewById(R.id.messageEditText);
        mSendButton = (Button) rootView.findViewById(R.id.sendButton);

        List<MessageModel> messageModel = new ArrayList<>();

        mMessageAdapter = new MessageAdapter(getActivity(),R.layout.item_message,messageModel);
        mMessageListView.setAdapter(mMessageAdapter);


        FirebaseDatabase mFirebaseDatabase = FirebaseDatabase.getInstance();
        mMessageDatabaseRefrence = mFirebaseDatabase.getReference().child("messages");

        mMessageEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.toString().trim().length()>0){
                    mSendButton.setEnabled(true);
                }else{
                    mSendButton.setEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mMessageEditText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(DEFAULT_MSG_LENGTH_LIMIT)});

        mSendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MessageModel message = new MessageModel(mUsername,mMessageEditText.getText().toString());
                mMessageDatabaseRefrence.push().setValue(message);
                mMessageEditText.setText("");
            }
        });



        if((MainActivity)getActivity()!=null){

            user = ((MainActivity)getActivity()).getDatabaseUser();
        }
        if(user!=null){
            mUsername = user.getDisplayName();
        }
        else{
            mUsername = "anonymous";
        }
        attachDatabaseListener();


        return rootView;
    }

    public void attachDatabaseListener(){
        if(mChildEventListener==null){
            mChildEventListener = new ChildEventListener() {
                @Override
                public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                    MessageModel messageModel = dataSnapshot.getValue(MessageModel.class);
                    mMessageAdapter.add(messageModel);

                }

                @Override
                public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                }

                @Override
                public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

                }

                @Override
                public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            };
            mMessageDatabaseRefrence.addChildEventListener(mChildEventListener);
        }
    }

    public void detachDatatabaseListener(){
        if(mChildEventListener!=null){
        mMessageDatabaseRefrence.removeEventListener(mChildEventListener);
        mChildEventListener=null;
        }
    }

//    public void OnSignedInitialize(String userName) {
//        mUsername = userName;
//        attachDatabaseListener();
//    }
//    public void OnSignedOutInitialized(){
//        mUsername = "anonymous";
//        mMessageAdapter.clear();
//        detachDatatabaseListener();
//    }




    @Override
    public void onStop() {
        super.onStop();
        detachDatatabaseListener();
        mMessageAdapter.clear();
    }
}
