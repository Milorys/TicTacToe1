package com.milorys.tictactoe.panels;

import com.milorys.tictactoe.TicTacToeFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static com.milorys.tictactoe.TicTacToeFrame.xWins;
import static com.milorys.tictactoe.TicTacToeFrame.yWins;

public class TicTacToePanel extends JPanel
{
    private ArrayList<JButton> signs = new ArrayList<>(9);
    private int activePlayer = 0;
    private TicTacToeFrame tttFrame;

    public TicTacToePanel()
    {
        setLayout(new GridLayout(3, 3));

        Font font = new Font("Serif", Font.BOLD, 96);

        for(int i = 0; i < 9; i++)
        {
            JButton button = new JButton("?");
            if(i == 0 || i % 2 == 0)
            {
                button.setBackground(Color.WHITE);
            }
            else
            {
                button.setBackground(Color.DARK_GRAY);
                button.setForeground(Color.WHITE);
            }
            button.setFont(font);
            button.setSize(150, 150);
            button.setToolTipText("Nr komponentu: " + i);
            button.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    JButton button = (JButton) e.getSource();

                    if(button.getText().equals("X") || button.getText().equals("O"))
                    {
                        Toolkit.getDefaultToolkit().beep();
                    }
                    else
                    {
                        if (activePlayer == 0)
                        {
                            button.setText("X");
                            activePlayer = 1;
                            ScorePanel.setCurrentTurn("O (kółko)");
                        }
                        else
                        {
                            button.setText("O");
                            activePlayer = 0;
                            ScorePanel.setCurrentTurn("X (krzyżyk)");
                        }

                        checkResult();
                    }
                }
            });
            signs.add(button);
            add(button);
            repaint();
        }

        repaint();
    }

    public void checkResult()
    {
        for(int i = 0; i < 9; i = i + 3)
        {
            if(signs.get(i).getText().equals("X") && signs.get(i + 1).getText().equals("X") && signs.get(i + 2).getText().equals("X"))
            {
                announceWinner("X");
            }
        }

        for(int i = 0; i < 3; i++)
        {
            if(signs.get(i).getText().equals("X") && signs.get(3 + i).getText().equals("X") && signs.get(6 + i).getText().equals("X"))
            {
                announceWinner("X");
            }
        }

        if(signs.get(0).getText().equals("X") && signs.get(4).getText().equals("X") && signs.get(8).getText().equals("X"))
        {
            announceWinner("X");
        }

        if(signs.get(6).getText().equals("X") && signs.get(4).getText().equals("X") && signs.get(2).getText().equals("X"))
        {
            announceWinner("X");
        }

        //Sprawdzanie O
        for(int i = 0; i < 9; i = i + 3)
        {
            if(signs.get(i).getText().equals("O") && signs.get(i + 1).getText().equals("O") && signs.get(i + 2).getText().equals("O"))
            {
                announceWinner("O");
            }
        }

        for(int i = 0; i < 3; i++)
        {
            if(signs.get(i).getText().equals("O") && signs.get(3 + i).getText().equals("O") && signs.get(6 + i).getText().equals("O"))
            {
                announceWinner("O");
            }
        }

        if(signs.get(0).getText().equals("O") && signs.get(4).getText().equals("O") && signs.get(8).getText().equals("O"))
        {
            announceWinner("O");
        }

        if(signs.get(6).getText().equals("O") && signs.get(4).getText().equals("O") && signs.get(2).getText().equals("O"))
        {
            announceWinner("O");
        }
    }

    public void announceWinner(String xo)
    {
        if(xo.equals("X"))
        {
            xWins++;
            ScorePanel.setxScore(xWins);
        }
        else
        {
            yWins++;
            ScorePanel.setyScore(yWins);
        }
        Toolkit.getDefaultToolkit().beep();
        JOptionPane.showMessageDialog(this, xo + " wygrał tę grę!", "Wygrana", JOptionPane.INFORMATION_MESSAGE);
        resetGame();
    }

    public void resetGame()
    {
        for(JButton button : signs)
        {
            button.setText("?");
        }
    }

}
