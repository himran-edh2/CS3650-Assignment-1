import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class iVoteSimulation implements VotingInterface {
    Random rand = new Random();
    private int[] student;
    private int numberOfStudents;
    private int aAnswer;
    private int bAnswer;
    private int cAnswer;
    private int dAnswer;
    private int numberOfAnswers;
    private boolean questionType;
    private char c;
    private boolean reTry;
    Map<Integer, List<Character>> studentInfo = new HashMap<> ();

    public iVoteSimulation() {
        
    }

    @Override
    public void setNumberOfParticipants() {
        numberOfStudents = rand.nextInt(21) + 10;
        student = (int[])new int[numberOfStudents];
    }

    @Override
    public void setTypeOfQuestion() {
        questionType = rand.nextBoolean();
        if (questionType == true) {
            System.out.println("Multiple Choice Question (Multiple Choices Allowed)");
        }
        else {
            System.out.println("Single Choice Question (Single Choice Allowed)");
        }
    }

    @Override
    public void setID() {
        for (int x = 0; x < student.length; x++) {
            int id = rand.nextInt(99999999) + 900000000;
            student[x] = id;
            studentInfo.put(id, null);
        }
    }

    @Override
    public void getNumberOfParticipants() {
        System.out.println("Number of Participants: " + numberOfStudents);
    }

    @Override
    public void getChoices() {
        if (questionType == true) {
            for (int x = 0; x < numberOfStudents; x++) {
                numberOfAnswers = rand.nextInt(4) + 1;
                for (int y = 0; y < numberOfAnswers; y++) {
                    do {
                    c = (char)(rand.nextInt(4) + 'A');
                    studentInfo.put(student[x], Arrays.asList(c));
                    reTry = rand.nextBoolean();
                } while (reTry == true);
                }
                if (studentInfo.containsValue(Arrays.asList('A'))) {
                    aAnswer++;
                }
                if (studentInfo.containsValue(Arrays.asList('B'))) {
                    bAnswer++;
                }
                if (studentInfo.containsValue(Arrays.asList('C'))) {
                    cAnswer++;
                }
                if (studentInfo.containsValue(Arrays.asList('D'))) {
                    dAnswer++;
                }
            }
        }
        else {
            for (int x = 0; x < numberOfStudents; x++) {
                do {
                    c = (char)(rand.nextInt(4) + 'A');
                    studentInfo.put(student[x], Arrays.asList(c));
                    reTry = rand.nextBoolean();
                } while (reTry == true);
                if (studentInfo.containsValue(Arrays.asList('A'))) {
                    aAnswer++;
                }
                if (studentInfo.containsValue(Arrays.asList('B'))) {
                    bAnswer++;
                }
                if (studentInfo.containsValue(Arrays.asList('C'))) {
                    cAnswer++;
                }
                if (studentInfo.containsValue(Arrays.asList('D'))) {
                    dAnswer++;
                }
            }
        }
    }

    @Override
    public void getID() {
        for (int x = 0; x < numberOfStudents; x++) {
                System.out.println(student[x]);
        }
    }

    @Override
    public void results() {
        System.out.println("IDs         Answer(s)");
        for(Map.Entry<Integer, List<Character>> entry : studentInfo.entrySet() ){
            System.out.println( entry.getKey() + " = " + entry.getValue() );
        }
        System.out.println("Number of A's: " + aAnswer);
        System.out.println("Number of B's: " + bAnswer);
        System.out.println("Number of C's: " + cAnswer);
        System.out.println("Number of D's: " + dAnswer);
    }

}
