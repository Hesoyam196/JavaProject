import org.jfree.chart.*;
import org.jfree.data.*;
import org.jfree.data.xy.XYSeries;

public class Main {
    public static void main(String[] args) {
        SchoolUtils schoolUtils = new SchoolUtils();
        schoolUtils.InitializateSchoolsFromCSV("D:\\JaJava\\FinalProject\\School.csv");
        DBHandler dbHandler = new DBHandler();
        dbHandler.createSchoolTable();

        for (School school: schoolUtils.getSchools()) {
            dbHandler.addSchool(school);
        }

        String[] countries = new String[] {"Sacramento", "Los Angeles", "San Diego", "Madera", "Orange",
                "Riverside", "Ventura", "Lake", "Nevada", "Marin"};
        double[] values = new double[countries.length];

        for (int i = 0; i < countries.length; i++) {
            values[i] = dbHandler.task1(countries[i]);
        }

        Grafic.draw(countries, values);

        System.out.println(dbHandler.task2());
        System.out.println(dbHandler.task3());
    }

}
