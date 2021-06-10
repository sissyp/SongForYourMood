package com.example.myapplication.domain;
import java.util.ArrayList;
import com.example.myapplication.InvalidDataException;
import com.example.myapplication.util.UserInfoUtil;
import com.example.myapplication.util.UserActionTime;

/**
 * User is the class that stores and process user's information.
 */
public class User {
    private int id;
    private  String firstName;
    private  String lastName;
    private String email;
    private String userName;
    private String password;
    private UserActionTime lastLoggIn;
    private ArrayList<MusicSession> musicSessions = new ArrayList<MusicSession>();
    private ArrayList<SongRating> songRatings = new ArrayList<SongRating>();
    private GenrePreference genrePreference;
    private BandPreference bandPreference;

    public User(){

    }

    public User(String firstName, String lastName, String email, String userName, String password, GenrePreference genrePreference, BandPreference bandPreference){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.userName = userName;
        this.password = password;
        this.genrePreference = genrePreference;
        this.bandPreference = bandPreference;
    }

    public Genre[] getGenrePreference(){
        return genrePreference.getFavouriteGenres();
    }

    public Band[] getBandPreference(){
        return bandPreference.getFavouriteBands();
    }

    public void setGenrePreference(GenrePreference genrePreference) {
        this.genrePreference = genrePreference;
    }

    public void setBandPreference(BandPreference bandPreference) {
        this.bandPreference = bandPreference;
    }


    public String getFirstName(){

        return firstName;
    }

    public String getLastName(){

        return lastName;
    }

    public String getFullName(){
        return "first name: " + firstName + ", last name: " + lastName;
    }

    public void setFirstName(String name) throws InvalidDataException{
        if (name.isEmpty()){
            throw new InvalidDataException("Invalid first name");
        }
        firstName = name;
    }

    public void setLastName(String name) throws InvalidDataException{
        if (name.isEmpty()) {
            throw new InvalidDataException("Invalid last name");
        }
        lastName = name;
    }

    public String getMail() {
        return email;
    }

    public void setMail(String email) throws InvalidDataException{
        if (email.isEmpty()) {
            throw new InvalidDataException("Invalid email");
        }
        if (!UserInfoUtil.isEmail(email)) {
            throw new InvalidDataException("Invalid email format");
        }
        this.email = email;
    }

    public String getUserName(){
        return userName;
    }

    public void setUserName(String name) throws InvalidDataException{
        if (name.isEmpty()) {
            throw new InvalidDataException("Invalid name");
        }
        userName = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) throws InvalidDataException{
        if (password.isEmpty()) {
            throw new InvalidDataException("Invalid password");
        }
        this.password = com.example.myapplication.util.PasswordProtector.md5(password);
    }

    public UserActionTime getLastLogIn(){

        return lastLoggIn;
    }

    public ArrayList<MusicSession> getAllMusicSessions() {
        return musicSessions;
    }

    public ArrayList<SongRating> getAllSongRatings() {

        return songRatings;
    }

    public void setMusicSessions(ArrayList<MusicSession> ms){
        musicSessions = ms;
    }

    public void setSongRatings(ArrayList<SongRating> sr){
        songRatings = sr;
    }

    public int getUserId() {
        return id;
    }

    public void setUserId(int id) {
        this.id = id;
    }
}
