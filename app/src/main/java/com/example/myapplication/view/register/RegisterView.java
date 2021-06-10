package com.example.myapplication.view.register;

import com.example.myapplication.domain.BandPreference;
import com.example.myapplication.domain.GenrePreference;

public interface RegisterView {

    void onSuccessfulRegister();

    String getEmail();

    void setEmail(String email);

    String getUsername();

    void setUsername(String username);

    String getPassword();

    void setPassword(String password);

    String getFirstName();

    void setFirstName(String firstName);

    String getLastName();

    void setLastName(String lastName);

    GenrePreference getGenrePreference();

    void setGenrePreference(GenrePreference genrePreference);

    BandPreference getBandPreference();

    void setBandPreference(BandPreference bandPreference);

    void showEmptyFieldsDetected();

    void showEmailAlreadyExists();

    void showInvalidEmail();
}