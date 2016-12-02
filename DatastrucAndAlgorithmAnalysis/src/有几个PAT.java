import java.util.Scanner;
public class 有几个PAT {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String orgStr = "";
        while (in.hasNext()) {
            orgStr = in.nextLine();
        }
        char[] arr = orgStr.toCharArray();
        int pNum = 0;
        int paNum = 0;
        int patNum = 0;
        for(char val : arr){
            if((""+val).equals("P")){
                pNum++;
            }else if((""+val).equals("A")){
                paNum +=pNum;
                paNum = paNum%1000000007;
            }else {
                patNum +=paNum;
                patNum = patNum%1000000007;
            }
        }
        System.out.println(patNum);
    }
}