package accolite;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;

public class TableIcon extends JPanel
{
    public TableIcon()
    {
        Icon aboutIcon = new ImageIcon("D:\\Ads_20.5\\dist\\apps\\monitorstudio\\monitorstudio.gif");
        Icon addIcon = new ImageIcon("\"D:\\Ads_20.5\\dist\\apps\\monitorstudio\\monitorstudio.gif\"");
        Icon copyIcon = new ImageIcon("\"D:\\Ads_20.5\\dist\\apps\\monitorstudio\\monitorstudio.gif\"");

        String[] columnNames = {"Picture", "Description"};
        Object[][] data =
        {
            {aboutIcon, "About"},
            {addIcon, "Add"},
            {copyIcon, "Copy"},
        };

        DefaultTableModel model = new DefaultTableModel(data, columnNames)
        {
            //  Returning the Class of each column will allow different
            //  renderers to be used based on Class
            public Class getColumnClass(int column)
            {
                return getValueAt(0, column).getClass();
            }
        };
        JTable table = new JTable( model );
        table.setPreferredScrollableViewportSize(table.getPreferredSize());

        JScrollPane scrollPane = new JScrollPane( table );
        add( scrollPane );
    }

    private static void createAndShowGUI()
    {
        JFrame frame = new JFrame("Table Icon");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new TableIcon());
        frame.setLocationByPlatform( true );
        frame.pack();
        frame.setVisible( true );
    }

    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                createAndShowGUI();
            }
        });
    }

}