package com.smartapplication.smartlearningsystem.Learning.Service;

import com.smartapplication.smartlearningsystem.Learning.Data.LearningDataItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LearningDataProvider {

    public static List<LearningDataItem> dataItemList;
    public static Map<String,LearningDataItem> dataItemMap;

    static {
        dataItemList = new ArrayList<>();
        dataItemMap = new HashMap<>();

        addItem(new LearningDataItem("Database Management",null,"dbms2"));
        addItem(new LearningDataItem("Compiler Construction",null,"compilerdesign"));
        addItem(new LearningDataItem("Software Engineering",null,"softwareengineering"));
        addItem(new LearningDataItem("Artificial Intelligence",null,"artificialintelligence1"));
    }

    private static void addItem(LearningDataItem dataItem){

        dataItemList.add(dataItem);
        dataItemMap.put(dataItem.getItemId(),dataItem);
    }
}
