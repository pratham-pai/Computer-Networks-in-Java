import java.io.DataInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Random;
public class RSA12
{
    private BigInteger p;
    private BigInteger q;
    private BigInteger N;
    private BigInteger phi;
    private BigInteger e;
    private BigInteger d;
    private int bitlength = 1024;
    private Random r;
    public RSA12()
    {
        r = new Random();
        p = BigInteger.probablePrime(bitlength,r);
        q = BigInteger.probablePrime(bitlength,r);
        N = p.multiply(q);
        phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
        e = BigInteger.probablePrime(bitlength/2,r);
        while(phi.gcd(e).compareTo(BigInteger.ONE)>0 && e.compareTo(phi)<0)
            e.add(BigInteger.ONE);
        d=e.modInverse(phi);
    }
    public RSA12(BigInteger e,BigInteger d,BigInteger N)
    {
        this.e = e;
        this.d = d;
        this.N = N;
    }
    public static void main(String[] args) throws IOException
    {
        RSA12 rsa = new RSA12();
        DataInputStream in = new DataInputStream(System.in);
        String teststring;
        System.out.print("Enter the plain text: ");
        teststring = in.readLine();
        System.out.println("Encrypting String: " + teststring);
        System.out.println("String in bytes: " + bytesToString(teststring.getBytes()));
        byte[] encrypted = rsa.encrypt(teststring.getBytes());
        bytesToString(encrypted);
        System.out.println(encrypted);
        byte[] decrypted = rsa.decrypt(encrypted);
        System.out.println("Decrypting Bytes: " + bytesToString(decrypted));
        System.out.println("Decrypting String: " + new String(decrypted));
    }
    private static String bytesToString(byte[] encrypted)
    {
        String test="";
        for(byte b:encrypted)
            test += Byte.toString(b);
        return test;
    }
    public byte[] encrypt(byte[] message)
    {
        return(new BigInteger(message)).modPow(e,N).toByteArray();
    }
    public byte[] decrypt(byte[] message)
    {
        return(new BigInteger(message)).modPow(d,N).toByteArray();
    }
}

/*Output:
Enter the plain text: hello
Encrypting String: hello
String in bytes: 104101108108111
[B@30a3107a
Decrypting Bytes: 104101108108111
Decrypting String: hello
*/
