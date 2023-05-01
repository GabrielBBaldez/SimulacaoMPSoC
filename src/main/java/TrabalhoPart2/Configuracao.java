package TrabalhoPart2;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Configuracao {
    @JsonProperty("MPSOC_SIZE_X")
    private int mpSoCSizeX;
    @JsonProperty("MPSOC_SIZE_Y")
    private int mpSoCSizeY;
    @JsonProperty("CLUSTER_SIZE_Y")
    private int clusterSizeY;
    @JsonProperty("CLUSER_SIZE_Y")
    private int cluserSizeY;
    @JsonProperty("TASKS_PER_PROCESSOR")
    private int tasksPerProcessor;
    @JsonProperty("TEST")
    private List<Test> test;

    public int getMpSoCSizeX() {
        return mpSoCSizeX;
    }

    public void setMpSoCSizeX(int mpSoCSizeX) {
        this.mpSoCSizeX = mpSoCSizeX;
    }

    public int getMpSoCSizeY() {
        return mpSoCSizeY;
    }

    public void setMpSoCSizeY(int mpSoCSizeY) {
        this.mpSoCSizeY = mpSoCSizeY;
    }

    public int getClusterSizeY() {
        return clusterSizeY;
    }

    public void setClusterSizeY(int clusterSizeY) {
        this.clusterSizeY = clusterSizeY;
    }

    public int getCluserSizeY() {
        return cluserSizeY;
    }

    public void setCluserSizeY(int cluserSizeY) {
        this.cluserSizeY = cluserSizeY;
    }

    public int getTasksPerProcessor() {
        return tasksPerProcessor;
    }

    public void setTasksPerProcessor(int tasksPerProcessor) {
        this.tasksPerProcessor = tasksPerProcessor;
    }

    public List<Test> getTest() {
        return test;
    }

    public void setTest(List<Test> test) {
        this.test = test;
    }
}