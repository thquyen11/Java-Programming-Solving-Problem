package WeatherForecast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class WeatherInfo {

	public Double AverageTempWithHumidityInFile(String fileName, Double humidity) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		CSVParser parser = new CSVParser(br,
				CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());

		Double avgTemp = 0.0;
		int numberOfLines = 0;
		for (CSVRecord record : parser) {
			if (Double.parseDouble(record.get("Humidity")) >= humidity) {
				if (Double.parseDouble(record.get("TemperatureF")) != -9999.0) {
					avgTemp += Double.parseDouble(record.get("TemperatureF"));
					numberOfLines++;
				}
			}
		}
		br.close();
		return avgTemp / numberOfLines;
	}

	public Double ColdestTempInManyFiles(String folderName) throws IOException {
		File folder = new File(folderName);
		Double minTemp = 100.0;

		if (folder.isDirectory()) {
			File[] listFiles = folder.listFiles();

			for (File file : listFiles) {
				Double temp = ColdestTempInFile(file.getPath());
				if (temp < minTemp && temp != -9999.0) {
					minTemp = temp;
				}
			}
		}
		return minTemp;
	}

	public Double ColdestTempInFile(String fileName) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		CSVParser parser = new CSVParser(br,
				CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());

		Double minTemp = 200.0;
		for (CSVRecord record : parser) {
			if (Double.parseDouble(record.get("TemperatureF")) < minTemp
					&& Double.parseDouble(record.get("TemperatureF")) != -9999.0) {
				minTemp = Double.parseDouble(record.get("TemperatureF"));
			}
		}
		br.close();
		return minTemp;
	}

	public Double AverageTempInFile(String fileName) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		CSVParser parser = new CSVParser(br,
				CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());

		Double avgTemp = 0.0;
		int numberOfLines = 0;
		for (CSVRecord record : parser) {
			if (Double.parseDouble(record.get("TemperatureF")) != -9999.0) {
				avgTemp += Double.parseDouble(record.get("TemperatureF"));
				numberOfLines++;
			}
		}
		br.close();
		return avgTemp / numberOfLines;
	}

	public Double LowestHumidityInManyFiles(String folderName) throws IOException {
		File folder = new File(folderName);
		Double minHumid = 100.0;

		if (folder.isDirectory()) {
			File[] listFiles = folder.listFiles();

			for (File file : listFiles) {
				Double humid = LowestHumidityInFile(file.getPath());
				if (humid < minHumid && humid != -9999.0) {
					minHumid = humid;
				}
			}
		}
		return minHumid;
	}

	public Double LowestHumidityInFile(String fileName) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		CSVParser parser = new CSVParser(br,
				CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());

		Double minHumid = 100.0;
		for (CSVRecord record : parser) {
			if (Double.parseDouble(record.get("Humidity")) < minHumid
					&& Double.parseDouble(record.get("Humidity")) != -9999.0) {
				minHumid = Double.parseDouble(record.get("Humidity"));
			}
		}
		br.close();
		return minHumid;
	}

}
