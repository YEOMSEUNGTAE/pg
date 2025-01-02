import java.awt.Container;
import javax.swing.*;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
//import java.awt.image.ImageObserver;
import java.awt.Image;


public class MyFrame1 extends JFrame {
    public MyFrame1() {
        setTitle("서버-클라이언트 1:1 채팅 프로그램");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(550, 300);

        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        // 제목 레이블
        JLabel lblNewLabel = new JLabel("서버-클라이언트 소켓 통신을 활용한 1:1 채팅 프로그램");
        lblNewLabel.setFont(new Font("Malgun Gothic", Font.PLAIN, 18)); // 폰트 스타일이 정확한지 확인
        lblNewLabel.setBounds(50, 110, 700, 21);
        contentPane.add(lblNewLabel);
        contentPane.setBackground(Color.WHITE);

        String imagePath = "C:\\Users\\tmdxo\\Desktop\\염승태\\png\\채팅 이미지.png";
        
        // 이미지 불러오기
        ImageIcon originalIcon = new ImageIcon(imagePath);
        Image originalImage = originalIcon.getImage(); // Image 객체로 변환
        
        // 원하는 크기로 이미지 크기 조정
        int newWidth = 100; // 새 너비
        int newHeight = 80; // 새 높이
        Image scaledImage = originalImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
        
        // 크기 조정된 이미지를 다시 ImageIcon으로 변환
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        
        // 이미지를 JLabel에 넣기
        JLabel imageLabel = new JLabel(scaledIcon);
        imageLabel.setBounds(350, 40, newWidth, newHeight);  // 위치와 크기 설정
        
        // 이미지를 contentPane에 추가
        contentPane.add(imageLabel);

        // 아이디 레이블
        JLabel lblId = new JLabel("아이디:");
        lblId.setBounds(133, 150, 60, 20); // 아이디 레이블 위치
        contentPane.add(lblId);

        // 아이디 입력 필드
        JTextField textField = new JTextField();
        textField.setBounds(190, 150, 150, 21); // 아이디 입력 필드 위치
        contentPane.add(textField);
        textField.setColumns(10);

        // 비밀번호 레이블
        JLabel lblPassword = new JLabel("비밀번호:");
        lblPassword.setBounds(120, 180, 60, 20); // 비밀번호 레이블 위치
        contentPane.add(lblPassword);

        // 비밀번호 입력 필드 (JPasswordField 사용)
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(190, 180, 150, 21); // 비밀번호 입력 필드 위치
        contentPane.add(passwordField);

       // 로그인 버튼
        JButton btnLogin = new JButton("로그인");
        btnLogin.setBounds(165, 220, 80, 23);
        btnLogin.setBackground(Color.decode("#FFC000"));  // 버튼 배경색 노란색으로 설정
        btnLogin.setFont(new Font("Malgun Gothic", Font.PLAIN, 12)); // 글자 크기 설정
        contentPane.add(btnLogin);
 
        // 회원가입 버튼
        JButton btnSignUp = new JButton("회원가입");
        btnSignUp.setBounds(255, 220, 85, 23);
        btnSignUp.setBackground(Color.decode("#FFC000"));   // 버튼 배경색 노란색으로 설정
        btnSignUp.setFont(new Font("Malgun Gothic", Font.PLAIN, 12)); // 글자 크기 설정
        contentPane.add(btnSignUp);
        
        btnSignUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SignUpFrame(); // SignUpFrame 창 열기
            }
        });
        setVisible(true);
    }

    class SignUpFrame extends JFrame {
        public SignUpFrame() {
            setTitle("회원가입");
            setSize(350, 300);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // 이 창만 닫을 때 프로그램 종료 안됨
    
            Container contentPane = getContentPane();
            contentPane.setLayout(null);
    
            // 배경 색을 하얀색으로 설정
            contentPane.setBackground(Color.WHITE);
    
            // 아이디 입력 필드
            JLabel lblId = new JLabel("아이디:");
            lblId.setBounds(55, 30, 60, 20);
            contentPane.add(lblId);
            JTextField textId = new JTextField();
            textId.setBounds(100, 30, 150, 20);
            contentPane.add(textId);
    
            // 이름 입력 필드
            JLabel lblName = new JLabel("이름:");
            lblName.setBounds(65, 60, 60, 20);
            contentPane.add(lblName);
            JTextField textName = new JTextField();
            textName.setBounds(100, 60, 150, 20);
            contentPane.add(textName);
    
            // 전화번호 입력 필드
            JLabel lblPhone = new JLabel("전화번호:");
            lblPhone.setBounds(40, 90, 60, 20);
            contentPane.add(lblPhone);
            JTextField textPhone = new JTextField();
            textPhone.setBounds(100, 90, 150, 20);
            contentPane.add(textPhone);
    
            // 비밀번호 입력 필드
            JLabel lblPassword = new JLabel("비밀번호:");
            lblPassword.setBounds(40, 120, 60, 20);
            contentPane.add(lblPassword);
            JPasswordField passwordField = new JPasswordField();
            passwordField.setBounds(100, 120, 150, 20);
            contentPane.add(passwordField);
    
            // 비밀번호 확인 입력 필드
            JLabel lblConfirmPassword = new JLabel("비밀번호 확인:");
            lblConfirmPassword.setBounds(10, 150, 100, 20);
            contentPane.add(lblConfirmPassword);
            JPasswordField confirmPasswordField = new JPasswordField();
            confirmPasswordField.setBounds(100, 150, 150, 20);
            contentPane.add(confirmPasswordField);
    
            // 회원가입 버튼
            JButton btnSignUpComplete = new JButton("가입하기");
            btnSignUpComplete.setBounds(120, 190, 90, 23);
            btnSignUpComplete.setFont(new Font("Malgun Gothic", Font.PLAIN, 12));
            btnSignUpComplete.setBackground(Color.decode("#FFC000")); // 이 부분을 수정하여 btnSignUpComplete에 폰트를 설정합니다.
            contentPane.add(btnSignUpComplete);
            
            setVisible(true);
        }
    }
    public static void main(String[] args) {
        new MyFrame1(); // 변수 선언 추가
    }
}
