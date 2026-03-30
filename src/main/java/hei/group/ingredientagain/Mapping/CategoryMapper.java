package hei.group.ingredientagain.Mapping;

import hei.group.ingredientagain.Entity.CategoryEntity;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class CategoryMapper {
      public CategoryEntity map(ResultSet rs) throws SQLException {
            CategoryEntity category = new CategoryEntity(
                    rs.getInt("id"),
                    rs.getString("name")
            );
            return category;
      }
}
