package xyz.itwill10.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import xyz.itwill10.dto.Student;
import xyz.itwill10.service.StudentService;

// Controller Ŭ���� : Ŭ���̾�Ʈ�� ��û�� ó���ϱ� ���� ����� �����ϴ� Ŭ����
// => ��û ó�� �޼ҵ忡���� Service Ŭ������ �޼ҵ带 ȣ���Ͽ� ��û ó��

// @Controller : Controller Ŭ������ Spring Bean���� ����ϴ� ������̼�
// => Ŭ���̾�Ʈ ��û�� ���� ó�� ����� �����޾� ���
// Spring Container�� ������̼��� ó���ϱ� ���� Bean Configuration File(servlet-context.xml)����
// component-scan ������Ʈ�� ����Ͽ� Service Ŭ������ �ۼ��� ��Ű���� ����
	// RequestMapping ��밡��
@Controller
// @RequestMapping ������̼��� Ŭ������ �����ϸ� ��� ��û ó�� �޼ҵ��� ��û URL �ּ� �պκп�
// ���������� ���ԵǴ� URL �ּ� ���� ����
@RequestMapping("/student")
public class StudentController {
	// Service Ŭ������ ��ϵ� Spring Bean�� �ʵ忡 ������ ó��
	// => ��û ó�� �޼ҵ忡�� Service ��ü�� �޼ҵ� ȣ�� ����
	@Autowired
	private StudentService studentService;

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add() {
		return "student/add_student";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(@ModelAttribute Student student, Model model) {
		try {
			// PK ���������� ������ �÷��� �ߺ��� ���� ���޵� ��� ���� �߻�
				// persistenct Exception? �ߺ��� ��� �ͼ��� �߻�
			studentService.addStudent(student);
		} catch (Exception e) {
			model.addAttribute("message", "�̹� ������� �й��� �Է��Ͽ����ϴ�.");
			return "add_student";
		}
		return "redirect:/student/display";
	}
	
	@RequestMapping("/display")
	public String display(Model model) {
		model.addAttribute("studentList", studentService.getStudentList());
		return "student/display_student";
	}
	
}