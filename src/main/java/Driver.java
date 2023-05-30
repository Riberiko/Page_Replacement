import simulation.AlgorithmType;
import simulation.Simulation;
import simulation.SimulationInput;
import simulation.SimulationResults;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Driver {

    public static void main(String[] args) {

        int[] referencePages;
        int[] rss = new int[]{10, 15, 20};
        int[] npf = new int[]{3, 5, 7};

        List<Simulation> simulationList = new LinkedList<>();
        List<SimulationResults> resultsList = new LinkedList<>();


        for(int i = 0; i < 3; i++)
        {
            for(int rs : rss)
            {
                referencePages = SimulationInput.generateReferencePages(rs);
                for(int np : npf)
                {
                    for(AlgorithmType type : AlgorithmType.values())
                    {
                        simulationList.add(new Simulation(new SimulationInput(np, referencePages, type)));
                        resultsList.add(simulationList.get(simulationList.size()-1).getSimulationResults());
                        simulationList.get(simulationList.size()-1).runExperiment();
                    }
                }
            }
        }

        System.out.println("All PageReplacement Configurations : " + resultsList);
        Collections.sort(resultsList);
        System.out.println("Best Performing Configurations : ");
        resultsList.stream().filter(result -> result.getRatio() == resultsList.get(resultsList.size()-1).getRatio()).forEach(result -> System.out.println(result));
    }

}
