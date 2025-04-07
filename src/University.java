import java.util.ArrayList;

public class University {

    private ArrayList<Student> students;
    public static void main(String[] args) {
        new University();
    }

    University() {
        students = new ArrayList<>();
        for (int i = 0; i < 200; i++) {
            students.add(new Student());
        }
    }
}
