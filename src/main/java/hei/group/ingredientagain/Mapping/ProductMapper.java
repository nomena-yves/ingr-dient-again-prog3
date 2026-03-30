package hei.group.ingredientagain.Mapping;

import hei.group.ingredientagain.Entity.ProductEntity;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProductMapper {

        public ProductEntity map(ResultSet rs) throws SQLException {
            ProductEntity productEntity = null;
            Instant createdAt = rs.getTimestamp("creation_datime").toInstant();

           productEntity=new ProductEntity(
                    rs.getInt("id"),
                    rs.getString("name"),
                    createdAt,
                    null
            );
            return productEntity;
        }
}
