import java.util.ArrayList;

public class SchoolUtils {
    private ArrayList<School> schools;

    public SchoolUtils() {
        this.schools = new ArrayList<>();
    }

    public SchoolUtils(ArrayList<School> schools) {
        this.schools = schools;
    }

    public void InitializateSchoolsFromCSV(String pathToCSV) {
        this.schools = SchoolParser.parseCSVToSchools(pathToCSV);
    }

    public ArrayList<School> getSchools() {
        return this.schools;
    }

    public void setSchools(ArrayList<School> schools) {
        this.schools = schools;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (School school: schools) {
            sb.append(school.toString() + "\n");
        }
        return sb.toString();
    }
}
