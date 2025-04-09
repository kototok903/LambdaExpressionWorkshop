import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

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

    public List<Student> example2Comp() {
        return university.getStudents().stream().sorted(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return Float.compare(o1.getGpa(), o2.getGpa());
            }
        }).toList();
    }

    public List<Student> example2() {
        return university.getStudents().stream().sorted((a, b) -> Float.compare(a.getGpa(), b.getGpa())).toList();
    }


    /**
     * Give a HashSet that contains every student.
     */
    public HashSet<Student> task1() {
        return new HashSet<>(university.getStudents());
    }

    /**
     * Find all students with a GPA of 3.5 or higher
     */
    public List<Student> task2() {
        return university.getStudents().stream().filter(s -> s.getGpa() >= 3.5).toList();
    }

    /**
     * Find the student who has the lowest GPA
     */
    public Student task3() {
        return university.getStudents().stream().reduce((a, b) -> b.getGpa() < a.getGpa() ? b : a).orElse(null);
    }

    /**
     * Find all courses with at least 3 graduate students (Masters and Phd).
     */
    public List<Course> task4() {
        return university.getCourses().stream()
                .filter(c -> c.getStudents().stream()
                        .filter(s -> s.getGrade() == Grade.Masters || s.getGrade() == Grade.Phd)
                        .count() >= 3)
                .toList();
    }

    /**
     * Count all pairs of friends that are taking a course together.
     * If two friends are taking two courses together count them twice.
     */
    public Integer task5() {
        return (int) university.getCourses().stream()
                .flatMapToInt(c -> c.getStudents().stream()
                        .flatMapToInt(s1 -> c.getStudents().stream()
                                .mapToInt(s2 -> s1.getFriends().containsKey(s2) ? 1 : 0)))
                .filter(n -> n > 0).count() / 2;
    }

    /**
     * Count how many students there are that do not have a unique name.
     */
    public Integer task6() {
        return (int) university.getStudents().stream()
                .filter(s1 -> university.getStudents().stream()
                        .filter(s2 -> s1.getName().equals(s2.getName()))
                        .count() > 1)
                .count();
    }

    /**
     * Group each student by grade and sort each group based on their GPA by increasing value.
     * Note: This is a hard one to solve.
     * Hint: Use .collect(groupingBy()) and .collect(Collectors.toMap())
     */
    public Map<Grade, List<Student>> task7() {
//        Map<Grade, List<Student>> groupMap = new HashMap<>();
//        university.getStudents().stream()
//                .sorted((s1, s2) -> Float.compare(s1.getGpa(), s2.getGpa()))
//                .forEach(s -> {
//                    groupMap.putIfAbsent(s.getGrade(), new ArrayList<>());
//                    groupMap.get(s.getGrade()).add(s);
//                });
//        return groupMap;

        // pretty cool solution
        return university.getStudents().stream()
                .sorted((s1, s2) -> Float.compare(s1.getGpa(), s2.getGpa()))
                .collect(groupingBy(Student::getGrade));
    }

    /**
     * Return all students that satisfy the given predicate.
     */
    public List<Student> task8(Predicate<Student> operation) {
        return university.getStudents().stream().filter(operation).toList();
    }
}
