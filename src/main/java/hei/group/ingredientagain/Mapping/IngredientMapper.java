package hei.group.ingredientagain.Mapping;

import hei.group.ingredientagain.Entity.CategoryEnum;
import hei.group.ingredientagain.Entity.IngredientEntity;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class IngredientMapper {
      private DishMapper dishMapper;

      public IngredientMapper(DishMapper dishMapper) {
            this.dishMapper = dishMapper;
      }

      public IngredientMapper() {
      }
      public IngredientEntity map(ResultSet rs) throws SQLException {
            IngredientEntity ingredient = new IngredientEntity(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getDouble("pice"),
                    CategoryEnum.valueOf(rs.getString("category")),
                    null
            );
            return ingredient;
      }

}
