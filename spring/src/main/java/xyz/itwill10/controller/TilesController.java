package xyz.itwill10.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// Tiles : ���ø� �������� �̿��� ����Ʈ ������ �����Ѵ� ���α׷�
// 1. Tiles ���� ���̺귯�� ���� ó�� - pom.xml
// 2. ��û ó�� �޼ҵ忡�� ��ȯ�Ǵ� ViewName�� Tiles ���α׷����� ����ǵ��� ViewResolver ���� - servlet-context.xml
// 3. Tiles Configuration File(tiles.xml) �ۼ� - ��û ó�� �޼ҵ忡�� ��ȯ�Ǵ� ViewName�� ���� ���� ���ø� ����
	// ���ø������� - ��� ������ ó��
	// InternalResourceViewResolver�� ������� �ʰ� Tile�� Ȱ���Ͽ� ����ǵ��� ó�� - Tiles
@Controller
public class TilesController {
	@RequestMapping("/")
	public String tiles() {
		return "main";
	}
		// context ��Ʈ�� ��û�ϸ� main ��ȯ
	
	@RequestMapping("/admin")
	public String tilesAdmin() {
		return "admin";
	}
	
	@RequestMapping("/admin/member")
	public String tilesAdminMember() {
		return "admin/member_manager";
	}
}
