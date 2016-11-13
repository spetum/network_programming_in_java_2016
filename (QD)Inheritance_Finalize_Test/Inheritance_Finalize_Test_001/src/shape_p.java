/*
 * 1998.12.14(Sun)
 * shape_p를 상속하는 polygon_p가 있다.
 * 이를 시험하는 main() method를 가지고 있는 test_p라는 클래스에서
 * 이 둘의 상속과 타입에 따라 발생하는 Garbage collection의 문제를 살펴보자.
 * C++에서의 명시적인 소멸자(explicit de-structor)와는 입장이 다르고
 * C++의 virtual이나 pure virtual member function과의 차이도 이해하자.
 * 
 * 아울러 Java의 소멸 순서는 사실 아래의 결과처럼 진행되지 않을 수도 있다.
 * 시스템에 따라 적용순서나 내용이 달라질 수도 있다.
 * Java에서 finalize와 System.gc()를 알아야 하는 이유는 
 * 화일이나 호스트 컴퓨터의 자원들에 관련된 것으로 세심하게 
 * 다루지 않으면 보안상의 문제나 메모리 누수(memory leak)
 * 등의 문제로 Java 프로그램이 비정상적인 작동을 할 수 있기
 * 때문이다.
 * */
/*결과는 다음과 같다.
Here is what() of "class polygon_p": class polygon_p ; Avira
Here is what() of "class polygon_p": class polygon_p ; mashia snir
Finalize in "class shape_p" : class polygon_p(shape_p)
Finalize in "class polygon_p" : class polygon_p (mashia snir)
Finalize in "class shape_p" : class polygon_p(shape_p)
Finalize in "class polygon_p" : class polygon_p (Avira)
*/
class shape_p {
	private String s ;
	public shape_p(){
		if (s == null )
			s = new String("shape_p");
	}
	public shape_p(String str){
		s = new String(str);
	}
	public void what() {
		System.out.println("Here is what() of \"class shape_p\": " + this.getClass() + " ; " + s) ;
	}
	public void finalize(){
		System.out.println("Finalize in \"class shape_p\" : " + this.getClass()+"("+ s+")");
	}
}

class polygon_p extends shape_p {
	private String p;
	public polygon_p() {
		if (p == null)
			p = new String("polygon_p");
	}
	public polygon_p (String str) {
		p = new String(str);
	}
	public void what() {
		System.out.println("Here is what() of \"class polygon_p\": " + this.getClass() + " ; " + p) ;
	}

	public void finalize(){
		super.finalize();
		System.out.println("Finalize in \"class polygon_p\" : " + this.getClass()+" ("+p+")");
	}	
}

class test_p {
	public static void main(String[] args) {
		polygon_p pp = new polygon_p("Avira");
		pp.what();
		pp=null;
		shape_p sp = new polygon_p("mashia snir");
		sp.what();
		sp=null;
		System.gc();
	}
}