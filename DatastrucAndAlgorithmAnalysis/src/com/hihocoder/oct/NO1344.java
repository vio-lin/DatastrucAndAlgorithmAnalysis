package com.hihocoder.oct;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class NO1344 {
    public static int [][] path;
    public static Map<String, Integer> result;
    public static void main(String[] args) {
        result = new HashMap<String, Integer>();
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int M = scan.nextInt();
        int Q = scan.nextInt();
        path = new int[N+1][N+1];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                path[i][j] = -1;
            }
        }
        for(int i=0;i<M;i++){
            int x = scan.nextInt();
            int y = scan.nextInt();
            int dis = scan.nextInt();
            path[x][y] = dis;
        }
        ArrayList<job> jobs = new ArrayList<job>();
        for(int i=0;i<Q;i++){
            int pos = scan.nextInt();
            int ear = scan.nextInt();
            int last = scan.nextInt();
            int time = scan.nextInt();
            int get = scan.nextInt();
            jobs.add(new job(pos,ear,last,time,get));
         }
        int maxpay = getMaxPay(1,0,jobs);
        System.out.println(maxpay);
        System.out.println(result);
    }
    /**
     * 
     * @param i 所在的地点
     * @param j 现在时间
     * @param jobs 所剩的job
     * @return
     */
    private static int getMaxPay(int i, int j, ArrayList<job> jobs) {
        // TODO Auto-generated method stub
        ArrayList<job> temp = (ArrayList<job>) jobs.clone(); 
        job tejob=null;
        int max = -1;
        for(job tem:jobs){
            if(validate(i,j,tem)){
                temp.remove(tem);
                int result = tem.get+getMaxPay(tem.pos,max(j+path[i][tem.pos]+tem.time,tem.ear+tem.time),temp); 
                if(result>max){
                    max = result; 
                    tejob = tem;
                }
                temp.add(tem);
            }
        }
        if(null==tejob){
            return 0;
        }else{
            result.put(i+";"+j+";"+tejob,max);
            temp.remove(tejob);
            return max;    
        }
    }
    public static int max(int a,int b){
        return a>=b?a:b;
    }
    private static boolean validate(int i, int j, job tem) {
        // TODO Auto-generated method stub
        int place = tem.pos;
        if(path[i][place]==-1){
            return false;
        }
        if(j+path[i][place]>tem.last){
            return false;
        }
        return true;
    }
}
class job{
    public int pos;
    public int ear;
    public int last;
    public int time;
    public int get;
    public job(int pos, int ear, int last, int time, int get) {
        super();
        this.pos = pos;
        this.ear = ear;
        this.last = last;
        this.time = time;
        this.get = get;
    }
    @Override
    public boolean equals(Object obj) {
        // TODO Auto-generated method stub
        job temp = (job)obj;
        return this.pos==temp.pos&&this.ear==temp.ear&&this.last==temp.last&&this.time==temp.time&&this.get==temp.get;
    }
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return pos+";"+ear+";"+last;
    }
}