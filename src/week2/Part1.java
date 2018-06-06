package week2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part1 {

//	public String findSimpleGene(String s) {
//		Pattern p = Pattern.compile("\\w*(ATG\\w+TAA)\\w*");
//		Matcher m=p.matcher(s);
//		
//		String DNA="";
//		if(!m.find()) return "";
//		else {
//			String tmp=m.group(1);
//			if((tmp.indexOf("ATG")-tmp.indexOf("TAA"))%3==0) {
//				DNA=tmp;
//			}
//		}
//		return DNA;
//	}

	public Object findSimpleGene(String s) {
		Pattern p = Pattern.compile("\\w*(ATG\\w+TAA)\\w*");
		Matcher m=p.matcher(s);
		
		String DNA="";
		if(!m.find()) return "";
		else {
			String tmp=m.group(1);
			if((tmp.indexOf("ATG")-tmp.indexOf("TAA"))%3==0) {
				DNA=tmp;
			}
		}
		return DNA;
	}

}
