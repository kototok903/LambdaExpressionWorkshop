import java.util.HashSet;

public class Course {
    private String number;
    private String name;
    private static final String[][] courseList = new String[][]{{"1010","Orientation"},{"1030","Computer Literacy and Applications"},{"1040","Brief Introduction to Computer Programming for Non-Majors"},{"1050A", "Short Course in Computer Programming: Perl"},{"1050B", "Short Course in Computer Programming: MATLAB"},{"1060","Introduction to Web Programming"},{"1070","Windows Application Programming"},{"1130","Introduction to Spreadsheets and Databases"},{"1270","Introduction to Computer Programming"},{"1920","Explorations in Computing Research I"},{"2030","Careers in Computer Science"},{"2070","Fundamentals of Computer Programming"},{"2270","Object-oriented Programming"},{"2280","Introduction to Data Structures"},{"2300","Discrete Computational Structures"},{"2520","Linux Operating System Essentials"},{"2900","Independent Study"},{"2900H", "Independent Study: Honors"},{"2950","Programming-Based Problem Solving Practices"},{"3090","Software Development Practices"},{"3110","Introduction to the Design and Analysis of Algorithms"},{"3190","Construction of User Interfaces"},{"3210","Introduction to Computer Architecture and Machine-Level Programming"},{"3260","C for Programmers"},{"3270","Advanced Programming Techniques"},{"3310","Theory of Computing"},{"3360","Introduction to Computer Graphics"},{"3420","Principles of Programming Languages"},{"3500","Number Theory"},{"3520","Introduction to Operating Systems"},{"3620","Object-Oriented Analysis and Design"},{"3630","Introduction to Database Management Systems"},{"3980","Cooperative Education"},{"3990X", "Special Topics"},{"4010","Bioinformatics of Sequences"},{"4020A", "Computer Science Senior Project: Multimedia and Computer Gaming I"},{"4020B", "Computer Science Senior Project: Multimedia and Computer Gaming II"},{"4020C", "Computer Science Senior Project: Project in Computer Science"},{"4060","Bioinformatics of OMICS"},{"4070","Applied Formal Methods"},{"4090","Software Requirements Engineering"},{"4100","Distributed Development of Software"},{"4120","Formal Methods in Software Engineering"},{"4130","Program Analysis"},{"4140","Gerontechnology in Smart Home Environments"},{"4150","Software System Safety"},{"4170","Software Testing"},{"4180","Introduction to Computational Geometry"},{"4190X", "Trustworthy Healthcare Software"},{"4210","Logic for Mathematics and Computer Science"},{"4240","Introduction to High Performance Computing"},{"4250","High Performance Computing for Scientific and Engineering Applications"},{"4260","Introduction to Parallel Algorithms and Programming"},{"4300","Concurrent Programming in Practice"},{"4330","Molecular Programming of Nanoscale Devices and Processes"},{"4340","Quantum Information and Complexity"},{"4350","Algorithms for Large Data Sets: Theory and Practice"},{"4370","Computer Game and Media Programming"},{"4400","Principles and Practice of Compiling"},{"4410","Programming Languages"},{"4530","Privacy Preserving Algorithms and Data Security"},{"4540","Distributed Systems"},{"4550","Simulation: Algorithms and Implementation"},{"4590X", "Security and Privacy in Cloud Computing"},{"4610","Principles and Internals of Database Systems"},{"4630X", "Healthcare Data Privacy, Security and Confidentiality: Principles and Algorithms"},{"4640X", "AI for Healthcare"},{"4720","Principles of Artificial Intelligence"},{"4740","Introduction to Machine Learning"},{"4760","Motion Planning for Robotics and Autonomous Systems"},{"4770","Foundations of Robotics and Computer Vision"},{"4810","Numerical Methods for Differential Equations"},{"4870","Introduction to Network Programming and Cloud Computing"},{"4880","Computer Networks"},{"4900","Independent Study"},{"4900H", "Independent Study: Honors"},{"4990X", "Special Topics"},{"5010X", "Computational Methods I"},{"5020X", "Algorithmic Foundations I"},{"5021X", "Algorithmic Foundations II"},{"5040X", "Computational Methods II"},{"5070","Applied Formal Methods"},{"5090","Software Requirements Engineering"},{"5100","Distributed Development of Software"},{"5110","Design and Analysis of Algorithms"},{"5120","Formal Methods in Software Engineering"},{"5130","Program Analysis"},{"5140","Gerontechnology in Smart Home Environments"},{"5150","Software System Safety"},{"5160","Artificial Intelligence in Software Engineering"},{"5180","Introduction to Computational Geometry"},{"5190X", "Trustworthy Healthcare Software"},{"5250","Numerical Analysis of High Performance Computing"},{"5260","Introduction to Parallel Algorithms and Programming"},{"5270","High-Performance Deep Learning"},{"5310","Theory of Computation"},{"5330","Molecular Programming of Nanoscale Devices and Processes"},{"5340","Quantum Information and Complexity"},{"5350","Algorithms for Large Data Sets: Theory and Practice"},{"5400","Principles and Practice of Compiling"},{"5410","Programming Languages"},{"5440","Fundamentals of Bioinformatics"},{"5510","Genomic Data Science"},{"5520","Principles of Operating Systems"},{"5530X", "Privacy Preserving Algorithms and Data Security"},{"5540","Distributed Systems"},{"5550","Simulation: Algorithms and Implementation"},{"5570","Computer Graphics and Geometric Modeling"},{"5590","Security and Privacy in Cloud Computing"},{"5600","Data-Driven Security and Privacy"},{"5610","Database Design, Management, and Research"}};
    private HashSet<Student> students;

    Course(int index) {
        number = courseList[index][0];
        name = courseList[index][1];
        students = new HashSet<>();
    }

    public void enrollStudent(Student student) {
        if (students.contains(student)) return;
        students.add(student);
        student.enrollInCourse(this);
    }
    
    public static int maxCourseNum() {
        return courseList.length;
    }

    public String getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public HashSet<Student> getStudents() {
        return students;
    }

}
