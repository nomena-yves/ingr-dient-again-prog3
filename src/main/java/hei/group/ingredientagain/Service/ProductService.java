package hei.group.ingredientagain.Service;

import hei.group.ingredientagain.Entity.ProductEntity;
import hei.group.ingredientagain.Repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

        private ProductRepository repository;

        public ProductService(ProductRepository repository) {
            this.repository = repository;
        }

        public List<ProductEntity> getProductsByCriteria(
                String productName,
                String categoryName,
                Instant creationMin,
                Instant creationMax) throws SQLException {
        List<ProductEntity> products = new ArrayList<>();
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
