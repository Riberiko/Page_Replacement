package simulation;

import java.util.Arrays;
import java.util.Random;

public class SimulationInput {
    private int[] referencePages;
    private AlgorithmType type;

    private int referenceStringSize;
    private final int numberOfPages;

    public SimulationInput(int referenceStringSize, int numberOfPages, AlgorithmType type)
    {
        if(type == null) throw new IllegalArgumentException("Must Provide a Valid Algorithm Type");
        this.referenceStringSize = referenceStringSize;
        this.numberOfPages = numberOfPages;
        this.type = type;
        referencePages = generateReferencePages();

    }

    public SimulationInput(int numberOfPages, String referenceString, AlgorithmType type)
    {
        this(numberOfPages,Arrays.stream(referenceString.split(",")).mapToInt(Integer::parseInt).toArray(), type);
    }

    public SimulationInput(int numberOfPages, int[] referencePages, AlgorithmType type)
    {
        if(type == null) throw new IllegalArgumentException("Must Provide a Valid Algorithm Type");
        this.type = type;
        this.numberOfPages = numberOfPages;
        this.referencePages = referencePages;
        referenceStringSize = referencePages.length;
    }

    public SimulationInput(int referenceStringSize, int numberOfPages, String referenceString, AlgorithmType type)
    {
        this(numberOfPages, referenceString, type);
        if(referencePages.length > referenceStringSize) referencePages = Arrays.copyOf(referencePages,  referenceStringSize);
        this.referenceStringSize = referencePages.length;
    }

    public int[] getReferencePages()
    {
        return referencePages;
    }

    public int getNumberOfPages()
    {
        return numberOfPages;
    }
    public int getReferenceStringSize()
    {
        return referenceStringSize;
    }
    public AlgorithmType getType() {
        return type;
    }

    private int[] generateReferencePages()
    {
        return generateReferencePages(referenceStringSize);
    }

    public static int[] generateReferencePages(int referenceStringSize)
    {
        int[] arr = new int[referenceStringSize];
        Random rand = new Random();
        for(int i = 0; i < referenceStringSize; i++) arr[i] = rand.nextInt(10);
        return arr;
    }


}
