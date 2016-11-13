/*
 * 원래 Inheritance_Finalize_Test_001에 있는
 * shape_p.java의 내용에서 polygon_p class의 
 * finalize()를 없애보자.
 * 클래스의 이름도 바꿔서 해보자.
 */
/* 결과는 다음과 같다.
Here is what() of "class polygon_p_without_finalize": class polygon_p_without_finalize ; Avira
Here is what() of "class polygon_p_without_finalize": class polygon_p_without_finalize ; mashia snir
Finalize in "class shape_p" : class polygon_p_without_finalize(shape_p)
Finalize in "class shape_p" : class polygon_p_without_finalize(shape_p)
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

class polygon_p_without_finalize extends shape_p {
	private String p;
	public polygon_p_without_finalize() {
		if (p == null)
			p = new String("polygon_p_without_finalize");
	}
	public polygon_p_without_finalize (String str) {
		p = new String(str);
	}
	public void what() {
		System.out.println("Here is what() of \"class polygon_p_without_finalize\": " + this.getClass() + " ; " + p) ;
	}

//	public void finalize(){
//		super.finalize();
//		System.out.println("Finalize in \"class polygon_p_without_finalize\" : " + this.getClass()+" ("+p+")");
//	}	
}

class test_p {
	public static void main(String[] args) {
		polygon_p_without_finalize pp = new polygon_p_without_finalize("Avira");
		pp.what();
		pp=null;
		shape_p sp = new polygon_p_without_finalize("mashia snir");
		sp.what();
		sp=null;
		System.gc();
	}
}