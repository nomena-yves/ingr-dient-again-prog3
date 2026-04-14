import hei.group.ingredientagain.Entity.DishEntity;
import hei.group.ingredientagain.Entity.DishTypeEnum;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StockMapper {
    public StockEntity map(ResultSet rs) throws SQLException {
        StockEntity stocKeNtity = null;
       DishEntity dish=new DishEntity(
                rs.getInt("id"),
                rs.getString("name"),
                DishTypeEnum.valueOf(rs.getString("dish_type")),
                new ArrayList<>(),
                rs.getDouble("price")
        );
        return dish;
    }
}