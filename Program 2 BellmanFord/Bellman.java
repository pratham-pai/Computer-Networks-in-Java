import java.io.*;
import java.util.*;
import java.io.DataInputStream;
class Edge
{
    int source;
    int dest;
    int weight;
}
class Bellman
{
    public static void BellmanFord(Edge edges[], int edgecount, int nodecount, int source)
    {
        int infinity = 50000;
        int i,j;
        int distance[] = new int[nodecount];
        for(i=0;i<nodecount;i++)
            distance[i] = infinity;
        distance[source] = 0;
        for(i=0;i<nodecount;i++)    //4
        {
            boolean somethingchanged = false;
            for(j=0;j<edgecount;j++)    //8
            {
                int new_distance = distance[edges[j].source] + edges[j].weight;
                if(new_distance < distance[edges[j].dest])
                {
                    distance[edges[j].dest] = new_distance;
                    somethingchanged = true;
                }
            }
            if(!somethingchanged)
            	break;
        }
        for(i=0;i<edgecount;++i)
        	if(distance[edges[i].dest] > distance[edges[i].source] + edges[i].weight)
        		System.out.println("Negative edge weight cycles detected!!!");
        for(i=0;i<nodecount;++i)
        	System.out.println("The shortest distance between nodes " + source + "&" + i + " is " + distance[i]);
    }
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        Edge edges[] = new Edge[4];
        for(int i=0;i<4;i++)
        {
            edges[i] = new Edge();
            System.out.println("Enter Source number[" + i + "]: ");
            edges[i].source = in.nextInt();
            System.out.println("Enter destination number[" + i + "]: ");
            edges[i].dest = in.nextInt();
            System.out.println("Enter weight number [" + i + "]: ");
            edges[i].weight = in.nextInt();
            System.out.println();
        }
        BellmanFord(edges,8,4,0);//edges,nodes,source
    }
}
