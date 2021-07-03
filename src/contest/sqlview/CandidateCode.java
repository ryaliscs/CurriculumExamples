package contest.sqlview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Task: Girlfriend
 * 
 *
 */
public class CandidateCode {

	public static void main(String[] args) {
		Integer destination_house = -1;
		int noOfRoads = -1;

		Map<Integer, List<PointWeight>> roadMap;
		try (Scanner sc = new Scanner(System.in)) {
			String input_houses_roads = sc.nextLine();
			String[] input_split = input_houses_roads.split(" ");
			destination_house = Integer.valueOf(input_split[0]);
			noOfRoads = Integer.parseInt(input_split[1]);
			roadMap = getRoadMap(sc, destination_house, noOfRoads);
			System.out.println(roadMap);
		}

		if (roadMap.isEmpty()) {
			System.out.println("NOT POSSIBLE");

		} else {
			Node root = new Node(Integer.valueOf(1));
			PointWeight shortPathCost = new PointWeight();
			shortPathCost.weight = Integer.MAX_VALUE;
			findPath(roadMap, root, destination_house, shortPathCost);
			if (shortPathCost.weight < 0) {
				System.out.println(0);
			}
			System.out.println(shortPathCost.weight);
			System.out.print(root);

		}
	}

	private static void findPath(Map<Integer, List<PointWeight>> roadMap, Node node, Integer destinationHouse,
			PointWeight shortPathCost) {
		List<PointWeight> pws = roadMap.get(node.nodeValue);
		if (pws != null) {
			for (PointWeight pw : pws) {
				if (node.hasPath(pw.to) || node.hasPath(destinationHouse)) {
					continue;
				}
				int pathCost = (pw.weight - node.weight) + node.weight;
				Node child = node.addChild(pw.to, pathCost);
				if (pw.to == destinationHouse) {
					if (shortPathCost.weight > child.weight) {
						shortPathCost.weight = child.weight;
					}
				}
				findPath(roadMap, child, destinationHouse, shortPathCost);
			}
		}
	}

	private static class PointWeight {
		public Integer to;
		public int weight;

		@Override
		public String toString() {
			return to + " (" + weight + ")";
		}
	}

	private static class Node {
		Integer nodeValue;
		int weight;
		String path;
		List<Node> childs;

		public Node(Integer value) {
			this.nodeValue = value;
			weight = 0;
			path = value + "";

		}

		public Node addChild(Integer value, int weight) {
			if (childs == null) {
				childs = new ArrayList<>(10);
			}
			Node node = new Node(value);
			node.weight = weight;
			node.path = this.path + "->" + value;
			this.childs.add(node);
			return node;
		}

		public boolean hasPath(Integer pathValue) {
			return this.path.indexOf(pathValue.toString()) != -1;
		}

		@Override
		public String toString() {
			String result = nodeValue + " (" + weight + ") (" + path + ")\n";
			if (this.childs != null) {
				result += "[";
				for (Node child : childs) {
					result += child;
				}
				result += "]";
			}

			return result;
		}
	}

	private static Map<Integer, List<PointWeight>> getRoadMap(Scanner sc, Integer destinationHouse, int noOfRoads) {
		Map<Integer, List<PointWeight>> mapRoadMap = new HashMap<>();
		boolean hasStopHouse = false;
		boolean hasStartHouse = false;
		for (int i = 0; i < noOfRoads; i++) {
			String input_path_weight = sc.nextLine();
			String[] input_split = input_path_weight.split(" ");
			Integer from = Integer.valueOf(input_split[0]);
			Integer to = Integer.valueOf(input_split[1]);
			int weight = Integer.valueOf(input_split[2]).intValue();

			if (from.intValue() == destinationHouse.intValue() || //
					to.intValue() == destinationHouse.intValue()) {
				hasStopHouse = true;
			}

			if (from.intValue() == 1 || to.intValue() == 1) {
				hasStartHouse = true;
			}

			// bi-directional add both sides
			updateRouteMap(mapRoadMap, from, to, weight); // a -> b
			updateRouteMap(mapRoadMap, to, from, weight); // b -> a
		}

		if (!hasStopHouse || !hasStartHouse) {
			return Collections.emptyMap();
		}
		return mapRoadMap;
	}

	private static void updateRouteMap(Map<Integer, List<PointWeight>> mapRoadMap, Integer from, Integer to,
			int weight) {
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
