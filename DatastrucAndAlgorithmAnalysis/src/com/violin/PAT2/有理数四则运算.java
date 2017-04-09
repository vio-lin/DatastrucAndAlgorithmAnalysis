package com.violin.PAT2;
import java.util.Scanner;


public class 有理数四则运算 {
	public static void main(String[] args){
		// TODO Auto-generated constructor stub
		Scanner  scan = new Scanner(System.in);
		while(scan.hasNext()){
			String line = scan.nextLine();
			String[] aqu = line.split(" ");
			Num a = new Num(aqu[0]);
			Num b = new Num(aqu[1]);
			System.out.print(a+" + "+b+" = ");
			System.out.println(pluse(a,b));
			System.out.print(a+" - "+b+" = ");
			System.out.println(minus(a,b));
			System.out.print(a+" * "+b+" = ");
			System.out.println(muti(a,b));
			System.out.print(a+" / "+b+" = ");
			System.out.println(dmu(a,b));
		}
	}

	private static String dmu(Num a, Num b) {
		// TODO Auto-generated method stub
		if(b.up==0){
			return "Inf";
		}
		int up = a.up*b.down;
		int down = a.down*b.up;
		return new Num(up+"/"+down).toString();
	}

	private static String muti(Num a, Num b) {
		// TODO Auto-generated method stub
		int up = a.up*b.up;
		int down = a.down*b.down;
		return new Num(up+"/"+down).toString();
	}

	private static String minus(Num a, Num b) {
		// TODO Auto-generated method stub
		int max = Num.getMax(a.down, b.down);
		int c = a.down*b.down/max;
		int up = a.up*c/a.down-b.up*c/b.down;
		return new Num(up+"/"+c).toString();
	}

	private static String pluse(Num a, Num b) {
		// TODO Auto-generated method stub
		int max = Num.getMax(a.down, b.down);
		int c = a.down*b.down/max;
		int up = a.up*c/a.down+b.up*c/b.down;
		return new Num(up+"/"+c).toString();
	}
}
class Num{
	public int up;
	public int down;
	public Num(String str){
		String[] st = str.split("/");
		this.up = Integer.valueOf(st[0]);
		this.down = Integer.valueOf(st[1]);
	}
	
	public String toString(){
		boolean flag =false;
		if(down*up<0){
			flag = true;
		}
		if(this.up==0){
			return "0";
		}
		int max = getMax(this.up , this.down);
		int up = Math.abs(this.up/max);
		int down = Math.abs(this.down/max);
		if(down==0){
			return "Inf";
		}else{
			String res = "";
			if(up/down!=0){
				res += up/down;
			}
			if(up%down!=0){
				if(up/down!=0){
					res+=" ";
				}
				res+=up%down+"/"+down;
			}
			if(flag){
				return "(-"+res+")";
			}
			return res;
		}
	}
	public static int getMax(int x,int y){
		x = Math.abs(x);
		y = Math.abs(y);
		if(y>x){
			return getMax(y, x);
		}
		if(x%y==0){
			return y;
		}else{
			return getMax(y,x%y);
		}
	}
}
