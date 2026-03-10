public class Main {
    static void main(String[] args) {
        DataRetriever dataRetriever = new DataRetriever();
        System.out.println(dataRetriever.getTotalPartsSoldByBrand());
        System.out.println("=======================");
        System.out.println(dataRetriever.getTotalPartsSoldByModel());
        System.out.println("=======================");
        System.out.println(dataRetriever.getTotalSalesAmountByKiaBrand());
    }
}
