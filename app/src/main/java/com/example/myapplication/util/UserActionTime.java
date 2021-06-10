package com.example.myapplication.util;
import com.example.myapplication.InvalidDataException;
import java.util.Calendar;

/**
 * UserActionTime is a class with helper functions that are used to calculate the time of a user's rating.
 */
    public class UserActionTime {
        private int day;
        private int month;
        private int year;
        private int minutes;
        private int hour;
        private int seconds;

        public UserActionTime() {

        }

        private UserActionTime(int year, int month, int day, int hour, int minutes, int seconds) {
            this.year = year;
            this.month = month;
            this.day = day;
            this.hour = hour;
            this.minutes = minutes;
            this.seconds = seconds;
        }

        public static UserActionTime getCurrentTime(Calendar calendar) throws InvalidDataException {
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int day = calendar.get(Calendar.DAY_OF_MONTH);
            int hour = calendar.get(Calendar.HOUR_OF_DAY);
            int minute = calendar.get(Calendar.MINUTE);
            int seconds = calendar.get(Calendar.SECOND);
            return UserActionTime.setTime(year, month, day, hour, minute, seconds);
        }


        public static UserActionTime setTime(int year, int month, int day, int hour, int minutes, int seconds) throws InvalidDataException {
            if (year < 0 || month > 12 || month < 0 || day < 0
                    || day > 31 || hour < 0 || hour > 24 || minutes < 0
                    || minutes > 60 || seconds < 0 || seconds > 60) {
                throw new InvalidDataException("Invalid date:" + day + "/" + month + "/" + year + "or time:" + hour + ":" + minutes + ":" + seconds);
            }

            return new UserActionTime(year, month, day, hour, minutes, seconds);
        }

        public String getDateAndTime() {
            String monthString = month >= 10 ? "" + month : "0" + month; // adds a 0 in front of the number of the month if it's earlier than the 10th month
            String dateString = day >= 10 ? "" + day : "0" + day;
            String hourString = hour >= 10 ? "" + hour : "0" + hour;
            String minuteString = minutes >= 10 ? "" + minutes : "0" + minutes;
            String secondsString = seconds >= 10 ? "" + seconds : "0" + seconds;
            return year + "-" + monthString + "-" + dateString + " " + hourString + ":" + minuteString + ":" + secondsString;
        }

        public String getDate() {
            String monthString = month >= 10 ? "" + month : "0" + month;
            String dateString = day >= 10 ? "" + day : "0" + day;
            return year + "-" + monthString + "-" + dateString;
        }

        public String getTime() {
            String hourString = hour >= 10 ? "" + hour : "0" + hour;
            String minuteString = minutes >= 10 ? "" + minutes : "0" + minutes;
            String secondsString = seconds >= 10 ? "" + seconds : "0" + seconds;
            return hourString + ":" + minuteString + ":" + secondsString;
        }

        public int getCurrentDay() {
            return day;
        }

        public void setDay(int day) throws InvalidDataException{
            if (day < 0 || day > 31)
                throw new InvalidDataException("Invalid day:" + day);
            System.out.println();
            this.day = day;
        }

        public int getCurrentMonth() {
            return month;
        }

        public void setMonth(int month) throws InvalidDataException{
            if (month < 0 || month > 12)
                throw new InvalidDataException("Invalid month:" + month);
            System.out.println();
            this.month = month;
        }

        public int getCurrentYear() {
            return year;
        }

        public void setYear(int year) throws InvalidDataException{
            if (year < 0)
                throw new InvalidDataException("Invalid year:" + year);
            System.out.println();
            this.year = year;
        }

        public int getCurrentHour() {
            return hour;
        }

        public void setHour(int hour) throws InvalidDataException{
            if (hour < 0 || hour > 24)
                throw new InvalidDataException("Invalid hour:" + hour);
            System.out.println();
            this.hour = hour;
        }

        public int getCurrentMinutes() {
            return minutes;
        }

        public void setMinutes(int minutes) throws InvalidDataException{
            if (minutes < 0 || minutes > 60)
                throw new InvalidDataException("Invalid minutes:" + minutes);
            System.out.println();
            this.minutes = minutes;
        }

        public int getCurrentSeconds() {
            return seconds;
        }

        public void setSeconds(int seconds) throws InvalidDataException{
            if (seconds < 0 || seconds > 60)
                throw new InvalidDataException("Invalid seconds:" + seconds);
            System.out.println();
            this.seconds = seconds;
        }

}

