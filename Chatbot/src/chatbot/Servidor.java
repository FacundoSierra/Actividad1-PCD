package chatbot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor implements Runnable {
	private Socket clientSocket;

	public Servidor(Socket clientSocket) {
		this.clientSocket = clientSocket;
	}

	public static void main(String[] args) {
		try {
			ServerSocket serverSocket = new ServerSocket(5001);
			System.out.println("Servidor de Chat iniciado.");

			int i = 0;

			while (true) {
				Socket clientSocket2 = serverSocket.accept();
				System.out.println("Cliente conectado desde " + clientSocket2.getInetAddress());
				i++;

				new Thread(new Servidor(clientSocket2), "Cliente" + i).start();

			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		String inputLine;
		try {
			PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			out.println("Bienvenido al servidor,a continuacion va a interactuar con nuestro chatBot");
			out.println("Elige una de las siguientes curiosidades que quiera saber:");
			out.println("---------------------------------------------------------------------------------------");
			out.println("Para saber que paises no pueden comercializar la cocacola, pulse 1");
			out.println("Para saber que pais tiene mas piramides en el mundo, pulse 2");
			out.println("Para saber cuantos años de retraso tiene Etiopia, pulse 3");
			out.println("Para saber cual es el pais que mayor numero de visitas tiene en el mundo , pulse 4");
			out.println("Para saber que pais tiene la zona residencial mas empinada del mundo, pulse 5");
			out.println("Para Salir del chatBot , pulse 6");
			out.println("---------------------------------------------------------------------------------------");

			while ((inputLine = in.readLine()) != null) {
				System.out.println("La respuesta elegida es " + inputLine);
				int option = Integer.parseInt(inputLine);
				switch (option) {
				case 1:
					option = 1;
					System.out.println("Corea del Norte desde 1950 y Cuba desde 1962.");
					break;
				case 2:
					option = 2;
					System.out.println("Sudan es el pais con mas piramides del mundo.");
					break;
				case 3:
					option = 3;
					System.out.println("En Etiopia hay siete años de retraso.");
					break;
				case 4:
					option = 4;
					System.out.println("Francia es el pais mas visitado, con 89 millones de turistas anuales.");
					break;
				case 5:
					option = 5;
					System.out.println("Nueva Zelanda tiene la zona residencial más empinada del mundo.");
					break;
				case 6:
					option = 6;
					clientSocket.close();
					System.out.println("Muchas gracias por hablar con nostros, que tenga un buen dia");
					break;

				default:
					System.out.println("Elige uno de los numeros indicados en pantalla porfavor.");

				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
