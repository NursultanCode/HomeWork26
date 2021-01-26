import java.util.ArrayList;
public interface Connection {
    void openConnection();
    void closeConnection();
    boolean checkConnection();
    String readProduct(int index);
    boolean haveProduct(String key) throws Exception;
    String readProductByKey(String key) throws Exception;
    ArrayList<Product> createListFromTo(int start, int end) throws Exception;
    int productsCount() throws Exception;
    void addProduct(String key, String value) throws Exception;
    void renameProductValueByIndex(int index, String newValue) throws Exception;
    void renameProductValueByKey(String key, String newValue) throws Exception;
}
