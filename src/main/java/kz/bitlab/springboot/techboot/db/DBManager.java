package kz.bitlab.springboot.techboot.db;

import java.util.ArrayList;

public class DBManager {
    public static final ArrayList<Student> students = new ArrayList<>();

    static {
        students.add(new Student(1L, "Asset", "Kanshora", 100, "A"));
        students.add(new Student(2L, "Almas", "Utepov", 100, "A"));
        students.add(new Student(3L, "Alibek", "Toleubay", 100, "A"));
    }

    private static Long studentId = 4L;

    public static ArrayList<Student> getStudents() {
        return students;
    }

    public static void addStudent(Student student) {
        if (student.getExam() >= 50 && student.getExam() <= 59) {
            student.setMark("D");
        } else if (student.getExam() >= 60 && student.getExam() <= 74) {
            student.setMark("C");
        } else if (student.getExam() >= 75 && student.getExam() <= 89) {
            student.setMark("B");
        } else if (student.getExam() >= 90 && student.getExam() <= 100) {
            student.setMark("A");
        } else {
            student.setMark("F");
        }
        student.setId(studentId);
        students.add(student);
        studentId++;
    }

    public static Student getStudent(int id) {
        return students.stream().filter(music -> music.getId() == id).findFirst().orElse(null);
    }
}
