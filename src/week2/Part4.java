package week2;

import edu.duke.URLResource;

public class Part4 {
	
	public static void findYouTubeLink(URLResource url) {
		
		for(String line: url.lines()) {
			line.toLowerCase();
			if(line.indexOf("youtube")!=-1) {
				int start=line.indexOf("\"http")+1;
				int end=line.indexOf("\"", start+1);
				line=line.substring(start, end);
				System.out.println(line);
			}
		}
	}
	
	public static void main(String[] args) {
		String link="http://www.dukelearntoprogram.com/course2/data/manylinks.html";
		URLResource url= new URLResource(link);
		
		findYouTubeLink(url);
	}

}
