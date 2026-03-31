@Repository
public class StockRepository {
private DataSource dataSource;
private StockMapper stockMapper;

    public StockRepository(DataSource dataSource, StockMapper stockMapper) {
        this.dataSource = dataSource;
        this.stockMapper = stockMapper;
    }


}