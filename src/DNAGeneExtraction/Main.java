package DNAGeneExtraction;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String filePath="src/DNAGeneExtraction/GRch38dnapart";
		BufferedReader br= new BufferedReader(new FileReader(filePath));
		String dna=br.readLine();
//		String dna="ATGTAAGATGCCCTAGT";
		
		FindGeneAlgorithm find= new FindGeneAlgorithm();
		
		dna=dna.toUpperCase();
		System.out.println("cau 3 "+find.findAllGenes(dna).size());
		System.out.println("cau 4 "+find.GeneLongerThan(find.findAllGenes(dna), 60));
		System.out.println("cau 5 "+find.GenecgRatioGreaterThan(find.findAllGenes(dna), 0.35));
		System.out.println("cau 6 "+find.CondonAppear(dna, "CTG"));
		System.out.println("cau 7 "+find.findLongestGene(find.findAllGenes(dna)));
	
		br.close();
	}

	

	public static String mystery(String dna) {
		int pos = dna.indexOf("T");
		int count = 0;
		int startPos = 0;
		String newDna = "";
		if (pos == -1) {
			return dna;
		}
		while (count < 3) {
			count += 1;
			newDna = newDna + dna.substring(startPos, pos);
			startPos = pos + 1;
			pos = dna.indexOf("T", startPos);
			if (pos == -1) {
				break;
			}
		}
		newDna = newDna + dna.substring(startPos);
		return newDna;
	}

}
