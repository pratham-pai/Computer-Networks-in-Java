import java.io.*;
class crc
{
    public static void main(String[] args) throws IOException , NumberFormatException
    {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        //declarations:
        int[] message;          //size==4 (key)
        int[] gen;              //size==17
        int[] app_message;      //size==total_bits==20      message followed by zeroes
        int[] rem;              //size==20
        int[] trans_message;    //size==20      app_message[i]^rem[i]
        int message_bits,gen_bits,total_bits;

        //input for message bits
        System.out.print("Enter no of bits in message: ");
        message_bits = Integer.parseInt(br.readLine());
        message = new int[message_bits];
        System.out.println("Enter the message bits: ");
        for(int i=0;i<message_bits;i++) //1st for loop
            message[i] = Integer.parseInt(br.readLine());

        //input for generated bits
        System.out.print("Enter no of bits generated: ");
        gen_bits = Integer.parseInt(br.readLine());
        gen = new int[gen_bits];
        System.out.println("Enter the generated bits: ");
        for(int i=0;i<gen_bits;i++) //2nd for loop
            gen[i] = Integer.parseInt(br.readLine());

        //equating total_bits to array sizes
        total_bits = message_bits + gen_bits - 1;
        app_message = new int[total_bits];
        rem = new int[total_bits];
        trans_message = new int[total_bits];

        for(int i=0;i<message.length;i++)   //3rd   //copy message[] to app_message[]
            app_message[i] = message[i];
        System.out.print("Message bits: ");
        for(int i=0;i<message.length;i++)      //4th    //output the copied value of app_message[]
            System.out.print(message[i]);
        //message.length is same as message_bits == 4

        System.out.print("\nGenerated bits: ");
        for(int i=0;i<gen_bits;i++)             //5th   //output gen[]
            System.out.print(gen[i]);
        //gen_bits is same as gen.length == 17

        System.out.print("\nAppended message: ");
        //app_message.length is same as message.length and also as message_bits == 4
        for(int i=0;i<app_message.length;i++)   //6th
            System.out.print(app_message[i]);   //print app_message[]
        //app_message.length size == 20
        for(int j=0;j<app_message.length;j++)   //7th
            rem[j] = app_message[j];            //copy app_message[] to rem[]

        rem = computecrc(gen,rem);      //app_message, NOT NEEDED
        //gen size == 17 and rem size == 20

        for(int i=0;i<app_message.length;i++)   //8th       //20 times, get trans_message by XOR
            trans_message[i] = app_message[i] ^ rem[i];     //bitwise XOR
        System.out.print("\nTransmitted message from transmitter: ");
        for(int i=0;i<trans_message.length;i++)     //9th   //output the trans_message[20]
            System.out.print(trans_message[i]);

        System.out.print("\nMessage of " + total_bits + " bits received:");

        for(int i=0;i<trans_message.length;i++)     //10th      //just input trans_message[] as above
            trans_message[i] = Integer.parseInt(br.readLine());
        System.out.println("Received message is: ");
        for(int i=0;i<trans_message.length;i++)     //11th      //output trans_message[] again
            System.out.println(trans_message[i]);
        for(int j =0;j<trans_message.length;j++)    //12th
            rem[j] = trans_message[j];
        rem = computecrc(gen,rem);              //trans_message, NOT NEEDED
        for(int i=0;i<rem.length;i++)               //13th
        {
            if(rem[i]!=0)
            {
                System.out.println("There is error");
                break;
            }
            if(i==rem.length-1)
                System.out.println("There is no error");
        }
    }
    static int[] computecrc(int gen[],int rem[])    //int app_message[],   NOT NEEDED
    {
        int current=0;
        while(true)
        {
            for(int i=0;i<gen.length;i++)   //gen.lentgh == 17
                rem[current+i] = (rem[current+i]^gen[i]); //^(caret) is bitwise-XOR
            while(rem[current] == 0 && current != rem.length - 1)   //true iff different inputs
                current++;
            if((rem.length-current)<gen.length)
                break;
        }
        return rem;
    }
}
/*Output:
Enter no of bits in message: 4
Enter the message bits:
1
0
0
1
Enter no of bits generated: 17
Enter the generated bits:
1
0
0
0
1
0
0
0
0
0
0
1
0
0
0
0
1
Message bits: 1001
Generated bits: 10001000000100001
Appended message: 10010000000000000000
Transmitted message from transmitter: 10011001000100101001
Message of 20 bits received:
10011001000100101001
There is no error
*/
