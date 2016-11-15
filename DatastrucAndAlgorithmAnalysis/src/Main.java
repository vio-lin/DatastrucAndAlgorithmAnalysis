import java.util.Scanner;


public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while(scan.hasNext()){
			int sum = scan.nextInt();
			int p = scan.nextInt();
			scan.nextLine();
			String[] arr = scan.nextLine().split(" ");
			int[] temp = new int[100000];
			for(int i=0;i<sum;i++){
				int num = Integer.valueOf(arr[i]);
				sort(temp,num,i);
			}
			int boundary = temp[0]*p;
			int res = 0;
			while(temp[res]<boundary&&temp[res+1]!=0){
				res++;
			}
			System.out.println(res+1);
		}
	}

	private static void sort(int[] temp, int num,int i) {
		// TODO Auto-generated method stub
					
		while(i>0&&num<temp[i-1]){
			temp[i] = temp[i-1];
			i--;
		}
		temp[i] = num;
	}
}
