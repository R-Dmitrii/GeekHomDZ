package Lesson_8.database;

        import dto.Weather;
        import dto.WeatherData;

        import java.io.IOException;
        import java.sql.*;
        import java.util.ArrayList;
        import java.util.List;

        import static database.DBFields.*;
        import static database.DBRequests.*;

public class DBRepository {

    private static Connection connection;

    private static final String url = "jdbc:sqlite:";

    private static final String database = "/weather.db";

    public static void init() {
        getConnection();
        createTableIfNotExists();
    }

    public static Connection getConnection() {
        if (connection == null) {
            try {
                Class.forName("org.sqlite.JDBC");
                connection = DriverManager.getConnection(url + System.getProperty("user.dir") + database);
                return connection;
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        } else {
            return connection;
        }
        return null;
    }

    public static boolean save(WeatherData weatherData) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(saveQuery);
            int i = 1;
            preparedStatement.setString(i++, weatherData.getCity());
            preparedStatement.setString(i++, weatherData.getLocalDate());
            preparedStatement.setString(i++, weatherData.getText());
            preparedStatement.setDouble(i, weatherData.getTemperature());
            boolean res = preparedStatement.execute();
            preparedStatement.close();
            return res;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static List<WeatherData> getAllSavedData()  {
        List<WeatherData> resultList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(selectAllQuery);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                WeatherData weatherData = new WeatherData();
                weatherData.setCity(rs.getString(city));
                weatherData.setLocalDate(rs.getString(date_time));
                weatherData.setText(rs.getString(weather_text));
                weatherData.setTemperature(rs.getDouble(temperature));
                resultList.add(weatherData);
            }
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultList;
    }

    public static void close() {
        try {
            System.out.println("Закрытие соединения");
            connection.close();
            System.out.println("Соединение закрыто");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void createTableIfNotExists() {
        try  {
            connection.createStatement().execute(createTableIfNotExists);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}