package com.hihocoder.oct;
import java.util.Scanner;


public class NO1014Trie树 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Trie main = new Trie(); 
        int sum = scan.nextInt();
        scan.nextLine();
        for(int i=0;i<sum;i++){
            String str = scan.nextLine();
            main.addWords(str);
        }
        sum = scan.nextInt();
        scan.nextLine();
        for(int i=0;i<sum;i++){
            String str = scan.nextLine();
            System.out.println(main.count(str));
        }
    }
}
class Trie{
    public int count;
    public Trie[] child;
    public Trie() {
        // TODO Auto-generated constructor stub
        this.count = 0;
        child = new Trie[26];
    }
    public int count(String str) {
        // TODO Auto-generated method stub
        Trie trie = this; 
        for (char ch : str.toCharArray()){
            if(trie.child[ch-'a'] == null){
                return 0;
            }
            trie = trie.child[ch-'a'];
        }
        return trie.count;
    }
    public Trie addWords(String str){
        Trie trie = this;
        for (char chr: str.toCharArray()){
            trie.count++;
            if(trie.child[chr-'a']==null){
                trie.child[chr-'a'] = new Trie();
            }
            trie = trie.child[chr-'a'];
        }
        trie.count++;
        return this;
    }
    public Trie[] getChild(){
        return child;
    }
}