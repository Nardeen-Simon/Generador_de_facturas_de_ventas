package Model;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class InvoiceHeader {
    private int num;
    private Date date;
    private String custName;
    private ArrayList <InvoiceLine> lines;
    private ArrayList <InvoiceHeader> row;

    public InvoiceHeader(int num, Date date, String custName) {
        this.num = num;
        this.date = date;
        this.custName = custName;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public ArrayList <InvoiceLine> getLines() {
        if (lines== null){
            lines= new ArrayList<>();}
        return lines;
    }

    public void setLines(ArrayList <InvoiceLine> lines) {
        this.lines = lines;
    }
    
    @Override
    public String toString() {
        String str = "Header{" + "invoiceNum=" + num + ", customerName=" + custName + ", invoiceDate=" + date + '}';
        for (InvoiceLine line : getLines()) {
            str += "\n\t" + line;
        }
        return str;
    }
    
        public double getTotal() {
        double total = 0.0;
        for (InvoiceLine line : getLines()) {
            total += line.getLineTotal();
        }
        return total;
    }
        
    public void addLine(InvoiceLine line) {
        getLines().add(line);
    }
    
    public String getDataAsCSV() {
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        return "" + getNum() + "," + df.format(getDate()) + "," + getCustName();
    }
    
}
