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
/**
 *
 * @author AHMED EID
 */
public class HeaderDialog extends JDialog {
    private JTextField custName;
    private JTextField invDate;
    private JLabel custNameLb;
    private JLabel invDateLb;
    private JButton ok;
    private JButton cancel;
    
        public HeaderDialog(NewJFrame frame) {
        custNameLb = new JLabel("Customer Name:");
        custName = new JTextField(20);
        invDateLb = new JLabel("Invoice Date:");
        invDate = new JTextField(20);
        ok = new JButton("OK");
        cancel = new JButton("Cancel");
        
        ok.setActionCommand("createInvOK");
        cancel.setActionCommand("createInvCancel");
        
        ok.addActionListener(frame.getListener());
        cancel.addActionListener(frame.getListener());
        setLayout(new GridLayout(3, 2));
        
        add(invDateLb);
        add(invDate);
        add(custNameLb);
        add(custName);
        add(ok);
        add(cancel);
        
        pack();
        
    }

    public JTextField getCustName() {
        return custName;
    }

    public JTextField getInvDate() {
        return invDate;
    }
    
}
