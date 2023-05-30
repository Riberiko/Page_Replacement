import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import simulation.AlgorithmType;
import simulation.Simulation;
import simulation.SimulationInput;

public class PageReplacementTest {
    private static String[] refStr = new String[]{"7,0,1,2,0,3,0,4,2,3,0,3,2,1,2,0,1,7,0,1", "8,1,0,7,3,0,3,4,5,3,5,2,0,6,8,4,8,1,5,3", "4,6,4,8,6,3,6,0,5,9,2,1,0,4,6,3,0,6,8,4"};

    @Test
    void index0FIFOTest()
    {
        Simulation sim = new Simulation(new SimulationInput(3, refStr[0], AlgorithmType.FIFO));
        sim.runExperiment();
        Assertions.assertEquals(15, sim.getSimulationResults().getPageFaults());
        Assertions.assertEquals(5, sim.getSimulationResults().getPageHits());
    }

    @Test
    void index1FIFOTest()
    {
        Simulation sim = new Simulation(new SimulationInput(3, refStr[1], AlgorithmType.FIFO));
        sim.runExperiment();
        Assertions.assertEquals(15, sim.getSimulationResults().getPageFaults());
        Assertions.assertEquals(5, sim.getSimulationResults().getPageHits());
    }

    @Test
    void index2FIFOTest()
    {
        Simulation sim = new Simulation(new SimulationInput(3, refStr[2], AlgorithmType.FIFO));
        sim.runExperiment();
        Assertions.assertEquals(16, sim.getSimulationResults().getPageFaults());
        Assertions.assertEquals(4, sim.getSimulationResults().getPageHits());
    }

    @Test
    void index0LRUTest()
    {
        Simulation sim = new Simulation(new SimulationInput(3, refStr[0], AlgorithmType.LRU));
        sim.runExperiment();
        Assertions.assertEquals(14, sim.getSimulationResults().getPageFaults());
        Assertions.assertEquals(6, sim.getSimulationResults().getPageHits());
    }

    @Test
    void index1LRUTest()
    {
        Simulation sim = new Simulation(new SimulationInput(3, refStr[1], AlgorithmType.LRU));
        sim.runExperiment();
        Assertions.assertEquals(15, sim.getSimulationResults().getPageFaults());
        Assertions.assertEquals(5, sim.getSimulationResults().getPageHits());
    }

    @Test
    void index2LRUTest()
    {
        Simulation sim = new Simulation(new SimulationInput(3, refStr[2], AlgorithmType.LRU));
        sim.runExperiment();
        Assertions.assertEquals(14, sim.getSimulationResults().getPageFaults());
        Assertions.assertEquals(6, sim.getSimulationResults().getPageHits());
    }

    @Test
    void index0OPTTest()
    {
        Simulation sim = new Simulation(new SimulationInput(3, refStr[0], AlgorithmType.OPT));
        sim.runExperiment();
        Assertions.assertEquals(9, sim.getSimulationResults().getPageFaults());
        Assertions.assertEquals(11, sim.getSimulationResults().getPageHits());
    }

    @Test
    void index1OPTTest()
    {
        Simulation sim = new Simulation(new SimulationInput(3, refStr[1], AlgorithmType.OPT));
        sim.runExperiment();
        Assertions.assertEquals(13, sim.getSimulationResults().getPageFaults());
        Assertions.assertEquals(7, sim.getSimulationResults().getPageHits());
    }

    @Test
    void index2OPTTest()
    {
        Simulation sim = new Simulation(new SimulationInput(3, refStr[2], AlgorithmType.OPT));
        sim.runExperiment();
        Assertions.assertEquals(13, sim.getSimulationResults().getPageFaults());
        Assertions.assertEquals(7, sim.getSimulationResults().getPageHits());
    }
}
