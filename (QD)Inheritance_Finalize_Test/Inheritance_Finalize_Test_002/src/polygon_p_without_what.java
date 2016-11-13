/*
 * 이제 상속받는 polygon_p에 what()메소드가 없으면
 * 당연히 상속상 상위의 shape_p의 what()메소드가 
 * 호출된다.
 */
/* 결과는 다음과 같다.
Here is what() of "class shape_p": class polygon_p_without_what ; shape_p
Here is what() of "class shape_p": class polygon_p_without_what ; shape_p
Finalize in "class shape_p" : class polygon_p_without_what(shape_p)
Finalize in "class polygon_p_without_what" : class polygon_p_without_what (mashia snir)
Finalize in "class shape_p" : class polygon_p_without_what(shape_p)
Finalize in "class polygon_p_without_what" : class polygon_p_without_what (Avira)
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

class polygon_p_without_what extends shape_p {
	private String p;
	public polygon_p_without_what() {
		if (p == null)
			p = new String("polygon_p_without_what");
	}
	public polygon_p_without_what (String str) {
		p = new String(str);
	}
//	public void what() {
//		System.out.println("Here is what() of \"class polygon_p\": " + this.getClass() + " ; " + p) ;
//	}

	public void finalize(){
		super.finalize();
		System.out.println("Finalize in \"class polygon_p_without_what\" : " + this.getClass()+" ("+p+")");
	}	
}

class test_p {
	public static void main(String[] args) {
		polygon_p_without_what pp = new polygon_p_without_what("Avira");
		pp.what();
		pp=null;
		shape_p sp = new polygon_p_without_what("mashia snir");
		sp.what();
		sp=null;
		System.gc();
	}
}