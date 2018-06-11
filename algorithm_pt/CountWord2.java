package algorithm_pt;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class CountWord2 {
	
	public static WordInfo find(String word, ArrayList<WordInfo> list) {
		for(int i = 0 ; i < list.size(); ++i) {
			if(list.get(i).word.equals(word)) 
				return list.get(i);
		}
		return null;
	}
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		String filePath = "c:/shakespeare.txt";
		Scanner scanner = new Scanner(Paths.get(filePath));
		scanner.useDelimiter("[^a-zA-Z]+");

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
			}
		}

		//for(int i = 0; i < list.size(); ++i) {
		//	System.out.println(list.get(i).word + " " +list.get(i).count );
		//}
		
		CompareCount c = new CompareCount();
		
		list.sort(c);
		
		System.out.println("총 단어 개수: " + total);
		for(int i = 0; i < 10; ++i) {
			System.out.println(list.get(i).word + " " + list.get(i).count);
		}
	}
}

class CompareCount implements Comparator<WordInfo>{
	@Override
	public int compare(WordInfo o1, WordInfo o2) {
		if(o1.count > o2.count) return -1;
		else if(o1.count == o2.count) return 0;
		else return 1;
	}
	
}
