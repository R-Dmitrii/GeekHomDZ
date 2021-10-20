package Lesson_8.database;

public class DBRequests {
    public static final String saveQuery = "INSERT INTO weather (city, date_time, weather_text, temperature) VALUES (?,?,?,?)";

    public static final String selectAllQuery = "SELECT * FROM weather";

    public static final String createTableIfNotExists = "CREATE TABLE IF NOT EXISTS weather (\n" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
            "city TEXT NOT NULL,\n" +
            "date_time TEXT NOT NULL,\n" +
            "weather_text TEXT NOT NULL,\n" +
            "temperature REAL NOT NULL\n" +
            ");";
}