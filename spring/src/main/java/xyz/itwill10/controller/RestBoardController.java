package xyz.itwill10.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.HtmlUtils;

import xyz.itwill10.dto.RestBoard;
import xyz.itwill10.service.RestBoardService;
import xyz.itwill10.util.Pager;

// REST ����� �����ϴ� ��û ó�� �޼ҵ忡 ���� JSON ���� ����� Ȯ���ϱ� ���� Advanced REST
// Client ũ������ ��ġ�Ͽ� REST ���α׷� �׽�Ʈ
	// ũ�� �÷����� - REST �׽�Ʈ ���α׷� (���忡���� ���� ����.)

// ��û ó�� �޼ҵ��� ��û ��� - method �Ӽ���
// => RequestMethod �ڷ���(Enum)�� ����� �̿��Ͽ� ǥ��
// GET(�˻�), POST(����), PUT(��ü ����), PATCH(�κ� ����), DELETE(����) ��
	// PUT, PATCH, DELETE�� POST�� �ڽ��̶�� ����ȴ�. (��ӹ޾� ����)
	// ��� POST��� ���� �ȴ�. �޼ҵ�Ӽ��� ���� � ������� �����ϱ� ���� ����ȭ.
	// PUT, PATCH, DELETE�� ���� explorer�� �ν� ���� �� �ִ�.
@Controller
// @RestController : ��� ��û ó�� �޼ҵ��� ��ȯ������ ����ǵ��� �����ϴ� ������̼�
// => ��û ó�� �޼ҵ忡�� @ResponseBody ������̼��� ������� �ʾƵ� �޼ҵ� ��ȯ������ ����
// => Rest ���񽺸� �����ϴ� ��Ʈ�ѷ� Ŭ������ �ۼ��� ��� ���
	// ViewResolver�� �������� �ʴ´�.
	// restBoard()�� ViewResolver�� ���� �����ϱ� ������ @RestController�� ����� �� ����.
public class RestBoardController {
	
	@Autowired
	private RestBoardService restBoardService;
	
	@RequestMapping("/board")
	public String restBoard() {
		return "rest/board";
	}
	
	// REST_BOARD ���̺� ����� �Խñ� ����� �˻��Ͽ� JSON ������ �ؽ�Ʈ�� �����ϴ� ��û ó�� �޼ҵ�
	// => �Խñ� ����� ����¡ ó���Ͽ� ����ǵ��� �ۼ�
	@RequestMapping(value = "/board_list", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> restBoardList(@RequestParam(defaultValue="1") int pageNum){
			// pageNum���� ���޵� ���� ������ 1�� �ǰ� ����
		// System.out.println("pageNum = "+pageNum);
		
		// REST_BOARD ���̺� ����� ��� �Խñ��� ������ ��ȯ�޾� ����
		int totalBoard=restBoardService.getRestBoardCount();
		int pageSize=5; // �� �������� ��µ� �Խñ��� ���� ����
		int blockSize=5; // �� ���� ��µ� ������ ��ȣ�� ���� ����
			// ������ ���Ƿ� �ϴ��� pageSize�� ���ް����� �ص���
		
		// ����¡ ó�� ���� ���� �����ϴ� Pager ��ü�� �����Ͽ� ����
		Pager pager=new Pager(pageNum, totalBoard, pageSize, blockSize);
		
		// RestBoardService Ŭ������ �޼ҵ� ȣ���� ���� �Ű������� �����ϱ� ���� Map ��ü ����
		// => ��û �������� ���� ���ȣ�� ���� ���ȣ�� Map ��ü�� ��Ʈ���� �����Ͽ� SQL ��ɿ� ����
		Map<String, Object> pagerMap=new HashMap<String, Object>();
		pagerMap.put("startRow", pager.getStartRow());
		pagerMap.put("endRow", pager.getEndRow());
		
		// ��û ó�� �޼ҵ��� ��ȯ���� ����ϴ� Map ��ü ����
		// => �Խñ� ��ϰ� ����¡ ó�� ���� ���� Map ��ü�� ��Ʈ���� �����Ͽ� ��ȯ - JSON
		Map<String, Object> returnMap=new HashMap<String, Object>();
		returnMap.put("restBoardList", restBoardService.getRestBoardList(pagerMap));
		returnMap.put("pager", pager);
		
		return returnMap;
			// JSON���� �����ϱ� ���ؼ� Map ���
			// �ƴ� ���(JSP�� return �Ѵٸ�) Model ��ü�� ����ؼ� ���ް��� - Model.addAttribute
	}
	
	
	
	// �Խñ��� ���޹޾� REST_BOARD ���̺� �����Ͽ� �����ϰ� �ؽ�Ʈ�� �����ϴ� ��û ó�� �޼ҵ�
	// => @RequestBody ������̼��� �̿��Ͽ� ��� ���ް��� �Ű������� ����
	// => �Ű������� �ڷ����� JavaBean�� ��� ���ް��� �̸��� ���� �̸��� �ʵ忡 ���ް��� �ڵ� ����
	@RequestMapping(value = "/board_add", method = RequestMethod.POST)
	@ResponseBody
	public String restBoardAdd(@RequestBody RestBoard board) {
		
		// HtmlUtils.htmlEscape(String str) : �Ű������� ���޹��� ���ڿ����� HTML �±� ����
		// ���ڸ� Escape ���ڷ� ��ȯ�Ͽ� ��ȯ�ϴ� �޼ҵ� - XSS ���ݿ� ���� ���
			// ����� �Է°� �� ��ȿ�� �˻縦 ���� �ʴ� �͵��� �̸� ����Ͽ� ��ũ��Ʈ�� Ȱ���� ���ݿ� ���
		board.setContent(HtmlUtils.htmlEscape(board.getContent()));
		restBoardService.addRestBoard(board);
		return "success";
	}
		
		// �� �޼ҵ忡�� �Ű������� ��ü�� Ŀ�ǵ� ��ü�� �� ���޹�İ� �ٸ���. 
		// JSON ���� ���޵� ������ ��ü�� ���εǴ� ��� 
	
		// JSON ������ ���ڿ��� �޾ƿ� RequestBody�� ��ü�� �����Ѵ�.
		// ��� �����͸� ����� ������. (���������Ͱ� �ƴ� ���)
		// smart ��⿡���� ��κ� �����͸� ����� ������. (JSON)
		// JSON���� ���� �����͵��� �ޱ����ؼ� RequestBody�� ����ؾ���.
		// Ajax�� �̿��ؼ� @ModelAttribute & @RequestBody�� ���Ͽ� �����͸� ���� ����� ���� �ٸ���.
	
	/*
	// �۹�ȣ�� ���޹޾� REST_BOARD ���̺� ����� �ش� �۹�ȣ�� �Խñ��� �˻��Ͽ� JSON ������
	// �ؽ�Ʈ�� �����ϴ� ��û ó�� �޼ҵ� - QueryString�� �̿��Ͽ� �۹�ȣ ����
	@RequestMapping(value="/board_view", method = RequestMethod.GET)
	@ResponseBody
	public RestBoard restBoardView(@RequestParam int num) {
		return restBoardService.getRestBoard(num);
	}
	*/
	
	// �۹�ȣ�� ���޹޾� REST_BOARD ���̺� ����� �ش� �۹�ȣ�� �Խñ��� �˻��Ͽ� JSON ������
	// �ؽ�Ʈ�� �����ϴ� ��û ó�� �޼ҵ� - ��û URL �ּҸ� �̿��Ͽ� �۹�ȣ ����
	// @RequestMapping ������̼ǿ��� ���ε� ��û URL �ּҿ� {������} �������� ���� ǥ���Ͽ� ��û
	// => @PathVariable ������̼��� ����Ͽ� URL �ּҸ� ������ �����޾� �Ű������� ����
	// => �ĺ��ڸ� ���޹޾� �˻��ϰų� ������ �� ���
		// ���� ���� ���� - URL�ּҷ� ���� ���� /
	@RequestMapping(value="/board_view/{num}", method = RequestMethod.GET)
	@ResponseBody
	// @PathVariable : ��û URL �ּҷ� ǥ���� ���� ���޹޾� �Ű������� �����ϴ� ������̼�
	// => ��û URL �ּҿ� ǥ���� ������� �Ű������� �̸��� �����ؾ߸� ���� ���޹޾� ����
	// => ��û URL �ּҷ� ǥ���� ������� �Ű������� �̸��� �ٸ� ��� @PathVariable ������̼���
	// value �Ӽ������� URL �ּ��� ���� ���޹޾� �Ű������� ���� ���� 
		// URL�ּҷ� ǥ���� ������� �Ű������� �̸��� �����ϰ� �ϴ� ���� �����Ѵ�.
	public RestBoard restBoardView(@PathVariable int num) {
		return restBoardService.getRestBoard(num);
	}
		// ���� ���� ���Ǵ� ���
		// QueryString�� ������..

	
	// �Խñ��� ���޹޾� REST_BOARD ���̺� ����� �Խñ��� �����ϰ� �ؽ�Ʈ�� �����ϴ� ��û ó�� �޼ҵ�
	// => ��û����� �������� ��� method �Ӽ����� {} �ȿ� �����Ͽ� �ۼ�
	@RequestMapping(value="/board_modify", method = {RequestMethod.PUT, RequestMethod.PATCH})
		// PUT - correct (���ø� ���� patch �߰�)
	@ResponseBody
	public String restBoardModify(@RequestBody RestBoard board) {
		restBoardService.modifyRestBoard(board);
		return "success";
		
	}
	/*
		public @ResponseBody String ~
		@ResponseBody�� ��ȯ�� �տ� ����ϴ� ��쵵 ����. -> ���� �����ϴ�.(���� ����� ���)
	*/
	
	// �۹�ȣ�� ���޹޾� REST_BOARD ���̺� ����� �ش� �۹�ȣ�� �Խñ��� �����ϰ� �ؽ�Ʈ��
	// �����ϴ� ��û ó�� �޼ҵ� - ��û URL �ּҸ� �̿��Ͽ� �۹�ȣ ����
	@RequestMapping(value="/board_remove/{num}", method = RequestMethod.DELETE)
	@ResponseBody
	public String restBoardRemover(@PathVariable int num) {
		restBoardService.removeRestBoard(num);
		return "success";
	}
}
