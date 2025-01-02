import mysql.connector

# MySQL 연결 설정
conn = mysql.connector.connect(
    host="localhost",      # MySQL 서버 주소 (예: localhost)
    user="root",  # MySQL 사용자 이름
    password="0000",  # MySQL 비밀번호
    database="mydb"  # 사용할 데이터베이스 이름
)

# 연결 성공 여부 확인
if conn.is_connected():
    print("MySQL에 연결되었습니다.")

# 커서 객체 생성
cursor = conn.cursor()

# 예시 쿼리 실행 (테이블 조회)
cursor.execute("SELECT * FROM num")

# 데이터 출력
rows = cursor.fetchall()
for row in rows:
    print(row)

# 연결 종료
cursor.close()
conn.close()

print('\n'.join([' '.join([f"{i}x{j}={i*j}" for j in range(1, 10)]) for i in range(2, 10)]))
