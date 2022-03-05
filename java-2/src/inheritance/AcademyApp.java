package inheritance;

//�п� �����ڿ�(�л�, ����, ����) ���� ���α׷�
public class AcademyApp {
	public static void main(String[] args) {
		/*
		//�л������� �����ϱ� ���� ��ҵ��� �����ϴ� �迭 ����
		AcademyStudent[] students = new AcademyStudent[300];
		
		//���������� �����ϱ� ���� ��ҵ��� �����ϴ� �迭 ����
		AcademyInstructor[] instructors = new AcademyInstructor[50];
		
		//���������� �����ϱ� ���� ��ҵ��� �����ϴ� �迭 ����
		AcademyStaff[] staffs = new AcademyStaff[100];
		*/
		
		//�п� �����ڿ�����(�л�,����,����)�� �����ϱ� ���� ��ҵ��� �����ϴ� �迭 ����
			//AcademyPerson���� ������� �ν��Ͻ��� �����ϴ� �迭�� ���� (�ڽ� �ν��Ͻ����� �� ������ �� �ֱ⶧����)
			//�θ� ���� �ڽ������� ������ �� ������ ��ü����ȯ�� ���ؼ� �ڽ������� ������ �� �ִ�.
		AcademyPerson[] persons=new AcademyPerson[5];
		
		//�θ� Ŭ������ ������ �迭�� ��ҿ� �ڽ� Ŭ������ �����ڷ� �ν��Ͻ��� �����Ͽ� ����
		//=> �ڽ� Ŭ������ �����ڸ� �̿��ϸ� ��Ӱ����� �θ� �ν��Ͻ��� �ڽ� �ν��Ͻ��� ����
		//=> �迭 ��ҿ��� �θ� �ν��Ͻ��� ����Ǿ� ���� ����
		//=> ��ü ����ȯ�� �̿��Ͽ� �ڽ� �ν��Ͻ� ���� ���� 
			//�θ�Ŭ������ ���������� ������ָ� ��� �ڽĵ��� Ȯ���� �� �ֱ� ������ ���� ���� ������ �� �ִ�.
		persons[0]=new AcademyStudent(1000, "ȫ�浿", "�� ������ ����");
		persons[1]=new AcademyInstructor(2000, "�Ӳ���", "Java ���α׷���");
		persons[2]=new AcademyStaff(3000, "����ġ", "������");
		persons[3]=new AcademyStudent(4000, "������", "�� ������ ����");
		persons[4]=new AcademyStaff(5000, "����", "�濵ȸ����");
		
		for(AcademyPerson person:persons) {
			//instanceof : Ŭ������ ��Ӱ��踦 �����ϱ����� ������
			//����) �θ��������� instanceof �ڽ�Ŭ����
			//=> ���������� ����� �θ� �ν��Ͻ��� ��Ӱ���� ������ �ڽ� �ν��Ͻ��� Ŭ������
			//   ��� true�� �����ϰ� �ƴ� ��� false ����
			//=> ����� ��ü ����ȯ ���� ����ϴ� ������ - ClassCastException �߻� ����
			if(person instanceof AcademyStudent) {
			//�������̵� ������� ���� �޼ҵ�� ����� ��ü ����ȯ �� �ڽ� �ν��Ͻ��� �޼ҵ� ȣ�� ����
			//=> ��� ���谡 �ƴ� Ŭ������ ����� ��ü ����ȯ�� �� ��� ClassCastException �߻�
				//�������̵� �Ǿ��� ������ �ڵ� ����ȯ����.
			System.out.println(((AcademyStudent)person).getCourse()+"�������� >> ");
			} else if (person instanceof AcademyInstructor) {
				System.out.println(((AcademyInstructor)person).getSubject()+"�������� >> ");
			} else if (person instanceof AcademyStaff) {
				System.out.println(((AcademyStaff)person).getDepart()+"�μ����� >> ");
			}
			//�������̵� ����� �޼ҵ带 ȣ���ϸ� ������ ��ü ����ȭ�� ���� �θ� �ν��Ͻ���
			//�޼ҵ� ��� �ڽ� �ν��Ͻ��� �޼ҵ� ȣ��
			//������ ��ü ����ȯ�� �θ� �ν��Ͻ��� ��� ����� ������ �ڽ� �ν��Ͻ���
			//Ŭ������ �ڵ� ����ȯ�Ǿ� �ڽ� �ν��Ͻ��� �޼ҵ尡 ȣ��
			//=> �޼ҵ� �������̵忡 ���� ������ - �ڽ� �ν��Ͻ��� ���� �޼ҵ� ���� ȣ��
			person.display();
			System.out.println("==================================================================");
		}
		
	}
}
