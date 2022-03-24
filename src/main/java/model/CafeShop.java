package model;

public class CafeShop {
    protected int id;
    protected String drinks;
    protected int price;
    protected int quantity;
    protected int total = price * quantity;
    public CafeShop(int id, String drinks, int price, int quantity , int total) {
        this.id = id;
        this.drinks = drinks;
        this.price = price;
        this.quantity = quantity;
        this.total = total;
    }

    public CafeShop(String drinks, int price, int quantity, int total) {
        this.drinks = drinks;
        this.price = price;
        this.quantity = quantity;
        this.total = total;
    }

    public CafeShop(String drinks, int price, int quantity) {
        this.drinks = drinks;
        this.price = price;
        this.quantity = quantity;
    }

    public CafeShop(String drinks, int quantity) {
        this.drinks = drinks;
        this.quantity = quantity;
    }

    public CafeShop(int id, String drinks,int price, int quantity) {
        this.id = id;
        this.drinks = drinks;
        this.quantity = quantity;
        this.price=price;
    }

    public CafeShop() {
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDrinks() {
        return drinks;
    }

    public void setDrinks(String drinks) {
        this.drinks = drinks;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return id + "," + drinks + "," + price + "," + quantity + "," + total ;
    }

}
