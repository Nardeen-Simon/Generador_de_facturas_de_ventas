package Model;

import Model.InvoiceHeader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author AHMED EID
 */
public class HeaderTableModel extends AbstractTableModel{
    
    private List<InvoiceHeader> HeaderList;
    private DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
    
    public HeaderTableModel(List<InvoiceHeader> HeaderList) {
        this.HeaderList = HeaderList;
    }

    public List<InvoiceHeader> getHeaderList() {
        return HeaderList;
    }
    
    
    @Override
    public int getRowCount() {
        return HeaderList.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Invoice Num";
            case 1:
                return "Customer Name";
            case 2:
                return "Invoice Date";
            case 3:
                return "Invoice Total";
            default:
                return "";
        }
    }

    @Override
    public Class<?> getColumnClass(int column) {
        switch (column) {
            case 0:
                return Integer.class;
            case 1:
                return String.class;
            case 2:
                return String.class;
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
        InvoiceHeader Row = HeaderList.get(row);
        
        switch (column) {
            case 0:
                return Row.getNum();
            case 1:
                return Row.getCustName();
            case 2:
                return df.format(Row.getDate());
            case 3:
                return Row.getTotal();
            default:
                return "";
        }
        
    }
    
}
