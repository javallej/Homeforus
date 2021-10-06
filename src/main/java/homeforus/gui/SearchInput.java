package main.java.homeforus.gui;


public class SearchInput {
    private int houseNum;
    private String street;
    private String city;
    private String state;
    private int zip;
    private int priceMin;
    private int priceMax;
    private int beds;
    private int baths;
    private int sqftMin;
    private int sqftMax;
    private int floors;
    private int yearBuiltMin;
    private int yearBuiltMax;
    private int daysListedMin;
    private int daysListedMax;

    public SearchInput() {
    }

    public SearchInput(int houseNum, String street, String city, String state, int zip,
                       int priceMin, int priceMax, int beds, int baths, int sqftMin, int sqftMax,
                       int floors, int yearBuiltMin, int yearBuiltMax, int daysListedMin, int daysListedMax) {
        this.setHouseNum(houseNum);
        this.setStreet(street);
        this.setCity(city);
        this.setState(state);
        this.setZip(zip);
        this.setPriceMin(priceMin);
        this.setPriceMax(priceMax);
        this.setBeds(beds);
        this.setBaths(baths);
        this.setSqftMin(sqftMin);
        this.setSqftMax(sqftMax);
        this.setFloors(floors);
        this.setYearBuiltMin(yearBuiltMin);
        this.setYearBuiltMax(yearBuiltMax);
        this.setDaysListedMin(daysListedMin);
        this.setDaysListedMax(daysListedMax);
    }

    @Override
    public String toString() {
        return "SearchInput{" +
                "houseNum=" + houseNum +
                ", \n street='" + street + '\'' +
                ", \n city='" + city + '\'' +
                ", \n state='" + state +
                ", \n zip=" + zip +
                ", \n priceMin=" + priceMin +
                ", \n priceMax=" + priceMax +
                ", \n beds=" + beds +
                ", \n baths=" + baths +
                ", \n sqftMin=" + sqftMin +
                ", \n sqftMax=" + sqftMax +
                ", \n floors=" + floors +
                ", \n yearBuiltMin=" + yearBuiltMin +
                ", \n yearBuiltMax=" + yearBuiltMax +
                ", \n daysListedMin=" + daysListedMin +
                ", \n daysListedMax=" + daysListedMax +
                '}';
    }

    public int getHouseNum() {
        return houseNum;
    }

    public void setHouseNum(int houseNum) {
        this.houseNum = houseNum;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public int getPriceMin() {
        return priceMin;
    }

    public void setPriceMin(int priceMin) {
        this.priceMin = priceMin;
    }

    public int getPriceMax() {
        return priceMax;
    }

    public void setPriceMax(int priceMax) {
        this.priceMax = priceMax;
    }

    public int getBeds() {
        return beds;
    }

    public void setBeds(int beds) {
        this.beds = beds;
    }

    public int getBaths() {
        return baths;
    }

    public void setBaths(int baths) {
        this.baths = baths;
    }

    public int getSqftMin() {
        return sqftMin;
    }

    public void setSqftMin(int sqftMin) {
        this.sqftMin = sqftMin;
    }

    public int getSqftMax() {
        return sqftMax;
    }

    public void setSqftMax(int sqftMax) {
        this.sqftMax = sqftMax;
    }

    public int getFloors() {
        return floors;
    }

    public void setFloors(int floors) {
        this.floors = floors;
    }

    public int getYearBuiltMin() {
        return yearBuiltMin;
    }

    public void setYearBuiltMin(int yearBuiltMin) {
        this.yearBuiltMin = yearBuiltMin;
    }

    public int getYearBuiltMax() {
        return yearBuiltMax;
    }

    public void setYearBuiltMax(int yearBuiltMax) {
        this.yearBuiltMax = yearBuiltMax;
    }

    public int getDaysListedMin() {
        return daysListedMin;
    }

    public void setDaysListedMin(int daysListedMin) {
        this.daysListedMin = daysListedMin;
    }

    public int getDaysListedMax() {
        return daysListedMax;
    }

    public void setDaysListedMax(int daysListedMax) {
        this.daysListedMax = daysListedMax;
    }
}
