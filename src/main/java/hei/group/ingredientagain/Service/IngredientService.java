package hei.group.ingredientagain.Service;

import hei.group.ingredientagain.Entity.DishEntity;
import hei.group.ingredientagain.Repository.DishRepository;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Service
public class IngredientService {

        private DishRepository repository;

        public IngredientService(DishRepository repository) {
            this.repository = repository;
        }

        public List<DishEntity> getProductsByCriteria(
                String productName,
                String categoryName,
                Instant creationMin,
                Instant creationMax) throws SQLException {
        List<DishEntity> products = new ArrayList<>();
            if (productName != null) {
                products.add(repository.)
            }

            if (categoryName != null) {
                return (categoryName);
            }

            if (creationMin != null) {
                return ;
            }

            if (creationMax != null) {
                return getByCreationMax(creationMax);
            }

            return new ArrayList<>();
        }
}
