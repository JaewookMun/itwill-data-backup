package realization;

public class WolfHumanApp {
	public static void main(String[] args) {
		WolfHuman wolfHuman=new WolfHuman();
		
		wolfHuman.speak();
		wolfHuman.walk();
		wolfHuman.smile();
		wolfHuman.change();
		wolfHuman.cryLoudly();
		wolfHuman.fastWalk();
		System.out.println("==================================================");
		//�θ� Ŭ������ ���������� �����Ͽ� �ڽ� Ŭ������ �����ڷ� �ν��Ͻ��� �����Ͽ� ����
		//=> ���������� �θ� �ν��Ͻ��� �޼ҵ常 ȣ�� ����
		//=> ��ü ����ȯ�� �̿��ϸ� �ڽ� �ν��Ͻ��� �޼ҵ� ȣ�� ����
			//�������̵带 �ߴٸ� wolfhuman �޼ҵ� ȣ�� ����.
			//sub class �޼ҵ带 ����ϰ� ������ ��������ȯ�� �ؾ���
		Human human=new WolfHuman();
		
		human.speak();
		human.walk();
		human.smile();
		System.out.println("==================================================");
		((WolfHuman)human).change();
		System.out.println("==================================================");
		//�������̽��� �̿��Ͽ� �������� ����
		//=> �ڽ� Ŭ������ �����ڷ� �ν��Ͻ��� �����Ͽ� ���� ����
		//Wolf wolf=new WolfHuman();
		
		//�ڽ� Ŭ������ ���� �θ� Ŭ���� �Ǵ� �θ� �������̽��� ���� ����� ��ü ����ȯ��
		//�̿��Ͽ� �ڽ� �ν��Ͻ� ���� ����
			//��ü ����ȯ�� �θ𳢸��� ����ȯ �Ҽ��� �ִ�. - �ڽ��� ���� ����ϱ� ������
			//�������̽��� �ٲܶ� ���� (�θ� Ŭ���� -> �θ� �������̽�) (�ſ� Ư���� ��� ���)
		Wolf wolf = (Wolf)human;

		//������ ��ü ����ȯ�� ���� �ڽ� �ν��Ͻ��� �޼ҵ� ȣ��
		wolf.cryLoudly();
		wolf.fastWalk();
		System.out.println("==================================================");
		
		
		
		
	}
}
