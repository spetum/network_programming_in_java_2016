
public class TextEncodedTextToBitOutput {
	private static final String ENCODING = "ISO-8859-1";
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		String msgTextEncoded= "1234567890987654 5mm Super Widgets\n"
				+ "1000 12999 d\n";
		byte[] strToByte = msgTextEncoded.getBytes(ENCODING);
		System.out.println("Text Encoding");
		for (int i=0; i< strToByte.length; i++){			
			switch(strToByte[i]) {
			case 9 :
				System.out.printf("(\\t)%3d : ", strToByte[i]);
				break;
			case 10 :
				System.out.printf("(\\n)%3d : ", strToByte[i]);
				break;
			case 13 :
				System.out.printf("(\\r)%3d : ", strToByte[i]);
				break ;
			default :
				System.out.printf("(%c)%4d : ", strToByte[i],strToByte[i]);
			} // end of switch-case
			System.out.print(bitsPrint.bitPrint(strToByte[i]));
			if ((i+1)%4==0)
				System.out.print("\n");
			else 
				System.out.print(", ");
		} // end of for
		
		long itemNumber = 1234567890987654L;
		// long itemNumber = 0x0123456789abcdefL; //맞는지 확인하기 위해.
		int itemQuantity = 1000;
		int itemUnitPrice = 12999 ;
		String itemDesc = "5mm Super Widgets";
		boolean DISCOUNTED = true ;
		boolean IN_STOCK = false ;
		byte flags = 0 ;
		byte[] encodedItemDesc = itemDesc.getBytes(ENCODING);
		byte encodedItemDescLength = (byte) encodedItemDesc.length ;
		System.out.println("Binary Encoding");
		System.out.println("Item Number : " + itemNumber + "\n: "
								+ bitsPrint.bitPrint(itemNumber));
		System.out.println("Item Quantity : " + itemQuantity + "\n: "
								+ bitsPrint.bitPrint(itemQuantity));
		System.out.println("Item Unit Price : " + itemUnitPrice + "\n: "
								+ bitsPrint.bitPrint(itemUnitPrice));
		if (DISCOUNTED)
			flags |= (1<<7);
		if (IN_STOCK)
			flags |= (1<<0);
		System.out.println("Discounted and In Stock : " + flags + "\n"
								+ bitsPrint.bitPrint(flags));
		
		System.out.println("Length of Item Description : " + encodedItemDescLength + "\n" 
								+ bitsPrint.bitPrint(encodedItemDescLength));
		System.out.println("Encoded Description : " + new String(encodedItemDesc));
		for (int i=0; i < encodedItemDesc.length; i++) 
			System.out.print(bitsPrint.bitPrint(encodedItemDesc[i]) 
					+ ((i+1)%4==0 ? "/\n":"/ "));	
		System.out.print('\n');
	} // end of main
} // end of class
