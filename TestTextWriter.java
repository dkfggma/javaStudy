package io1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TestTextWriter {

	public static void main(String[] args) throws IOException {
		//파일조작 폴더 c:\iotest
		//자바 경로 표시는 반드시 \\ 사용하라
		String filename = "c:\\iotest\\data1.txt"; //windows
	    //String filename = "c:/iotest/data1.txt";  - unix/linux/mac 
		FileWriter fw = new FileWriter(filename); //open
		
		fw.write("쯔위\n");
		fw.write("사나\n");
		fw.write("모모\n");
		fw.write("리사\n");
		
		fw.close();
		
		//------------------------------------------------------------------------
		String filename2 = "c:\\iotest\\data2.txt";
		String [] names  = {"아이유","소향", "J Fla","블랙핑크", "여자친구"};
		
		
		FileWriter     fw2  =  new FileWriter( filename2 );
		BufferedWriter bw2  =  new BufferedWriter( fw2 ); 
		
		String msg = "";
		for (int i = 0; i < names.length; i++) {
			String fmt = "%d.%s\n";
			msg = String.format(fmt, i+1, names[i]);
			bw2.write( msg );			
		}
		
		bw2.close();
		fw2.close();

		//---------------------------------------------------------------------------------
	
	}

}
