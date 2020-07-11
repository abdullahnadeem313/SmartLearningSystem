package com.smartapplication.smartlearningsystem.Learning.Recyclerview;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.smartapplication.smartlearningsystem.Activity.DetailActivity;
import com.smartapplication.smartlearningsystem.Activity.MainActivity;
import com.smartapplication.smartlearningsystem.Learning.Data.LearningDataItem;
import com.smartapplication.smartlearningsystem.R;

import java.util.List;

public class LearningAdapter extends RecyclerView.Adapter<LearningAdapter.LearningViewholder> {


    public static final String ITEM_NAME_KEY = "item_name_key" ;
    private List<LearningDataItem> mitems;

    public LearningAdapter(List<LearningDataItem> mitems) {
        this.mitems = mitems;

    }

    @NonNull
    @Override
    public LearningViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.learning_cardview,parent,false);

        LearningViewholder viewholder = new LearningViewholder(view);

        return viewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull LearningViewholder holder, int position) {
        final LearningDataItem dataItem = mitems.get(position);

        try {
            holder.textView.setText(dataItem.getItemName());

//            InputStream inputStream = mContext.getAssets().open(imageFile);
//            Drawable drawable = Drawable.createFromStream(inputStream,null);
//            holder.imageView.setImageDrawable(drawable);
            holder.UpdateImageUI(dataItem);

        } catch (Exception e) {
            e.printStackTrace();
        }


        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String itemName = dataItem.getItemName();
                Intent intent = new Intent(MainActivity.getMainActivity(),DetailActivity.class);
                intent.putExtra(ITEM_NAME_KEY,itemName);
                MainActivity.getMainActivity().startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return mitems.size();
    }

    public class LearningViewholder extends RecyclerView.ViewHolder{

        public View view;
        public CardView cardView;
        public TextView textView;
        public ImageView imageView;
        public LinearLayout linearLayout;
        public Button button;

        public LearningViewholder(View itemView) {


            super(itemView);

            view = itemView;
            linearLayout =(LinearLayout) itemView.findViewById(R.id.linearlayout);
            cardView =(CardView) itemView.findViewById(R.id.cardView);
            textView = (TextView) itemView.findViewById(R.id.text_to_show);
            imageView = (ImageView) itemView.findViewById(R.id.image_to_show);

        }

        public void UpdateImageUI(LearningDataItem dataItem){

            String imageFile = dataItem.getImage();
            int resource = imageView.getResources().getIdentifier(imageFile,null,imageView
            .getContext().getPackageName());
            imageView.setImageResource(resource);
        }
    }



}

