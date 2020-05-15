import model.Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * @author Dima B
 * @version problema1
 * @apiNote 14.05.2020
 */


public class Application {
    public static void main(String[] args) {

        int nrPeak = 0;
        List<Graph> graphList = new ArrayList<>();

        MemoryGraph memoryGraph = new MemoryGraph();
        while (true) {

            Scanner scanner = new Scanner(System.in);
            System.out.println("\n\n\nAlegeti comanda");
            System.out.println("1 - Adauga un graph");
            System.out.println("2 - Afiseaza matricea de incidenta");
            System.out.println("3 - Afiseaza matricea de adiacenta");
            System.out.println("4 - Afiseaza lista de adiacenta");
            int command = scanner.nextInt();

            switch (command) {
                case 1:
                    nrPeak = memoryGraph.addGraph(graphList);
                    break;

                case 2:
                    if (graphList.isEmpty()) {
                        System.out.println("Nu exista nici u  graph");
                        return;
                    }

                    int finalNrPeak = nrPeak;
                    graphList.forEach((v) -> System.out.println(memoryGraph.createLineMatrixIncidence(v, finalNrPeak)));
                    break;

                case 3:
                    if (graphList.isEmpty()) {
                        System.out.println("Nu exista nici u  graph");
                        return;
                    }

                    int finalNrPeak1 = nrPeak;
                    IntStream.range(1, nrPeak).forEach((i) -> System.out.println(memoryGraph.createLineMatrixAdjacency(graphList, i, finalNrPeak1)));
                    break;

                case 4:
                    if (graphList.isEmpty()) {
                        System.out.println("Nu exista nici u  graph");
                        return;
                    }
                    IntStream.range(1, nrPeak).forEach((i) -> System.out.println(i + "|" + memoryGraph.createLineListAdjacency(graphList, i)));
                    break;

                default:
                    System.exit(0);
            }

        }
    }
}
