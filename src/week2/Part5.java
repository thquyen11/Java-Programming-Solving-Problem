package week2;

public class Part5 {
	
	public static void findAbc(String input){
	       int index = input.indexOf("abc");
	       while (true){
	           if (index == -1 || index >= input.length() - 3){
	               break;
	           }
//	           System.out.println(index);
	           String found = input.substring(index+1, index+4);
	           System.out.println(found);
	           index = input.indexOf("abc",index+3);
//	           System.out.println("index after "+index);
	       }
	   }
	
	   public static void main(String[] args) {
	    //no code yet
//		   findAbc("abcd");
		   findAbc("abcabcabcabca");
	}
}
