package com.example.myapplication.view.favouriteBands;

import com.example.myapplication.domain.Band;

import java.util.List;

public interface favouriteBandsView {

    void onFetchBands(List<Band> bandList);

    String getBandTitle1();

    void setBandTitle1(String title);

    String getBandTitle2();

    void setBandTitle2(String title);

    void onSuccessfullyCompletedProcess(String band1, String band2);

    void showEmptyOrWrongFieldsDetected();
}
