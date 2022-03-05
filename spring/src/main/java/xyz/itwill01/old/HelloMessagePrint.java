package xyz.itwill01.old;

	// service
public class HelloMessagePrint {
	public void helloMessagePrint() {
		HelloMessageObject object = new HelloMessageObject();
		String messaString=object.getHelloMessage();
		System.out.println("messaString = "+messaString);
	}
}
