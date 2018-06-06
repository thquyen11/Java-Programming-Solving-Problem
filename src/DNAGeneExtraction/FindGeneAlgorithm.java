package DNAGeneExtraction;

import java.util.ArrayList;
import java.util.List;

import javax.naming.ldap.StartTlsRequest;

import edu.duke.StorageResource;

public class FindGeneAlgorithm {

	public FindGeneAlgorithm() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int GeneLongerThan(StorageResource store, int threshold) {
		int count=0;
		for (String st : store.data()) {
			if(st.length()>threshold) count++;
		}
		return count;
	}

	public StorageResource findAllGenes(String dna) {
		StorageResource store = new StorageResource();
		String iGene = "ATG";
		int startIndex = dna.indexOf(iGene);

		while (true) {

			if (startIndex == -1)
				break;
			
			String currentGene = findGene(dna, startIndex);
			if (currentGene.isEmpty() && dna.toUpperCase().indexOf(iGene, startIndex + 3) == -1) {
				break;
			} else {
				if (currentGene.isEmpty()) {
					startIndex = dna.indexOf(iGene, startIndex + 3);
					continue;
				} else {
					store.add(currentGene);
					startIndex = dna.indexOf(iGene, startIndex + currentGene.length()+1);
				}
			}
		}
		return store;
	}

	public String findGene(String s, int startIndex) {
		if (startIndex == -1)
			return "";

		int taaIndex = findStopCondon(s.toUpperCase(), startIndex, "TAA");
		int tagIndex = findStopCondon(s.toUpperCase(), startIndex, "TAG");
		int tgaIndex = findStopCondon(s.toUpperCase(), startIndex, "TGA");

		int minIndex = Math.min(taaIndex, tagIndex);
		minIndex = Math.min(minIndex, tgaIndex);

		if (minIndex == s.length())
			return "";
		else
			return s.substring(startIndex, minIndex + 3);
	}

	public int findStopCondon(String dna, int startIndex, String stopCondon) {
		if (dna.indexOf(stopCondon, startIndex + 1) != -1) {
			int stopIndex = dna.indexOf(stopCondon, startIndex + 1);
			if ((stopIndex - startIndex) % 3 == 0)
				return stopIndex;
			else
				return dna.length();
		} else
			return dna.length();
	}

	public int GenecgRatioGreaterThan(StorageResource store, double threshold) {
		int count=0;
		for (String s : store.data()) {
			if (CgRatio(s) > threshold) {
				count++;
			}
		}
		return count;
	}
	
	public double CgRatio(String dna) {
		int num = 0;
		for (char cha : dna.toLowerCase().toCharArray()) {
			if (cha == 'c' || cha == 'g')
				num++;
		}
		return num * 1.0 / dna.length();
	}

//	public List<String> GeneLongerThan(StorageResource store, int checkLength) {
//		List<String> resultList = new ArrayList<>();
//
//		for (String s : store.data()) {
//			if (s.length() > checkLength) {
//				resultList.add(s);
//			}
//		}
//		return resultList;
//	}


	public int CondonAppear(String dna, String codon) {
		// TODO Auto-generated method stub
		int count = 0;
		int startIndex = 0;

		while(startIndex!=-1) {
			if(dna.toUpperCase().indexOf(codon, startIndex)!=-1) {
				count++;
				startIndex=dna.indexOf(codon, startIndex)+3;
			} else break;
			
		}
		return count;
	}

	public String findLongestGene(StorageResource store) {
		String longest = "";
		for (String s : store.data()) {
			if (s.length() > longest.length()) {
				longest = s;
			}
		}

		return longest;
	}

}
