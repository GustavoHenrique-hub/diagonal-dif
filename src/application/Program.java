package application;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {
	
	 public static int diagonalDifference(List<List<Integer>> arr) {
		    // Write your code here
		        int diagA = 0, diagB = 0;
		        
		        for (int i = 0; i < arr.size(); i++){
		            for (int j = 0; j < arr.get(i).size(); j ++){
		                if(i == j){
		                    diagA += arr.get(i).get(j);    
		                }
		                if((i + j) == arr.size() - 1){
		                    diagB += arr.get(i).get(j);
		                }
		                
		            }
		        }
		        
		        return (diagA > diagB) ? diagA - diagB : diagB - diagA;
		    }

}


public class Program {

	public static void main(String[] args) throws NumberFormatException, IOException, NullPointerException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                arr.add(
                    Stream.of(bufferedReader.readLine().split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.diagonalDifference(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}