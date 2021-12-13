public class School {
    private final int id;
    private int district;
    private String school;
    private String country;
    private String grades;
    private int students;
    private double teachers;
    private double calworks;
    private double lunch;
    private int computer;
    private double expenditure;
    private double income;
    private double english;
    private double read;
    private double math;

    public School(int id) {
        this.id = id;
    }

    public School(int id, int district, String school, String county, String grades, int students,
                  double teachers, double calworks, double lunch, int computer, double expenditure,
                  double income, double english, double read, double math) {
        this.id = id;
        this.district = district;
        this.school = school;
        this.country = county;
        this.grades = grades;
        this.students = students;
        this.teachers = teachers;
        this.calworks = calworks;
        this.lunch = lunch;
        this.computer = computer;
        this.expenditure = expenditure;
        this.income = income;
        this.english = english;
        this.read = read;
        this.math = math;
    }

    public int getId() {
        return this.id;
    }

    public  int getDistrict() {
        return this.district;
    }

    public String getSchool() {
        return this.school;
    }

    public String getCountry() {
        return this.country;
    }

    public  String getGrades() {
        return  this.grades;
    }

    public int getStudents() {
        return this.students;
    }

    public  double getTeachers() {
        return this.teachers;
    }

    public double getCalworks() {
        return this.calworks;
    }

    public double getLunch() {
        return this.lunch;
    }

    public int getComputer() {
        return this.computer;
    }

    public double getExpenditure() {
        return this.expenditure;
    }

    public double getIncome() {
        return this.income;
    }

    public double getEnglish() {
        return this.english;
    }

    public double getRead() {
        return this.read;
    }

    public double getMath() {
        return this.math;
    }

    public  void setDistrict(int district) {
        this.district = district;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public  void setGrades(String grades) {
        this.grades = grades;
    }

    public void setStudents(int students) {
        this.students = students;
    }

    public  void setTeachers(double teachers) {
        this.teachers = teachers;
    }

    public void setCalworks(double calworks) {
        this.calworks = calworks;
    }

    public void setLunch(double lunch) {
        this.lunch = lunch;
    }

    public void setComputer(int computer) {
        this.computer = computer;
    }

    public void setExpenditure(double expenditure) {
        this.expenditure = expenditure;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    public void setEnglish(double english) {
        this.english = english;
    }

    public void setRead(double read) {
        this.read = read;
    }

    public void setMath(double math) {
        this.math = math;
    }

    @Override
    public String toString() {
        String formatString = "id: %d\n" +
                "district: %s\n" +
                "school: %s\n" +
                "county: %s\n" +
                "grades: %s\n" +
                "students: %d\n" +
                "teachers: %f\n" +
                "calworks: %f\n" +
                "lunch: %f\n" +
                "computer: %d\n" +
                "expenditure: %f\n" +
                "income: %f\n" +
                "english: %f\n" +
                "read: %f\n" +
                "math: %f.";
        return String.format(formatString, this.id, this.district, this.school, this.country, this.grades,
                this.students, this.teachers, this.calworks, this.lunch, this.computer, this.expenditure,
                this.income, this.english, this.read, this.math);
    }
}
