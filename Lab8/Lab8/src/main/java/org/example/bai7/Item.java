package org.example.bai7;

/** Don hang bao gom ten san pham, don gia, so luong */
public class Item {
    private final String name;
    private final double price;
    private final int    qty;

    public Item(String name, double price, int qty) {
        this.name  = name;
        this.price = price;
        this.qty   = qty;
    }

    public double getPrice() { return price; }
    public int    getQty()   { return qty; }
    public String getName()  { return name; }
}
