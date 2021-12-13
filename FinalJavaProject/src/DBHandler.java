import org.sqlite.JDBC;
import java.sql.*;

public class DBHandler {
    private static final String address = "jdbc:sqlite:D:\\JaJava\\FinalProject\\schools.db";
    private Connection connection;

    public DBHandler() {
        try {
            DriverManager.registerDriver(new JDBC());
            this.connection = DriverManager.getConnection(address);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createSchoolTable() {
        Statement statement = null;
        try {
             statement = this.connection.createStatement();
             var a = statement.executeUpdate("CREATE TABLE schools (\n" +
                     "id INT PRIMARY KEY," +
                     "district INT NOT NULL," +
                     "school TEXT NOT NULL," +
                     "country TEXT NOT NULL," +
                     "grades TEXT NOT NULL," +
                     "students INT NOT NULL," +
                     "teachers REAL NOT NULL," +
                     "calworks REAL NOT NULL," +
                     "lunch REAL NOT NULL," +
                     "computer INT NOT NULL," +
                     "expenditure REAL NOT NULL," +
                     "income REAL NOT NULL," +
                     "english REAL NOT NULL," +
                     "read REAL NOT NULL," +
                     "math REAL NOT NULL);");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addSchool(School school) {
        PreparedStatement statement = null;
        try {
            statement = this.connection.prepareStatement("INSERT INTO schools('id', 'district', 'school'," +
                    "'country', 'grades', 'students', 'teachers', 'calworks', 'lunch', 'computer', 'expenditure'," +
                    "'income', 'english', 'read', 'math') VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");
            statement.setObject(1, school.getId());
            statement.setObject(2, school.getDistrict());
            statement.setObject(3, school.getSchool());
            statement.setObject(4, school.getCountry());
            statement.setObject(5, school.getGrades());
            statement.setObject(6, school.getStudents());
            statement.setObject(7, school.getTeachers());
            statement.setObject(8, school.getCalworks());
            statement.setObject(9, school.getLunch());
            statement.setObject(10, school.getComputer());
            statement.setObject(11, school.getExpenditure());
            statement.setObject(12, school.getIncome());
            statement.setObject(13, school.getEnglish());
            statement.setObject(14, school.getRead());
            statement.setObject(15, school.getMath());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public double task1(String country) {
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            statement = this.connection.createStatement();
            resultSet = statement.executeQuery("SELECT avg(students) FROM schools " +
                    "WHERE country = '" + country + "';");
            return resultSet.getDouble(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public double task2() {
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            statement = this.connection.createStatement();
            resultSet = statement.executeQuery("SELECT avg(expenditure) FROM schools " +
                    "WHERE country IN ('El Dorado', 'Contra Costa', 'Fresno', 'Glenn') " +
                    "and expenditure > 10;");
            return resultSet.getDouble(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public String task3() {
        Statement statement = null;
        try {
            statement = this.connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT school FROM schools " +
                    "WHERE math = (SELECT MAX(math) FROM schools " +
                    "WHERE (students > 5000 and students < 7500) or (students > 10000 and students < 11000));");
            return resultSet.getString(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
