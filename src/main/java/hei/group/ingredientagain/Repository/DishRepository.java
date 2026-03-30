package hei.group.ingredientagain.Repository;

import hei.group.ingredientagain.Entity.DishEntity;
import hei.group.ingredientagain.Entity.IngredientEntity;
import hei.group.ingredientagain.Mapping.DishMapper;
import hei.group.ingredientagain.Mapping.IngredientMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@Repository
public class DishRepository {
    private DataSource dataSource;
    private DishMapper dishMapper;
    private IngredientMapper ingredientMapper;

    public DishRepository(DataSource dataSource, DishMapper dishMapper,IngredientMapper ingredientMapper) {
        this.dataSource = dataSource;
        this.dishMapper = dishMapper;
        this.ingredientMapper = ingredientMapper;
    }

   public DishEntity findDishById(Integer id) throws SQLException {
       DishEntity dishEntity = null;
        String sql = "select d.id,d.name,d.dish_type,d.price,di.id_dish,di.id_ingredient,i.name as name_ingredient,i.price as ingredient_price,i.category from dish d inner join dishingredient di on d.id=di.id_dish inner join ingredient i on di.id_ingredient= i.id where d.id=?";
        try (Connection conn = dataSource.getConnection()) {

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
              if(dishEntity==null){
                 dishEntity=dishMapper.map(rs);
              }

              if(rs.getObject("id_ingredient")!=null){
                  dishEntity.getIngredients().add(ingredientMapper.map(rs));
              }
                }
            } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return dishEntity;
        }

}
