
public class Cropdata{
   private String state,district,crop,year;
    
    public Cropdata(String state,String district,String crop, String year){
        this.state = state;
        this.district=district;
        this.crop=crop;
        this.year=year;
    }

    public String getState() {
        return state;
    }
    public String getCrop() {
        return crop;
    }public String getDistrict() {
        return district;
    }public String getYear() {
        return year;
    }

    @Override
    public String toString() {
        return state +"\t" + district +"\t"+ crop +"\t" + year;
    }
}