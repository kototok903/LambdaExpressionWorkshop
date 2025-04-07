import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

public class TasksTests {
    static University university;
    static Tasks tasks;

    @BeforeAll
    static void setup() {
        university = new University();
        tasks = new Tasks(university);
    }

    @Test
    void task1() {
        HashSet<Student> students = tasks.task1();
        if (students == null) {
            // The user has not attempted the problem, skip it
            assumeTrue(false);
            return;
        }

        HashSet<Student> solution = new HashSet<>(university.getStudents());
        assertEquals(solution.size(), students.size());
        solution.forEach(s -> assertTrue(students.contains(s)));
    }

    @Test
    void task5() {
        List<Student> students = tasks.task5();
        if (students == null) {
            // The user has not attempted the problem, skip it
            assumeTrue(false);
            return;
        }

        HashSet<Student> studentSet = new HashSet<>(students);
        List<Student> solution = university.getStudents().stream().filter(s -> s.getGpa() >= 3.5f).toList();
        assertEquals(solution.size(), studentSet.size());
        solution.forEach(s -> assumeTrue(studentSet.contains(s)));
    }
}
