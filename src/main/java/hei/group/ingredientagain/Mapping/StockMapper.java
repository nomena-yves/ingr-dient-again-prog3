public class StockMapper {
    public StockEntity map(ResultSet rs) throws SQLException {
        STOCKeNtity stocKeNtity = null;
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