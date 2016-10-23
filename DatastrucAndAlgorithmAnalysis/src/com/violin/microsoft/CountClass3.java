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
import java.awt.Point;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import org.junit.Test;

public class CountClass3 {
    public static char[][] array;
    public static int col;
    public static ArrayList<ArrayList<Point>> disjSet = new ArrayList<ArrayList<Point>>();
    public static int[][] path = new int[][]{{-1,-1},{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1}};
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
            for(int i=0;i<50;i++){
                for(int j=0;j<50;j++){
                    if(array[i][j]=='#'){
                        for(int k = 0;k<8;k++){
                            if(array[i+path[k][0]][j+path[k][1]]=='#'){
                                union(new Point(i,j),new Point(i+path[k][0],j+path[k][1]));
                            }
                        }
                    }
                }
            }
            int countM=0,countS=0;
            for(ArrayList<Point> list :disjSet){
                if(judge2(list)){
                    countM++;
                }else{
                    countS++;
                }
            }
            System.out.println("M:"+countM+";"+"S:"+countS);
        }
    }

    public static void union(Point a,Point b){
        ArrayList<Point> fathera = find(a);
        ArrayList<Point> fatherb = find(b);
        if(fathera == null&&fatherb==null){
            ArrayList<Point> temp = new ArrayList<Point>();
            temp.add(a);temp.add(b);
            disjSet.add(temp);
        }
        if(fathera == null&&fatherb!=null){
            fatherb.add(a);
        }
        if(fathera != null&&fatherb ==null){
            fathera.add(b);
        }
        if(fathera != null&&fatherb!=null&&fathera!=fatherb){
            fathera.addAll(fatherb);
            disjSet.remove(fatherb);
        }
    }

    public static ArrayList<Point> find(Point point){
        for(ArrayList<Point> list : disjSet){
            if(list.contains(point))
                return list;
        }
        return null;
    } 
    public static boolean judge2(ArrayList<Point> list){
      Collections.sort(list,new Comparator<Point>() {

          public int compare(Point o1, Point o2) {
              // TODO Auto-generated method stub
              if(o1.x!=o2.x){
                  return o1.x-o2.x;
              }else{
                  return o1.y-o2.y; 
              }
          }
      });
      Point  start = list.get(0),point2=new Point(start.x,start.y);
      int pos=0;
      int count = 0;
      int orie = 1;
      do{
    	  String value = findnext(point2,pos,list,orie);
    	  point2.x = Integer.valueOf(value.split(",")[0]);
    	  point2.y = Integer.valueOf(value.split(",")[1]);
    	  pos = Integer.valueOf(value.split(",")[2]);
    	  if(value.split(",")[3].equals("T")){
   		  System.out.println(point2+""+orie);
    		  count++;
    		  orie = orie*-1;
    	  }
    	  System.out.print("");
      }while(!point2.equals(start));
    	  System.out.println("belone:"+list.get(0)+";rate:"+list.size()+":"+(((float)count)/list.size()));
      System.out.println(count);
    	return false;
    }
    /**
     * 找到下一个位置所处在位置并且判断是否发生跳转 同时决定刷新下一个的pos
     * @param point2
     * @param pos
     * @return 下一个位置 x,y,对应的pos,是否反转 
     */
    private static String findnext(Point point2, int pos,ArrayList<Point> list,int orie) {
		// TODO Auto-generated method stub
    	int range = (pos+4)%8,temp = (pos+1)%8;
    	char change = 'F';
    	while(!list.contains(new Point(point2.x+path[temp][0],point2.y+path[temp][1]))){
    		temp =(temp+1)%8;
    	}
    	if(temp==pos){
    		System.out.println();
    	}
    	if(clockwise(temp,range)&&orie==-1){
    		change = 'T';
    	}
    	if(!clockwise(temp,range)&&orie==1){
    		change = 'T';
    	}
    	if(temp==range||temp==pos){
    		change = 'F';
    	}
    	return (point2.x+path[temp][0])+","+(point2.y+path[temp][1])+","+((temp+4)%8)+","+change;
	}
    /**
     * 返回是否在顺时针的范围内
     * @param temp
     * @param range
     * @return
     */
	private static boolean clockwise(int temp, int range) {
		// TODO Auto-generated method stub
		return (temp>range)||(temp<(range+4)/8);
	}

	/**
	 * 寻找最大穿过 m s 跳转的次数
	 * @param list
	 * @return
	 */
	public static boolean judge(ArrayList<Point> list){
//        Collections.sort(list,new Comparator<Point>() {
//
//            public int compare(Point o1, Point o2) {
//                // TODO Auto-generated method stub
//                if(o1.x!=o2.x){
//                    return o1.x-o2.x;
//                }else{
//                    return o1.y-o2.y; 
//                }
//            }
//        });
        int countmax = 0;
        int maxx=0,maxy=0,minx=100,miny=100;
        for(Point point :list){
            if(point.x>maxx){
                maxx=point.x;
            }
            if(point.y>maxy){
                maxy = point.y;
            }
            if(point.x<minx){
                minx = point.x;
            }
            if(point.y<miny){
                miny = point.y;
            }
        }
        int midlex = (maxx+minx)/2;
        int midley = (maxy+miny)/2;
        for(int i=0;i<4;i++){
            boolean temp = list.contains(new Point(midlex,midley));
            int x = midlex+path[i][0];
            int y = midley+path[i][1];
            int count1 = 0;
            while(x>=minx&&y>=miny&&x<maxx&&y<maxy){
                if(temp != list.contains(new point(x, y)))
                    {
                        count1++;
                        temp=!temp;
                    }
                x = x+path[i][0];
                y = y+path[i][1];
            }
            i=i+4;
            x = midlex+path[i][0];
            y = midley+path[i][1];
            temp = list.contains(new Point(midlex,midley));
            while(x>=minx&&y>=miny&&x<maxx&&y<maxy){
                if(temp != list.contains(new point(x, y)))
                    {
                        count1++;
                        temp=!temp;
                    }
                x = x+path[i][0];
                y = y+path[i][1];
            }
            if(count1>countmax){
                countmax = count1;
            }
        }
        if(countmax>4){
            return true;
        }
        return false;
    }

}
