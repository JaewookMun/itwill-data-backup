package xyz.itwill10.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xyz.itwill10.dao.PointUserDAO;
import xyz.itwill10.dto.PointUser;

@Service
public class PointUserServiceImpl implements PointUserService{

	@Autowired
	private PointUserDAO pointUserDAO;

	// ����� ������ ���޹޾� POINTUSER ���̺� �����Ͽ� �����ϰ� ����� ����� ������
	// �˻��Ͽ� ��ȯ�ϴ� �޼ҵ�
	@Override
	public PointUser addPointUser(PointUser user) {
		// ���޹��� ����� ������ �ߺ��� ��� ���� �߻� - ���̵� �ߺ� �˻�
		// => ���ܰ� �߻��� ��� �ϴܿ� �ۼ��� ��� �̽���
		if(pointUserDAO.selectPointUser(user.getId())!=null) {
			throw new RuntimeException("�̹� ��� ���� ���̵��Դϴ�.");
				// ���� ����� ���� Ŭ������ �����Ͽ� ����ó���ϴ� �� ���� eg) ExistUserException ��
				// ���� Ŭ������ ���� ���� ����ϴ� ���� ����. - RuntimeException�� �������� �����̴�.
		}
		
		pointUserDAO.insertPointUser(user);
		return pointUserDAO.selectPointUser(user.getId());
			// jdbc.connection - 3. Connection opened ó�� �޼ҵ尡 ����� ������
			// ���� SqlSession�� ����Ѵ�.
	}
}
