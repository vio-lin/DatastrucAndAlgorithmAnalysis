import java.util.Scanner;


public class Main1 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while(scan.hasNext()){
			int type = scan.nextInt();
			int sum = scan.nextInt();
			int[] quality = new int[type];
			int[] cash = new int[type];
			for(int i=0;i<type;i++){
				quality[i] = scan.nextInt();
			}
			for(int i=0;i<type;i++){
				cash[i] = scan.nextInt();
			}
			
		}
	}
}
