package BirthRate;

import edu.duke.FileResource;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class BabyBirths {

	public int getTotalBirthsRankedHigher(int year, String name, String gender) throws IOException {
		int ref=getRank(year, name, gender);
		int total=0;
		String fileName=yearToPath(year);
		BufferedReader br=new BufferedReader(new FileReader(fileName));
		CSVParser parser=new CSVParser(br, CSVFormat.DEFAULT);
		int rank=0;
		
		for (CSVRecord rec : parser) {
			if(rec.get(1).equals(gender)) rank++;
			if(rank<ref&&rec.get(1).equals(gender)) {
				total+=Integer.parseInt(rec.get(2));
			}
			
			if(rank>=ref&&rec.get(1).equals(gender)) break;
		}
		
		return total;
		
	}
	
	public int HighestRank(String name, String gender, int firstYear, int lastYear) throws IOException {
		int currentYear=firstYear;
		int highestRank=1000000000;
		int highestYear = 0;
		
		while(currentYear<=lastYear) {
			if(getRank(currentYear, name, gender)<highestRank) {
				highestRank=getRank(currentYear, name, gender);
				highestYear=currentYear;
				
			}
			currentYear++;
		}
		
		return highestYear;
	}
	
	public Double getAverageRank(String name, String gender, int firstYear, int lastYear) throws IOException {
		int currentYear=firstYear;
		Double totalRank=0.0;
		
		while(currentYear<=lastYear) {
			totalRank+=getRank(currentYear, name, gender);
			currentYear++;
		}
		
		return totalRank!=0?totalRank/(lastYear-firstYear+1):-1.0;
	}
	
	
	/* Get Rank from a Name and Gender in a specific year */
	public int getRank(int year, String name, String gender) throws IOException {
		String fileName=yearToPath(year);
		BufferedReader br=new BufferedReader(new FileReader(fileName));
		CSVParser parser=new CSVParser(br, CSVFormat.DEFAULT);
		int rank=0;
		
		for (CSVRecord rec : parser) {
			if(rec.get(1).equals(gender)) rank++;
			if(rec.get(0).equals(name)&&rec.get(1).equals(gender)) return rank;
		}
		return 0;
	}
	
	/* Get Name from a Rank and Gender in a specific year */
	public String getName(int year, int rank, String gender) throws IOException {
		String fileName=yearToPath(year);
		BufferedReader br=new BufferedReader(new FileReader(fileName));
		CSVParser parser=new CSVParser(br, CSVFormat.DEFAULT);
		int currentRank=0;
		
		for (CSVRecord rec : parser) {
			if(rec.get(1).equals(gender)) currentRank++;
			if(currentRank==rank&&rec.get(1).equals(gender)) return rec.get(0);
		}
		return "NO NAME";
	}
	
	public String whatIsNameInYear(String name, String gender, int year, int newYear) throws IOException {
		// Find the ranking in this year
		int initalRank=getRank(year, name, gender);
		
		// Find the ranking in newYear
		String newName=getName(newYear, initalRank, gender);
		
		return newName;
	}
	
	/* convert year to filepath */
	private String yearToPath(int year) {
		return "data/us_babynames/us_babynames_by_year/yob"+year+".csv";
	}
	
	public void totalBirths (int year) throws IOException {
		int totalBirths = 0;
		int totalBoys = 0;
		int totalGirls = 0;
		String fileName=yearToPath(year);
		
		BufferedReader br=new BufferedReader(new FileReader(fileName));
		CSVParser parser=new CSVParser(br, CSVFormat.DEFAULT);
		int boyName=0;
		int girlName=0;
		
		for (CSVRecord rec : parser) {
			int numBorn = Integer.parseInt(rec.get(2));
			totalBirths += numBorn;
			
			if (rec.get(1).equals("M")) {
				totalBoys += numBorn;
				boyName++;
			}
			else {
				totalGirls += numBorn;
				girlName++;
			}
		}
		System.out.println("total births = " + totalBirths);
		System.out.println("female girls total births = " + totalGirls);
		System.out.println("male boys total births = " + totalBoys);
		System.out.println("female name "+girlName);
		System.out.println("male name "+boyName);
	}

}
