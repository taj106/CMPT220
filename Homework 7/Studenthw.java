import java.util.Random;


class Student {
    String name;
    String year;
    double gpa;
    int id;

    public Student(String n, String y, double g, int i) {
        name = n;
        year = y;
        gpa = g;
        id = i;
    }

    //check if student is on the honor roll
    public boolean isHonorRoll() {
        return gpa > 3.6;
    }

    //check if the student gets free lunch
    public boolean getsFreeLunch(int randomId) {
        return id == randomId;
    }
}


public class Main {
    public static void main(String[] args) {
        Student MelC = new Student("Melissa", "Senior", 3.4, 1343);
        Student KrishivD = new Student("Krishiv", "Junior", 3.8, 1872);
        Student AnnaB = new Student("Anna", "Sophomore", 3.5, 542);
        Student ChrisP = new Student("Chris", "Freshman", 3.7, 1011);
        Student JayM = new Student("Jay", "Senior", 2.9, 302);

        //array of students
        Student[] students = {MelC, KrishivD, AnnaB, ChrisP, JayM};

        
        for (Student student : students) {
            if (student.isHonorRoll()) {
                System.out.println(student.name + " is on the honor roll.");
            } else {
                System.out.println(student.name + " is not on the honor roll.");
            }
        }

        // create a random id for free lunch
        Random random = new Random();
        int randomId = random.nextInt(2000);  // random id
        System.out.println("\nRandom student ID for free lunch check: " + randomId);

        // checking if anyone gets free lunch
        for (Student student : students) {
            if (student.getsFreeLunch(randomId)) {
                System.out.println(student.name + " gets free lunch today!");
            } else {
                System.out.println(student.name + " does not get free lunch today.");
            }
        }
    }
}
