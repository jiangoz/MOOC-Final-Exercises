import java.util.*;

public class Program {
    private ArrayList<Jumper> jumperList;
    private Random random;
    private Scanner input;

    public Program(Random rand) {
        this.jumperList = new ArrayList<Jumper>();
        this.random = rand;
        this.input = new Scanner(System.in);
    }

    //starts the program
    public void start() {
        //Scanner input = new Scanner(System.in);
        System.out.println("Kumpula ski jumping week\n");
        System.out.println("Write the names of the participants one at a time; an empty string brings you to the jumping phase.");

        while (true) {
            System.out.print("  Participant name: ");
            String name = input.nextLine();
            if (name.isEmpty()) {
                System.out.println();
                System.out.println("The tournament begins!");
                System.out.println();
                this.beginTournament();
                break;
            }
            this.jumperList.add(new Jumper(name));
        }
    }

    //begins the jumping simulations and points calculations
    public void beginTournament() {
        int roundCount = 1;
        //int nameCount = 1;
        while (true) {
            System.out.print("Write \"jump\" to jump; otherwise you quit: ");
            //System.out.println();
            String cmd = this.input.nextLine();
            System.out.println();
            if (!cmd.equals("jump")) {
                System.out.println("Thanks!");
                System.out.println();
                this.printResults();
                break;
            }
            System.out.println("Round " + roundCount);
            System.out.println();
            System.out.println("Jumping order:");
            Collections.sort(this.jumperList, new SortByPoint());
            for (int i = 1; i <= this.jumperList.size(); i++) {
                //jumperList.get(i-1).jump(this.random);
                System.out.println("  " + i + ". " + jumperList.get(i - 1).nameAndPoint());
            }
            System.out.println();
            System.out.println("Results of round " + roundCount);
            //Collections.sort(this.jumperList,new SortByPoint());
            for (Jumper j : this.jumperList) {
                j.jump(this.random);
                System.out.println("  " + j.getName());
                System.out.println("    length: " + j.getJumpLength());
                System.out.println("    judge votes: " + Arrays.toString(j.getJudgePoints()));
            }
            roundCount++;
            System.out.println();
        }

    }

    public void printResults() {
        System.out.println("Tournament results:");
        System.out.println("Position    Name");
        Collections.sort(this.jumperList, new SortByPoint());
        Collections.reverse(this.jumperList);
        for (int i = 1; i <= this.jumperList.size(); i++) {
            Jumper jumper = jumperList.get(i - 1);
            System.out.println(i + "           " + jumper.getName() + " (" + jumper.getPoints() + " points)");
            System.out.println("            jump lengths: " + jumper.getLengthsMeter());
        }
    }


}
