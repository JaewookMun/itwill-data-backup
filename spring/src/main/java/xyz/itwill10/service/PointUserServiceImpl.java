package xyz.itwill10.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xyz.itwill10.dao.PointUserDAO;
import xyz.itwill10.dto.PointUser;

@Service
public class PointUserServiceImpl implements PointUserService{

	@Autowired
	private PointUserDAO pointUserDAO;

	// 사용자 정보를 전달받아 POINTUSER 테이블에 삽입하여 저장하고 저장된 사용자 정보를
	// 검색하여 반환하는 메소드
	@Override
	public PointUser addPointUser(PointUser user) {
		// 전달받은 사용자 정보가 중복될 경우 예외 발생 - 아이디 중복 검사
		// => 예외가 발생된 경우 하단에 작성된 명령 미실행
		if(pointUserDAO.selectPointUser(user.getId())!=null) {
			throw new RuntimeException("이미 사용 중인 아이디입니다.");
				// 본래 사용자 예외 클래스를 생성하여 예외처리하는 게 정석 eg) ExistUserException 등
				// 예외 클래스를 직접 만들어서 사용하는 것을 권장. - RuntimeException은 광범위한 예외이다.
		}
		
		pointUserDAO.insertPointUser(user);
		return pointUserDAO.selectPointUser(user.getId());
			// jdbc.connection - 3. Connection opened 처럼 메소드가 실행될 때마다
			// 개별 SqlSession을 사용한다.
	}
}
