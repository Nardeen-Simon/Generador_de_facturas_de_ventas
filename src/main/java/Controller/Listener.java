package Controller;

import Model.LineTableModel;
import Model.HeaderTableModel;
import Model.InvoiceHeader;
import Model.InvoiceLine;
import View.NewJFrame;
import View.HeaderDialog;
import View.LineDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Listener implements ActionListener, ListSelectionListener  {
    private NewJFrame frame;
    private DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
    
    public Listener(NewJFrame frame) {
        this.frame = frame;
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {

        switch (e.getActionCommand()) {
            case "CreateNewInvoice":
                HeaderDialog();
                break;
            case "DeleteInvoice":
                deleteHeaderAction();
                break;
            case "CreateNewLine":
                LineDialog();
                break;
            case "DeleteLine":
                deleteLineAction();
                break;
            case "LoadFile":
                loadFromFile();
                break;
            case "SaveFile":
                saveToFile();
                break;
            case "createInvCancel":
                HeaderDialogCancel();
                break;
            case "createInvOK":
                HeaderDialogOk();
                break;
            case "createLineCancel":
                LineDialogCancel();
                break;
            case "createLineOK":
                LineDialogOk();
                break;
        }
    }

    private void loadFromFile() {
        JOptionPane.showMessageDialog(frame, "Please, select header file!", "Attension", JOptionPane.WARNING_MESSAGE);
        JFileChooser openFile = new JFileChooser();
        int result = openFile.showOpenDialog(frame);
        if (result == JFileChooser.APPROVE_OPTION) {
            File headerFile = openFile.getSelectedFile();
            try {
                FileReader headerFr = new FileReader(headerFile);
                BufferedReader headerBr = new BufferedReader(headerFr);
                String headerLine = null;

                while ((headerLine = headerBr.readLine()) != null) {
                    String[] headerParts = headerLine.split(",");
                    String invNumStr = headerParts[0];
                    String invDateStr = headerParts[1];
                    String custName = headerParts[2];

                    int invNum = Integer.parseInt(invNumStr);
                    Date invDate = df.parse(invDateStr);
                    InvoiceHeader invHeader = new InvoiceHeader(invNum, invDate, custName);
                    frame.getHeaderList().add(invHeader);
                }

                JOptionPane.showMessageDialog(frame, "Please, select lines file!", "Attension", JOptionPane.WARNING_MESSAGE);
                result = openFile.showOpenDialog(frame);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File linesFile = openFile.getSelectedFile();
                    BufferedReader linesBr = new BufferedReader(new FileReader(linesFile));
                    String linesLine = null;
                    while ((linesLine = linesBr.readLine()) != null) {
                        String[] lineParts = linesLine.split(",");
                        String invNumStr = lineParts[0];
                        String itemName = lineParts[1];
                        String itemPriceStr = lineParts[2];
                        String itemCountStr = lineParts[3];

                        int invNum = Integer.parseInt(invNumStr);
                        double price = Double.parseDouble(itemPriceStr);
                        int count = Integer.parseInt(itemCountStr);
                        InvoiceHeader header = findByNum(invNum);
                        InvoiceLine invLine = new InvoiceLine(itemName, price, count, header);
                        header.getLines().add(invLine);
                    }
                    frame.setHeaderTableModel(new HeaderTableModel(frame.getHeaderList()));
                   frame.getheaderTable().setModel(frame.getHeaderTableModel());
                  frame.getheaderTable().validate();
                }
                System.out.println("Check");
            } catch (ParseException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(frame, "Date Format Error\n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            } catch (NumberFormatException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(frame, "Number Format Error\n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(frame, "File Error\n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            } catch (IOException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(frame, "Read Error\n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        display();
    }

    private void saveToFile() {
        String headers = "";
        String lines = "";
        for (InvoiceHeader header : frame.getHeaderList()) {
            headers += header.getDataAsCSV();
            headers += "\n";
            for (InvoiceLine line : header.getLines()) {
                lines += line.getDataAsCSV();
                lines += "\n";
            }
        }
        JOptionPane.showMessageDialog(frame, "Please, select file to save header data!", "Attension", JOptionPane.WARNING_MESSAGE);
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showSaveDialog(frame);
        if (result == JFileChooser.APPROVE_OPTION) {
            File headerFile = fileChooser.getSelectedFile();
            try {
                FileWriter hFW = new FileWriter(headerFile);
                hFW.write(headers);
                hFW.flush();
                hFW.close();

                JOptionPane.showMessageDialog(frame, "Please, select file to save lines data!", "Attension", JOptionPane.WARNING_MESSAGE);
                result = fileChooser.showSaveDialog(frame);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File linesFile = fileChooser.getSelectedFile();
                    FileWriter lFW = new FileWriter(linesFile);
                    lFW.write(lines);
                    lFW.flush();
                    lFW.close();
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        JOptionPane.showMessageDialog(frame, "Saved successfully", "Success", JOptionPane.INFORMATION_MESSAGE);

    }

    private InvoiceHeader findByNum(int invNum) {
        InvoiceHeader header = null;
        for (InvoiceHeader inv : frame.getHeaderList()) {
            if (invNum == inv.getNum()) {
                header = inv;
                break;
            }
        }
        return header;
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        System.out.println("Invoice Selected!");
        HeaderTableRowSelected();
    }

    private void HeaderTableRowSelected() {
        int selectedRowIndex = frame.getheaderTable().getSelectedRow();
        if (selectedRowIndex >= 0) {
            InvoiceHeader row = frame.getHeaderTableModel().getHeaderList().get(selectedRowIndex);
            frame.getCustNameTF().setText(row.getCustName());
            frame.getDateTF().setText(df.format(row.getDate()));
            frame.getinvNumber().setText("" + row.getNum());
            frame.getTotal().setText("" + row.getTotal());
            ArrayList<InvoiceLine> lines = row.getLines();
            frame.setLineTableModel(new LineTableModel(lines));
            frame.getlineTable().setModel(frame.getLineTableModel());
            frame.getLineTableModel().fireTableDataChanged();
        }
    }

    private void HeaderDialog() {
        frame.setHeaderDialog(new HeaderDialog(frame));
        frame.getHeaderDialog().setVisible(true);
    }

    private void LineDialog() {
        frame.setLineDialog(new LineDialog(frame));
        frame.getLineDialog().setVisible(true);
    }

    private void HeaderDialogCancel() {
        frame.getHeaderDialog().setVisible(false);
        frame.getHeaderDialog().dispose();
        frame.setHeaderDialog(null);
    }

    private void HeaderDialogOk() {
        String custName = frame.getHeaderDialog().getCustName().getText();
        String invDateStr = frame.getHeaderDialog().getInvDate().getText();
        frame.getHeaderDialog().setVisible(false);
        frame.getHeaderDialog().dispose();
        frame.setHeaderDialog(null);
        try {
            Date invDate = df.parse(invDateStr);
            int invNum = getNextInvoiceNum();
            InvoiceHeader invoiceHeader = new InvoiceHeader(invNum, invDate, custName);
            frame.getHeaderList().add(invoiceHeader);
            frame.getHeaderTableModel().fireTableDataChanged();
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(frame, "Wrong date format", "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
        display();
    }

    private int getNextInvoiceNum() {
        int max = 0;
        for (InvoiceHeader header : frame.getHeaderList()) {
            if (header.getNum() > max) {
                max = header.getNum();
            }
        }
        return max + 1;
    }

    private void LineDialogCancel() {
        frame.getLineDialog().setVisible(false);
        frame.getLineDialog().dispose();
        frame.setLineDialog(null);
    }

    private void LineDialogOk() {
        String productStr = frame.getLineDialog().getProduct().getText();
        String priceStr = frame.getLineDialog().getCount().getText();
        String countStr = frame.getLineDialog().getPrice().getText();
        frame.getLineDialog().setVisible(false);
        frame.getLineDialog().dispose();
        frame.setLineDialog(null);
        int Count = Integer.parseInt(countStr);
        double Price = Double.parseDouble(priceStr);
        int headerIndex = frame.getheaderTable().getSelectedRow();
        InvoiceHeader header = frame.getHeaderTableModel().getHeaderList().get(headerIndex);

        InvoiceLine invoiceLine = new InvoiceLine(productStr, Price, Count, header);
        header.addLine(invoiceLine);
        frame.getLineTableModel().fireTableDataChanged();
        frame.getHeaderTableModel().fireTableDataChanged();
        frame.getTotal().setText("" + header.getTotal());
        display();
    }

    private void deleteHeaderAction() {
        int invIndex = frame.getheaderTable().getSelectedRow();
        InvoiceHeader header = frame.getHeaderTableModel().getHeaderList().get(invIndex);
        frame.getHeaderTableModel().getHeaderList().remove(invIndex);
        frame.getHeaderTableModel().fireTableDataChanged();
        frame.setLineTableModel(new LineTableModel(new ArrayList<InvoiceLine>()));
        frame.getlineTable().setModel(frame.getLineTableModel());
        frame.getLineTableModel().fireTableDataChanged();
        frame.getCustNameTF().setText("");
        frame.getDateTF().setText("");
        frame.getinvNumber().setText("");
        frame.getTotal().setText("");
        display();
    }

    private void deleteLineAction() {
        int lineIndex = frame.getlineTable().getSelectedRow();
        InvoiceLine line = frame.getLineTableModel().getLineLines().get(lineIndex);
        frame.getLineTableModel().getLineLines().remove(lineIndex);
        frame.getHeaderTableModel().fireTableDataChanged();
        frame.getLineTableModel().fireTableDataChanged();
        frame.getTotal().setText("" + line.getHeader().getTotal());
        display();
    }

    private void display() {
        System.out.println("***************************");
        for (InvoiceHeader header : frame.getHeaderList()) {
            System.out.println(header);
        }
        System.out.println("***************************");
    }
    
}
