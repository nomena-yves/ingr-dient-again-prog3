package hei.group.ingredientagain.Repository;

import hei.group.ingredientagain.Entity.CategoryEntity;
import hei.group.ingredientagain.Entity.ProductEntity;
import hei.group.ingredientagain.Mapping.CategoryMapper;
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
public class CategoryRepository {

    private DataSource dataSource;
    private CategoryMapper categoryMapper;

    public CategoryRepository(DataSource dataSource, CategoryMapper categoryMapper) {
        this.dataSource = dataSource;
        this.categoryMapper = categoryMapper;
    }


    public List<CategoryEntity> getAllCategories()throws java.sql.SQLException {
        String SQL = "SELECT id,name FROM Product_category";
        List<CategoryEntity> categories = new ArrayList<>();
        try(Connection conn =dataSource.getConnection();
            PreparedStatement stmt =conn.prepareStatement(SQL);
            ResultSet rs = stmt.executeQuery()){
            while (rs.next()){
                categories.add(categoryMapper.map(rs));
            }
            return categories;
        }
    }

}
