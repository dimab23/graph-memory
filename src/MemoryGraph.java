import model.Graph;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author Dima B
 * @version problema1
 * @apiNote 14.05.2020
 */


public class MemoryGraph {

    public int addGraph(List<Graph> graphs) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduceti numarul de varfuri : ");
        int nrPeak = scanner.nextInt();

        System.out.print("Introduceti numarul de arce : ");
        int nrArcs = scanner.nextInt();

        for (int i = 0; i < nrArcs; i++) {
            System.out.print("Introduceti start: ");
            int start = scanner.nextInt();
            System.out.print("Introduceti destinatia: ");
            int end = scanner.nextInt();
            graphs.add(new Graph(start, end));
        }

        return nrPeak + 1;
    }


    public String createLineMatrixIncidence(Graph graph, int nrPeak) {

        return IntStream.range(1, nrPeak).map(i -> {
            if (graph.getI() == graph.getJ() && graph.getI() == i)
                return 2;

            else if (i == graph.getI())
                return -1;

            else if (i == graph.getJ())
                return 1;

            return 0;
        }).mapToObj(String::valueOf)
                .collect(Collectors.joining(" "));
    }

    public String createLineMatrixAdjacency(List<Graph> graphStream, int row, int nrPeak) {

        List<Graph> graphs = graphStream
                .stream()
                .filter(s -> s.getI() == row)
                .collect(Collectors.toList());

        return IntStream.range(1, nrPeak).map(i -> {
            if (graphs.stream().anyMatch(s -> s.getJ() == i))
                return 1;

            return 0;
        }).mapToObj(String::valueOf)
                .collect(Collectors.joining(" "));
    }

    public String createLineListAdjacency(List<Graph> graphs, int row) {
        List<Integer> list = graphs
                .stream()
                .filter(s -> s.getI() == row)
                .map(Graph::getJ)
                .collect(Collectors.toList());
        list.add(0);

        return list.stream().map(String::valueOf)
                .collect(Collectors.joining("_"));

    }
}
