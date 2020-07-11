package com.smartapplication.smartlearningsystem.Forum;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.smartapplication.smartlearningsystem.Activity.MainActivity;
import com.smartapplication.smartlearningsystem.R;

import java.util.List;

public class MessageAdapter extends ArrayAdapter<MessageModel> {


    private static final String ADMIN = "ADMIN";

    MessageAdapter(Context context, int resource, @NonNull List<MessageModel> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position,View convertView,@NonNull ViewGroup parent) {

        if (convertView == null) {

            convertView =((Activity) getContext()).getLayoutInflater().inflate(R.layout.item_message, parent, false);
        }

        MessageModel message = getItem(position);

        TextView messageTextView = (TextView) convertView.findViewById(R.id.messageTextView);
        TextView authorTextView = (TextView) convertView.findViewById(R.id.nameTextView);


        if (message != null) {
            messageTextView.setText(message.getMsgText());
            authorTextView.setText(message.getUserName());
        }
//        if (message != null && message.getUserName().equals(ADMIN)) {
//            authorTextView.setBackgroundColor(Color.parseColor("#FF9E22"));
//        }
        return convertView;
    }
}
