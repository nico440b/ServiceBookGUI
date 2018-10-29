package sample;

import java.util.Objects;

public class Service {


    private int mileage;
    private Date date;
    private String service;


    public Service (int mileage, Date date,String service){

        this.mileage = mileage;
        this.date = date;
        this.service = service;

    }

    public Service(){

        mileage = 0;
        date = new Date();
        service = "";

    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public int getMileage() {
        return mileage;
    }

    public Date getDate() {
        return date.copy();
    }

    public boolean isOlder(Service service){

        if (date.getYear()<service.getDate().getYear()){return true;}
        if (date.getMonth()<service.getDate().getMonth()){return true;}
        if (date.getDay()<service.getDate().getDay()){return true;}

        return false;
    }
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Service service = (Service) o;
        return mileage == service.mileage &&
                Objects.equals(date, service.date);
    }


    public int hashCode() {
        return Objects.hash(mileage, date);
    }


    public String toString() {
        return service +") "+ "Mileage: " + mileage +"h" + " Date: " + date +"\r\n"  ;
    }
}
