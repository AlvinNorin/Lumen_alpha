/**
 *	**	**	**	**	**	**	**	**
 * 	Socket.java
 * 	client
 *	**	**	**	**	**	**	**	**
 *
 * 	Author		:		Alvin
 * 	Year		:		2014
 * 	Time		:		12:40:40
 * 
 *	**	**	**	**	**	**	**	**
 */
package client;

/**
 * @author Alvin
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Main {
	
	static Object input = "";
    public static Object main(String str) {
        
        /*if (args.length != 2) {
            System.err.println(
                "Usage: java EchoClient <host name> <port number>");
            System.exit(1);
        }*/
    	
    	//String hostName = args[0];
    	String hostName = singleplayer.server.address;
    	//int portNumber = Integer.parseInt(args[1]);
    	int portNumber = 4444;

        try (
            Socket kkSocket = new Socket(hostName, portNumber);
            PrintWriter out = new PrintWriter(kkSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(
                new InputStreamReader(kkSocket.getInputStream()));
        ) {
            BufferedReader stdIn =
                new BufferedReader(new InputStreamReader(System.in));
            String fromServer;
            String fromUser;

            while ((fromServer = in.readLine()) != null) {
                System.out.println("Server: " + fromServer);
                input = fromServer;
                if (fromServer.equals("accept"))
                    break;
                
                //fromUser = stdIn.readLine();
                fromUser = str;
                if (fromUser != null) {
                    System.out.println("Client: " + fromUser);
                    out.println(fromUser);
                }
            }
        } catch (UnknownHostException e) {
        	try {
            System.err.println("Don't know about host " + hostName);
            input = "DISCONNECTED\0";
        	} finally {}
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to " +
                hostName);
            input = "HOST NOT FOUND\0";
        }
        return input;
    }
}
