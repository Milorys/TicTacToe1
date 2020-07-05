package com.milorys.tictactoe.panels;

import javax.swing.*;
import java.awt.*;

public class ScorePanel extends JPanel
{
    private TicTacToePanel tttPanel;
    private static JLabel currentTurn;
    private static JLabel xScore;
    private static JLabel yScore;

    public ScorePanel(TicTacToePanel tttPanel)
    {
        this.tttPanel = tttPanel;

        setBorder(BorderFactory.createEtchedBorder());
        setLayout(new GridBagLayout());
        setBackground(Color.LIGHT_GRAY);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.weighty = 100;
        gbc.weightx = 100;

        Font title = new Font("SansSerif", Font.BOLD, 18);
        Font common = new Font("Serif", Font.PLAIN, 16);

        JLabel scoreLabel = new JLabel("Wynik");
        scoreLabel.setFont(title);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        add(scoreLabel, gbc);

        JLabel x = new JLabel("X");
        x.setFont(common);
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(x, gbc);

        JLabel y = new JLabel("Y");
        y.setFont(common);
        gbc.gridx = 1;
        add(y, gbc);

        xScore = new JLabel("0");
        xScore.setFont(common);
        xScore.setForeground(Color.RED);
        gbc.gridy = 2;
        gbc.gridx = 0;
        add(xScore, gbc);

        yScore = new JLabel("0");
        yScore.setForeground(Color.RED);
        yScore.setFont(common);
        gbc.gridx = 1;
        add(yScore, gbc);

        JLabel turn = new JLabel("Czekam na ruch:");
        turn.setFont(common);
        gbc.gridy = 4;
        gbc.gridx = 0;
        add(turn, gbc);

        currentTurn = new JLabel("X (krzyżyk)");
        currentTurn.setFont(common);
        gbc.gridx = 1;
        add(currentTurn, gbc);

    }

    public static JLabel getCurrentTurn()
    {
        return currentTurn;
    }

    public static JLabel getxScore()
    {
        return xScore;
    }

    public static JLabel getyScore()
    {
        return yScore;
    }

    public static void setCurrentTurn(String currentTurn)
    {
        getCurrentTurn().setText(currentTurn);
    }

    public static void setxScore(int aXScore)
    {
        xScore.setText(String.valueOf(aXScore));
    }

    public static void setyScore(int aYScore)
    {
        yScore.setText(String.valueOf(aYScore));
    }
}
