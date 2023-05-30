package simulation;

import java.lang.reflect.Array;
import java.util.Arrays;

public class SimulationResults implements Comparable<SimulationResults>{
    private int pageHits;
    private int pageFaults;
    private final AlgorithmType type;
    private final int rss;
    private final int npf;
    private final int[] referencePage;

    public SimulationResults(SimulationInput input)
    {
        pageHits = 0;
        pageFaults = 0;
        type = input.getType();
        referencePage = input.getReferencePages();
        rss = input.getReferenceStringSize();
        npf = input.getNumberOfPages();
    }

    public void incrementPageHits()
    {
        pageHits++;
    }
    public int getPageHits()
    {
        return pageHits;
    }

    public void incrementPageFaults()
    {
        pageFaults++;
    }
    public int getPageFaults()
    {
        return pageFaults;
    }

    public double getRatio()
    {
        return pageHits/(double) pageFaults;
    }

    public String toString()
    {
        String str = "\nReference String : " + Arrays.toString(referencePage);
        str += String.format("\nAlgorithm Type : %s, RSS : %d, NPF : %d", type, rss, npf);
        str += "\n\tHits : " + pageHits;
        str += "\n\tFaults : " + pageFaults;
        str += "\n\tRatio : " + getRatio();
        return str;
    }

    @Override
    public int compareTo(SimulationResults o) {
        return Double.compare(getRatio(), o.getRatio());
    }
}
