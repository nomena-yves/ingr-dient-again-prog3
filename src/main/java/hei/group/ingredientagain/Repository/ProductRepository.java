package hei.group.ingredientagain.Repository;

import hei.group.ingredientagain.Entity.ProductEntity;
import hei.group.ingredientagain.Mapping.ProductMapper;
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
    private DataSource dataSource;
    private ProductMapper productMapper;

    public ProductRepository(DataSource dataSource, ProductMapper productMapper) {
        this.dataSource = dataSource;
        this.productMapper = productMapper;
    }

    public List<ProductEntity> getAllProducts(int page, int size)throws java.sql.SQLException {
        int offset = (page - 1) * size;
        List<ProductEntity> products = new ArrayList<>();
        String sql= "SELECT * FROM Product limit? offset?";
        try(Connection conn = dataSource.getConnection();
            PreparedStatement stmt =conn.prepareStatement(sql);){
            stmt.setInt(1, size);
            stmt.setInt(2, offset);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
               products.add(productMapper.map(rs));
            }
        }
        return products;
    }
}
