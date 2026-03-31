@Repository
public class StockRepository {
private DataSource dataSource;
private StockMapper stockMapper;

    public StockRepository(DataSource dataSource, StockMapper stockMapper) {
        this.dataSource = dataSource;
        this.stockMapper = stockMapper;
    }

    public StockEntity getStockEntity()throws SQLException{
        String sql="select id,name,quantity,unit,creation_datetime,id_ingredient from stokcMouvement inner join ingredient on stockMouvement.id_ingredient=ingredient.id where id=? ";
        try(Connection conn= dataSource.getConnection()){

        }
    }
}