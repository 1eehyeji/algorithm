package programmers.kakao2018;

import java.util.*;

public class 파일명정렬 {

	public String[] solution(String[] files) {
		List<File> fileList = new ArrayList<>();

		for (String f : files) {
			File file = new File(f);
			fileList.add(file);
		}

		fileList.sort((o1, o2) -> {
			if (o1.head.equals(o2.head)) {
				return o1.number - o2.number;
			}
			return o1.head.compareTo(o2.head);
		});

		String[] answer = new String[files.length];
		for (int i = 0; i < answer.length; ++i) {
			answer[i] = fileList.get(i).originalFileName;
		}

		return answer;
	}

	static class File{
		int MAX_NUMBER_LENGTH = 5;

		String head;
		int number;
		String originalFileName;

		public File(String file) {
			String fileToLowerCase = file.toLowerCase();
			this.head = findFileHead(fileToLowerCase);
			this.number = findFileNumber(fileToLowerCase.substring(this.head.length()));
			this.originalFileName = file;
		}

		private String findFileHead(String fileToLowerCase) {
			return fileToLowerCase.split("[0-9]")[0];
		}

		private int findFileNumber(String file) {
			StringBuilder sb = new StringBuilder();

			for (int i = 0; i < file.length(); ++i) {
				if (sb.length() == MAX_NUMBER_LENGTH || !Character.isDigit(file.charAt(i))) {
					break;
				}

				sb.append(file.charAt(i));
			}

			return Integer.parseInt(sb.toString());
		}

		@Override
		public String toString() {
			return this.head + " " + this.number + " " + this.originalFileName;
		}
	}
}
