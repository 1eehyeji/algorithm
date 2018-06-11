package algorithm_pt;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class CountWord1 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		String filePath = "c:/shakespeare.txt";
	      Scanner scanner = new Scanner(Paths.get(filePath));
	      scanner.useDelimiter("[^a-zA-Z]+");
	      
	      
	      HashMap<String, Integer> map = new HashMap<String, Integer>();
	      
	      while(scanner.hasNext("[a-zA-Z]+")) {
	    	  String s = scanner.next().toLowerCase();
	    	  Integer count = map.get(s);
	    	  if(count == null) count = 0;
	    	  count += 1;
	    	  map.put(s, count);
	      }
	      
	      scanner.close();
	      
	      System.out.println("총 단어 수: " + map.size());
	      
	      Collection<Integer> c = map.values();
	      Object[] a = c.toArray();
	      Arrays.sort(a);
	      Collections.reverse(Arrays.asList(a));
	   //   System.out.println(Arrays.toString(a));
	      
	      
	      for (int i = 0; i <= 9; i++) {
	         for (String key : map.keySet()) {
	            if (a[i].equals(map.get(key))) {
	               System.out.printf("단어: %s, 횟수: %d \n", key, map.get(key));
	            }
	         }
	      }
	      

	      System.out.println();
	      
	     // for (String s : map.keySet())
	    //	  System.out.printf("%s %d\n", s, map.get(s));
	}
}
