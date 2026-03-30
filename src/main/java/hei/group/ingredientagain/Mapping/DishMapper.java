package hei.group.ingredientagain.Mapping;

import hei.group.ingredientagain.Entity.DishEntity;
import hei.group.ingredientagain.Entity.DishTypeEnum;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.util.ArrayList;

@Component
public class DishMapper {

        public DishEntity map(ResultSet rs) throws SQLException {
            DishEntity dish = null;
          dish=new DishEntity(
                  rs.getInt("id"),
                  rs.getString("name"),
                  DishTypeEnum.valueOf(rs.getString("dish_type")),
                  new ArrayList<>(),
                  rs.getDouble("price")
            );
            return dish;
        }
}
