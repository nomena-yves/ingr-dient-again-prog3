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
import java.util.List;

@Repository
public class IngredientRepository {

    private DataSource dataSource;
    private IngredientMapper ingredientMapper;
    private DishMapper dishMapper;

    public IngredientRepository(DataSource dataSource, IngredientMapper ingredientMapper, DishMapper dishMapper) {
        this.dataSource = dataSource;
        this.ingredientMapper = ingredientMapper;
        this.dishMapper = dishMapper;
    }
    public List<IngredientEntity> findByIngredient(int page, int size) throws SQLException {
        int offset = (page - 1) * size;
        String sql = "select i.id,i.name,i.price,i.category,di.id_dish,di.id_ingredient,di.id_dish,d.name as name_ingredient,d.price as dish_price,d.dish_type from ingredient i inner join dishingredient di on i.id=di.id_ingredient inner join  dish d on di.id_dish=d.id limit ? offset ? ";
        List<IngredientEntity> Listingredients = new ArrayList<>();
        DishEntity dishEntity = null;
        try(Connection conn = dataSource.getConnection()){
PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, offset);
            stmt.setInt(2, size);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                ingredientMapper.map(rs);
            if (ingredientMapper.map(rs).getDish()!=null){
                IngredientEntity ingredient = ingredientMapper.map(rs);
                ingredient.setDish(dishMapper.map(rs));
                Listingredients.add(ingredient);
            }
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return Listingredients;
    }

}
