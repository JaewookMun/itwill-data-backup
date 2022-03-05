package xyz.itwill10.service;

import java.util.List;

import xyz.itwill10.dto.Userinfo;
import xyz.itwill10.exception.LoginAuthFailException;
import xyz.itwill10.exception.UserinfoExistsException;
import xyz.itwill10.exception.UserinfoNotFoundException;

	// 예외를 만들어서 전달할 수 있도록.
public interface UserinfoService {
	void addUserinfo(Userinfo userinfo) throws UserinfoExistsException;
	void modifyUserinfo(Userinfo userinfo) throws UserinfoNotFoundException;
	void removeUserinfo(String userid) throws UserinfoNotFoundException;
	Userinfo getUserinfo(String userid) throws UserinfoNotFoundException;
	List<Userinfo> getUseinfoList();
	void loginAuth(Userinfo userinfo) throws LoginAuthFailException;
		// 인증을 위한 메소드
}
