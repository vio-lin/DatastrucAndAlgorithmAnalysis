import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;


public class 反转链表 {
	public static void main(String[] args) {
			Scanner scan = new Scanner(System.in);
			String line = scan.nextLine();
			String[] arrays= line.split(" ");
			String start = arrays[0];
			int sum = Integer.valueOf(arrays[1]);
			int step = Integer.valueOf(arrays[2]);
			HashMap<String, String> list = new HashMap<>();
			for(int i=0;i<sum;i++){
				String temp = scan.nextLine();
				String[] arra = temp.split(" ");
				list.put(arra[0], arra[2]+arra[1]);
			}
			ArrayList<String> stack = new ArrayList<>();
			String index = start;
			boolean falg =true;
			ArrayList<String> res = new ArrayList<String>();
			while(true){
				A:
				for(int i=0;i<step;i++){
					if(!index.startsWith("-")){
						stack.add(index);
						String te1 = list.get(index);
						if(te1.length()<5){
							break A;
						}else{
							index = te1.substring(0,5);							
						}
					}else{
						break ;//使用break 代替goto 
					}
				}
				if(stack.size()==step){
					Collections.reverse(stack);
					res.addAll(stack);
					stack.clear();
				}else{
					res.addAll(stack);
					}
				if(res.size()==sum){
					for(int i=0;i<res.size();i++){
						if(i<res.size()-1){
							String te = res.get(i);
							System.out.print(te+" "+list.get(te).substring(5));
							System.out.println(" "+res.get(i+1));
						}else{
							String te = res.get(i);
							System.out.print(te+" "+list.get(te).substring(2));
							System.out.println(" -1");
						}
					}
					break;
				}
			}
			
	}
}
