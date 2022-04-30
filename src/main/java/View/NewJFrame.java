/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Controller.Listener;
import Model.LineTableModel;
import Model.HeaderTableModel;
import Model.InvoiceHeader;
import Model.InvoiceLine;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JTable;
import javax.swing.JTextField;
/**
 *
 * @author AHMED EID
 */
public class NewJFrame extends javax.swing.JFrame{
    
    DateFormat dateFormat= new SimpleDateFormat("dd-mm-yyyy");
    Date date= new Date();
    Calendar cla= Calendar.getInstance();
    
    public NewJFrame() {
        initComponents();
        InvDateTF.setText(" " +dateFormat.format(date));

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        headerTable = new javax.swing.JTable();
        headerTable.getSelectionModel().addListSelectionListener(listener);
        createNewInv = new javax.swing.JButton();
        createNewInv.addActionListener(listener);
        deleteInv = new javax.swing.JButton();
        deleteInv.addActionListener(listener);
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        InvDateTF = new javax.swing.JTextField();
        CustNameTF = new javax.swing.JTextField();
        InvTotalLbl = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lineTable = new javax.swing.JTable();
        saveBtn = new javax.swing.JButton();
        saveBtn.addActionListener(listener);
        cancelBtn = new javax.swing.JButton();
        cancelBtn.addActionListener(listener);
        invNumber = new javax.swing.JLabel();
        invTotal = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        LoadFileMenuItem = new javax.swing.JMenuItem();
        LoadFileMenuItem.addActionListener(listener);
        SaveFileMenuItem = new javax.swing.JMenuItem();
        SaveFileMenuItem.addActionListener(listener);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sales Invoice App");
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jLabel6.setText("Invoice table");

        headerTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "No.", "Date", "Customer", "Total"
            }
        ));
        jScrollPane3.setViewportView(headerTable);

        createNewInv.setText("Create new invoice");
        createNewInv.setActionCommand("CreateNewInvoice");
        createNewInv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createNewInvActionPerformed(evt);
            }
        });

        deleteInv.setText("Delete invoice");
        deleteInv.setActionCommand("DeleteInvoice");
        deleteInv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteInvActionPerformed(evt);
            }
        });

        jLabel1.setText("Invoice number");

        jLabel2.setText("Invoice Date");

        jLabel3.setText("Customer Name");

        jLabel4.setText("Invoice Total");

        jLabel5.setText("Invoice items");

        InvDateTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InvDateTFActionPerformed(evt);
            }
        });

        CustNameTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CustNameTFActionPerformed(evt);
            }
        });

        jScrollPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        lineTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "No.", "Item Name", "Item Price", "Count", "Item Total"
            }
        ));
        lineTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lineTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(lineTable);

        saveBtn.setText("Add Item");
        saveBtn.setActionCommand("CreateNewLine");
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });

        cancelBtn.setText("Cancel Item");
        cancelBtn.setActionCommand("DeleteLine");
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 459, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(47, 47, 47)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CustNameTF)
                            .addComponent(InvDateTF)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(invTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(InvTotalLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(invNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addComponent(createNewInv)
                .addGap(32, 32, 32)
                .addComponent(deleteInv)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(saveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cancelBtn)
                .addGap(165, 165, 165))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(invNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(InvDateTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(CustNameTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(InvTotalLbl)))
                            .addComponent(invTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(createNewInv)
                    .addComponent(deleteInv)
                    .addComponent(saveBtn)
                    .addComponent(cancelBtn))
                .addContainerGap())
        );

        jMenu2.setText("File");
        jMenu2.setContentAreaFilled(false);
        jMenu2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenu2.setName("file"); // NOI18N

        LoadFileMenuItem.setText("Load file");
        LoadFileMenuItem.setActionCommand("LoadFile");
        LoadFileMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoadFileMenuItemActionPerformed(evt);
            }
        });
        jMenu2.add(LoadFileMenuItem);

        SaveFileMenuItem.setText("Save file");
        SaveFileMenuItem.setActionCommand("SaveFile");
        SaveFileMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveFileMenuItemActionPerformed(evt);
            }
        });
        jMenu2.add(SaveFileMenuItem);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SaveFileMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveFileMenuItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SaveFileMenuItemActionPerformed

    private void CustNameTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CustNameTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CustNameTFActionPerformed

    private void LoadFileMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoadFileMenuItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LoadFileMenuItemActionPerformed

    private void createNewInvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createNewInvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_createNewInvActionPerformed

    private void InvDateTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InvDateTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_InvDateTFActionPerformed

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_saveBtnActionPerformed

    private void deleteInvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteInvActionPerformed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_deleteInvActionPerformed

    private void lineTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lineTableMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lineTableMouseClicked

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cancelBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CustNameTF;
    private javax.swing.JTextField InvDateTF;
    private javax.swing.JLabel InvTotalLbl;
    private javax.swing.JMenuItem LoadFileMenuItem;
    private javax.swing.JMenuItem SaveFileMenuItem;
    private javax.swing.JButton cancelBtn;
    private javax.swing.JButton createNewInv;
    private javax.swing.JButton deleteInv;
    private javax.swing.JTable headerTable;
    private javax.swing.JLabel invNumber;
    private javax.swing.JLabel invTotal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable lineTable;
    private javax.swing.JButton saveBtn;
    // End of variables declaration//GEN-END:variables

    private List<InvoiceHeader> invoices= new ArrayList<>();
    private HeaderTableModel headerTableModel;
    private LineTableModel lineTableModel;     
    private HeaderDialog headerDialog;
    private LineDialog lineDialog;
    private Listener listener = new Listener(this);
    
    public Listener getListener() {
        return listener;
    }

    public void setHeaderDialog(HeaderDialog headerDialog) {
        this.headerDialog = headerDialog;
    }

    public void setLineDialog(LineDialog lineDialog) {
        this.lineDialog = lineDialog;
    }

    public void setHeaderTableModel(HeaderTableModel headerTableModel) {
        this.headerTableModel = headerTableModel;
    }

    public void setLineTableModel(LineTableModel lineTableModel) {
        this.lineTableModel = lineTableModel;
    }

    public JButton getcreateNewInvBtn() {
        return createNewInv;
    }

    public JButton getsaveBtn() {
        return saveBtn;
    }

    public JTextField getCustNameTF() {
        return CustNameTF;
    }

    public JButton getDeleteInvBtn() {
        return deleteInv;
    }

    public JButton getcancelBtn() {
        return cancelBtn;
    }

    public JTextField getDateTF() {
        return InvDateTF;
    }

    public JTable getlineTable() {
        return lineTable;
    }

    public JLabel getinvNumber() {
        return invNumber;
    }

    public JLabel getTotal() {
        return invTotal;
    }

    public JTable getheaderTable() {
        return headerTable;
    }

    public JMenuItem getLoadMenuItem() {
        return LoadFileMenuItem;
    }

    public JMenuItem getSaveMenuItem() {
        return SaveFileMenuItem;
    }

    public List<InvoiceHeader> getHeaderList() {
        return invoices;
    }

    public HeaderTableModel getHeaderTableModel() {
        return headerTableModel;
    }

    public LineTableModel getLineTableModel() {
        return lineTableModel;
    }

    public HeaderDialog getHeaderDialog() {
        return headerDialog;
    }

    public LineDialog getLineDialog() {
        return lineDialog;
    }

}