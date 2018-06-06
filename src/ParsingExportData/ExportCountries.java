package ParsingExportData;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import edu.duke.FileResource;

public class ExportCountries {

	public void findExportCountries(String good) {
		FileResource fr = new FileResource();
		CSVParser parser = fr.getCSVParser();
		
		List<String> exporters=listExporters(parser, good);
		for (String s : exporters) {
			System.out.println(s);
		}
	}
	
	public void findCountryInfo(String country) {
		FileResource fr = new FileResource();
		CSVParser parser = fr.getCSVParser();
		
		System.out.println(countryInfo(parser, "Nauru"));
	}

	private String countryInfo(CSVParser parser, String string) {
		// TODO Auto-generated method stub
		for (CSVRecord record : parser) {
			if(record.get("Country")!=null) {
				String output=record.get("Country")+record.get("Exports")+record.get("Value (dollars)");
				return output;
			}
		}
		
		return "NOT FOUND";
		
	}

	private List<String> listExporters(CSVParser parser, String good) {
		// TODO Auto-generated method stub
		List<String> listExporters = new ArrayList<>();
		
			for (CSVRecord record : parser) {
				String export = record.get("Exports");
				if (export.contains(good)) {
					listExporters.add(record.get("Country"));
				}
			}
		return listExporters;
	}

}
