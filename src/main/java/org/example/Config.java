package org.example;

import java.awt.Color;

public class Config {
    public Color wallCellColor = Color.BLACK, pathColor = Color.GREEN, gridColor = Color.LIGHT_GRAY;
    public boolean drawGrid = true;
    public int animationDelayMs = 50;

    public void parseJson(String json) {
        try {
            json = json.trim().replace("{", "").replace("}", "").replace("\"", "");
            for (String pair : json.split(",")) {
                String[] keyValue = pair.split(":");
                if (keyValue.length < 2) continue;
                String key = keyValue[0].trim(), value = keyValue[1].trim();

                switch (key) {
                    case "wallCellColor" -> this.wallCellColor = Color.decode(value);
                    case "pathColor" -> this.pathColor = Color.decode(value);
                    case "drawGrid" -> this.drawGrid = Boolean.parseBoolean(value);
                    case "gridColor" -> this.gridColor = Color.decode(value);
                    case "animationDelayMs" -> this.animationDelayMs = Integer.parseInt(value);
                }
            }
        } catch (Exception e) { e.printStackTrace(); }
    }
}