public class Main {
    public static void main(String[] args) throws Exception {
        Market market = new Market();
        System.out.println(market.toString());
        System.out.println(market.checkConnection());
        market.openConnection();
        System.out.println(market.checkConnection());
        System.out.println(market.readProduct(3));
        System.out.println(market.haveProduct("abc"));
        System.out.println(market.haveProduct("asd"));
        System.out.println(market.readProductByKey("ABC"));
    }
}
