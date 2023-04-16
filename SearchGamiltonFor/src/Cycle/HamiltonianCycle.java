package Cycle;

public class HamiltonianCycle {

    private int[][] graph; // матрица смежности графа
    private int[] path; // массив для хранения пути
    private int pathLength; // длина пути

    public HamiltonianCycle(int[][] graph) {
        this.graph = graph;
        this.path = new int[graph.length];
        this.pathLength = 0;
    }

    public int[] findCycle() {
        int n = graph.length;
        int[] visited = new int[n]; // массив для хранения посещенных вершин

        // начинаем поиск с первой вершины
        visited[0] = 1;
        path[0] = 0;
        hamiltonianCycleUtil(visited, 1);

        return pathLength == n ? path : null; // если найден цикл, возвращаем путь, иначе null
    }

    private void hamiltonianCycleUtil(int[] visited, int position) {
        if (position == graph.length) { // если путь проходит через все вершины, проверяем наличие ребра между последней вершиной и первой
            if (graph[path[position - 1]][path[0]] == 1) {
                pathLength = position;
            }
            return;
        }

        for (int i = 1; i < graph.length; i++) {
            if (visited[i] == 0 && graph[path[position - 1]][i] == 1) {
                visited[i] = 1;
                path[position] = i;
                hamiltonianCycleUtil(visited, position + 1);
                visited[i] = 0;
            }
        }
    }

}



