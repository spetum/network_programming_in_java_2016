
public class instance_class {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		interface_a i_a = new main_class() ;
		interface_b i_b = new main_class() ;
		main_class m_c = new main_class();
		
		i_a.aaa();
		i_b.bbb();
		m_c.aaa();
		m_c.bbb();
		
		//System.out.println("i_a.bb := " + i_a.bb);
		System.out.println("i_b.bb := " + i_b.bb);
		
		System.out.println("interface_b.bb := " + interface_b.bb);		
		System.out.println("m_c.bb := " + m_c.bb);

	}

}
