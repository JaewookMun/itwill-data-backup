package realization;

public class BoatCarRealApp {
	public static void main(String[] args) {
		//BoatCarReal boatCar = new BoatCarReal();
			//�������̽��� �̿��ؼ� ���������� ����� ���߿� �ڽĵ��� �ٲٱ⿡ ���ϴ�.
			//���߿� �۾��� �Ҷ� ���������ϻ��� ������ �Ʒ�ó��
			//�������̽� ���������� �ڽ� �������̽� ������ �����ϴ� ���̽��� �ټ� �߻��Ѵ�.
		BoatCar boatCar = new BoatCarReal();
		
		//������ ��ü ����ȯ�� ���� �ڽ� �ν��Ͻ��� �޼ҵ� ȣ��
		boatCar.run();
		boatCar.navigate();
		boatCar.floating();
		
	}
}
