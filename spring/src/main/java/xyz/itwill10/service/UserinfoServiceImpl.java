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

// Service Ŭ������ �޼ҵ�� ���� ����� �߻��Ǵ� ������ ���� ���� �߻�
// => �߻��� ���ܴ� Controller Ŭ�������� ����ó���ϵ��� ����
	// ���ܸ� �߻����Ѽ� ���޸��ϴ� ���� -> ó���� ��Ʈ�ѷ��� �Ѵ�.
@Service
public class UserinfoServiceImpl implements UserinfoService {

	@Autowired
	private UserinfoDAO userinfoDAO;
	
	@Transactional
	@Override
	public void addUserinfo(Userinfo userinfo) throws UserinfoExistsException {
		// ���޹��� ȸ�������� ���̵� ���� ȸ���� ���̵�� �ߺ��� ��� ���� �߻�
		if(userinfoDAO.selectUserinfo(userinfo.getUserid())!=null) {
			throw new UserinfoExistsException("�̹� ������� ���̵� �Է� �Ͽ����ϴ�.", userinfo);
				// �����ڰ� �ۼ��� ���ܸ� �߻���Ų��.
		}
		
		// ����ڷκ��� �Է¹޾� ���޵� ��й�ȣ�� ��ȣȭ ��ȯ�Ͽ� �ʵ尪 ����
		// => ��û ó�� �޼ҵ忡�� ��ȣȭ ó���Ͽ� �ʵ尪 ���� ����
		// ��ȣȭ ����� �����ϴ� jbcrypt ���̺귯���� ���� ó���Ͽ� ��� - pom.xml
		// BCrypt.hashpw(String password, String salt) : ���޹��� ��й�ȣ�� ÷������ ������
		// �� ��ȣȭ ó���Ͽ� ��ȯ�ϴ� �޼ҵ�
		// BCrypt.genSalt(int log_bounds) : ÷������ ���̸� ���޹޾� ÷������ �����Ͽ� ��ȯ�ϴ� �޼ҵ�
		// => �Ű������� ������ �޼ҵ带 ȣ���� ��� ÷������ ���̴� �⺻��(10)���� �ڵ� ����
			// ��й�ȣ�� ��ȣȭ�ϴ� ÷���� ���� ���� �߰� - genSalt�� salt�� ���� ��������
			// ���� ���ڿ��� ���� ��ȣȭ ó������ �� ���� �ٸ� ���� ���� ����
			// ÷������ ���̰� ����� ��ȣȭ ó�� �ð��� ��������� �� ����������.
		userinfo.setPassword(BCrypt.hashpw(userinfo.getPassword(), BCrypt.gensalt()));
		
		
		userinfoDAO.insertUserinfo(userinfo);
			// �ߺ����� ���� �� ȸ�������� DB�� �Է��ϰڴ�.
			// JSP �н� �� ȸ�������� ������ �� ��й�ȣ�� ��ȣȭ�ϴ� �޼ҵ带 ����
			// => ���� ���̺귯�� ����
			// ��й�ȣ�� ��ȣȭ���� �����ϴ� ���� ����.
	}

	@Override
	public void modifyUserinfo(Userinfo userinfo) throws UserinfoNotFoundException {
		// ���޹��� ȸ�������� ���̵� ���� ȸ���� ���̵� �ƴ� ��� ���� �߻�
		if(userinfoDAO.selectUserinfo(userinfo.getUserid())==null) {
			throw new UserinfoNotFoundException("���̵��� ȸ�������� �������� �ʽ��ϴ�.");
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
			throw new UserinfoNotFoundException("���̵��� ȸ�������� �������� �ʽ��ϴ�.");
		}
		userinfoDAO.deleteUserinfo(userid);
	}

	@Override
	public Userinfo getUserinfo(String userid) throws UserinfoNotFoundException {
		Userinfo userinfo=userinfoDAO.selectUserinfo(userid);
		
		if(userinfo==null) {
			throw new UserinfoNotFoundException("���̵��� ȸ�������� �������� �ʽ��ϴ�.");
		}

		return userinfo;
	}
		// insert, delete, update sql�� ����ϴ� �޼ҵ带 ȣ������ �ʾұ� ������ Transactional ������̼��� �Ƚᵵ �ȴ�.

	@Override
	public List<Userinfo> getUseinfoList() {
		// TODO Auto-generated method stub
		return userinfoDAO.selectUserinfoList();
	}

	// �޼ҵ忡�� ���ܰ� �߻����� ���� ��� ���� ����
	@Override
	public void loginAuth(Userinfo userinfo) throws LoginAuthFailException {
		Userinfo authUserinfo=userinfoDAO.selectUserinfo(userinfo.getUserid());
		if(authUserinfo==null) { // ���̵� ���� ���� - ���� �߻�
			throw new LoginAuthFailException("���̵��� ȸ�������� �������� �ʽ��ϴ�.", userinfo.getUserid());
		}
		
		// BCrypt.checkpw(String plainText, String hashed) : �Ϲ� ���ڿ��� ��ȣ ó����
		// ���ڿ��� ���Ͽ� �ٸ� ��� false�� ��ȯ�ϰ� ���� ��� true�� ��ȯ�ϴ� �޼ҵ�
			// ���޹��� ��й�ȣ�� ������ ��ȣȭ�� ��й�ȣ�� ���ϴ� �޼ҵ� 
		if(!BCrypt.checkpw(userinfo.getPassword(), authUserinfo.getPassword())) { // ��й�ȣ ���� ���� = ���� ����
			throw new LoginAuthFailException("���̵� ���ų� ��й�ȣ�� ���� �ʽ��ϴ�.", userinfo.getUserid());
		}
		
			// �����Ѵٸ� ������ �α��� ��¥�� �����ϴ� �޼ҵ带 ȣ���Ͽ� �α��γ�¥�� �����Ѵ�.
	}

}