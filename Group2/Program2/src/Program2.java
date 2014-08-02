
public class Program2 {
	public static void main(String[] args){
		CreditCard cc = new CreditCard(4388576018402625L,12,2013,5675,"Mary S. Smtih");
	    CreditCard cc1 = new CreditCard(4388576018410707L,1,2015,7656,"Robert A. Jones");
	    CreditCard cc3 = new CreditCard(3788576018410707L,13,2015,7676,"Harry A. Lambert");
	    System.out.println(cc + "\n" + cc1 + "\n" + cc3);
	    System.out.println(cc.typeOfCard());
	    System.out.println(cc.getStatus());
	    System.out.println(cc3.getStatus());
	}
}
