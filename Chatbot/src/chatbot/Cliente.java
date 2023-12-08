package chatbot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {

	public static void main(String[] args) {
		try {
			Socket socket = new Socket("localhost", 5001);
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

			while (true) {
				// Linea 1
				String inputLine = in.readLine();
				System.out.println(inputLine);
				// Linea 2
				inputLine = in.readLine();
				System.out.println(inputLine);
				// Linea 3
				inputLine = in.readLine();
				System.out.println(inputLine);
				// Linea 4
				inputLine = in.readLine();
				System.out.println(inputLine);
				// Linea 5
				inputLine = in.readLine();
				System.out.println(inputLine);
				// Linea 6
				inputLine = in.readLine();
				System.out.println(inputLine);
				// Linea 7
				inputLine = in.readLine();
				System.out.println(inputLine);
				// Linea 8
				inputLine = in.readLine();
				System.out.println(inputLine);
				// Linea 9
				inputLine = in.readLine();
				System.out.println(inputLine);
				// Linea 10
				inputLine = in.readLine();
				System.out.println(inputLine);

				System.out.println();
				Scanner scanner = new Scanner(System.in);

				while (true) {

					String response = scanner.nextLine();
					out.println(response);

				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}