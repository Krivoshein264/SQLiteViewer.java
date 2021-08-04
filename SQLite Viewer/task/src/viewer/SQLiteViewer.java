package viewer;

import javax.swing.*;
import java.util.ArrayList;

public class SQLiteViewer extends JFrame {
    private JButton openFileButton;
    private JTextField fileNameTextField;
    private JComboBox box;
    private JTextArea queryTextArea;
    private JTable tab;

    public SQLiteViewer() {
        super("SQLite Viewer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 500);
        setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);

        fileNameTextField = new JTextField();
        fileNameTextField.setName("FileNameTextField");
        fileNameTextField.setBounds(20, 30, 500, 30);
        add(fileNameTextField);

        box = new JComboBox();
        box.setName("TablesComboBox");
        box.setBounds(20, 100, 600, 30);
        add(box);

        queryTextArea = new JTextArea();
        queryTextArea.setName("QueryTextArea");
        queryTextArea.setBounds(20, 150, 450, 100);
        add(queryTextArea);

        JButton executeQueryButton = new JButton("Execute");
        executeQueryButton.setName("ExecuteQueryButton");
        executeQueryButton.setBounds(500, 150, 120, 50);
        add(executeQueryButton);

        openFileButton = new JButton("Open");
        openFileButton.setName("OpenFileButton");
        openFileButton.setBounds(550, 30, 100, 30);
        add(openFileButton);

        tab = new JTable();

        initComponents();
    }
        private void initComponents() {
            openFileButton.addActionListener(e -> {
                box.removeAllItems();
                String dbName = fileNameTextField.getText();
                DataB.createDatabase(dbName);
                ArrayList<String> tableNames = DataB.getTableNames();
                for (String s : tableNames) {
                    box.addItem(s);
                }
            });

            box.addActionListener(e -> {
                String table = (String) box.getSelectedItem();
                queryTextArea.setText(String.format("SELECT * FROM %s;", table));
            });
    }
}