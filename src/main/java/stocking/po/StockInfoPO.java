package stocking.po;

/**
 * Created by dell on 2017/6/5.
 */
public class StockInfoPO {
    private String[] code;
    private String[] name;

    public StockInfoPO(String[] code, String[] name) {
        this.code = code;
        this.name = name;
    }

    public String[] getCode() {
        return code;
    }

    public String[] getName() {
        return name;
    }
}
