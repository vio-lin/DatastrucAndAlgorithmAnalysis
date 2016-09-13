package com.violin.qlcode;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Scanner;
public class 并查集的实现{
    private static int father[];
    public static void main(String[]args)throws Exception{
            Scanner scan = new Scanner(System.in);
            while(scan.hasNext()){
            	int n = scan.nextInt();
                father=new int[n+1];
                for(int i=1;i<=n;i++){
                    father[i]=i;
                }
                int m=scan.nextInt();
                int p=scan.nextInt();
                for(int i=0;i<m;i++){
                    int a=scan.nextInt();
                    int b=scan.nextInt();
                    union(a,b);
                }
  
                for(int i=0;i<p;i++){
                    int a=scan.nextInt();
                    int b=scan.nextInt();
                    a=findParent(a);
                    b=findParent(b);
                    System.out.println(a==b?"Yes":"No");
                }
            }
    }
    private static void union(int f,int t){
        int a=findParent(f);
        int b=findParent(t);
        if(a==b)return;
        if(a>b){
            father[a]=b;
        }
        else {
            father[b]=a;
        }
    }
    private static int findParent(int f){
        while(father[f]!=f){
            f=father[f];
        }
        return f;
    }
}