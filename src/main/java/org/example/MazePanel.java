package org.example;

import javax.swing.*;
import java.awt.*;
import java.util.Set;

public class MazePanel extends JPanel {
    private boolean[][] mazeMatrix;
    private Set<Point> animatedPath;
    private final Config config;

    public MazePanel(Config config) { this.config = config; }

    public void updateData(boolean[][] mazeMatrix, Set<Point> animatedPath) {
        this.mazeMatrix = mazeMatrix;
        this.animatedPath = animatedPath;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (mazeMatrix == null) return;

        int h = mazeMatrix.length, w = mazeMatrix[0].length;
        double cellSize = Math.min((double) getWidth() / w, (double) getHeight() / h);
        int offsetX = (int) ((getWidth() - (w * cellSize)) / 2);
        int offsetY = (int) ((getHeight() - (h * cellSize)) / 2);

        for (int y = 0; y < h; y++) {
            for (int x = 0; x < w; x++) {
                int px = offsetX + (int) (x * cellSize), py = offsetY + (int) (y * cellSize);
                int size = (int) Math.ceil(cellSize);

                g.setColor(mazeMatrix[y][x] ? Color.WHITE : config.wallCellColor);
                g.fillRect(px, py, size, size);

                if (animatedPath.contains(new Point(x, y))) {
                    g.setColor(config.pathColor);
                    g.fillRect(px, py, size, size);
                }
                if (config.drawGrid) {
                    g.setColor(config.gridColor);
                    g.drawRect(px, py, size, size);
                }
            }
        }
    }
}