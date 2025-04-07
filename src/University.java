import java.util.ArrayList;
import java.util.Random;
import java.util.stream.IntStream;

public class University {
    private ArrayList<Student> students;
    private ArrayList<Course> courses;

    public static void main(String[] args) {
        University university = new University();
    }

    University() {
        var random = new Random();
        students = new ArrayList<>();
        courses = new ArrayList<>();

        // Generate students
        for (int i = 0; i < random.nextInt(150, 200); i++) {
            students.add(new Student());
        }

        // Generate courses
        for (int i = 0; i < Course.maxCourseNum(); i++) {
            courses.add(new Course(i));
        }

        // --Create friendships---

        // Regular double for loop
        for (Student student : students) {
            for (int i = 0; i < random.nextInt(0, 5); i++) {
                student.makeFriend(students.get(random.nextInt(0, students.size())), random.nextInt(0, 100));
            }
        }

        // One line of code using lambda expressions
        students.forEach(s -> IntStream.range(0, random.nextInt(0, 5))
                .forEach(a -> s.makeFriend(students.get(random.nextInt(0, students.size())), random.nextInt(0, 100))));

        // -- Enroll Students--
        students.forEach(s -> IntStream.range(0, random.nextInt(3,7))
                .forEach(a -> courses.get(random.nextInt(0, courses.size())).enrollStudent(s)));
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }
}
