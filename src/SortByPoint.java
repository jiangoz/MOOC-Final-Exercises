import java.util.Comparator;

//sort Jumper object by points
public class SortByPoint implements Comparator<Jumper> {

    @Override
    public int compare(Jumper jumper, Jumper t1) {
        return jumper.getPoints() - t1.getPoints();
    }
}
