public class Palindrome 
{
	 public static void main(String[] args) 
	 {
		 for (int i = 0; i < args.length; i++) 
		 {
			 	String s = args[i];
			 	System.out.println(s + " " + isPalindrome(s));
		 } 
	 }
	 public static String reverseString(String text)
	 {
		 String reverse = "";
		 for(int i = text.length()-1;i>=0;i--)
		 {
			 reverse+=text.charAt(i);
		 }
		 return reverse;
	 }
	 public static boolean isPalindrome(String s)
	 {
		 String rs = reverseString(s);
		 return s.equals(rs);
	 }
}