package org.forest.fire.service;

import org.forest.fire.model.DisplayForest;
import org.forest.fire.model.Forest;

import javax.swing.*;
import java.awt.*;

public class DisplayForestService {
    private static JFrame frame = null;

    public static void display(Forest forest, int cellSize) {
        int width = forest.getTreeArray().size() * cellSize;
        int height = forest.getTreeArray().getFirst().size() * cellSize+30;

        if (frame == null) {
            frame = new JFrame("Forest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new BorderLayout());
            frame.setPreferredSize(new Dimension(width, height));
            frame.pack();
            frame.setVisible(true);
        }

        frame.getContentPane().removeAll();

        DisplayForest panel = new DisplayForest(forest, cellSize);
        panel.setPreferredSize(new Dimension(width, height));
        frame.add(panel, BorderLayout.CENTER);

        frame.revalidate();
        frame.repaint();
    }
}
