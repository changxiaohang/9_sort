package com.sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Insertion_Sort {
	
	//javac Insertion_Sort.java
	//java Insertion_Sort input.txt

	public static void main(String[] args) {
		try {
			//FileReader fr = new FileReader(args[0]);
			FileReader fr = new FileReader("input.txt");
			FileWriter fw = new FileWriter("output.txt");
			BufferedReader br = new BufferedReader(fr);
			BufferedWriter bw = new BufferedWriter(fw);
			String line;
			String[] array = null;
			while((line = br.readLine()) != null){
				line = line.trim();
				array = line.split(";");
			}
			//float[] number = new float[array.length];
			int[] number = new int[array.length];
			for(int i=0; i<array.length; i++){
				number[i] = Integer.parseInt(array[i]);
			}

			for (int i = 1; i < number.length; i++) {
				int j = i-1;
				int key = number[i];
				while(j>=0 && number[j]>key){
					number[j+1] = number[j];
					j--;
				}
				number[j+1] = key;
			}

			for (int i = 0; i < number.length; i++) {
				bw.write(String.valueOf(number[i]));
				if(i != number.length-1){
					bw.write(";");
				}
			}

			bw.flush();
			bw.close();
			br.close();
			fw.close();
			fr.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}


	}

}
