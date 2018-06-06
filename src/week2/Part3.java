package week2;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part3 {
	
	public boolean twoOccurences(String stringa, String stringb) {
		
		Pattern p=Pattern.compile(stringa);
		Matcher m=p.matcher(stringb);
		
		int cnt=0;
		while(m.find()) cnt++;
		
		return (cnt==2)?true:false;
	}
	
	public String lastPart(String stringa, String stringb) {
		
		if(stringb.indexOf(stringa)==-1) return stringb;
		else {
			return stringb.substring(stringb.indexOf(stringa)+stringa.length());
		}
	}
}
