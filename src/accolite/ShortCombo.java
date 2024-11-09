package accolite;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Rectangle;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.SwingUtilities;
 
public class ShortCombo {
 
   public static void main(String[] args) {
	   
      SwingUtilities.invokeLater(new Runnable() {
 
         @Override
         public void run() {
            new ShortCombo().makeUI();
         }
      });
   }
 
   public void makeUI() {
      Object[] data = {
         "Longish Data one",
         "Longish Data two",
         "Longish Data three",
         "Longish Data four",
         "Longish Data five"
      };
      final JComboBox combo = new JComboBox(data);
      combo.setPrototypeDisplayValue("Short");
      combo.setRenderer(new DefaultListCellRenderer() {
 
         @Override
         public Component getListCellRendererComponent(JList list, Object value,
                 int index, boolean isSelected, boolean cellHasFocus) {
            super.getListCellRendererComponent(list, value, index,
                    isSelected, cellHasFocus);
            if (index == -1) {
               combo.setToolTipText(value.toString());
               return this;
            }
             
            setToolTipText(value.toString());
            Rectangle textRect =
                    new Rectangle(combo.getSize().width,
                    getPreferredSize().height);
            String shortText = SwingUtilities.layoutCompoundLabel(this,
                    getFontMetrics(getFont()),
                    value.toString(), null,
                    getVerticalAlignment(), getHorizontalAlignment(),
                    getHorizontalTextPosition(), getVerticalTextPosition(),
                    textRect, new Rectangle(), textRect,
                    getIconTextGap());
            setText(shortText);
            return this;
         }
      });
      JFrame frame = new JFrame("");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(200, 200);
      frame.setLayout(new FlowLayout());
      frame.setLocationRelativeTo(null);
      frame.add(combo);
      frame.setVisible(true);
   }
}