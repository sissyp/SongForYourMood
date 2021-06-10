package com.example.myapplication.domain;
import com.example.myapplication.InvalidDataException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Activity includes all the available options for activities and contains methods that manage them.
 */
public enum Activity {
    WORK("work"), STUDYING("studying"), WORKING_OUT("working_out"), PARTY("party"), HOBBY("hobby"), NO_ACTIVITY("no_activity");
    String activity;

    Activity(){

    }

    Activity(String activity){
        this.activity = activity;
    }

    public static String getActivityAsString(Activity activity){
        return activity.activity;
    }

    public void setActivity(String a) throws InvalidDataException{
        if (!isAvailable(a)) {
            throw new InvalidDataException("Invalid activity");
        }
        this.activity = a;
    }

    public static Activity[] getAvailableActivities(){
        Activity[] activities =  new Activity[6];
        int i = 0;
        for (Activity act: Activity.values()) {
            activities[i] = act;
            i++;
        }
        return activities;
    }

    public void showPossibleActivities(){
        System.out.println("Available Activities: ");
        for (Activity act:Activity.values()){
            System.out.print(act.name());
        }
    }

    public static boolean isAvailable(String act){
        boolean found = false;
        for (Activity a: Activity.values()) {
            if (a.name().toLowerCase().equals(act)) {
                found = true;
                break;
            }
        }
        return found;
    }
}
