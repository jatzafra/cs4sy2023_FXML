package exercise13truthzafrajulian;

import java.util.ArrayList;

public class Subject {
    private String name, imgFileName;
    private double units, grade;
    private static ArrayList<Subject> subjectList = new ArrayList<>();
	
    public Subject(String n, String i, double u, double g){
        name = n;
        imgFileName = i;
        units = u;
        grade = g;
        subjectList.add(this);
    }
    public String getName() {
        return name;
    }
    public String getImgFileName(){
        return imgFileName;
    }
    public double getUnits() {
        return units;
    }
    public void setUnits(double units) {
        units = units;
    }
    public double getGrade() {
        return grade;
    }
    public void setGrade(double grade) {
        grade = grade;
    }
    public static ArrayList<Subject> getSubjectList(){
        return subjectList;
    }
    
}
