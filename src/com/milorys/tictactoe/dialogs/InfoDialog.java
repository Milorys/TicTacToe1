package com.milorys.tictactoe.dialogs;

import javax.swing.*;
import java.awt.event.*;

public class InfoDialog extends JDialog
{
    private JPanel contentPane;
    private JButton buttonOK;
    private JLabel label;

    public InfoDialog()
    {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        setTitle("Tic Tac Toe! | O grze");
        setResizable(false);

        buttonOK.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                onOK();
            }
        });


        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent e)
            {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

        pack();
    }

    private void onOK()
    {
        // add your code here
        dispose();
    }

    private void onCancel()
    {
        // add your code here if necessary
        dispose();
    }
}
