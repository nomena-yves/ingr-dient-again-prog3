public class StockEntity {
    private int id;
    private StockValueEntity value;
    private TypeMouvement;
    private Instant;

    public StockEntity(int id, StockValueEntity value,TypeMouvement type,Instant creationDatetime) {
        this.id = id;
        this.value = value;
        this.type=type;
        this.creationDatetime=creationDatetime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public StockValueEntity getValue() {
        return value;
    }

    public void setValue(StockValueEntity value) {
        this.value = value;
    }
}