package sample;

import java.util.Objects;

public class Date {

    private int day;
    private int month;
    private int year;



    public Date(int day, int month, int year){

        this.day = day;
        this.month = month;
        this.year = year;

    }

    public Date(){

        day = 0;
        month = 0;
        year = 0;

    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public Date copy(){
        Date date = new Date(day,month,year);
        return date;
    }
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Date date = (Date) o;
        return day == date.day &&
                month == date.month &&
                year == date.year;
    }


    public int hashCode() {
        return Objects.hash(day, month, year);
    }


    public String toString() {
        return
                day +"/" + month +"/" + year;
    }
}