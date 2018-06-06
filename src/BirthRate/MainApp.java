package BirthRate;

import java.io.IOException;

import edu.duke.FileResource;

public class MainApp {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BabyBirths bb=new BabyBirths();
		
//		bb.totalBirths(1990);
		bb.totalBirths(1905);
		System.out.println(bb.getRank(1960, "Emily", "F"));
		System.out.println(bb.getRank(1971, "Frank", "M"));
		System.out.println(bb.getName(1980, 350, "F"));
		System.out.println(bb.getName(1982, 450, "M"));
		System.out.println(bb.whatIsNameInYear("Susan", "F", 1972, 2014));
		System.out.println(bb.whatIsNameInYear("Owen", "M", 1974, 2014));
		System.out.println(bb.HighestRank("Genevieve", "F", 1880, 2014));
		System.out.println(bb.HighestRank("Mich", "M", 1880, 2014));
		System.out.println(bb.getAverageRank("Susan", "F", 1880, 2014));
		System.out.println(bb.getAverageRank("Robert", "M", 1880, 2014));
		System.out.println(bb.getTotalBirthsRankedHigher(1990, "Emily", "F"));
		System.out.println(bb.getTotalBirthsRankedHigher(1990, "Drew", "M"));

	}

}
