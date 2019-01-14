package com.evontech.demo.testtest.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

import java.util.Date;

public class DummyModel implements Parcelable, Comparable<DummyModel> {

    DummyDoodle dummyDoodle;

    Date createDate;

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    protected DummyModel(Parcel in) {
    }
    public DummyModel() {
    }

    public static final Creator<DummyModel> CREATOR = new Creator<DummyModel>() {
        @Override
        public DummyModel createFromParcel(Parcel in) {
            return new DummyModel(in);
        }

        @Override
        public DummyModel[] newArray(int size) {
            return new DummyModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }

    public DummyDoodle getDummyDoodle() {
        return dummyDoodle;
    }

    public void setDummyDoodle(DummyDoodle dummyDoodle) {
        this.dummyDoodle = dummyDoodle;
    }

    public static Creator<DummyModel> getCREATOR() {
        return CREATOR;
    }

    @Override
    public int compareTo(@NonNull DummyModel o) {

        return getCreateDate().compareTo(o.getCreateDate());
    }
}
