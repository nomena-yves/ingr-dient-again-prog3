package hei.group.ingredientagain.Repository;

import hei.group.ingredientagain.Entity.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
@Repository
public class CategoryRepository {
    @Autowired
    private DataSource dataSource;
    public List<ProductEntity> getProductsByCriteria(String productName, String categoryName, Instant creationMin, Instant creationMax)throws java.sql.SQLException{
        if (productName!=null){
            String sql= "SELECT * FROM Product WHERE name ILIKE ?";
            List<ProductEntity> products = new ArrayList<>();
            try(Connection conn =dataSource.getConnection();
                PreparedStatement stmt =conn.prepareStatement(sql);){
                stmt.setString(1, productName);
                ResultSet rs = stmt.executeQuery();
                while (rs.next()){
                    Instant createdAt = rs.getTimestamp("creation_datime").toInstant();
                    ProductEntity product = new ProductEntity(
                            rs.getInt("id"),
                            rs.getString("name"),
                            createdAt,
                            null
                    );
                    products.add(product);
                }
                return products;
            }

        } else if (categoryName!=null) {
            String sql= "SELECT * FROM Product p inner join product_category c on p.id=c.id WHERE c.name ILIKE ?";
            List<ProductEntity> products = new ArrayList<>();
            try(Connection conn =dataSource.getConnection();
                PreparedStatement stmt =conn.prepareStatement(sql);){
                stmt.setString(1, productName);
                ResultSet rs = stmt.executeQuery();
                while (rs.next()){
                    Instant createdAt = rs.getTimestamp("creation_datime").toInstant();
                    ProductEntity product = new ProductEntity(
                            rs.getInt("id"),
                            rs.getString("name"),
                            createdAt,
                            null
                    );
                    products.add(product);
                }
                return products;
            }

        } else if (creationMin!=null) {
            String sql= "SELECT * FROM Product WHERE creation_min<=?";
            List<ProductEntity> products = new ArrayList<>();
            try(Connection conn =dataSource.getConnection();
                PreparedStatement stmt =conn.prepareStatement(sql);){
                stmt.setString(1, creationMin.toString());
                ResultSet rs = stmt.executeQuery();
                while (rs.next()){
                    Instant createdAt = rs.getTimestamp("creation_datime").toInstant();
                    ProductEntity product = new ProductEntity(
                            rs.getInt("id"),
                            rs.getNString("name"),
                            createdAt,
                            null
                    );
                    products.add(product);
                }
                return products;
            }
        } else if (creationMax!=null) {
            String sql= "SELECT * FROM Product WHERE creation_max>=?";
            List<ProductEntity> products = new ArrayList<>();
            try(Connection conn =dataSource.getConnection();
                PreparedStatement stmt =conn.prepareStatement(sql);){
                stmt.setString(1, creationMax.toString());
                ResultSet rs = stmt.executeQuery();
                while (rs.next()){
                    Instant createdAt = rs.getTimestamp("creation_datime").toInstant();
                    ProductEntity product = new ProductEntity(
                            rs.getInt("id"),
                            rs.getNString("name"),
                            createdAt,
                            null
                    );
                    products.add(product);
                }
                return products;
            }
        }
        return null;
    }
}
