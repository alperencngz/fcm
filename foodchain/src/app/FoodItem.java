package app;

public class FoodItem {
	
	// Fields for FactoryPage
	private String name;
    private String category;
    private String expiryDate;
    private String origin;
    private double price;
    private String warehouselocation;
    private String receiveDate;
    
    // Fields for TransportationPage
    private String transporterCompany;
    private String officeLocation;
    private String foodSource;
    private String foodDestination;
    private String expectedDeliveryDate;
    
    // Fields for WarehousePage
    private String warehouseLocation;
    private String dateOfReceiving;
    private String comment;
    private String rating;

    public FoodItem(String name, String category, String expiryDate, String origin, double price) {
        this.name = name;
        this.category = category;
        this.expiryDate = expiryDate;
        this.origin = origin;
        this.price = price;
    }

    // Getters and setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getExpiryDate() { return expiryDate; }
    public void setExpiryDate(String expiryDate) { this.expiryDate = expiryDate; }

    public String getOrigin() { return origin; }
    public void setOrigin(String origin) { this.origin = origin; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    
    public String getWarehouselocation() { return warehouselocation; }
    public void setWarehouselocation(String warehouselocation) { this.warehouselocation = warehouselocation; }
    
    public String getReceiveDate() { return receiveDate; }
    public void setReceiveDate(String receiveDate) { this.receiveDate = receiveDate; }
    
    public String getTransporterCompany() { return transporterCompany; }
    public void setTransporterCompany(String transporterCompany) { this.transporterCompany = transporterCompany; }

    public String getOfficeLocation() { return officeLocation; }
    public void setOfficeLocation(String officeLocation) { this.officeLocation = officeLocation; }

    public String getFoodSource() { return foodSource; }
    public void setFoodSource(String foodSource) { this.foodSource = foodSource; }

    public String getFoodDestination() { return foodDestination; }
    public void setFoodDestination(String foodDestination) { this.foodDestination = foodDestination; }

    public String getExpectedDeliveryDate() { return expectedDeliveryDate; }
    public void setExpectedDeliveryDate(String expectedDeliveryDate) { this.expectedDeliveryDate = expectedDeliveryDate; }
    
    public String getWarehouseLocation() { return warehouseLocation; }
    public void setWarehouseLocation(String warehouseLocation) { this.warehouseLocation = warehouseLocation; }

    public String getDateOfReceiving() { return dateOfReceiving; }
    public void setDateOfReceiving(String dateOfReceiving) { this.dateOfReceiving = dateOfReceiving; }
    
    public String getComment() { return comment; }
    public void setComment(String comment) { this.comment=comment; }
    
    public String getRating() { return rating; }
    public void setRating(String rating) { this.rating=rating; }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FoodItem{");
        sb.append("name='").append(name).append('\'');
        sb.append(", category='").append(category).append('\'');
        sb.append(", expiryDate='").append(expiryDate).append('\'');
        sb.append(", origin='").append(origin).append('\'');
        sb.append(", price=").append(price);
        sb.append(", warehouselocation='").append(warehouselocation).append('\'');
        sb.append(", receiveDate='").append(receiveDate).append('\'');
        sb.append(", transporterCompany='").append(transporterCompany).append('\'');
        sb.append(", officeLocation='").append(officeLocation).append('\'');
        sb.append(", foodSource='").append(foodSource).append('\'');
        sb.append(", foodDestination='").append(foodDestination).append('\'');
        sb.append(", expectedDeliveryDate='").append(expectedDeliveryDate).append('\'');
        if (comment != null && !comment.isEmpty()) {
            sb.append(", comment='").append(comment).append('\'');
        }
        if (rating != "") {
            sb.append(", rating=").append(rating);
        }
        sb.append('}');
        return sb.toString();
    }
}
