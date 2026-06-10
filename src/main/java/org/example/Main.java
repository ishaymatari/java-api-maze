package org.example;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        // הפעלת חלון המבוך בצורה בטוחה ב-Thread של ה-UI
        SwingUtilities.invokeLater(MazeApp::new);
    }
}