package com.milorys.tictactoe;

import javax.swing.*;
import java.awt.*;

public class Main
{
    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                JFrame frame = new TicTacToeFrame();
                frame.setVisible(true);
            }
        });
    }
}
