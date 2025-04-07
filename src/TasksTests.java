import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
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
        var students = tasks.task1();
        if (students == null) {
            // The user has not attempted the problem, skip it
            assumeTrue(false);
            return;
        }

        var solution = new HashSet<>(university.getStudents());
        assertEquals(solution.size(), students.size());
        solution.forEach(s -> assertTrue(students.contains(s)));
    }

    @Test
    void task2() {
        var students = tasks.task2();
        if (students == null) {
            // The user has not attempted the problem, skip it
            assumeTrue(false);
            return;
        }

        var studentSet = new HashSet<>(students);
        var solution = university.getStudents().stream().filter(s -> s.getGpa() >= 3.5f).toList();
        assertEquals(solution.size(), studentSet.size());
        solution.forEach(s -> assumeTrue(studentSet.contains(s)));
    }


    @Test
    void task3() {
        var student = tasks.task3();
        if (student == null) {
            // The user has not attempted the problem, skip it
            assumeTrue(false);
            return;
        }

        Student solution = university.getStudents().stream().min(Comparator.comparingDouble(Student::getGpa)).get();
        if (student != solution) {
            // There could be two students with the exact same gpa
            assertTrue(student.getGpa() <= solution.getGpa());
        }

    }
}
