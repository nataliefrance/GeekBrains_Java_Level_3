package Lesson3.DopDZ;

import java.io.*;
import java.net.Socket;

public class Client {

    private static Socket clientSocket;
    private static BufferedWriter out; //поток записи в сокет
    private static ObjectOutputStream oos;

    public static void main(String[] args) {
        new Client();
        Player player = new Player("Gamer1", 10, "male");
        player.info();

        try {
            String serPlayer = player.getNickname() + ".ser";
            oos = new ObjectOutputStream(new FileOutputStream(serPlayer));
            oos.writeObject(player);
            //отправляем сообщение на сервер
            out.write(serPlayer);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                oos.close();
                out.close();
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private Client() {
        try {
            //запрашиваем у сервера доступ на соединение
            clientSocket = new Socket("localhost", 8190);
            System.out.println("Клиент подключился!");
            out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
