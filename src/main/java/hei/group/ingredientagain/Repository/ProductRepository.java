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
public class ProductRepository {
    @Autowired
    private DataSource dataSource;

    public List<ProductEntity> getAllProducts(int page, int size)throws java.sql.SQLException {
        int offset = (page - 1) * size;
        String sql= "SELECT * FROM Product limit? offset?";
        List<ProductEntity> products = new ArrayList<>();
        try(Connection conn = dataSource.getConnection();
            PreparedStatement stmt =conn.prepareStatement(sql);){
            stmt.setInt(1, size);
            stmt.setInt(2, offset);

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
        }
        return products;
    }
}
