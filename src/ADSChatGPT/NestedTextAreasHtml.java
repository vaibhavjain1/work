package ADSChatGPT;
import javax.swing.*;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import java.awt.*;

public class NestedTextAreasHtml {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Nested Text Areas HTML");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JTextPane textPane = new JTextPane();
        HTMLEditorKit kit = new HTMLEditorKit();
        HTMLDocument doc = (HTMLDocument) kit.createDefaultDocument();
        textPane.setEditorKit(kit);
        textPane.setDocument(doc);
        // Insert HTML content
        String html = "<html><body>Outer text area...<br><br>" +
                "<table><tr><td><textarea rows='10' cols='20'>" +
                "Inner text area...</textarea></td></tr></table>" +
                "</body></html>";

        textPane.setText(html);

        JScrollPane scrollPane = new JScrollPane(textPane);
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }
}
