package programmers;

import java.util.*;

public class 방금그곡 {
	static String solution(String m, String[] musicinfos) {
		Map<String, String> sharpNotes = new HashMap<>();
		sharpNotes.put("C#", "c");
		sharpNotes.put("D#", "d");
		sharpNotes.put("F#", "f");
		sharpNotes.put("G#", "g");
		sharpNotes.put("A#", "a");

		String convertedM = convertSharpNote(m, sharpNotes);
		List<MusicInfo> matchedMusics = new ArrayList<>();

		for (String info : musicinfos) {
			String[] infoToken = info.split(",");
			MusicInfo musicInfo = new MusicInfo(infoToken[0].split(":"), infoToken[1].split(":"),
					infoToken[2], convertSharpNote(infoToken[3], sharpNotes));

			if (musicInfo.playedNotes.contains(convertedM)) {
				matchedMusics.add(musicInfo);
			}
		}

		if (matchedMusics.size() > 1) {
			Collections.sort(matchedMusics);
		}

		return matchedMusics.size() == 0 ? "(None)" : matchedMusics.get(0).title;
	}

	// C#, D#, F#, G#, A# -> c, d, f, g, a
	static String convertSharpNote(String m, Map<String, String> sharpNotes) {
		for (String note : sharpNotes.keySet()) {
			m = m.replaceAll(note, sharpNotes.get(note));
		}

		return m;
	}

	static class MusicInfo implements Comparable<MusicInfo> {
		String title;
		int playTime;
		String playedNotes;

		public MusicInfo(String[] startTimeToken, String[] endTimeToken, String title, String notes) {
			this.title = title;
			this.playTime = calculatePlayTime(startTimeToken, endTimeToken);
			this.playedNotes = createPlayedNotes(notes, this.playTime);
		}

		private String createPlayedNotes(String notes, int playTime) {
			if (playTime < notes.length()) {
				return notes.substring(0, playTime + 1);
			}

			StringBuilder sb = new StringBuilder(notes);

			int q = playTime / notes.length();
			int r = playTime % notes.length();

			for (int i = 0; i < q; ++i) {
				sb.append(notes);
			}

			return sb.append(notes, 0, r + 1).toString();
		}

		private int calculatePlayTime(String[] startTimeToken, String[] endTimeToken) {
			int hour = Integer.parseInt(endTimeToken[0]) - Integer.parseInt(startTimeToken[0]);
			int minute = Integer.parseInt(endTimeToken[1]) - Integer.parseInt(startTimeToken[1]);

			return (hour * 60) + minute;
		}

		@Override
		public int compareTo(MusicInfo other) {
			return other.playTime - this.playTime;
		}
	}

	public static void main(String[] args) {
		String m = "CC#BCC#BCC#BCC#B";

		String[] musicinfos = {
				"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"
		};

		System.out.println(solution(m, musicinfos));
	}
}
