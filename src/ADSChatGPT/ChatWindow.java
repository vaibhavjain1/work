package ADSChatGPT;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChatWindow extends JFrame {

    private JTextArea chatArea;
    private JTextField messageField;
    private JButton sendButton;

    public ChatWindow() {
        super("Chat Window");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 600);

        // Create chat area
        chatArea = new JTextArea(20, 30);
        chatArea.setEditable(false);
        JScrollPane chatScrollPane = new JScrollPane(chatArea);

        // Create message field and send button
        messageField = new JTextField(30);
        sendButton = new JButton("Send");

        // Add action listener to send button
        sendButton.addActionListener(e -> {
            String message = messageField.getText();
            chatArea.append("You: " + message + "\n");
            messageField.setText("");
            // Add logic to send message to server or other user
        });

        // Create panel for message field and send button
        JPanel messagePanel = new JPanel();
        messagePanel.setLayout(new FlowLayout());
        messagePanel.add(messageField);
        messagePanel.add(sendButton);

        // Add components to frame
        add(chatScrollPane, BorderLayout.CENTER);
        add(messagePanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ChatWindow();
            }
        });
    }
}
