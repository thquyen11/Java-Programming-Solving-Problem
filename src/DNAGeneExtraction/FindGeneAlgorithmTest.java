package DNAGeneExtraction;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class FindGeneAlgorithmTest {
	
	public FindGeneAlgorithmTest() {
		super();
		// TODO Auto-generated constructor stub
	}

	FindGeneAlgorithm algo=new FindGeneAlgorithm();
	String testCase1;
	String testCase2;
	String testCase3;
	
	@Before
	public void setUp() {
		testCase1="TAAXXXTAGXXXTGA";
		testCase2="ATGXXXTAAXXXATGXXXTAGXXXATGXXXXXXTGA";
		testCase3="CGAACCCTAATGCCGTCATAAGAGCCCTAGGGAGACCTTAGGGAACAAGCATTAAACTGACACTCGATTCTGTAGCCGGCTCTGCCAAGAGACATGGCGTTGCGGTGATATGAGGGCAGGGGTCATGGAAGAAAGCCTTCTGGTTTTAGACCCACAGGAAGATCTGTGACGCGCTCTTGGGTAGAGCACACGTTGCTGGGCGTGCGCTTGAAAAGAGCCTAAGAAGAGGGGGCGTCTGGAAGGAACCGCAACGCCAAGGGAGGGTGTCCAGCCTTCCCGCTTCAACACCTGGACACATTCTGGAAAGTTTCCTAAGAAAGCCAGAAAAATAATTTAAAAAAAAATCCAGAGGCCAGACGGGCTAATGGGGCTTTACTGCGACTATCTGGCTTAATCCTCCAAACAACCTTGCCATACCAGCCCATCAGTCCTCTGA";
	}

	@Test
	public void test() {
		
//		assertEquals("Test Wrong", 0, algo.findAllGenes(testCase1).size());
//		assertEquals("Test Correct",3,algo.findAllGenes(testCase2).size());
		assertEquals("Test Correct", 4, algo.findAllGenes(testCase3).size());
	}

}
