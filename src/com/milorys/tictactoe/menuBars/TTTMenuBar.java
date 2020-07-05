package com.milorys.tictactoe.menuBars;

import com.milorys.tictactoe.TicTacToeFrame;
import com.milorys.tictactoe.dialogs.InfoDialog;
import com.milorys.tictactoe.panels.ScorePanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TTTMenuBar extends JMenuBar
{
    public TTTMenuBar()
    {
        JMenu game = new JMenu("Gra");
        JMenuItem resetGame = new JMenuItem("Resetuj grę");
        JMenuItem resetScore = new JMenuItem("Resetuj wynik");
        resetScore.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                ScorePanel.setyScore(0);
                ScorePanel.setxScore(0);
            }
        });
        resetGame.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                TicTacToeFrame.getTttPanel().resetGame();
            }
        });

        game.add(resetGame);
        game.add(resetScore);
        game.addSeparator();

        JMenuItem aboutGame = new JMenuItem("O grze");
        aboutGame.setMnemonic('0');
        aboutGame.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                JDialog dialog = new InfoDialog();
                dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                dialog.setVisible(true);
            }
        });

        game.add(aboutGame);

        add(game);
    }
}
