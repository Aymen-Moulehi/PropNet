package tn.esprit.propnetapp.realestatellisting;

public class AllocationFilter {

    private String government;
    private String region;
    private Float maxPrice;
    private Float area;
    private Operation operation;
    private Boolean realEstateIsSold;
    private RealEstateStatus realEstateStatus;
    private Integer numberOfBedrooms;
    private PropertyType propertyType ;
    private Boolean hasParking;
    private Boolean hasGarden;
    private Boolean hasBalcony;
    private Boolean hasPool;



    public AllocationFilter(String government, String region, Float maxPrice, Float area, Operation operation, Boolean realEstateIsSold, RealEstateStatus realEstateStatus, Integer numberOfBedrooms, PropertyType propertyType, Boolean hasParking, Boolean hasGarden, Boolean hasBalcony, Boolean hasPool) {
        this.government = government;
        this.region = region;
        this.maxPrice = maxPrice;
        this.area = area;
        this.operation = operation;
        this.realEstateIsSold = realEstateIsSold;
        this.realEstateStatus = realEstateStatus;
        this.numberOfBedrooms = numberOfBedrooms;
        this.propertyType = propertyType;
        this.hasParking = hasParking;
        this.hasGarden = hasGarden;
        this.hasBalcony = hasBalcony;
        this.hasPool = hasPool;
    }

    public String getGovernment() {
        return government;
    }

    public void setGovernment(String government) {
        this.government = government;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Float getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(Float maxPrice) {
        this.maxPrice = maxPrice;
    }

    public Float getArea() {
        return area;
    }

    public void setArea(Float area) {
        this.area = area;
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

}
