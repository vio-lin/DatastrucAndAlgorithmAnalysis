import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int sum = scan.nextInt();
        int i=2;
        while(sum>=i){
            sum-=i;
            i++;
        }
        int res = 1;
        i--;
        if(sum==0){
            while(i!=2){
                res *=i;
            }
        }else if (sum == i){
            res = res*(i+2);
            i--;
            while(i!=3){
                res*=i;
            }
        }else{
            while(i!=1){
                if(sum!=0){
                    res*=(i+1);
                    sum--;
                    i--;
                }else{
                    res*=i;
                    i--;
                }
            }
        }
        System.out.println(res);
    }
}
