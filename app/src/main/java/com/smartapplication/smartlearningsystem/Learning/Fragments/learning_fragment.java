package com.smartapplication.smartlearningsystem.Learning.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.smartapplication.smartlearningsystem.Forum.MessageAdapter;
import com.smartapplication.smartlearningsystem.Learning.Data.LearningDataItem;
import com.smartapplication.smartlearningsystem.Learning.Recyclerview.LearningAdapter;
import com.smartapplication.smartlearningsystem.Learning.Service.LearningDataProvider;
import com.smartapplication.smartlearningsystem.R;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class learning_fragment extends Fragment {



    private List<LearningDataItem> dataItemList = LearningDataProvider.dataItemList;

    public learning_fragment() {
        // Required empty public constructor

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.learning, container, false);

        RecyclerView recyclerView = (RecyclerView)v.findViewById(R.id.Learning_rv);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        LearningAdapter adapter =new LearningAdapter(dataItemList);
        recyclerView.setAdapter(adapter);


        return v;
    }

}
