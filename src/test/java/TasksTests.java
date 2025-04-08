import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

/**
 * Here are the solutions to each of the tasks.
 * The tasks return null by default so we skip every test where the task returns a null value.
 */
public class TasksTests {
    static University university;
    static Tasks tasks;

    @BeforeAll
    static void setup() {
        university = new University();
        tasks = new Tasks(university);
    }

    @Test
    void example1For() {
        assertEquals((float) university.getStudents().stream().mapToDouble(Student::getGpa).sum()
                / university.getStudents().size(), tasks.example1For(), 0.00001);
    }

    @Test
    void example1Foreach() {
        assertEquals((float) university.getStudents().stream().mapToDouble(Student::getGpa).sum()
                / university.getStudents().size(), tasks.example1Foreach(), 0.00001);
    }

    @Test
    void example1Lambda() {
        assertEquals((float) university.getStudents().stream().mapToDouble(Student::getGpa).sum()
                / university.getStudents().size(), tasks.example1Lambda(), 0.00001);
    }

    @Test
    void example2Comp() {
        List<Student> students = university.getStudents();
        students.sort((a, b) -> Float.compare(a.getGpa(), b.getGpa()));
        assertEquals(students, tasks.example2Comp());
    }

    @Test
    void example2() {
        List<Student> students = university.getStudents();
        students.sort((a, b) -> Float.compare(a.getGpa(), b.getGpa()));
        assertEquals(students, tasks.example2());
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

        var solution = university.getStudents().stream().min(Comparator.comparingDouble(Student::getGpa)).get();
        if (student != solution) {
            // There could be two students with the exact same gpa. We should account for floating point precision as well.
            assertTrue(student.getGpa() <= solution.getGpa() + 0.0000001);
        }
    }

    @Test
    void task4() {
        var courses = tasks.task4();
        if (courses == null) {
            // The user has not attempted the problem, skip it
            assumeTrue(false);
            return;
        }

        var coursesSet = new HashSet<Course>(courses);
        var solution = university.getCourses().stream().filter(c ->
                c.getStudents().stream().filter(s ->
                                s.getGrade() == Grade.Masters || s.getGrade() == Grade.Phd)
                        .count() >= 3).toList();
        assertEquals(solution.size(), courses.size());
        solution.forEach(s -> assertTrue(coursesSet.contains(s)));
    }

    @Test
    void task5() {
        var count = tasks.task5();
        if (count == null) {
            // The user has not attempted the problem, skip it
            assumeTrue(false);
            return;
        }

        // There are many different ways you can solve this one
        var solution = university.getCourses().stream().mapToInt(c ->
                c.getStudents().stream().mapToInt(s ->
                        // Count all friends each student has in this class and divide it by 2
                        (int) c.getStudents().stream().filter(f -> (s.getFriends().containsKey(f)))
                                .count()).sum()).sum() / 2;
        assertEquals(solution, count);
    }

    @Test
    void task6() {
        var count = tasks.task6();
        if (count == null) {
            // The user has not attempted the problem, skip it
            assumeTrue(false);
            return;
        }

        // There are many different ways you can solve this one
        var studentSet = new HashSet<>(university.getStudents().stream().map(Student::getName).toList());
        var solution = (int) university.getStudents().stream().map(Student::getName).filter(studentSet::contains).count();
        assertEquals(solution, count);
    }

    @Test
    void task7() {
        var studentsGroupedByGrade = tasks.task7();
        if (studentsGroupedByGrade == null) {
            // The user has not attempted the problem, skip it
            assumeTrue(false);
            return;
        }

        // This one is quite complex, there is probably a better solution
        var solution = university.getStudents().stream().collect(groupingBy(Student::getGrade)).entrySet().stream().toList()
                .stream().collect(Collectors.toMap(Map.Entry::getKey,
                        e -> e.getValue().stream().sorted((a, b) -> Float.compare(a.getGpa(), b.getGpa())).toList()));
        assertEquals(solution.size(), studentsGroupedByGrade.size());
        assertTrue(solution.entrySet().stream().allMatch(s -> studentsGroupedByGrade.containsKey(s.getKey())));
        solution.forEach((key, value) -> assertEquals(value, studentsGroupedByGrade.get(key)));
    }

    @Test
    void task8() {
        Predicate<Student> operation = (s) -> s.getName().toLowerCase().charAt(0) == 'S' && s.getFriends().size() > 2;
        var studentsListList = tasks.task8(operation);
        if (studentsListList == null) {
            // The user has not attempted the problem, skip it
            assumeTrue(false);
            return;
        }

        var studentSet = new HashSet<>(studentsListList);
        List<Student> solution = university.getStudents().stream().filter(operation).toList();
        assertEquals(solution.size(), studentSet.size());
        assertTrue(studentSet.containsAll(solution));

    }
}
