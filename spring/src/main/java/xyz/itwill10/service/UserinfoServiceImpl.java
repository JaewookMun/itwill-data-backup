package xyz.itwill10.service;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xyz.itwill10.dao.UserinfoDAO;
import xyz.itwill10.dto.Userinfo;
import xyz.itwill10.exception.LoginAuthFailException;
import xyz.itwill10.exception.UserinfoExistsException;
import xyz.itwill10.exception.UserinfoNotFoundException;

// Service 클래스의 메소드는 명령 실행시 발생되는 문제에 대한 예외 발생
// => 발생된 예외는 Controller 클래스에서 예외처리하도록 전달
	// 예외를 발생시켜서 전달만하는 역할 -> 처리는 컨트롤러가 한다.
@Service
public class UserinfoServiceImpl implements UserinfoService {

	@Autowired
	private UserinfoDAO userinfoDAO;
	
	@Transactional
	@Override
	public void addUserinfo(Userinfo userinfo) throws UserinfoExistsException {
		// 전달받은 회원정보의 아이디가 기존 회원의 아이디와 중복되 경우 예외 발생
		if(userinfoDAO.selectUserinfo(userinfo.getUserid())!=null) {
			throw new UserinfoExistsException("이미 사용중인 아이디를 입력 하였습니다.", userinfo);
				// 개발자가 작성한 예외를 발생시킨다.
		}
		
		// 사용자로부터 입력받아 전달된 비밀번호를 암호화 변환하여 필드값 변경
		// => 요청 처리 메소드에서 암호화 처리하여 필드값 변경 가능
		// 암호화 기능을 제공하는 jbcrypt 라이브러리를 빌드 처리하여 사용 - pom.xml
		// BCrypt.hashpw(String password, String salt) : 전달받은 비밀번호에 첨가물을 삽입한
		// 후 암호화 처리하여 반환하는 메소드
		// BCrypt.genSalt(int log_bounds) : 첨가물의 길이를 전달받아 첨가물을 생성하여 반환하는 메소드
		// => 매개변수가 생략된 메소드를 호출한 경우 첨가물의 길이는 기본값(10)으로 자동 설정
			// 비밀번호를 암호화하는 첨가물 같은 것을 추가 - genSalt로 salt의 길이 수정가능
			// 같은 문자열을 각각 암호화 처리했을 때 서로 다른 값을 저장 가능
			// 첨가물의 길이가 길수록 암호화 처리 시간은 길어지지만 더 복잡해진다.
		userinfo.setPassword(BCrypt.hashpw(userinfo.getPassword(), BCrypt.gensalt()));
		
		
		userinfoDAO.insertUserinfo(userinfo);
			// 중복되지 않을 때 회원정보를 DB에 입력하겠다.
			// JSP 학습 시 회원정보를 저장할 때 비밀번호를 암호화하는 메소드를 생성
			// => 관련 라이브러리 빌드
			// 비밀번호는 암호화시켜 저장하는 것을 권장.
	}

	@Override
	public void modifyUserinfo(Userinfo userinfo) throws UserinfoNotFoundException {
		// 전달받은 회원정보의 아이디가 기존 회원의 아이디가 아닌 경우 예외 발생
		if(userinfoDAO.selectUserinfo(userinfo.getUserid())==null) {
			throw new UserinfoNotFoundException("아이디의 회원정보가 존재하지 않습니다.");
		}
		
		String password=userinfo.getPassword();
		if(password!=null && !password.equals("")) {
			userinfo.setPassword(BCrypt.hashpw(userinfo.getPassword(), BCrypt.gensalt()));
		}
		
		userinfoDAO.updateUserinfo(userinfo);
	}

	@Transactional
	@Override
	public void removeUserinfo(String userid) throws UserinfoNotFoundException {
		if(userinfoDAO.selectUserinfo(userid)==null) {
			throw new UserinfoNotFoundException("아이디의 회원정보가 존재하지 않습니다.");
		}
		userinfoDAO.deleteUserinfo(userid);
	}

	@Override
	public Userinfo getUserinfo(String userid) throws UserinfoNotFoundException {
		Userinfo userinfo=userinfoDAO.selectUserinfo(userid);
		
		if(userinfo==null) {
			throw new UserinfoNotFoundException("아이디의 회원정보가 존재하지 않습니다.");
		}

		return userinfo;
	}
		// insert, delete, update sql을 사용하는 메소드를 호출하지 않았기 때문에 Transactional 어노테이션을 안써도 된다.

	@Override
	public List<Userinfo> getUseinfoList() {
		// TODO Auto-generated method stub
		return userinfoDAO.selectUserinfoList();
	}

	// 메소드에서 예외가 발생되지 않은 경우 인증 성공
	@Override
	public void loginAuth(Userinfo userinfo) throws LoginAuthFailException {
		Userinfo authUserinfo=userinfoDAO.selectUserinfo(userinfo.getUserid());
		if(authUserinfo==null) { // 아이디 인증 실패 - 예외 발생
			throw new LoginAuthFailException("아이디의 회원정보가 존재하지 않습니다.", userinfo.getUserid());
		}
		
		// BCrypt.checkpw(String plainText, String hashed) : 일반 문자열과 암호 처리된
		// 문자열을 비교하여 다른 경우 false를 반환하고 같은 경우 true를 반환하는 메소드
			// 전달받은 비밀번호를 내부의 암호화된 비밀번호와 비교하는 메소드 
		if(!BCrypt.checkpw(userinfo.getPassword(), authUserinfo.getPassword())) { // 비밀번호 인증 실패 = 인증 실패
			throw new LoginAuthFailException("아이디가 없거나 비밀번호가 맞지 않습니다.", userinfo.getUserid());
		}
		
			// 존재한다면 마지막 로그인 날짜를 변경하는 메소드를 호출하여 로그인날짜를 지정한다.
	}

}
