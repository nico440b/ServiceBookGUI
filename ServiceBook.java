package sample;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class ServiceBook {

    List<Service> services = new ArrayList<>();

    public void addService(Service service){

        services.add(service);
    }

    public int getNumberOfServices(){

        return services.size();
    }
    public Service getService(int index){

        if(index <services.size()){
            return services.get(index);
        }
        return null;
    }
    public List<Service> getAllServices(){

        return services;


    }

    public List<Integer> getMileageAsList() {

        List<Integer> mileages = new ArrayList<>();
        for (Service service : services) {
            mileages.add(service.getMileage());
        }
    return mileages;
    }
    public int[] getAllServiceMileages(){

        int[]mileages = new int[services.size()];
        int i = 0;

        for (Service service: services){
            mileages[i] = service.getMileage();
            i++;

        }
        return mileages;
    }
    public boolean hasServiceOnDate(Date date){
        for(Service service: services){
            if(service.getDate().equals(date)){
            return true;
            }
        } return false;
    }

    public Date getDateOfLastService()
    {
        Service lastService = services.get(0);

        for(Service service: services){
            if(lastService.isOlder(service)){
                lastService = service;
            }
        }
        return lastService.getDate();
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ServiceBook that = (ServiceBook) o;
        return Objects.equals(services, that.services);
    }

    @Override
    public int hashCode() {
        return Objects.hash(services);
    }

    @Override
    public String toString() {
        return "ServiceBook: " + "\n"+services;
    }


}
