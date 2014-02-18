package com.tw.unoProject.view;

import com.tw.unoProject.model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.util.*;
import java.util.List;

public class LogDisplay {
    private JScrollPane log;
    private JTable logTable;

    public void createLog(int x, int y, int width, int height) {
        List<Player> players = Arrays.asList(new Player("sa"),new Player("ma"));
        List<Card> cards = Arrays.asList(new Card(2, com.tw.unoProject.model.Color.BLUE),new Card(4, com.tw.unoProject.model.Color.GREEN));
        createTable(players,cards);
        log = new JScrollPane(logTable);
        log.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        log.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        log.setBounds(x, y, width, height);
    }

    public void createTable(List<Player> players,List<Card> card) {
        String ColumnName[] = {"NAME", "CARD"};
        Object data[][] = new Object[players.size()][2];
        System.out.println(data.length);
        for (int i = 0; i < players.size(); i++) {
            for (int j = 0; j < card.size(); j++) {
                data[i][0] = players.get(i).getName();
                data[i][1] = card.get(i).getColor() + ":" + card.get(i).getValue();

            }
        }

        logTable = new JTable(data, ColumnName);
        logTable.setBounds(40, 120, 520, 200);
        logTable.setLayout(new GridLayout(5, 3));
        logTable.setAutoResizeMode(1);
        logTable.setBackground(Color.lightGray);
        logTable.setBorder(BorderFactory.createLineBorder(Color.black));
        logTable.setFont(new Font("serif", Font.BOLD, 20));
        logTable.setRowHeight(40);
    }

    public JScrollPane getLog() {
        return log;
    }

    public JTable getLogTable() {
        return logTable;
    }
}