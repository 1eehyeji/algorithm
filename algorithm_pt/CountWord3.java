package algorithm_pt;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class CountWord3 {

	public static WordInfo find(String word, ArrayList<WordInfo> list) {
		int start = 0;
		int end = list.size() - 1;
		
		while(start <= end) {
			int middle = (start + end) / 2;
			if(list.get(middle).word.compareTo(word) == 0) {
				return list.get(middle);
			}else if(list.get(middle).word.compareTo(word) > 0) {
				end = middle - 1;
			}else if(list.get(middle).word.compareTo(word) < 0){
				start = middle + 1;
			}
		}
		
		return null;
	}

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		String filePath = "c:/shakespeare.txt";
		Scanner scanner = new Scanner(Paths.get(filePath));
		scanner.useDelimiter("[^a-zA-Z]+");
		
		CompareWord c = new CompareWord();
		ArrayList<WordInfo> list = new ArrayList<>();
		int total = 0;

		while(scanner.hasNext("[a-zA-Z]+")) {
			String s = scanner.next().toLowerCase();
			//System.out.println(s);
			WordInfo word = find(s,list);
			if(word != null) ++word.count;
			else {
				++total;
				list.add(new WordInfo(s));
				Collections.sort(list, c);
			}
		}

		//for(int i = 0; i < list.size(); ++i) {
		//	System.out.println(list.get(i).word + " " +list.get(i).count );
		//}

		CompareCount c2 = new CompareCount();
		Collections.sort(list, c2);

		System.out.println("총 단어 개수: " + total);
		for(int i = 0; i < 10; ++i) {
			System.out.println(list.get(i).word + " " + list.get(i).count);
		}
	}
}

class CompareWord implements Comparator<WordInfo>{
	@Override
	public int compare(WordInfo o1, WordInfo o2) {
		return o1.word.compareTo(o2.word);
	}
}
