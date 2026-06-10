package org.example;

import java.awt.Point;
import java.util.*;

public class MazeSolver {
    public static List<Point> solve(boolean[][] matrix) {
        List<Point> path = new ArrayList<>();
        if (matrix == null || !matrix[0][0] || !matrix[matrix.length - 1][matrix[0].length - 1]) return path;

        int h = matrix.length, w = matrix[0].length;
        Queue<Point> q = new LinkedList<>();
        Map<Point, Point> parents = new HashMap<>();
        Set<Point> visited = new HashSet<>();

        Point start = new Point(0, 0), end = new Point(w - 1, h - 1);
        q.add(start); visited.add(start);

        boolean found = false;
        int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};

        while (!q.isEmpty()) {
            Point curr = q.poll();
            if (curr.equals(end)) { found = true; break; }

            for (int i = 0; i < 4; i++) {
                int nx = curr.x + dx[i], ny = curr.y + dy[i];
                Point next = new Point(nx, ny);
                if (nx >= 0 && nx < w && ny >= 0 && ny < h && matrix[ny][nx] && !visited.contains(next)) {
                    visited.add(next); parents.put(next, curr); q.add(next);
                }
            }
        }
        if (found) {
            for (Point c = end; c != null; c = parents.get(c)) path.add(0, c);
        }
        return path;
    }
}