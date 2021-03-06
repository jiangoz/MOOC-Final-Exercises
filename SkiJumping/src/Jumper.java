import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

//represents a Jumper
public class Jumper {
    private int jumpLength;
    private ArrayList<Integer> jumpLengthsList;
    private String name;
    private int[] judgePoints;
    private int totalPoints;

    public Jumper(String name) {
        this.jumpLength = 0;
        this.jumpLengthsList = new ArrayList<Integer>();
        this.name = name;
        this.judgePoints = new int[5];
        this.totalPoints = 0;
    }

    //jump points are calculated based on jump length and judge points
    public void jump(Random rand) {
        this.jumpLength = rand.nextInt(60) + 60;
        this.jumpLengthsList.add(jumpLength);
        for (int i = 0; i < judgePoints.length; i++) {
            judgePoints[i] = rand.nextInt(10) + 10;
        }
        Arrays.sort(judgePoints);
        int pointsFromJudge = judgePoints[1] + judgePoints[2] + judgePoints[3];

        this.totalPoints += pointsFromJudge + this.jumpLength;
    }

    public int getPoints() {
        return this.totalPoints;
    }

    //returns the Name (X points) --- STILL NEED the numbering infront
    public String nameAndPoint() {
        return this.name + " (" + this.totalPoints + " points)";
    }

    public String getName() {
        return this.name;
    }

    public int getJumpLength() {
        return this.jumpLength;
    }

    public int[] getJudgePoints() {
        return this.judgePoints;
    }

    //string output of jump lengths in meters
    public String getLengthsMeter() {
        String output = "";
        for (int i : this.jumpLengthsList) {
            output += i + " m, ";
        }
        return output.substring(0, (output.length() - 2));
    }

}
