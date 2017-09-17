package indeed;

/**
 * Project Name : Company Algorithm Solution
 * Package Name : indeed
 * File Name : FindMeanAveragefromDataStream
 * Creator : Edward
 * Date : Sep, 2017
 * Description : TODO
 */
public class FindMeanAveragefromDataStream {

    private int sum = 0;
    private int count = 0;

    public FindMeanAveragefromDataStream() {

    }

    public void addNum(int num) {
        sum += num;
        count++;
    }

    public double findMean() {
        return sum / count;
    }
}
