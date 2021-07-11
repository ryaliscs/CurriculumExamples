package contest;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

/**
 * GraphParsing
 *
 */
public class GraphParsing {

	private static final String START = "1";
	private static String END = "5";
	private static int RESULT = -1;
	static Map<String, Integer> WEIGHTS;
	private static boolean DEBUG = true;

	public static void main(String[] args) {
		int noOfRoads = -1;

		try (Scanner sc = new Scanner(System.in)) {
			String input_houses_roads = sc.nextLine();
			String[] input_split = input_houses_roads.split(" ");
			END = input_split[0];
			noOfRoads = Integer.parseInt(input_split[1]);
			getRoadMapInput(sc, noOfRoads);
		}

		if (RESULT == -1) {
			System.out.print("NOT POSSIBLE");
		} else {
			System.out.print(RESULT);
		}

	}

	private static void getRoadMapInput(Scanner sc, int noOfRoads) {
		WEIGHTS = new HashMap<>(noOfRoads);
		Graph graph = new Graph();
		for (int i = 0; i < noOfRoads; i++) {
			String input_path_weight = sc.nextLine();
			String[] input_split = input_path_weight.split(" ");
			String from = input_split[0];
			String to = input_split[1];
			Integer weight = Integer.valueOf(input_split[2]);

			graph.addEdge(from, to);
			WEIGHTS.put(from + "-" + to, weight);
		}

		LinkedList<String> visited = new LinkedList<String>();
		visited.add(START);
		depthFirst(graph, visited);
		if (DEBUG)
			System.out.println(WEIGHTS);
	}

	private static void depthFirst(Graph graph, LinkedList<String> visited) {
		LinkedList<String> nodes = graph.adjacentNodes(visited.getLast());
		// examine adjacent nodes
		for (String node : nodes) {
			if (visited.contains(node)) {
				continue;
			}
			if (node.equals(END)) {
				visited.add(node);
				printPath(visited);
				visited.removeLast();
				break;
			}
		}
		for (String node : nodes) {
			if (visited.contains(node) || node.equals(END)) {
				continue;
			}
			visited.addLast(node);
			depthFirst(graph, visited);
			visited.removeLast();
		}
	}

	private static void printPath(LinkedList<String> visited) {
		int weight = 0;
		int prevWeight = 0;
		for (int i = 1; i < visited.size(); i++) {
			String key = visited.get(i - 1) + "-" + visited.get(i);
			int currentWeight = WEIGHTS.get(key);
			int newCalcuatedWeight = currentWeight - prevWeight;
			newCalcuatedWeight = newCalcuatedWeight < 0 ? 0 : newCalcuatedWeight;
			weight += newCalcuatedWeight;
			prevWeight = currentWeight;
		}
		if (weight < RESULT || RESULT == -1) {
			RESULT = weight;
		}
		if (DEBUG) {
			for (String node : visited) {
				System.out.print(node);
				System.out.print(" ");
			}
			System.out.print(" - " + weight);
			System.out.println();
		}
	}

	public static class Graph {
		private Map<String, LinkedHashSet<String>> map = new HashMap<String, LinkedHashSet<String>>();

		public void addEdge(String node1, String node2) {
			LinkedHashSet<String> adjacent = map.get(node1);
			if (adjacent == null) {
				adjacent = new LinkedHashSet<String>();
				map.put(node1, adjacent);
			}
			adjacent.add(node2);
		}

		public LinkedList<String> adjacentNodes(String last) {
			LinkedHashSet<String> adjacent = map.get(last);
			if (adjacent == null) {
				return new LinkedList<String>();
			}
			return new LinkedList<String>(adjacent);
		}
	}

}
