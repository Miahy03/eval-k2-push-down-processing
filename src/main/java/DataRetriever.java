import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DataRetriever {
    public List<BrandSalesResult> getTotalPartsSoldByBrand(){
        DBConnection dbConnection = new DBConnection();
        String sql = """
                SELECT cm.brand AS brand_name, SUM(s.quantity) AS total_part_sold
                FROM sales s
                JOIN car_parts cp ON s.car_part_id = cp.id
                JOIN car_models cm ON cp.car_model_id = cm.id
                GROUP BY cm.brand
                """;
        List<BrandSalesResult> results = new ArrayList<>();

        try (
                Connection connection = dbConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql);
                ResultSet resultSet = ps.executeQuery()
        ){
            while(resultSet.next()) {
                results.add(
                        new BrandSalesResult(
                                resultSet.getString("brand_name"),
                                resultSet.getInt("total_part_sold")
                        )
                );
            }

        } catch (Exception e) {
            throw new RuntimeException("Error executing query", e);
        }
        return results;
    }

    public ModelSalesResult getTotalPartsSoldByModel() {
        DBConnection dbConnection = new DBConnection();
        String sql = """
                SELECT
                    SUM(CASE WHEN cm.model = 'GETZ' THEN s.quantity ELSE 0 END) AS getz_total,
                    SUM(CASE WHEN cm.model = 'PRIDE' THEN s.quantity ELSE 0 END) AS pride_total,
                    SUM(CASE WHEN cm.model = 'LACETTI' THEN s.quantity ELSE 0 END) AS lacetti_total
                FROM sales s
                JOIN car_parts cp ON s.car_part_id = cp.id
                JOIN car_models cm ON cp.car_model_id = cm.id
                """;
        ModelSalesResult result = new ModelSalesResult();

        try (
                Connection connection = dbConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql);
                ResultSet resultSet = ps.executeQuery()
        ){
            while(resultSet.next()){
                result.setGetzTotal(resultSet.getInt("getz_total"));
                result.setPrideTotal(resultSet.getInt("pride_total"));
                result.setLacettiTotal(resultSet.getInt("lacetti_total"));
            }
        } catch (Exception e) {
            throw new RuntimeException("Error executing query", e);
        }
        return result;
    }

    public Double getTotalSalesAmountByKiaBrand() {
        DBConnection dbConnection = new DBConnection();
        String sql = """
                SELECT SUM(cp.price * s.quantity) AS total_sales_amount
                FROM sales s
                JOIN car_parts cp ON s.car_part_id = cp.id
                JOIN car_models cm ON cp.car_model_id = cm.id
                WHERE cm.brand = 'KIA'
                """;
        Double result = 0.0;

        try (
                Connection connection = dbConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql);
                ResultSet resultSet = ps.executeQuery()
        ){
            while(resultSet.next()) {
                result = resultSet.getDouble("total_sales_amount");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error executing query", e);
        }
        return result;
    }
}
