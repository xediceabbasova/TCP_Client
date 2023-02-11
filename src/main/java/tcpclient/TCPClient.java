package tcpclient;

import com.mycompany.file.FileUtility;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;
import lombok.SneakyThrows;

public class TCPClient {

    @SneakyThrows
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("please enter your name:");
        String name = scanner.nextLine();
        System.out.println("please enter your surname:");
        String surname = scanner.nextLine();

        System.out.println("please enter the path of the file you want to send:");
        String path = scanner.nextLine();

        System.out.println("enter the ip and port of the server you want to send this image to:");
        String ip_port = scanner.nextLine();

        String[] arr = ip_port.split(":");
        String ip = arr[0];
        int port = Integer.parseInt(arr[1]);

        Socket socket = new Socket(ip, port);

        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
        byte[] bytes = FileUtility.readBytes(path);
        dataOutputStream.writeInt(bytes.length);
        dataOutputStream.write(bytes);
        socket.close();

    }
}
