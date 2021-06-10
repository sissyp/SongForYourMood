package com.example.myapplication.util;
import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.myapplication.App;
import com.example.myapplication.InvalidDataException;
import com.example.myapplication.domain.Activity;
import com.example.myapplication.domain.Intensity;
import com.example.myapplication.domain.Mood;
import com.example.myapplication.domain.MusicSession;
import com.example.myapplication.domain.Song;
import com.example.myapplication.domain.SongRating;
import com.example.myapplication.memorydao.MemoryInitializer;
import com.example.myapplication.memorydao.SongDAO;
import com.example.myapplication.memorydao.SongRatingDAO;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Statistics is responsible for displaying song statistics based on ratings.
 */


public class Statistics {
   Song song;
   static HashMap<Mood,Integer> moodL = new HashMap<Mood ,Integer>();
   static HashMap<Activity,Integer> actL = new HashMap<Activity ,Integer>();
   static HashMap<Intensity,Integer> intL = new HashMap<Intensity ,Integer>();

   public Statistics(Song song){
       this.song = song;
   }

    public static void initialize(){
        for (Mood m: Mood.getAvailableMoods()){
            moodL.put(m,0);
        }
        for (Activity a: Activity.getAvailableActivities()){
            actL.put(a,0);
        }
        for (Intensity i: Intensity.getIntensityLevels()){
            intL.put(i,0);
        }
    }

    /**
     * calculateRatings finds the maximum mood, activity and intensity based on users' song ratings
     * @param songRatingDAO contains all ratings for songs.
     * @return a hashmap that contains the most common mood, activity and intensity and the percentages.
     */

   public HashMap<String, Integer> calculateRatings(SongRatingDAO songRatingDAO){
       List<SongRating> ratings = songRatingDAO.find(song.getSongId());
       for(SongRating r: ratings){
           for (Map.Entry<Mood,Integer> moodtuple: moodL.entrySet()){
               if (moodtuple.getKey().name().toLowerCase().equals(r.getMood())){
                   moodtuple.setValue(moodtuple.getValue()+1);
               }
           }
           for (Map.Entry<Activity,Integer> activitytuple: actL.entrySet()){
               if (activitytuple.getKey().name().toLowerCase().equals(r.getActivity())){
                   activitytuple.setValue(activitytuple.getValue()+1);
               }
           }
           for (Map.Entry<Intensity,Integer> intensitytuple: intL.entrySet()){
               if (intensitytuple.getKey().name().toLowerCase().equals(r.getIntensity())){
                   intensitytuple.setValue(intensitytuple.getValue()+1);
               }
           }
       }

       HashMap<String, Integer> perc = new HashMap<String, Integer>();
       String maxMood = "";
       double maxPerc = 0;
       for (Map.Entry<Mood, Integer> moodtuple: moodL.entrySet()) {
           if (moodtuple.getValue() > maxPerc) {
               maxMood = moodtuple.getKey().name();
               maxPerc = moodtuple.getValue();
           }
       }
       maxPerc = (maxPerc/ ratings.size())*100;
       perc.put(maxMood, (int) maxPerc);

       String maxActivity = "";
       maxPerc = 0;
       for (Map.Entry<Activity,Integer> activitytuple: actL.entrySet()) {
           if (activitytuple.getValue() > maxPerc) {
               maxActivity = activitytuple.getKey().name();
               maxPerc = activitytuple.getValue();
           }
       }
       maxPerc = (maxPerc/ ratings.size())*100;
       perc.put(maxActivity, (int) maxPerc);

       String maxIntensity = "";
       maxPerc = 0;
       for (Map.Entry<Intensity,Integer> intensitytuple: intL.entrySet()){
           if (intensitytuple.getValue() > maxPerc){
               maxIntensity = intensitytuple.getKey().name();
               maxPerc = intensitytuple.getValue();
           }
       }
       maxPerc = (maxPerc/ ratings.size())*100;
       perc.put(maxIntensity, (int) maxPerc);

       return perc;
   }

    public static HashMap<String, Integer> sortByValue(HashMap<String, Integer> hm) {
        // Create a list from elements of HashMap
        List<Map.Entry<String, Integer> > list =
                new LinkedList<Map.Entry<String, Integer> >(hm.entrySet());

        // Sort the list
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2)
            {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });

        // put data from sorted list to hashmap
        HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }
}
