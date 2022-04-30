package Model;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class LineTableModel extends AbstractTableModel{
    
    private List<InvoiceLine> LineList;
    private DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
    
    public LineTableModel(List<InvoiceLine> LineList) {
        this.LineList = LineList;
    }

    public List<InvoiceLine> getLineLines() {
        return LineList;
    }
    
    
    @Override
    public int getRowCount() {
        return LineList.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Item Name";
            case 1:
                return "Item Price";
            case 2:
                return "Count";
            case 3:
                return "Line Total";
            default:
                return "";
        }
    }

    @Override
    public Class<?> getColumnClass(int column) {
        switch (column) {
            case 0:
                return String.class;
            case 1:
                return Double.class;
            case 2:
                return Integer.class;
            case 3:
                return Double.class;
            default:
                return Object.class;
        }
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }

   
    @Override
    public Object getValueAt(int row, int column) {
        InvoiceLine Row = LineList.get(row);
        
        switch (column) {
            case 0:
                return Row.getProduct();
            case 1:
                return Row.getPrice();
            case 2:
                return Row.getCount();
            case 3:
                return Row.getLineTotal();
            default:
                return "";
        }
        
    }
}
