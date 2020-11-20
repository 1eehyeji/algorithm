package programmers;

import java.util.*;

public class 파일명정렬 {
	static String[] solution(String[] files) {
		List<File> fileList = new ArrayList<>();

		int index = 0;
		for (String f : files) {
			File file = new File(f, index);
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
			System.out.println(fileList.get(i).toString());
			answer[i] = fileList.get(i).originalFileName;
		}

		return answer;
	}

	static class File{

		int MAX_NUMBER_LENGTH = 5;

		String head;
		int number;
		int index;
		String originalFileName;

		public File(String file, int index) {
			String fileToLowerCase = file.toLowerCase();
			this.head = findFileHead(fileToLowerCase);
			this.number = findFileNumber(fileToLowerCase.substring(this.head.length()));
			this.originalFileName = file;
			this.index = index;
		}

		private String findFileHead(String fileToLowerCase) {
			return fileToLowerCase.split("[0-9]")[0];
		}

		private int findFileNumber(String file) {
			StringBuilder sb = new StringBuilder();

			for (int i = 0; i < file.length(); ++i) {
				if (sb.length() == MAX_NUMBER_LENGTH) {
					break;
				}
				if (!Character.isDigit(file.charAt(i))) {
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

	public static void main(String[] args) {
		String[] files =  {
				"foo010bar020.zip","Foo010bar020.zip", "foo09bar020.zip"
		};

		System.out.println(Arrays.toString(solution(files)));
	}
}
