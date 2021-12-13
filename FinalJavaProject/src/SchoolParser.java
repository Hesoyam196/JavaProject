import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class SchoolParser {

    public static ArrayList<School> parseCSVToSchools(String path) {
        if (path.isEmpty() || path == null) {
            throw new IllegalArgumentException("Path is null or empty!");
        }

        ArrayList<School> schools = new ArrayList<>();
        List<String> lines = null;
        try {
            lines = Files.readAllLines(Paths.get(path));
        } catch (IOException e) {
            e.printStackTrace();
        }

        lines.remove(0);
        for (String line: lines) {
            schools.add(parseSchoolLine(line));
        }
        return schools;
    }

    private static School parseSchoolLine(String schoolLine) {
        String[] lineData = schoolLine.split(",");
        for (int i = 0; i < 5; i++) {
            lineData[i] = lineData[i].replaceAll("[\"]", "");
        }
        return new School(Integer.parseInt(lineData[0]), Integer.parseInt(lineData[1]), lineData[2], lineData[3],
                lineData[4], Integer.parseInt(lineData[5]), Double.parseDouble(lineData[6]),
                Double.parseDouble(lineData[7]), Double.parseDouble(lineData[8]), Integer.parseInt(lineData[9]),
                Double.parseDouble(lineData[7]), Double.parseDouble(lineData[7]), Double.parseDouble(lineData[7]),
                Double.parseDouble(lineData[7]), Double.parseDouble(lineData[7]));
    }
}
