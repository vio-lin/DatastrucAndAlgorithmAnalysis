package com.violin.Map;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 直接定义定点类的方法 来改写dijkstra
 * @author lin
 *
 */
public class DijkstraClass {
	/**
	 * Print shortest path to v
	 * after dijkstra has run.Assum that the path exists.
	 */
	public void printPath(Vertex v){
		if(v.path != null){
			printPath(v.path);
			System.out.println(" to ");
		}
		System.out.print(v);
	}
	
	public void dijsktra(Vertex s){
		Vertex[] vet= new Vertex[7];
		for(int i=0;i<vet.length;i++){
			vet[i].dis = Integer.MAX_VALUE;
			vet[i].known = false;
		}
		s.dis = 0;
		while(true){
			Vertex v = vet[3];
			v.known = true;
			for(Vertex w :v.connect){
				if(!w.known){
					int cvw = v.getconnect(w);
					if(v.dis+cvw<w.dis){
						//uodate w
						w.dis = v.dis+cvw;
						w.path = v;
					}
				}
			}
		}
	}
}

class Vertex{
	//这个连接其他的店
	public static int [][] vertexs;
	{
		vertexs = new int[7][7];
		for(int i=0;i<7;i++){
			for(int j=0;j<7;j++){
				vertexs[i][j] =Integer.MAX_VALUE;
			}
		}
		vertexs[2][0]=3;vertexs[0][1]=2;
		vertexs[1][4]=10;vertexs[4][6]=6;
		vertexs[6][5]=1;vertexs[2][5]=5;
		vertexs[3][2]=2;vertexs[0][3]=1;
		vertexs[1][3]=3;vertexs[3][4]=2;
		vertexs[3][6]=4;vertexs[3][5]=8;
	}
	public List<Vertex> connect;
	public boolean known;
	public int dis;
	public int id;
	public Vertex path;
	int getconnect(Vertex c){
		
		return vertexs[this.id][c.id];
	}
}
