package xyz.itwill.util;

public class Utility {
	// JSON ������ �ؽ�Ʈ �����͸� ���޹޾� �ڹٽ�ũ��Ʈ ��ü�� �Ӽ������� ǥ���� �� ���� ���ڸ�
	// ȸ�ǹ���(Escape Character)�� ��ȯ�Ͽ� ��ȯ�ϴ� �޼ҵ�
		// �Ӽ����� ���Ͱ� ������ ������ �߻�. ���� ���ı��� �Ӽ������� �ν��� ����.
		// ����, ���������̼� ���.
	public static String toJSON(String source) {
		return source.replace("\\", "\\\\").replace("\"", "\\\"")
				.replace("\n", "\\n").replace("\r\n", "\\n");
	}
	
	
}
