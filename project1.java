import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class project1 {
    public static void main(String[] args) {
        BufferedReader in = null;
        PrintWriter out = null;

        ServerSocket serverSocket = null;
        Socket socket = null;
        Scanner scanner = new Scanner(System.in);

        try {
            serverSocket = new ServerSocket(8000); // 서버 소켓 생성
            System.out.println("[Server 실행] Client 연결 대기중...");
            socket = serverSocket.accept(); // 클라이언트 연결 대기
            System.out.println("Client 연결됨");

            in = new BufferedReader(new InputStreamReader(socket.getInputStream())); // 클라이언트로부터 입력 받기
            out = new PrintWriter(socket.getOutputStream(), true); // 클라이언트로 출력

            while (true) {
                String inputMessage = in.readLine(); // 클라이언트로부터 메시지 수신
                if (inputMessage == null || "quit".equalsIgnoreCase(inputMessage)) { // 연결 종료 조건 확인
                    System.out.println("Client disconnected.");
                    break;
                }
                System.out.println("From Client: " + inputMessage);

                System.out.print("전송하기>>> ");
                String outputMessage = scanner.nextLine();
                out.println(outputMessage); // 클라이언트로 메시지 전송
                if ("quit".equalsIgnoreCase(outputMessage)) break;
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            try {
                if (in != null) in.close();
                if (out != null) out.close();
                if (socket != null) socket.close();
                if (serverSocket != null) serverSocket.close();
                scanner.close();
                System.out.println("연결종료");
            } catch (IOException e) {
                System.out.println("자원 해제 중 오류 발생: " + e.getMessage());
            }
        }
    }
}
