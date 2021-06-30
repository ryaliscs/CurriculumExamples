package contest;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 
 * Problem Statement
Jazzy and Cricket Balls
Jazzy is good with bowling but is not good with studies. His mom wants him to focus on studies too and for this she has found an interesting way. She has brought N packets of balls which may or may not have the same number of balls in them. The balls in a packet are arranged in a linear manner and Jazzy wants to play with the balls.

She will give the balls to Jazzy only if he can tell the maximum number of moves required in which he can get to play with all the balls. There are few conditions though:

In one move, Jazzy can divide the number of balls in the packet into an equal number of groups only. 
Example: Suppose there are 6 balls in the packet.
Jazzy can divide this packet in 3 ways.

1. Two groups of 3 balls each. (3, 3)
2. Three groups of 2 balls each (2, 2, 2)
3. Six groups of 1 ball each.

Note: Dividing a single group into multiple groups of equal number is considered one move only.

Jazzy can get to play with the balls when they are present as a single unit only and not in any group of size greater than 1. Also, getting to play with a ball is considered a move.

Example: In a group there are 2 balls, then Jazzy cannot play with them until he further divides them into single-single units.

 The length of all the packets/groups should always be an integer.

Example:

Number of Packets, N = 1
Number of balls in packet = 6

Jazzy only cares about playing with the balls and needs your help in finding the maximum number of moves. Can you help him?


Input Format
The first line of input consists of the number of packets, N.
The second line of input consists of N space-separated integers representing the number of balls in the packet (length of the packet), Ni

Constraints
1<= N <=100
1<= Ni <=10^12 (1e12)

Output Format
Print the required number of maximum moves to get to play with the balls.

Sample TestCase 1
Input
2
6 1
Output
11
Explanation

For 6 numbers of balls in a packet, 10 moves are required as explained above.

For 1 ball, only 1 move is required.


Total number of moves = 10 + 1 = 11


 *
 */

public class CandidateCode {

	public static void main(String[] args) {
		int total_packets = -1;
		String input_balls_per_packet;
		try (Scanner sc = new Scanner(System.in)) {
			total_packets = sc.nextInt();
			sc.nextLine();
			input_balls_per_packet = sc.nextLine();
		}
		calculateTotalMoves(total_packets, input_balls_per_packet);

	}

	/**
	 * Calculate total moves
	 * 
	 * @param total_packets          total packets to process
	 * @param input_balls_per_packet array of balls per packet
	 */
	private static void calculateTotalMoves(int total_packets, String input_balls_per_packet) {
		String[] balls_per_packet = input_balls_per_packet.split(" ");
		long total_moves = 0;
		for (int i = 0; i < total_packets; i++) {
			Long ball_qty = Long.valueOf(balls_per_packet[i]);
			if (ball_qty == 1) {
				total_moves += 1;
				continue;
			}
			List<Long> primeFactors = primeFactors(ball_qty);
			System.out.println("Factorys:" + primeFactors);
			total_moves += getCurrentMove(primeFactors);
		}
		System.out.println(total_moves);
	}

	private static long getCurrentMove(List<Long> primeFactors) {
		long current_pack_move = 1; // default move
		int move = 1;
		for (int j = primeFactors.size(); j > 0; j--) {
			current_pack_move += getMoveCount(primeFactors, move++);
		}
		System.out.println("Pack : " + current_pack_move);
		return current_pack_move;
	}

	private static long getMoveCount(List<Long> primeFactors, int move) {
		int size = primeFactors.size() - 1;
		long result = 1;
		for (int i = 0; i < move; i++, size--) {
			result *= primeFactors.get(size);
		}
		return result;
	}

	// A function to print all prime factors
	// of a given number n
	public static List<Long> primeFactors(long n) {
		List<Long> primeFactors = new ArrayList<Long>(10);
		if (n == 1) {
			primeFactors.add(Long.valueOf(1));
		}
		// Print the number of 2s that divide n
		while (n % 2 == 0) {
			// System.out.print(2 + " ");
			primeFactors.add(Long.valueOf(2));
			n /= 2;
		}

		// n must be odd at this point. So we can
		// skip one element (Note i = i +2)
		for (long i = 3; i <= Math.sqrt(n); i += 2) {
			// While i divides n, print i and divide n
			while (n % i == 0) {
				// System.out.print(i + " ");
				primeFactors.add(i);
				n /= i;
			}
		}

		// This condition is to handle the case whien
		// n is a prime number greater than 2
		if (n > 2) {
			// System.out.print(n);
			primeFactors.add(n);
		}

		return primeFactors;
	}

}