package Cycle;

import Cycle.HamiltonianCycle;

import java.util.Arrays;

public class Start {
    public static void main(String[] args) {
        int[][] graph = {
                {0, 1, 0, 1, 0},
                {1, 0, 1, 1, 1},
                {0, 1, 0, 0, 1},
                {1, 1, 0, 0, 1},
                {0, 1, 1, 1, 0}
        };

        HamiltonianCycle hamiltonianCycle = new HamiltonianCycle(graph);
        int[] cycle = hamiltonianCycle.findCycle();
        if (cycle == null) {
            System.out.println("Гамильтонов цикл не найден");
        } else {
            System.out.println("Гамильтонов цикл: " + Arrays.toString(cycle));
        }

    }
}