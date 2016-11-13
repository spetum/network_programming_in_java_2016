class getFavoriteColorProperty {

  public static void main(String args[]) {
	   // Print favorite color property
	   // test and compare between below two commands
	   // (1) java ListProperties 
	   // (2) java -Duser.favoritecolor=RED ListProperties 
	   System.out.println("\nFavorite Color: " 
	              + System.getProperty("user.favoritecolor", "None"));
	   System.out.println("\nFavorite Color: " 
	              + System.getProperties().getProperty("user.favoritecolor"));
  }
}
