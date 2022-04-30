package Model;
import java.util.ArrayList;

public class InvoiceLine {
   
    private String product;
    private double price;
    private int count;
    private InvoiceHeader header;
    
    public InvoiceLine(String product, double price, int count, InvoiceHeader header) {
        this.product = product;
        this.price = price;
        this.count = count;
        this.header = header;
    }
    
    public InvoiceHeader getHeader() {
        return header;
    }

    public void setHeader(InvoiceHeader header) {
        this.header = header;
    }
    
    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
 
    @Override
    public String toString() {
        return "Line{" + "productName=" + product + ", productprice=" + price + ", productCount=" + count + '}';
    }
    
    public double getLineTotal() {
        return count * price;
    }
    
    public String getDataAsCSV() {
        return "" + getHeader().getNum() + "," + getProduct() + "," + getPrice() + "," + getCount();
    }
    
    
}
