package com.milorys.tictactoe;

import com.milorys.tictactoe.menuBars.TTTMenuBar;
import com.milorys.tictactoe.panels.ScorePanel;
import com.milorys.tictactoe.panels.TicTacToePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TicTacToeFrame extends JFrame
{
    private static TicTacToePanel tttPanel;

    public static int yWins = 0;
    public static int xWins = 0;

    public TicTacToeFrame()
    {
        setTitle("Tic Tac Toe!");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLayout(new BorderLayout());
        addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent e)
            {
                int option = JOptionPane.showConfirmDialog(null, "Czy na pewno chcesz wyjść z gry?", "Wyjście z gry", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if(option == 0)
                {
                    System.exit(0);
                }
            }
        });

        tttPanel = new TicTacToePanel();

        add(tttPanel, BorderLayout.NORTH);
        add(new ScorePanel(tttPanel), BorderLayout.CENTER);
        setSize(430, 550);

        setJMenuBar(new TTTMenuBar());
        setResizable(false);
    }

    public static TicTacToePanel getTttPanel()
    {
        return tttPanel;
    }
}
