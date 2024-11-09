package accolite;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableCellRenderer;

 class MyRenderer extends DefaultTableCellRenderer {

	  /*
	   * @see TableCellRenderer#getTableCellRendererComponent(JTable, Object, boolean, boolean, int, int)
	   */
	  public Component getTableCellRendererComponent(JTable table, Object value,
	                                                 boolean isSelected, boolean hasFocus, 
	                                                 int row, int column) {
	    ImageIcon icon = new ImageIcon("D:\\Ads_20.5\\dist\\apps\\monitorstudio\\monitorstudio.gif");
	    setText((String)value);
	    setIcon(icon);
	    return this;
	  }
	}

public class FrameRenderer {

  public static void main(String[] args) {
    JFrame f = new JFrame("Sample");
    f.getContentPane().setLayout(new GridLayout(1,0,0,0));
    TableModel model = new AbstractTableModel() {
      public Object getValueAt(int rowIndex, int columnIndex) {
        return rowIndex + "," + columnIndex;
      }
      public int getColumnCount() {
        return 3;
      }
      public int getRowCount() {
        return 10;
      }
    };

    JTable table = new JTable(model);
    table.getColumnModel().getColumn(1).setCellRenderer(new MyRenderer());
    JScrollPane pane = new JScrollPane(table);
    f.getContentPane().add(pane);
    f.pack();
    f.setVisible(true);
  }
}