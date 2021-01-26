import java.util.ArrayList;
import java.util.Arrays;

public class Market implements Connection{
    ArrayList <Product> products;
    boolean connection = false;

    public Market() {
        Product [] array = JsonReader.readProducts();
        products  =new ArrayList<>();
        products.addAll(Arrays.asList(array));
    }

    @Override
    public void openConnection() {
        connection = true;
        System.out.println("Connection ON");
    }

    @Override
    public void closeConnection() {
        connection = false;
        System.out.println("Connection OFF");
    }

    @Override
    public boolean checkConnection() {
        return connection;
    }

    @Override
    public String readProduct(int index) {
        try{
            if (!checkConnection()) throw new Exception("The connection error");
            if (index<products.size()){
                return products.get(index).toString();
            }else {
                throw new Exception("There is no element in this position");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public boolean haveProduct(String key) throws Exception {
        if (!checkConnection()) throw new Exception("The connection error");
        for (Product a:products
             ) {
            if (a.getKey().equals(key))return true;
        }
        return false;
    }

    @Override
    public String readProductByKey(String key) throws Exception {
        if (!checkConnection()) throw new Exception("The connection error");
        for (Product a : products
        ) {
            if (a.getKey().equals(key)) return a.toString();
        }
        throw new Exception("There is no product with key: " + key);
    }

    @Override
    public ArrayList<Product> createListFromTo(int start, int end) throws Exception {
        if (!checkConnection()) throw new Exception("The connection error");
        ArrayList<Product> list = new ArrayList<>();
        if (start>0 && end<products.size()){
            for (int i = start; i <end ; i++) {
                list.add(products.get(i));
            }
        }else {
            throw new Exception("Incorrect input1");
        }
        return  list;
    }

    @Override
    public int productsCount() throws Exception {
        if (!checkConnection()) throw new Exception("The connection error");
        return products.size();
    }

    @Override
    public void addProduct(String key, String value) throws Exception {
        if (!checkConnection()) throw new Exception("The connection error");
        if (!haveProduct(key)){
            Product a = new Product(key,value);
            products.add(a);
        }
    }

    @Override
    public void renameProductValueByIndex(int index, String newValue) throws Exception {
        if (!checkConnection()) throw new Exception("The connection error");
        try{
            if (index<products.size()){
                products.get(index).setValue(newValue);
            }else {
                throw new Exception("There is no element in this position");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void renameProductValueByKey(String key, String newValue) throws Exception {
        if (!checkConnection()) throw new Exception("The connection error");
        try {
            if (haveProduct(key)){
                for (Product a:products
                ) {
                    if (a.getKey().equals(key)) a.setValue(newValue);
                }
            }else throw new Exception("There is no product with this key!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String toString() {
        StringBuilder r= new StringBuilder();
        for (Product a:products
             ) {
            r.append(a.toString());
        }
        return r.toString();
    }
}
