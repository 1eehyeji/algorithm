package programmers;

import java.util.LinkedList;

public class 캐시 {

	static LinkedList<String> lru;
	static int CACHE_HIT = 1;
	static int CACHE_MISS = 5;

	static int solution(int cacheSize, String[] cities) {
		if (cacheSize == 0) {
			return cities.length * CACHE_MISS;
		}

		int answer = 0;
		lru = new LinkedList<>();

		for (String s : cities) {
			String city = s.toLowerCase();
			int preIndex = findIndexCity(city);
			if (preIndex > -1) {
				answer += CACHE_HIT;
				moveIndexFirstLRU(preIndex);
				continue;
			}
			answer += CACHE_MISS;
			addElementLRU(city, cacheSize);
		}

		return answer;
	}

	private static void addElementLRU(String city, int cacheSize) {
		if (lru.size() == cacheSize) {
			lru.removeLast();
		}
		lru.addFirst(city);
	}

	private static int findIndexCity(String city) {
		for (int i = 0; i < lru.size(); ++i) {
			if (lru.get(i).equals(city)) {
				return i;
			}
		}
		return -1;
	}

	static void moveIndexFirstLRU(int preIndex) {
		String city = lru.remove(preIndex);
		lru.addFirst(city);
	}

	public static void main(String[] args) {
		int cacheSize = 0;
		String[] cities = {
				"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"
		};

		System.out.println(solution(cacheSize, cities));

	}
}
