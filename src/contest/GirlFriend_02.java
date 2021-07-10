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

	public static void main(String[] args) {
		boolean debug = true;
		Instant start = Instant.now();
		int destination_house = -1;
		int noOfRoads = -1;

		Map<Integer, List<PointWeight>> roadMap;
		try (Scanner sc = new Scanner(System.in)) {
			String input_houses_roads = sc.nextLine();
			String[] input_split = input_houses_roads.split(" ");
			destination_house = Integer.parseInt(input_split[0]);
			noOfRoads = Integer.parseInt(input_split[1]);
			roadMap = getRoadMap(sc, destination_house, noOfRoads);
//			if (debug)
//				System.out.println(roadMap);
		}
		if (debug) {
			Instant end = Instant.now();
			Duration timeElapsed = Duration.between(start, end);
			System.out.println("Input ->" + timeElapsed.toSeconds() + " sec");
			start = Instant.now();
		}

		findShortestPathCost(destination_house, roadMap);

		if (debug) {
			Instant finalEnd = Instant.now();
			Duration totalTimeElapsed = Duration.between(start, finalEnd);
			System.out.println("\nfinal ->" + totalTimeElapsed.toSeconds() + " sec");
			System.out.println("\nfinal ->" + totalTimeElapsed.toMillis() + " milli");
		}

	}

	private static void findShortestPathCost(int destination_house, Map<Integer, List<PointWeight>> roadMap) {
		if (roadMap.isEmpty()) {
			System.out.print("NOT POSSIBLE");

		} else {
			Node root = new Node(1);

			int counter = 0;

			int shortPathCost = -1;
			LinkedList<Node> nodes = new LinkedList<Node>();
			nodes.add(root);
			boolean isShortestPathFound = false;

			Map<Integer, Integer> nodeWeights = new HashMap<Integer, Integer>(roadMap.size());

			while (true) {
				int size = nodes.size();
				if (0 == size) {
					break;
				}
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

				List<PointWeight> childNodes = roadMap.get(parent.nodeValue);
				for (PointWeight pw : childNodes) {
					Node node = new Node(pw.to, parent.paths, pw.weight, parent.weight);
					if (!isValidNodeWeight(nodeWeights, node)) {
						continue;
					}
					boolean isAdd = node.nodeValue > parent.nodeValue || !node.hasNode();
					node.addSelfToPath();
					if (isAdd) {
						if (node.nodeValue == destination_house
								&& (shortPathCost == -1 || shortPathCost > node.weight)) {
							shortPathCost = node.weight;
							isShortestPathFound = true;
							isAdd = false;
						} else if (shortPathCost != -1 && node.weight >= shortPathCost) {
							isAdd = false;
						}
						if (isAdd) {
							nodes.add(node);
						}
					}
				}
				counter++;

//				System.out.println(nodes);
//				System.out.println("Shortest Path cost:" + shortPathCost);
//				System.out.println("No. of iterations:" + counter);
			}

			System.out.println("No. of iterations:" + counter);

			if (!isShortestPathFound) {
				System.out.print("NOT POSSIBLE");
			} else if (shortPathCost < 0) {
				System.out.print("0");
			} else {
				System.out.print(shortPathCost);
			}
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

	private static class PointWeight implements Comparable<PointWeight> {
		public int to;
		public int weight;

		@Override
		public String toString() {
			return to + " (" + weight + ")";
		}

		@Override
		public int compareTo(PointWeight aPW) {
			return aPW.weight - weight;
		}
	}

	private static class Node {
		int nodeValue;
		int weight;
		List<Integer> paths;

		public Node(int value) {
			this.nodeValue = value;
			weight = 0;
			paths = new ArrayList<>(1);
			paths.add(Integer.valueOf(value));

		}

		public Node(int nodeValue, List<Integer> aPaths, int childWeight, int parentWeight) {
			this.nodeValue = nodeValue;
			this.paths = new ArrayList<Integer>(aPaths);
			int pathCost = (childWeight - parentWeight);
			this.weight = ((pathCost < 0) ? 0 : pathCost) + parentWeight;
		}

		public boolean hasNode() {
			return this.paths.indexOf(Integer.valueOf(this.nodeValue)) != -1;
		}

		public void addSelfToPath() {
			this.paths.add(Integer.valueOf(this.nodeValue));
		}

		@Override
		public boolean equals(Object obj) {
			Node o = (Node) obj;
			return o.nodeValue == nodeValue;
		}

		@Override
		public String toString() {
			String result = nodeValue + " (" + weight + ") (" + paths + ")\n";

			return result;
		}
	}

	private static Map<Integer, List<PointWeight>> getRoadMap(Scanner sc, int destinationHouse, int noOfRoads) {
		Map<Integer, List<PointWeight>> mapRoadMap = new HashMap<>(destinationHouse);
		boolean hasStopHouse = false;
		boolean hasStartHouse = false;
		for (int i = 0; i < noOfRoads; i++) {
			String input_path_weight = sc.nextLine();
			String[] input_split = input_path_weight.split(" ");
			int from = Integer.parseInt(input_split[0]);
			int to = Integer.parseInt(input_split[1]);
			int weight = Integer.parseInt(input_split[2]);

			boolean isFromEqualsToDestination = from == destinationHouse;
			boolean isToEqualsToDestination = to == destinationHouse;
			if (isFromEqualsToDestination || isToEqualsToDestination) {
				hasStopHouse = true;
			}

			if (from == 1 || to == 1) {
				hasStartHouse = true;
			}

			// bi-directional add both sides
			updateRouteMap(mapRoadMap, from, to, weight); // a -> b
			updateRouteMap(mapRoadMap, to, from, weight); // b -> a
		}

		if (!hasStopHouse && !hasStartHouse) {
			return Collections.emptyMap();
		}

		if (mapRoadMap.get(destinationHouse) == null || //
				mapRoadMap.get(Integer.valueOf(1)) == null) {
			return Collections.emptyMap();
		}
		return mapRoadMap;
	}

	private static void updateRouteMap(Map<Integer, List<PointWeight>> mapRoadMap, int from, int to, int weight) {
		Integer intFrom = Integer.valueOf(from);
		List<PointWeight> values = mapRoadMap.get(intFrom);
		if (values == null) {
			values = new ArrayList<>(500);
			mapRoadMap.put(intFrom, values);
		}
		PointWeight pw = new PointWeight();
		pw.to = to;
		pw.weight = weight;
		values.add(pw);
	}
}