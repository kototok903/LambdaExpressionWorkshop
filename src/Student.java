import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

public class Student {
    private String name;
    private float gpa;
    private Grade grade;
    // Hashset of friendships along with the value of the friendship from 0 to 100
    private HashMap<Student, Integer> friends;
    private HashSet<Course> courses;

    final static String[] namesList = new String[]{"Johnnie Hoga", "Bert Pearso", "Sonny Aceved", "Edmundo Stevenso", "Lesley Tapi", "Michael Jenkin", "Samuel Schmid", "Hipolito Robert", "Vanessa Potte", "Wes Peterso", "Arron May", "Brenton Spence", "Abe Vazque", "Ricky Duart", "Fritz Mannin", "Ezekiel Kir", "Rudolf Tyle", "Antoinette Camero", "Candace Winter", "Louella Rui", "Buford Ponc", "Hilario Boye", "Micheal Erickso", "Sasha Cardena", "Gregg Kin", "Helen Bernar", "Guy Hendrick", "Genaro Loga", "Kerry Holme", "Saul Russ", "Allison Aria", "Elsie Mosle", "Alberta Comb", "Winford Vele", "Cody Berr", "Maurice Flower", "Cindy Owen", "Julian Huyn", "Jamel Sha", "Stewart Castr", "Brian Nelso", "Sergio Aguirr", "Juana Dun", "Tyson Butle", "Leslie Gonzale", "Katie La", "Milton Buc", "Cedric Ferguso", "Ines Edward", "Elton Y"};

    public Student() {
        Random random = new Random();
        name = namesList[random.nextInt(namesList.length)];
        gpa = random.nextFloat(0, 4);
        grade = Grade.values()[random.nextInt(6)];
        friends = new HashMap<>();
        courses = new HashSet<>();
    }

    public void makeFriend(Student newFriend, Integer friendshipLevel) {
        if (friends.containsKey(newFriend)) return;
        if (this == newFriend) return;
        friends.put(newFriend, friendshipLevel);
    }

    public void enrollInCourse(Course course) {
        if (courses.contains(course)) return;
        courses.add(course);
    }

    public String getName() {
        return name;
    }

    public float getGpa() {
        return gpa;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public HashMap<Student, Integer> getFriends() {
        return friends;
    }
}

