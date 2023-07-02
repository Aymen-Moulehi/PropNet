package tn.esprit.propnetapp.realestatellisting;

import tn.esprit.propnetapp.city.City;
import tn.esprit.propnetapp.governorate.Governorate;

public class AllocationFilter {

    private Governorate governorate;
    private City city;
    private Float price;
    private Float area;
    private Operation operation;
    private Boolean realEstateIsSold;
    private RealEstateStatus realEstateStatus;
    private Integer numberOfBedrooms;
    private Integer numberOfBathrooms;
    private PropertyType propertyType;
    private Boolean hasParking;
    private Boolean hasGarden;
    private Boolean hasBalcony;
    private Boolean hasPool;
    private Boolean isFurnished;
    private Boolean hasSecurity;
    private Integer builtYear;
    private Integer floorNumber;
    private  String orderBy;

    public AllocationFilter(Governorate governorate, City city, Float price, Float area, Operation operation, Boolean realEstateIsSold, RealEstateStatus realEstateStatus, Integer numberOfBedrooms, Integer numberOfBathrooms, PropertyType propertyType, Boolean hasParking, Boolean hasGarden, Boolean hasBalcony, Boolean hasPool, Boolean isFurnished, Boolean hasSecurity, Integer builtYear, Integer floorNumber, String orderBy) {
        this.governorate = governorate;
        this.city = city;
        this.price = price;
        this.area = area;
        this.operation = operation;
        this.realEstateIsSold = realEstateIsSold;
        this.realEstateStatus = realEstateStatus;
        this.numberOfBedrooms = numberOfBedrooms;
        this.numberOfBathrooms = numberOfBathrooms;
        this.propertyType = propertyType;
        this.hasParking = hasParking;
        this.hasGarden = hasGarden;
        this.hasBalcony = hasBalcony;
        this.hasPool = hasPool;
        this.isFurnished = isFurnished;
        this.hasSecurity = hasSecurity;
        this.builtYear = builtYear;
        this.floorNumber = floorNumber;
        this.orderBy = orderBy;
    }

    public Float getMinArea() {
        return area;
    }

    public void setMinArea(Float area) {
        this.area = area;
    }


    public City getCity() {
        return city;
    }

    public void setCity(City region) {
        this.city = region;
    }

    public Governorate getGovernorate() {
        return governorate;
    }

    public void setGovernorate(Governorate governorate) {
        this.governorate = governorate;
    }

    public Float getMaxPrice() {
        return price;
    }

    public void setMaxPrice(Float price) {
        this.price = price;
    }

    public Boolean getRealEstateIsSold() {
        return realEstateIsSold;
    }

    public void setRealEstateIsSold(Boolean realEstateIsSold) {
        this.realEstateIsSold = realEstateIsSold;
    }

    public RealEstateStatus getRealEstateStatus() {
        return realEstateStatus;
    }

    public void setRealEstateStatus(RealEstateStatus realEstateStatus) {
        this.realEstateStatus = realEstateStatus;
    }

    public Integer getNumberOfBedrooms() {
        return numberOfBedrooms;
    }

    public void setNumberOfBedrooms(Integer numberOfBedrooms) {
        this.numberOfBedrooms = numberOfBedrooms;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public PropertyType getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(PropertyType propertyType) {
        this.propertyType = propertyType;
    }

    public Boolean getHasParking() {
        return hasParking;
    }

    public void setHasParking(Boolean hasParking) {
        this.hasParking = hasParking;
    }

    public Boolean getHasGarden() {
        return hasGarden;
    }

    public void setHasGarden(Boolean hasGarden) {
        this.hasGarden = hasGarden;
    }

    public Boolean getHasBalcony() {
        return hasBalcony;
    }

    public void setHasBalcony(Boolean hasBalcony) {
        this.hasBalcony = hasBalcony;
    }

    public Boolean getHasPool() {
        return hasPool;
    }

    public void setHasPool(Boolean hasPool) {
        this.hasPool = hasPool;
    }

    public Integer getNumberOfBathrooms() {
        return numberOfBathrooms;
    }

    public void setNumberOfBathrooms(Integer numberOfBathrooms) {
        this.numberOfBathrooms = numberOfBathrooms;
    }

    public Boolean getFurnished() {
        return isFurnished;
    }

    public void setFurnished(Boolean furnished) {
        isFurnished = furnished;
    }

    public Boolean getHasSecurity() {
        return hasSecurity;
    }

    public void setHasSecurity(Boolean hasSecurity) {
        this.hasSecurity = hasSecurity;
    }

    public Integer getBuiltYear() {
        return builtYear;
    }

    public void setBuiltYear(Integer builtYear) {
        this.builtYear = builtYear;
    }

    public Integer getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(Integer floorNumber) {
        this.floorNumber = floorNumber;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }
}
