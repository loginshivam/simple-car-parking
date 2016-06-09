package com.saple.parking;

import org.junit.Test;

import com.saple.parking.run.RunFromCommondAndFile;

public class MainTest {

	public void testStart() {
		RunFromCommondAndFile.runCommond();
	}

	@Test
	public void readFile() {
		RunFromCommondAndFile.runFromFile("file_inputs.txt");
	}

}
