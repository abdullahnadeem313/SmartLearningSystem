package com.smartapplication.smartlearningsystem.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;
import com.smartapplication.smartlearningsystem.Learning.Recyclerview.LearningAdapter;
import com.smartapplication.smartlearningsystem.R;

public class DetailActivity extends AppCompatActivity {

    PDFView pdfView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        String itemName = getIntent().getExtras().getString(LearningAdapter.ITEM_NAME_KEY);

        switch (itemName){

            case "Database Management":

                pdfView = (PDFView)findViewById(R.id.pdfview);
                pdfView.fromAsset("database1.pdf").load();

                break;
            case  "Compiler Construction":

                pdfView = (PDFView)findViewById(R.id.pdfview);
                pdfView.fromAsset("compiler.pdf").load();

                break;
            case  "Software Engineering":

                pdfView = (PDFView)findViewById(R.id.pdfview);
                pdfView.fromAsset("software.pdf").load();

                break;

            case  "Artificial Intelligence":

                pdfView = (PDFView)findViewById(R.id.pdfview);
                pdfView.fromAsset("ai.pdf").load();

                break;
        }



    }
}
