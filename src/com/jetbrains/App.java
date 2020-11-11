package com.jetbrains;

import javax.swing.*;

public class App extends JFrame{
    private JPanel MainPanel;
    private JButton exitButton;
    private JTextField textFieldIn;
    private JTextField textFieldOut;
    private JRadioButton change1RadioButton;
    private JRadioButton insertRadioButton;
    private JRadioButton change2RadioButton;
    private JButton resultButton;
    private JComboBox narechCombo;
    private JComboBox suchCombo;
    private JButton clearButton;

    App()
    {
        narechCombo.setEnabled(false);
        suchCombo.setEnabled(false);
        setSize(500, 500);
        setVisible(true);
        add(MainPanel);
        change2RadioButton.addActionListener(e ->
        {
            narechCombo.setEnabled(true);
            suchCombo.setEnabled(false);
        });
        change1RadioButton.addActionListener(e ->
        {
            narechCombo.setEnabled(false);
            suchCombo.setEnabled(true);
        });
        insertRadioButton.addActionListener(e ->
        {
            narechCombo.setEnabled(false);
            suchCombo.setEnabled(false);
        });
        clearButton.addActionListener(e ->
        {
            textFieldOut.setText("");
            textFieldIn.setText("");
        });

        resultButton.addActionListener(e ->
        {
            String temp_str;
            boolean key1 = true, key2 = true;
            String word1 = null, word2 = null, word3 = null;
            int last = 0;
            temp_str = textFieldIn.getText();
            for(int i = 0;i < temp_str.length() ; i++)
            {
                if(temp_str.charAt(i) == ' ' && key1)
                {
                    word1 = temp_str.substring(0, i);
                    key1 = false;
                    last = i + 1;
                }
                else if(temp_str.charAt(i) == ' ' && key2)
                {
                    word2 = temp_str.substring(last, i);
                    key2 = false;
                    last = i + 1;
                }
                if(!key1 && !key2 && i == temp_str.length() - 1)
                    word3 = temp_str.substring(last, i + 1);

            }
            if(change1RadioButton.isSelected())
            {
                word1 = (String) suchCombo.getSelectedItem();
            }
            if(insertRadioButton.isSelected())
                word2 += " бы";
            if(change2RadioButton.isSelected())
            {
                word3 = (String) narechCombo.getSelectedItem();
            }


            textFieldOut.setText(word1 + ' ' + word2 + ' ' + word3);
        });

        exitButton.addActionListener(e -> System.exit(0));


    }

}
