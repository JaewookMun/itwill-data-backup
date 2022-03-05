package xyz.itwill10.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

// ��û ó�� �޼ҵ��� ó������� ��������(JSP)���� �����ϴ� ���
// 1. ModelAndView ��ü�� �̿��Ͽ� ó����� ����
// => ��û ó�� �޼ҵ�� �ݵ�� ModelAndView ��ü ��ȯ
// 2. HttpServletRequest ��ü�� ó������� �Ӽ������� �����Ͽ� ���� 
// 3. Model ��ü�� ó������� �Ӽ������� �����Ͽ� ���� 
	// 3��° ����� ���� ����

@Controller
public class ResultController {
	/*
	@RequestMapping("/resultMVC")
	public ModelAndView modelAndViewResult() {
		ModelAndView modelAndView=new ModelAndView("result_display");
		// ModelAndView.addObject(String attributeName, Object attributeValue)
		// => ������������ ��� �����ϵ��� ó�����(��ü)�� �����ϴ� �޼ҵ� - Request Scope
			// Ư���� ��찡 �ƴϸ� ��� Request Scope�� ����ȴ�.
		modelAndView.addObject("mavName", "ȫ�浿");
		return modelAndView;
	}
	*/
	
	// ��ûó�� �޼ҵ�� Front Controller�� ���� �ڵ� ȣ��Ǵ� �޼ҵ�
	// => ��ûó�� �޼ҵ忡 �Ű������� �ۼ��ϸ� Spring Container�κ��� Spring Bean ��ü�� 
	// �����޾� �ڵ� ����
		// �ʿ��� ��ü�� �ִٸ� ����� ����ص� ������(����Ŭ����), 
		// Spring Container�� �����ϰ� �ִ� ��ü�� ���� �����޾� �������ش�.
	@RequestMapping("/resultMVC")
	public ModelAndView modelAndViewResult(ModelAndView modelAndView) {
		modelAndView.setViewName("result_display");
		modelAndView.addObject("mavName", "ȫ�浿");
		return modelAndView;
		
	}
		/*
			����(desktop application)���� getBean()�� ���������,
			web������ Spring Container�� �����ϰ� �ִ� Spring bean ��ü�� ���޹��� �� �ִ�.
			Spring Container���� ���� �� �ִ� ��ü �� �ϳ���
			ModelAndView ��ü�̴�.
		 */
	
	@RequestMapping("/resultRequest")
	public String requestResult(HttpServletRequest request) {
		request.setAttribute("requestName", "�Ӳ���");
		
		return "result_display";
	}
		// -> �� �������� �ʴ´�. �ܼ��� �Ӽ����� �����ϱ� ���� ������ ����. - �پ��� �������� ����Ǿ� ����.
		// HttpServletRequest Ŭ���̾�Ʈ�� ��û���� ������ ��� ���޵ȴ�.
		// �Ӽ����� �����ϱ� ���� ���ʿ��� ������ ���� �����´�. (��Ű, ��û��� ��.)
	
	
	// Model : ó������� �����ϱ� ���� ��ü(ModelMap)
		// ModelAndView�� Model�� ���� �Ŷ�� ����ȴ�.
	@RequestMapping("/resultModel")
	public String modelResult(Model model) {
		// Model.addAttribute(String attributeName, Object attributeValue)
		// => ������������ ��� �����ϵ��� ó�����(��ü)�� �����ϴ� �޼ҵ� - Request Scope
		model.addAttribute("modelName", "����ġ");
		return "result_display";
	}
}
