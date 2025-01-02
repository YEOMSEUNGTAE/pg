import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class project2 {
    public static void main(String[] args) {
        BufferedReader in = null;
        PrintWriter out = null;

        Socket socket = null;
        Scanner scanner = new Scanner(System.in);

        try {
            socket = new Socket("127.0.0.1", 8000); // 서버에 연결
            System.out.println("[Client 실행] 서버에 연결 성공");

            in = new BufferedReader(new InputStreamReader(socket.getInputStream())); // 서버로부터 입력 받기
            out = new PrintWriter(socket.getOutputStream(), true); // 서버로 출력

            while (true) {
                System.out.print("전송하기>>> ");
                String outputMessage = scanner.nextLine(); // 사용자 입력
                out.println(outputMessage); // 서버로 메시지 전송
                if ("quit".equalsIgnoreCase(outputMessage)) break; // 종료 조건 확인

                String inputMessage = in.readLine(); // 서버로부터 메시지 수신
                if (inputMessage == null || "quit".equalsIgnoreCase(inputMessage)) { // 연결 종료 조건 확인
                    System.out.println("Server disconnected.");
                    break;
                }
                System.out.println("From Server: " + inputMessage);
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            try {
                if (in != null) in.close();
                if (out != null) out.close();
                if (socket != null) socket.close();
                scanner.close();
                System.out.println("서버 연결 종료");
            } catch (IOException e) {
                System.out.println("자원 해제 중 오류 발생: " + e.getMessage());
            }
        }
    }
}
