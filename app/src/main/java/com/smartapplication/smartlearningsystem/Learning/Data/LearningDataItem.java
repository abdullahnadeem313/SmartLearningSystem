package com.smartapplication.smartlearningsystem.Learning.Data;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.UUID;

public class LearningDataItem implements Parcelable {

    final String DRAWABLE = "drawable/";
    private String ItemName;
    private String ItemId;
    private String Image;


    public LearningDataItem() {
    }


    public LearningDataItem(String itemName, String itemId, String image) {

        if (itemId==null){
            itemId = UUID.randomUUID().toString();
        }

        ItemName = itemName;
        ItemId = itemId;
        Image = image;
    }


    @Override
    public String toString() {
        return "LearningDataItem{" +
                "ItemName='" + ItemName + '\'' +
                ", ItemId=" + ItemId +
                ", Image='" + Image + '\'' +
                '}';
    }


    public String getItemName() {
        return ItemName;
    }

    public void setItemName(String itemName) {
        ItemName = itemName;
    }

    public String getItemId() {
        return ItemId;
    }

    public void setItemId(String itemId) {
        ItemId = itemId;
    }

    public String getImage() {
        return DRAWABLE + Image;
    }

    public void setImage(String image) {
        Image = image;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.ItemName);
        dest.writeString(this.ItemId);
        dest.writeString(this.Image);
    }

    protected LearningDataItem(Parcel in) {
        this.ItemName = in.readString();
        this.ItemId = in.readString();
        this.Image = in.readString();
    }

    public static final Parcelable.Creator<LearningDataItem> CREATOR = new Parcelable.Creator<LearningDataItem>() {
        @Override
        public LearningDataItem createFromParcel(Parcel source) {
            return new LearningDataItem(source);
        }

        @Override
        public LearningDataItem[] newArray(int size) {
            return new LearningDataItem[size];
        }
    };
}
