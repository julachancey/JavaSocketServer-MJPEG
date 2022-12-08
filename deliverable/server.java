// inspired by https://www.digitalocean.com/community/tutorials/java-socket-programming-server-client Java Socket Programming tutorial

// imports ordered alphabetically
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.ClassNotFoundException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

// java socket server implementation for CNT 4731 - Programming Assignment 2
public class server {

    // socket server global veriables, port number is last 4 digits of my ufid
    // (6592-4559)
    private static ServerSocket juliaServer;
    private static int juliaPort = 4559;

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // create java socket server on port 4559
        juliaServer = new ServerSocket(juliaPort);

        // create socket and wait for client connection
        Socket juliaSocket = juliaServer.accept();

        // create output stream object and write "Hello!" to juliaSocket
        ObjectOutputStream juliaOutput = new ObjectOutputStream(juliaSocket.getOutputStream());
        juliaOutput.writeObject("Hello!");
        System.out.println("Hello!");

        // close everything
        juliaSocket.close();
        juliaOutput.close();

        // image files to send to client
        File juliaJpegImage1 = new File("flower1.jpg");
        File juliaJpegImage2 = new File("flower2.jpg");
        File juliaJpegImage3 = new File("flower3.jpg");
        File juliaJpegImage4 = new File("flower4.jpg");
        File juliaJpegImage5 = new File("flower5.jpg");
        File juliaJpegImage6 = new File("flower6.jpg");
        File juliaJpegImage7 = new File("flower7.jpg");
        File juliaJpegImage8 = new File("flower8.jpg");
        File juliaJpegImage9 = new File("flower9.jpg");
        File juliaJpegImage10 = new File("flower10.jpg");
        File juliaJpegImage11 = new File("flower11.jpg");
        File juliaJpegImage12 = new File("flower12.jpg");
        File juliaJpegImage13 = new File("flower13.jpg");
        File juliaJpegImage14 = new File("flower14.jpg");
        File juliaJpegImage15 = new File("flower15.jpg");

        Vector<File> vector = new Vector<File>(15);
        vector.add(juliaJpegImage1);
        vector.add(juliaJpegImage2);
        vector.add(juliaJpegImage3);
        vector.add(juliaJpegImage4);
        vector.add(juliaJpegImage5);
        vector.add(juliaJpegImage6);
        vector.add(juliaJpegImage7);
        vector.add(juliaJpegImage8);
        vector.add(juliaJpegImage9);
        vector.add(juliaJpegImage10);
        vector.add(juliaJpegImage11);
        vector.add(juliaJpegImage12);
        vector.add(juliaJpegImage13);
        vector.add(juliaJpegImage14);
        vector.add(juliaJpegImage15);

        int counter = 0;

        // server continues running until user types the command "bye"
        while (true) {
            // create socket and wait for client connection
            juliaSocket = juliaServer.accept();

            // get output stream object
            juliaOutput = new ObjectOutputStream(juliaSocket.getOutputStream());
            juliaOutput.writeObject(vector.get(counter));
            counter++;

            // close everything
            juliaSocket.close();
            juliaOutput.close();

            if (counter >= vector.size()){
                juliaOutput.writeObject("disconnected");
                juliaOutput.close();
                break;
            }

        }

        // close and terminate julia's server socket
        juliaServer.close();
    }
}