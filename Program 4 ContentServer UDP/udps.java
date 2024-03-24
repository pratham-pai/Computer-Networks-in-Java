import java.io.*;
import java.net.*;
public class udps
{
    public static void main(string[] args)
    {
        DatagramSocket Skt=null;
        try
        {
            Skt=new DatagramSocket(6788);
            Byte[] buffer= new byte(1000);
            While(true)
            {
                DatagramPacket request=new DatagramPacket(buffer,buffer.length);
                Skt.receive(request);
                String[] message=(new string(request.getData())).split(" ");
                byte[] sendMsg=(message[1]+"Network Laboratory").getBytes();
                DatagramPacket reply=new DatagramPacket(sendMsg,sendMsg.length,request.getAddress(),request.getport());
                Skt.send(reply);
                System.out.println("Client received :"" + new String(reply.getData()));
                Skt.close();
            }
        }
        catch(Exception ex)
        { }
    }
}
