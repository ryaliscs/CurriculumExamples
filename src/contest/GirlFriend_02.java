package contest;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Task: Girlfriend
 * 
 *
 */
public class GirlFriend_02 {

	private static int DEBUG_LEVEL = 0; // {-1, 0, 1} '-1' for no logging; '0' for time calculation; '1' for all nodes
										// and path traversing

	public static void main(String[] args) {
		Instant start = Instant.now();
		int destination_house = -1;
		int noOfRoads = -1;

		Map<Integer, List<Node>> roadMap;

		try (Scanner sc = new Scanner(System.in)) {
			String input_houses_roads = sc.nextLine();
			String[] input_split = input_houses_roads.split(" ");
			destination_house = Integer.parseInt(input_split[0]);
			noOfRoads = Integer.parseInt(input_split[1]);
			roadMap = getRoadMap(sc, destination_house, noOfRoads);

			if (DEBUG_LEVEL > 0)
				System.out.println(roadMap);
		}

		endProcessedTimeLog(start);
		start = Instant.now();

		findShortestPathCost(destination_house, roadMap);

		endProcessedTimeLog(start);
	}

	private static void endProcessedTimeLog(Instant start) {
		if (DEBUG_LEVEL >= 0) {
			Instant finalEnd = Instant.now();
			Duration totalTimeElapsed = Duration.between(start, finalEnd);
			System.out.println("\nprocessed in -> " + totalTimeElapsed.toSeconds() + " sec");
			System.out.println("processed in -> " + totalTimeElapsed.toMillis() + " milli");
		}
	}

	private static void findShortestPathCost(int destination_house, Map<Integer, List<Node>> roadMap) {
		if (roadMap.isEmpty()) {
			System.out.print("NOT POSSIBLE");
			return;
		}

		int counter = 0;
		int shortPathCost = -1;
		LinkedList<Node> nodes = new LinkedList<Node>();
		nodes.add(new Node(1));
		boolean isShortestPathFound = false;

		Map<Integer, Integer> nodeWeights = new HashMap<Integer, Integer>(roadMap.size());

		while (!nodes.isEmpty()) {
			Node parent = nodes.remove();

			if (isShortestPathFound && parent.weight >= shortPathCost) {
				continue;
			}

			Integer currentNodeWeight = nodeWeights.get(parent.nodeValue);
			if (currentNodeWeight != null) {
				if (parent.weight > currentNodeWeight.intValue()) {
					continue;
				}
			}

			List<Node> childNodes = roadMap.get(parent.nodeValue);
			for (Node child : childNodes) {
				Node childNode = new Node(child.nodeValue, child.weight, parent.weight);
				if (!isValidNodeWeight(nodeWeights, childNode)) {
					continue;
				}
				// check the weight of the child node if it is valid to get added to the list
				boolean isAdd = true;
				if (childNode.nodeValue == destination_house
						&& (!isShortestPathFound || childNode.weight < shortPathCost)) {
					shortPathCost = childNode.weight;
					isShortestPathFound = true;
					isAdd = false;
				} else if (isShortestPathFound && childNode.weight >= shortPathCost) {
					isAdd = false;
				}
				if (isAdd) {
					nodes.add(childNode);
				}
			}
			counter++;
			if (DEBUG_LEVEL > 0) {
				System.out.println(nodes);
				System.out.println("Shortest Path cost:" + shortPathCost);
				System.out.println();
			}
		}

		if (DEBUG_LEVEL >= 0) {
			System.out.println("\nNo. of iterations:" + counter);
			System.out.println();
		}

		if (!isShortestPathFound) {
			System.out.print("NOT POSSIBLE");
		} else {
			System.out.print(shortPathCost);
		}
	}

	private static boolean isValidNodeWeight(Map<Integer, Integer> nodeWeights, Node node) {
		Integer weight = nodeWeights.get(Integer.valueOf(node.nodeValue));
		if (weight == null) {
			nodeWeights.put(Integer.valueOf(node.nodeValue), Integer.valueOf(node.weight));
			return true;
		} else if (weight.intValue() > node.weight) {
			nodeWeights.put(Integer.valueOf(node.nodeValue), Integer.valueOf(node.weight));
			return true;
		} else if (weight.intValue() == node.weight) {
			return false;
		}
		return false;

	}

	private static class Node {
		int nodeValue;
		int weight;

		public Node(int value) {
			this.nodeValue = value;
			weight = 0;
		}

		public Node(int nodeValue, int childWeight, int parentWeight) {
			this.nodeValue = nodeValue;
			int pathCost = (childWeight - parentWeight);
			this.weight = ((pathCost < 0) ? 0 : pathCost) + parentWeight;
		}

		@Override
		public boolean equals(Object obj) {
			Node o = (Node) obj;
			return o.nodeValue == nodeValue;
		}

		@Override
		public String toString() {
			String result = nodeValue + " (" + weight + ")";

			return result;
		}
	}

	private static Map<Integer, List<Node>> getRoadMap(Scanner sc, int destinationHouse, int noOfRoads) {
		Map<Integer, List<Node>> mapRoadMap = new HashMap<>(destinationHouse);
		boolean hasStopHouse = false;
		boolean hasStartHouse = false;

		for (int i = 0; i < noOfRoads; i++) {

			String input_path_weight = sc.nextLine();
			String[] input_split = input_path_weight.split(" ");

			int from = Integer.parseInt(input_split[0]);
			int to = Integer.parseInt(input_split[1]);
			int weight = Integer.parseInt(input_split[2]);

			if ((from == destinationHouse) || (to == destinationHouse)) {
				hasStopHouse = true;
			}

			if (from == 1 || to == 1) {
				hasStartHouse = true;
			}

			// bi-directional add both sides
			updateRouteMap(mapRoadMap, from, to, weight); // a -> b
			updateRouteMap(mapRoadMap, to, from, weight); // b -> a
		}

		// if there no start or stop node then there is no path from start to stop
		if (!hasStopHouse && !hasStartHouse) {
			return Collections.emptyMap();
		}

		// if there are no children for the start or stop node then there is no path
		// from start to stop
		if (mapRoadMap.get(destinationHouse) == null || //
				mapRoadMap.get(Integer.valueOf(1)) == null) {
			return Collections.emptyMap();
		}
		return mapRoadMap;
	}

	/**
	 * updateRouteMap: updates the parent as key and children as values
	 * 
	 * @param mapRoadMap
	 * @param from       path starting point
	 * @param to         path end point
	 * @param weight     cost to travel the path
	 */
	private static void updateRouteMap(Map<Integer, List<Node>> mapRoadMap, int from, int to, int weight) {
		Integer intFrom = Integer.valueOf(from);
		List<Node> values = mapRoadMap.get(intFrom);
		if (values == null) {
			values = new ArrayList<>(500);
			mapRoadMap.put(intFrom, values);
		}
		Node node = new Node(to);
		node.weight = weight;
		values.add(node);
	}
}