package programmers;

import java.util.*;

public class 베스트앨범 {
	static int[] solution(String[] genres, int[] plays) {
		List<Integer> bestAlbum = new ArrayList<>();

		Map<String, List<Song>> songMap = new HashMap<>();

		for (int i = 0; i < genres.length; ++i) {
			List<Song> list = songMap.getOrDefault(genres[i], new ArrayList<>());
			list.add(new Song(i, plays[i]));

			songMap.put(genres[i], list);
		}

		Map<Integer, String> totalPlays = new TreeMap<>(Collections.reverseOrder());

		for (String str : songMap.keySet()) {
			int totalPlay = 0;
			for (Song s : songMap.get(str)) {
				totalPlay += s.play;
			}

			totalPlays.put(totalPlay, str);
		}

		for (String s : totalPlays.values()) {
			List<Song> list = songMap.get(s);
			list.sort(Collections.reverseOrder());

			int count = list.size() < 2 ? 1 : 2;

			for (int i = 0; i < count; ++i) {
				bestAlbum.add(list.get(i).index);
			}
		}

		return bestAlbum.stream().mapToInt(i -> i).toArray();
	}
	public static void main(String[] args) {
		String[] genres = {"classic", "pop", "classic", "classic", "pop"};
		int[] plays = {500, 600, 150, 800, 2500};

		System.out.println(Arrays.toString(solution(genres, plays)));
	}
}

class Song implements Comparable{

	int index;

	int play;

	public Song (int index, int play) {
		this.index = index;
		this.play = play;
	}

	@Override
	public int compareTo(Object o) {
		Song s = (Song) o;

		return this.play - s.play;
	}
}
