public class BrandSalesResult {
    private String brand;
    private int totalPartsSold;

    @Override
    public String toString() {
        return "BrandSalesResult{" +
                "brand='" + brand + '\'' +
                ", totalPartsSold=" + totalPartsSold +
                '}';
    }

    public BrandSalesResult(String brand, int totalPartsSold) {
        this.brand = brand;
        this.totalPartsSold = totalPartsSold;
    }

    public BrandSalesResult() {
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getTotalPartsSold() {
        return totalPartsSold;
    }

    public void setTotalPartsSold(int totalPartsSold) {
        this.totalPartsSold = totalPartsSold;
    }
}
