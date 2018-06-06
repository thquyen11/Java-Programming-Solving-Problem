package week2;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class Part1Test {

	Part1 actual;
	String DNA1;
	String DNA2;
	String DNA3;
	String DNA4;
	String DNACorrect;
	Part1 findDNA;

	@Before
	public void setUpBeforeClass() throws Exception {
		DNA1 = "ABCDTAA";
		DNA2 = "ATGABCDE";
		DNA3 = "ABCDEFG";
		DNA4 = "ATGXXXXTAA";
		DNACorrect = "AAATGCCCTAACTAGATTAAGAAACC";
		findDNA = new Part1();

	}

	@Test
	public void test() {

		assertTrue("No ATG ", findDNA.findSimpleGene(DNA1).equals(""));
		assertTrue("No TAA ", findDNA.findSimpleGene(DNA2).equals(""));
		assertTrue("No ATG and TAA ", findDNA.findSimpleGene(DNA3).equals(""));
		assertTrue("Has ATG and TAA but not correct ", findDNA.findSimpleGene(DNA4).equals(""));
		assertTrue("Correct DNA ", findDNA.findSimpleGene(DNACorrect).equals("DNACorrect"));
	}

}
