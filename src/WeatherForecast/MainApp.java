package WeatherForecast;

import java.io.IOException;

public class MainApp {
	
	static String fileName="data/nc_weather/2013/weather-2013-09-02.csv";
	static String folderName="data/nc_weather/2013";

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		WeatherInfo weatherInfo=new WeatherInfo();
		
		System.out.println("AverageTempInFile "+weatherInfo.AverageTempInFile(fileName));
		System.out.println("ColdestTempInFile "+weatherInfo.ColdestTempInFile(fileName));
		System.out.println("ColdestTempInManyFiles "+weatherInfo.ColdestTempInManyFiles(folderName));
		System.out.println("LowestHumidityInFile "+weatherInfo.LowestHumidityInFile(fileName));
		System.out.println("AverageTempWithHumidityInFile "+weatherInfo.AverageTempWithHumidityInFile(fileName, 80.0));
		System.out.println("LowestHumidityInManyFiles "+weatherInfo.LowestHumidityInManyFiles(folderName));
	}

}
