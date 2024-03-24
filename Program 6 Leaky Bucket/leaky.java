import java.util.*;
public class leaky
{
	public static void main(String[] args)
    {
        Scanner my = new Scanner(System.in);
        int no_groups, bucket_size;
        System.out.println("Enter bucket size: ");
        bucket_size = my.nextInt();
        System.out.println("Enter number of groups: ");
        no_groups = my.nextInt();
        int no_packets[] = new int[no_groups];
        int in_bw[] = new int[no_groups];
        int out_bw, reqd_bw = 0, tot_packets = 0;
        for(int i=0;i<no_groups;i++)
        {
            System.out.println("Enter the number of packets for group: " + (i+1));
            no_packets[i] = my.nextInt();
			System.out.println("Enter the input bandwidth for group: " + (i+1));
			in_bw[i] = my.nextInt();
            if((tot_packets + no_packets[i]) <= bucket_size)
                tot_packets += no_packets[i];
            else
            {
                do
                {
                    System.out.println("Bucket Overflow");
                    System.out.println("Enter value less than " + (bucket_size - tot_packets));
                    no_packets[i] = my.nextInt();

                }while((tot_packets + no_packets[i]) <= bucket_size);
                tot_packets += no_packets[i];
            }
            reqd_bw += (no_packets[i] * in_bw[i]);
        }
        System.out.println("The total required bandwidth is: " + reqd_bw);
        System.out.println("Enter the output bandwidth: ");
        out_bw = my.nextInt();
        int temp = reqd_bw;
        int rem_pkts = tot_packets;
        while((out_bw <= temp) && (rem_pkts > 0))
        {
            System.out.println("Data sent\n" + (--rem_pkts) + " Packets remaining");
            System.out.println("Remaining bandwidth " + (temp -= out_bw));
            if((out_bw > temp) && (rem_pkts > 0))
                System.out.println(rem_pkts + " Packets discarded due to insufficient bandwidth");
        }
    }
}

/*Output:
Enter bucket size:
20
Enter number of groups:
2
Enter the number of packets for group: 1
2
Enter the input bandwidth for group: 1
2
Enter the number of packets for group: 2
3
Enter the input bandwidth for group: 2
3
The total required bandwidth is: 13
Enter the output bandwidth:
2
Data sent
4 Packets remaining
Remaining bandwidth 11
Data sent
3 Packets remaining
Remaining bandwidth 9
Data sent
2 Packets remaining
Remaining bandwidth 7
Data sent
1 Packets remaining
Remaining bandwidth 5
Data sent
0 Packets remaining
Remaining bandwidth 3
*/
