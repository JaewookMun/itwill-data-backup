package basic;

public class OperatorApp {
	public static void main(String[] args) {
		System.out.println("10+20*3 = " + (10+20*3));
		System.out.println("10+20*3 = " + ((10+20)*3));
		System.out.println("===============================================");
		
		int a1=10;
		System.out.println("a1 = " +a1);
		System.out.println("-a1 = " +(-a1));
		System.out.println("===============================================");
		System.out.println("20 > 10 = " + (20>10));
		System.out.println("20 > 10 = " + !(20>10));
		System.out.println("===============================================");
		int a2=10, a3=10;
		
		System.out.println("연산 전: a2 = "+a2+", a3 = "+a3);
		
		/*
		++a2;	// a2=a2+1;
		--a3;	// a3=a3-1;
		*/
		
		a2++;
		a3--;
		
		System.out.println("연산 후: a2 = "+a2+", a3 = "+a3);
		System.out.println("===============================================");
		
		int a4=10, a5=10;
		System.out.println("연산 전: a4 = "+a4+", a5 = "+a5);

		// 연산식이 다른 명령과 같이 작성된 경우 연산자의 위치는 연산식 처리순서에 영향을 미친다.
		int a6=++a4;	// 전처리 : ++a4 명령 실행 후 int a6=a4 명령 실행
		int a7=a5++;	// 후처리 : a7 = a5명령 실행 후 a5++ 명령 실행
		
		System.out.println("연산 후: a4 = "+a4+", a5 = "+a5);
		System.out.println("연산 후: a6 = "+a6+", a7 = "+a7);
		System.out.println("===============================================");
		
		int b1=20, b2=10;
		System.out.println(b1 + " * "+b2+" = " +(b1*b2));
		System.out.println(b1 + " / "+b2+" = " +(b1/b2));
		System.out.println(b1 + " % "+b2+" = " +(b1%b2));
		System.out.println(b1 + " + "+b2+" = " +(b1+b2));
		System.out.println(b1 + " - "+b2+" = " +(b1-b2));
		System.out.println("===============================================");
		
		System.out.println("20>10 = "+(20>10));
		System.out.println("20<10 = "+(20<10));
		System.out.println("20==10 = "+(20==10));
		System.out.println("20!=10 = "+(20!=10));
		System.out.println("===============================================");

		int c=20;
		System.out.println("c= "+c);
		System.out.println("c>=10 && c<=30 = "+(c>=10 && c<=30));
		System.out.println("c<10 || c>30 = "+(c<10 || c>30));
		System.out.println("===============================================");
		
		int d1=20, d2=10;
		System.out.println("큰값 = " +(d1>d2?d1:d2));
		System.out.println("===============================================");
		
		int d3=10;
		System.out.println(d3+"은 >> "+(d3%2==0?"짝수":"홀수")+"입니다.");
		
		System.out.println("===============================================");
		int e=10;
		System.out.println("e = " + e);
		
		e+=5; //e=e+5;
		System.out.println("e = "+e);
		System.out.println("===============================================");
		
		
	}
}
