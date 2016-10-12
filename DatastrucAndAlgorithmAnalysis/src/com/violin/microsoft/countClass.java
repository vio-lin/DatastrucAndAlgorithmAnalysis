package com.violin.microsoft;

/**
 * 从图像中 识别其中有关  m s 的字符并进行统计
 */

/*
50 50
..................................................
..................................................
..........................................#.......
............................###..........##.......
.......##..................##.##........#.........
.......##..................#...........##.........
......###.......#..........#...........##.........
......####.....###.........###..........######....
......#.##.....###..........####..............#...
......#.##....####............##..............#...
.....##..#...##.#..........#...#.............##...
.....##..#..##.##..........#####...........##.....
.....#...#.##..##.................................
.....#...###...#..................................
.....#...###...#..................................
.........##...##......................##..........
..............##.....##..............###..........
....................###............###............
...................###.............##.............
..................###.............##..............
.................###..............##..............
................###......###.......########.......
...............###.....#####........########......
..............###...########...............##.....
.............###..#####..##................##.....
............########....###................##.....
...........#######......##.....##.........###.....
............###.........##....###.......####......
.......................###...###.......###........
.......#...............##...###...................
.....####.............###..###....................
...######.............##..###.....................
..####................######......................
..###................######.......................
.###.................#####.......##...............
.###................#####........######...........
.###.................###.........##########.......
..##########.......................##...####......
..############......................##............
....###########......................###..........
.............##.......................###.........
.............###.......................###........
.............###...................#######........
.............##................########...........
............###................####...............
..........####..................######............
.......######......................######.........
.......###.............................##.........
..................................................
..................................................
*/
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import org.junit.Test;

public class countClass {
	public static char[][] array;
	public static int col;
	//定义这边 搜索顺序
	/*
	 * 0 1 2
	 * 7 X 3
	 * 6 5 4
	 */
	public static int size[][] = new int[][]{{-1,-1},{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1}};
	public static void main(String[] args) throws IOException{
		Scanner  scan = new  Scanner(System.in);
		int row;
		int countm=0,counts=0;
		while(scan.hasNext()){
			row  = scan.nextInt();
			col = scan.nextInt();
			array = new char[row*2][col*2]; 
			scan.nextLine();
			for(int i=0;i<row;i++){ 
				array[i]=scan.nextLine().toCharArray();
			}
			System.out.println();
			
			for(int i=0;i<50;i++){
				for(int j=0;j<50;j++){
					System.out.print(array[i][j]);
				}
				System.out.print(i);
				System.out.println();
			}
			for(int i=6;i<100;i++){
				for(int j=0;j<100;j++){
					if(array[i][j]=='#'){
						int res = findchanges(i,j);
						if(res == 5){
							countm++;
						}else{
							counts++;
						}
					}
				}
			}
		}
//		countthecharinaline();
		
	}

	public static  void countthecharinaline() throws IOException{
		int count = 0;
		File file = new File("c://test//format.txt"); 
		int i=0;
		try {
			BufferedReader br = new BufferedReader(new FileReader(file)); 
			String line = br.readLine();
			while(line!=null){
				array[i] = line.toCharArray();
				line = br.readLine();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 定义一个旋转方向  比如顺时针活着逆时针旋转假如找不到对应的 数字找到的下一个数字不在这个范围之内开始进行一次change标志
	 * @return
	 */
	public static int findchanges(int x,int y){
		int count = 0;
		int tempx=x,tempy =y,pos=0;
		int orin =1;
		do{
			String res = isChage(tempx,tempy,pos,orin);
			array[tempx][tempy]='0';
			tempx = Integer.valueOf(res.split(",")[0]);
			tempy = Integer.valueOf(res.split(",")[1]);
			if(Integer.valueOf(res.split(",")[2])==1){
				count++;
			}
			orin = Integer.valueOf(res.split(",")[3]);
			pos = (Integer.valueOf(res.split(",")[4])+4)%8;
			System.out.print("");
		}while(tempx!=x||tempy!=y);
		return count;
	}
	/**
	 * 
	 * @param x  当前位置的x
	 * @param y	 当前位置的y 
	 * @param orien	 现在位置在前一个位置 的相对位置
	 * @param orin   现在搜寻的方向  
	 */
	private static String isChage(int x, int y, int pos, int orin) {
		// TODO Auto-generated method stub
		//这边是另一个方向的延展
		int range = (pos+4)%8;
		int change=0;
		int postemp;
		if(array[x+size[range][0]][y+size[range][1]]=='#'){
			while(array[x+size[range][0]][y+size[range][1]]=='#'){
				if(range==pos){
					orin = orin *-1;
					change = 1;
					range = (pos+4)%8;
					while(array[x+size[range][0]][y+size[range][1]]=='#'){
						range = (range+orin+8)%8;
					}
					break;
				}
				range = (range+orin+8)%8;
			}
			range = (range+orin+8)%8;
		}else{
			while(array[x+size[range][0]][y+size[range][1]]!='#'){
				if(range==pos){
					orin = orin *-1;
					change =1;
					range = (pos+4)%8;
					while(array[x+size[range][0]][y+size[range][1]]!='#'){
						range = (range+orin+8)%8;
					}
					break;
				}
				range = (range+orin+8)%8;
			}
		}
		return (x+size[range][0])+","+(y+size[range][1])+","+change+","+orin+","+range;
	}
}
