/*
 * 원래 Inheritance_Finalize_Test_001에 있는
 * shape_p.java의 내용에서 shape_p class의 
 * finalize()를 없애보자.
 * 클래스의 이름도 바꿔서 해보자.
 */
/* 결과는 다음과 같다.
Here is what() of "class polygon_p": class polygon_p ; Avira
Here is what() of "class polygon_p": class polygon_p ; mashia snir
Finalize in "class polygon_p" : class polygon_p (mashia snir)
Finalize in "class polygon_p" : class polygon_p (Avira)
*/
class shape_p_without_finalize {
	private String s ;
	public shape_p_without_finalize(){
		if (s == null )
			s = new String("shape_p");
	}
	public shape_p_without_finalize(String str){
		s = new String(str);
	}
	public void what() {
		System.out.println("Here is what() of \"class shape_p_without_finalize\": " + this.getClass() + " ; " + s) ;
	}
//	public void finalize(){
//		System.out.println("Finalize in \"class shape_p_without_finalize\" : " + this.getClass()+"("+ s+")");
//	}
}

class polygon_p extends shape_p_without_finalize{
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
		//super.finalize(); //--> 상속 상위 클래스에 없으니 에러다.당연히 호출이 안된다.
		System.out.println("Finalize in \"class polygon_p\" : " + this.getClass()+" ("+p+")");
	}	
}

class test_p {
	public static void main(String[] args) {
		polygon_p pp = new polygon_p("Avira");
		pp.what();
		pp=null;
		shape_p_without_finalize sp = new polygon_p("mashia snir");
		sp.what();
		sp=null;
		System.gc();
	}
}