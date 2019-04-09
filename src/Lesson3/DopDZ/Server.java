package Lesson3.DopDZ;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

//Создать клиент и сервер.
//Далее создать класс Player
//Далее создать экземпляр класса Player, сереализовать объект, передать его по сети и десереализовать.

public class Server {

    private static Socket clientSocket; //сокет для общения
    private static ServerSocket server; // серверсокет
    private static BufferedReader in; // поток чтения из сокета
    private static ObjectInputStream ois;

    public static void main(String[] args) {
        new Server();

        try {
            String msgFromClient = in.readLine(); // ждём сообщение от клиента
            ois = new ObjectInputStream(new FileInputStream(msgFromClient));
            Player player = (Player) ois.readObject();
            player.info();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                ois.close();
                in.close();
                server.close();
                clientSocket.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private Server() {
        try {
            server = new ServerSocket(8190);
            System.out.println("Сервер запущен!");
            clientSocket = server.accept(); //ожидаем подключения клиента
            //поток, чтобы принимать сообщения
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}