package org.forest.fire.model;

import javax.swing.*;
import java.awt.*;

public class DisplayForest extends JPanel {
    private final Forest forest;
    private final int cellSize;

    public DisplayForest(Forest forest, int cellSize) {
        this.forest = forest;
        this.cellSize = cellSize;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (int row = 0; row < forest.getTreeArray().size(); row++) {
            for (int col = 0; col < forest.getTreeArray().get(row).size(); col++) {
                Tree tree = forest.getTreeArray().get(row).get(col);

                switch (tree.getStatus()) {
                    case ALIVE -> g.setColor(Color.GREEN);
                    case ON_FIRE -> g.setColor(Color.RED);
                    case BURNED -> g.setColor(Color.GRAY);
                    default -> g.setColor(Color.GREEN);
                }

                int x = col * cellSize;
                int y = row * cellSize;
                g.fillRect(x, y, cellSize, cellSize);

                g.setColor(Color.BLACK);
                g.drawRect(x, y, cellSize, cellSize);
            }
        }
    }
}
