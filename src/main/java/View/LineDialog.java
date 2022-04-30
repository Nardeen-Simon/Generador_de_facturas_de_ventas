/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class LineDialog extends JDialog{
    private JTextField product;
    private JTextField Count;
    private JTextField Price;
    private JLabel productLb;
    private JLabel CountLb;
    private JLabel PriceLb;
    private JButton ok;
    private JButton cancel;
    
        public LineDialog(NewJFrame frame) {
        product = new JTextField(20);
        productLb = new JLabel("Item Name");
        
        Count = new JTextField(20);
        CountLb = new JLabel("Item Count");
        
        Price = new JTextField(20);
        PriceLb = new JLabel("Item Price");
        
        ok = new JButton("OK");
        cancel = new JButton("Cancel");
        
        ok.setActionCommand("createLineOK");
        cancel.setActionCommand("createLineCancel");
        
        ok.addActionListener(frame.getListener());
        cancel.addActionListener(frame.getListener());
        setLayout(new GridLayout(4, 2));
        
        add(productLb);
        add(product);
        add(CountLb);
        add(Count);
        add(PriceLb);
        add(Price);
        add(ok);
        add(cancel);
        
        pack();
    }

    public JTextField getProduct() {
        return product;
    }

    public JTextField getCount() {
        return Count;
    }

    public JTextField getPrice() {
        return Price;
    }
}
