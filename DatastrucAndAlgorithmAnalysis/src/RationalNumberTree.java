import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
 
/**
 * @author Zhenyi 2013 Dec 21, 2013 17:56:56 PM
 */
public class RationalNumberTree {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(
                "C:/Users/Zhenyi/Downloads/B-small-practice.in"));
        FileWriter out = new FileWriter(
                "C:/Users/Zhenyi/Downloads/B-small-practice.out");
        // BufferedReader in = new BufferedReader(new FileReader(
        // "C:/Users/Zhenyi/Downloads/B-large-practice.in"));
        // FileWriter out = new FileWriter(
        // "C:/Users/Zhenyi/Downloads/B-large-practice.out");
 
        Integer T = new Integer(in.readLine());
        for (int cases = 1; cases <= T; cases++) {
            String[] st = in.readLine().split("\\s");
            Integer choice = new Integer(st[0]);
 
            if (choice.equals(1)) {
                // find p, q
                BigInteger n = new BigInteger(st[1]);
                BigInteger p = new BigInteger("1");
                BigInteger q = new BigInteger("1");
                int len = 0;
                BigInteger[] bits = new BigInteger[65];
                while (!n.equals(new BigInteger("0"))) {
                    bits[len] = n.mod(new BigInteger("2"));
                    n = n.divide(new BigInteger("2"));
                    len++;
                }
                if (len == 1) {
                    out.write("Case #" + cases + ": 1 1" + "\n");
                } else {
                    for (int i = len - 2; i >= 0; i--) {
                        if (bits[i].equals(new BigInteger("0"))) {
                            q = q.add(p);
                        }
 
                        if (bits[i].equals(new BigInteger("1"))) {
                            p = p.add(q);
                        }
                    }
                    out.write("Case #" + cases + ": " + p + " " + q + "\n");
                }
 
            } else {
                // find sequence
                BigInteger n = new BigInteger("0");
                BigInteger p = new BigInteger(st[1]);
                BigInteger q = new BigInteger(st[2]);
                BigInteger root = new BigInteger("1");
                BigInteger[] bits = new BigInteger[65];
                int len = 0;
                while (!(p.equals(root) && q.equals(root))) {
                    if (p.subtract(q).signum() > 0) {
                        // right child
                        bits[len] = new BigInteger("1");
                        p = p.subtract(q);
 
                    } else {
                        // left child
                        bits[len] = new BigInteger("0");
                        q = q.subtract(p);
                    }
                    len++;
                }
                bits[len] = new BigInteger("1");
                len++;
 
                if (len == 1) {
                    out.write("Case #" + cases + ": 1" + "\n");
                } else {
                    for (int i = len - 1; i >= 0; i--) {
                        n = n.multiply(new BigInteger("2")).add(bits[i]);
                    }
                    out.write("Case #" + cases + ": " + n + "\n");
                }
 
            }
 
        }
 
        in.close();
        out.flush();
        out.close();
    }
}