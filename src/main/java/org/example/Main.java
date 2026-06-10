package org.example;

public class Main {
    public static void main(String[] args) {
        // הפעלת חלון המבוך באמצעות Thread עצמאי כפי שנדרש בלימודים
        new Thread(new Runnable() {
            @Override
            public void run() {
                new MazeApp();
            }
        }).start();
    }
}