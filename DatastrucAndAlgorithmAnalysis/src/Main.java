import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * 
 * @author lin
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader(
				"D:/codejam/ProviceLeader/B-small-practice.in"));
        FileWriter out = new FileWriter(
                "D:/codejam/ProviceLeader/B-small-practice.out");
		int sum = Integer.valueOf(in.readLine());
		for(int i=0;i<sum;i++){
			int peonum = Integer.valueOf(in.readLine());
			for(int j=0;j<peonum;j++){
				int max = 0;
				String name ="";
				String temp = in.readLine();
				int count = count(temp.replace(" ", ""));
				if(count>max){
					max = count;
					name = temp;
				}
				out.write("Case #" + (i+1) + ": "+name + "\n");
			}
		}
	}

	private static int count(String temp1) {
		// TODO Auto-generated method stub
		boolean[] flag= new boolean[26];
		int sum = 0 ;
		for(char c : temp1.toCharArray()){
			if(flag[c-'A']==false){
				flag[c-'A'] = true;
				sum++;
			}
		}
		return sum;
	}
}
