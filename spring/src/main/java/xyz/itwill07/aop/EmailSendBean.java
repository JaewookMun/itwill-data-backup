package xyz.itwill07.aop;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;

// 메일 전송 기능을 제공하는 클래스
	// 메일서버(메일 기능을 제공하는 컴퓨터-smtp(전송)/pop3(수신서비스 제공)
	// 메일서버가 있어야 메일 기능을 사용할 수 있음.
	// 서버용 운영체제가 아니기 때문에 메일서버를 만들 수 없다. 서버용 운영체제가 있어야함. 리눅스, 유닉스 등. Window는 client용
	// 도메인도 있어야 이메일 서버를 만들 수 있음 (서버용 os, 도메인서버, 이메일 서버) 
public class EmailSendBean {
	// 메일을 전송하는 JavaMailSender 객체를 저장하는 필드
		// EmailSendBean이 직접 메일을 보내지 않는다. - 메일을 보내기위한 환경을 설정
		// 실제로 메일을 보내는 것은 JavaMailSender(JavaMailSenderImpl)이다.
	private JavaMailSender mailSender;

	public JavaMailSender getMailSender() {
		return mailSender;
	}

	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}
	
	// 메일을 전송하는 메소드 - 핵심관심모듈
	// => 받는 사람 이메일 주소, 제목, 내용을 매개변수로 전달받아 저장
	// => 받는 사람 이메일 주소를 반환 - 메세지 출력 (원래는 '기록'으로 표기)
	public String sendEmail(String email, String subject, String content) {
		// JavaMailSender.createMimeMessage() : MimeMessage 객체를 반환하는 메소드
		// MimeMessage : 메일 전송 관련 정보를 저장하기 위한 객체
		MimeMessage message=mailSender.createMimeMessage();
		
		try {
			// MimeMessage.setSubject(String subject) : MimeMessage 객체에서 메일 제목을 변경하는 메소드
			message.setSubject(subject);
			
			// MimeMessage.setText(String content) : MimeMessage 객체에서 메일 내용(텍스트)을 변경하는 메소드
				// setContent - 첨부파일을 보낼 때 사용 setText는 내용(글)만 보낼 때 사용
			message.setText(content);
			
			// MimeMessage.setRecipients(RecipientType type, InternetAddress email)
			// => MimeMessage 객체의 메일을 받는 사용자에 대한 정보를 변경하는 메소드
			// => 받는 사람의 이메일 주소는 InternetAddress 객체 대신 문자열(String) 가능
			// InternetAddress.parse(String email) : 문자열을 전달받아 InternetAddress 객체로 변환하여 반환하는 메소드
				// 일반적으로 한명한테 전송할 때는 문자열 대신 InternetAddress로 파싱시켜서 보냄
			message.setRecipients(MimeMessage.RecipientType.TO, InternetAddress.parse(email));
			
			// JavaMailSender.send(MimeMessage message) : JavaMailSender 객체로 메일을 전송하는 메소드
			mailSender.send(message);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
		return email;
	}
	
}
