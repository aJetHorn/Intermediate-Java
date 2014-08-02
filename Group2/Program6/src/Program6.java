
public class Program6 {
	public static void main(String[] args){
		int numbers[] = {1, 2, 3, 4};
		System.out.println(inOrder(numbers, 1));
		
		int numbers1[] = {5, 2, 3, 4};
		System.out.println(inOrder(numbers1, 1));
		
		String a = "ab"; //should be false
		System.out.println(isGood(a, 0));
		String b = "abba"; //should be true
		System.out.println(isGood(b, 0));
		String c = "a"; //should be true
		System.out.println(isGood(c, 0));
		String d = "abb"; //should be true
		System.out.println(isGood(d, 0));
		String e = "bb"; //should be false
		System.out.println(isGood(e, 0));
		String f = "aa"; //should be true
		System.out.println(isGood(f, 0));
	}
	
	public static boolean inOrder(int[] numbers, int count){
		if (count == numbers.length){
			return true;
		}
		else if (numbers[count] < numbers[count - 1]){
			return false;
		}
		else{
			count++;
			return inOrder(numbers, count);
		}
	}
	
	public static boolean isGood(String a, int b){
		//a is original string, b is current index
		String e = "a";
		String f = "bb";
		
		int c = b + 1;
		int d = c + 1;
		
		if (a.length() - 1 <= b){
			return true;
		}
		
		if (!a.substring(0, 1).equals(e)){
			return false;
		}
		else{
			if (a.substring(b, c).equals(e)){
				if ((a.substring(c, d).equals(e) || (d < a.length() &&
						a.substring(c, d + 1).equals(f)))){
					b++;
					return isGood(a, b);
				}
				else {
					return false;
				}
			}
			else if (a.substring(b, d).equals(f)) {
				if (d >= a.length()) {
					return true;
				}
				else if (d < a.length() && a.substring(d, d + 1).equals(e)){
					b += 2;
					return isGood(a, b);
				}
				else {
					return false;
				}
			}
			else{
				return false;
			}
		}
	}
}
