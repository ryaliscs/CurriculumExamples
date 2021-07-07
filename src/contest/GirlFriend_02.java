package contest;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

/**
 * Task: Girlfriend
 * 
 *
 */
public class GirlFriend_02 {

	public static void main(String[] args) {
		Instant start = Instant.now();
		boolean debug = true;
		int destination_house = -1;
		int noOfRoads = -1;

		Map<Integer, List<PointWeight>> roadMap;
		try (Scanner sc = new Scanner(System.in)) {
			String input_houses_roads = sc.nextLine();
			String[] input_split = input_houses_roads.split(" ");
			destination_house = Integer.parseInt(input_split[0]);
			noOfRoads = Integer.parseInt(input_split[1]);
			roadMap = getRoadMap(sc, destination_house, noOfRoads);
			if (debug)
				System.out.println(roadMap);
		}
		Instant end = Instant.now();
		Duration timeElapsed = Duration.between(start, end);
		if (debug)
			System.out.println("Input ->" + timeElapsed.toSeconds());

		if (roadMap.isEmpty()) {
			System.out.print("NOT POSSIBLE");

		} else {
			Node root = new Node(1);
			PointWeight shortPathCost = new PointWeight();
			shortPathCost.weight = -1;
			Queue<Node> nodes = new LinkedList<Node>();
			nodes.add(root);
			while (true) {
				int size = nodes.size();
				if (0 == size) {
					break;
				}
				Node parent = nodes.remove();
				List<PointWeight> childNodes = roadMap.get(parent.nodeValue);
				for (PointWeight pw : childNodes) {
					Node node = new Node(pw.to, parent.paths, pw.weight, parent.weight);
					boolean isAdd = !node.hasNode(pw.to);
					node.addSelfToPath();
					if (isAdd) {
						if (node.nodeValue == destination_house
								&& (shortPathCost.weight > node.weight || shortPathCost.weight == -1)) {
							shortPathCost.weight = node.weight;
							isAdd = false;
						} else if (shortPathCost.weight != -1 && node.weight > shortPathCost.weight) {
							isAdd = false;
						}
						if (isAdd)
							nodes.add(node);
					}
				}
			}

			if (shortPathCost.weight < 0) {
				System.out.print("NOT POSSIBLE");
			} else {
				System.out.print(shortPathCost.weight);
			}
			if (debug)
				System.out.print(nodes);
		}
		Instant finalEnd = Instant.now();
		Duration totalTimeElapsed = Duration.between(start, finalEnd);
		if (debug)
			System.out.println("final ->" + totalTimeElapsed.toSeconds());

	}

	private static class PointWeight {
		public int to;
		public int weight;

		@Override
		public String toString() {
			return to + " (" + weight + ")";
		}
	}

	private static class Node {
		int nodeValue;
		int weight;
		List<Integer> paths = new ArrayList<>();

		public Node(int value) {
			this.nodeValue = value;
			weight = 0;
			paths.add(Integer.valueOf(value));

		}

		public Node(int nodeValue, List<Integer> aPaths, int childWeight, int parentWeight) {
			this.nodeValue = nodeValue;
			this.paths.addAll(aPaths);
			int pathCost = (childWeight - parentWeight);
			this.weight = ((pathCost < 0) ? 0 : pathCost) + parentWeight;
		}

		public boolean hasNode(int pathValue) {
			return this.paths.indexOf(Integer.valueOf(pathValue)) != -1;
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
		Map<Integer, List<PointWeight>> mapRoadMap = new HashMap<>();
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
			// if (!isFromEqualsToDestination && to.intValue() != 1)
			{
				updateRouteMap(mapRoadMap, from, to, weight); // a -> b
			}
			// if (!isToEqualsToDestination && from.intValue() != 1)
			{
				updateRouteMap(mapRoadMap, to, from, weight); // b -> a
			}
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
		List<PointWeight> values = mapRoadMap.get(from);
		if (values == null) {
			values = new ArrayList<>(10);
			mapRoadMap.put(from, values);
		}
		PointWeight pw = new PointWeight();
		pw.to = to;
		pw.weight = weight;
		values.add(pw);
	}

}