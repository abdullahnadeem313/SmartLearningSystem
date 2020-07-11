package com.smartapplication.smartlearningsystem.Forum;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.smartapplication.smartlearningsystem.R;

import java.util.List;

public class ForumAdapter extends RecyclerView.Adapter<ForumAdapter.ForumViewholder> {

    private List<MessageModel> msgItems;

    public ForumAdapter(List<MessageModel> msgItems) {
        this.msgItems = msgItems;
    }

    @NonNull
    @Override
    public ForumViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_message,parent);

        ForumViewholder viewholder = new ForumViewholder(view);

        return viewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull ForumViewholder holder, int position) {

        MessageModel message = msgItems.get(position);

        holder.messageTextView.setText(message.getMsgText());
        holder.authorTextView.setText(message.getUserName());

    }

    @Override
    public int getItemCount() {
        return msgItems.size();
    }


    public class ForumViewholder extends RecyclerView.ViewHolder {

        public TextView messageTextView;
        public TextView authorTextView;

        public ForumViewholder(View itemView) {
            super(itemView);
            messageTextView = (TextView) itemView.findViewById(R.id.messageTextView);
            authorTextView = (TextView) itemView.findViewById(R.id.nameTextView);

        }
    }
}
