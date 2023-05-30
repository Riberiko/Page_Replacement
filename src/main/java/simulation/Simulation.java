package simulation;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Simulation{

    private SimulationResults results;
    private SimulationInput input;
    private ArrayDeque<Integer> lst;

    public Simulation(SimulationInput input)
    {
        this.input = input;
        lst = new ArrayDeque<>();
        results = new SimulationResults(input);
    }

    public SimulationResults getSimulationResults()
    {
        return results;
    }

    public void runExperiment()
    {

        int[] values = input.getReferencePages();
        HashMap<Integer, Integer> future = new HashMap<>();

        boolean found;

        for(int i = 0; i < values.length; i++)
        {
            found = lst.contains(values[i]);
            if(found) results.incrementPageHits();
            else results.incrementPageFaults();

            if(lst.size() < input.getNumberOfPages())
            {
                switch (input.getType())
                {
                    case LRU -> {
                        if(found) lst.remove(getIndexOf(lst, values[i]));
                        lst.addFirst(values[i]);
                    }
                    default -> {
                        if(found) continue;
                        lst.addFirst(values[i]);
                    }
                }
            }
            //Replacement is Needed
            else
            {
                switch (input.getType())
                {
                    case OPT -> {
                        if(found) continue;
                        future.clear();
                        lst.stream().forEach(val -> future.put(val, 0));
                        lst.clear();
                        for(int j = i+1; j < values.length; j++) if(future.containsKey(values[j])) future.put(values[j], future.get(values[j])+1);
                        Integer min = getLeastOccurrences(future);
                        future.entrySet().removeIf(pair -> (pair.getKey() == min || pair.getValue() == 0));
                        future.entrySet().forEach(pair -> lst.addFirst(pair.getKey()));
                        lst.addFirst(values[i]);
                    }
                    case FIFO -> {
                        if(found) continue;
                        lst.removeLast();
                        lst.addFirst(values[i]);
                    }
                    case LRU -> {
                        if(found)
                        {
                            lst.remove(lst.size()-getIndexOf(lst, values[i]));
                            lst.addFirst(values[i]);
                        }else
                        {
                            lst.removeLast();
                            lst.addFirst(values[i]);
                        }
                    }
                }
            }
        }

    }

    private int getIndexOf(ArrayDeque<Integer> deque, int value)
    {
        int i = 0;

        for(int temp : deque)
        {
            if(temp == value) return i;
            i++;
        }

        return -1;
    }

    private int getLeastOccurrences(HashMap<Integer, Integer> map)
    {
        int low = Integer.MAX_VALUE;
        int val = -1;

        for(Map.Entry<Integer, Integer> pair:  map.entrySet())
        {
            if(pair.getValue() < low)
            {
                low = pair.getValue();
                val = pair.getKey();
            }
        }
        return val;
    }
}
