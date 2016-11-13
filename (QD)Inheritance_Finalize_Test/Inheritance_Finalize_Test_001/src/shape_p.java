/*
 * 1998.12.14(Sun)
 * shape_p�� ����ϴ� polygon_p�� �ִ�.
 * �̸� �����ϴ� main() method�� ������ �ִ� test_p��� Ŭ��������
 * �� ���� ��Ӱ� Ÿ�Կ� ���� �߻��ϴ� Garbage collection�� ������ ���캸��.
 * C++������ ������� �Ҹ���(explicit de-structor)�ʹ� ������ �ٸ���
 * C++�� virtual�̳� pure virtual member function���� ���̵� ��������.
 * 
 * �ƿ﷯ Java�� �Ҹ� ������ ��� �Ʒ��� ���ó�� ������� ���� ���� �ִ�.
 * �ý��ۿ� ���� ��������� ������ �޶��� ���� �ִ�.
 * Java���� finalize�� System.gc()�� �˾ƾ� �ϴ� ������ 
 * ȭ���̳� ȣ��Ʈ ��ǻ���� �ڿ��鿡 ���õ� ������ �����ϰ� 
 * �ٷ��� ������ ���Ȼ��� ������ �޸� ����(memory leak)
 * ���� ������ Java ���α׷��� ���������� �۵��� �� �� �ֱ�
 * �����̴�.
 * */
/*����� ������ ����.
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