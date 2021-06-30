package contest;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CandidateCode {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int total_packets = sc.nextInt();
			sc.nextLine();
			String input_balls_per_packet = sc.nextLine();
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