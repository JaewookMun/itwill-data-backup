package xyz.itwill10.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// Tiles : 템플릿 페이지를 이용한 사이트 구현을 제공한느 프로그램
// 1. Tiles 관련 라이브러리 빌드 처리 - pom.xml
// 2. 요청 처리 메소드에서 반환되는 ViewName을 Tiles 프로그램으로 응답되도록 ViewResolver 설정 - servlet-context.xml
// 3. Tiles Configuration File(tiles.xml) 작성 - 요청 처리 메소드에서 반환되는 ViewName에 대한 응답 템플릿 설정
	// 템플릿페이지 - 모든 응답을 처리
	// InternalResourceViewResolver를 사용하지 않고 Tile을 활용하여 응답되도록 처리 - Tiles
@Controller
public class TilesController {
	@RequestMapping("/")
	public String tiles() {
		return "main";
	}
		// context 루트를 요청하면 main 반환
	
	@RequestMapping("/admin")
	public String tilesAdmin() {
		return "admin";
	}
	
	@RequestMapping("/admin/member")
	public String tilesAdminMember() {
		return "admin/member_manager";
	}
}
