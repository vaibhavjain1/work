package accolite;

import java.awt.Component;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

public class DynRowAdd extends JFrame{

private JPanel mainPanel;
private JTable table;
private DefaultTableModel model_table;
private JScrollPane scroll_pane;

public static void main(String[] args) {
	DynRowAdd main = new DynRowAdd();
    main.setVisible(true);
}   
public DynRowAdd() {
    mainPanel = new JPanel(null);
    setSize(500, 500);

    table = new JTable();
    model_table = new DefaultTableModel();
    model_table.addColumn("1");
    table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
    
    TableCellRenderer cellRenderer = table.getCellRenderer(1, 1); 
    Component c = table.prepareRenderer(cellRenderer, 0, 0);
    int width = c.getPreferredSize().width + table.getIntercellSpacing().width;
    table.getColumnModel().getColumn(0).setPreferredWidth(width);
    
    table.setTableHeader(null);
    table.setModel(model_table);
    table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
    for(int i=0;i<10;i++){                             // add value to table
           Vector<String> r  = new Vector<String>();
            r.addElement("dksljfjdsklfjklfjsklfsdfklkldfjalkfjdklfjasfkljdfk");
            model_table.addRow(r);
    } 

    scroll_pane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);            // add table to scroll panel
    scroll_pane.setBounds(5, 10, 350, 150);
    scroll_pane.setVisible(true);
    mainPanel.add(scroll_pane);

    this.add(mainPanel);
  }
}