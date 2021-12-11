package me.hqj.algorithms.graph;

import org.junit.Assert;
import org.junit.Test;

public class GraphTest {

    @Test
    public void graphTest() {

        Integer[][] matrix = {
                {null,1,1,1},
                {1,null,1,1},
                {1,1,null,1},
                {1,1,1,null}
        };

        String[] nodes = new String[] {"V1", "V2", "V3", "V4"};

        AdjMatrixGraph<String, Integer> matrixGraph = new AdjMatrixGraph<>(nodes, matrix);

        AdjListGraph<String, Integer> listGraph = new AdjListGraph<String, Integer>(matrixGraph);

        listGraph.dfs();

        Assert.assertEquals(0,0);
    }
}
