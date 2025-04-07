import java.util.AbstractMap;
import java.util.HashSet;
import java.util.List;

/**
 * This is the main class where you will work in.
 */
public class Tasks {
    private University university;

    Tasks(University university) {
        this.university = university;
    }

    /**
     * Find the average GPA of all students.
     * This implementation uses a for loop.
     */
    public double example1For() {
        double sum = 0;
        for (int i = 0; i < university.getStudents().size(); i++) {
            sum += university.getStudents().get(i).getGpa();
        }
        return sum / university.getStudents().size();
    }

    /**
     * Find the average GPA of all students
     */
    public double example1Foreach() {
        double sum = 0;
        for (var student : university.getStudents()) {
            sum += student.getGpa();
        }
        return sum / university.getStudents().size();
    }

    /**
     * Find the average GPA of all students
     */
    public double example1Lambda() {
        return university.getStudents().stream().mapToDouble(s -> s.getGpa()).sum() / university.getStudents().size();
        // Alternative variant using method reference
        //   return (float) university.getStudents().stream().mapToDouble(Student::getGpa).sum();
    }


    /**
     * Give a HashSet that contains every student.
     */
    public HashSet<Student> task1() {
        return null;
    }

    /**
     * Find all students with a GPA of 3.5 or higher
     */
    public List<Student> task2() {
        return null;
    }

    /**
     * Find the student who has the lowest GPA
     */
    public Student task3() {
        return null;
    }

    /**
     * Find all courses with at least 3 graduate students (Masters and Phd).
     */
    public List<Course> task4() {
        return null;
    }

    /**
     * Count all pairs of friends that are taking a course together.
     * If two friends are taking two courses together count them twice.
     */
    public Integer task5() {
        return null;
    }

    /**
     * Count how many students there are that do not have a unique name.
     */
    public Integer task6() {
        return null;
    }

    /**
     * Count all pairs of friends that are taking a course together.
     * If two friends are taking two courses together count them twice.
     */
    public List<AbstractMap.SimpleEntry<Grade, List<Student>>> task7() {
        return null;
    }
}
