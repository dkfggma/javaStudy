package io2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TestIoOSungjuk {

	public static void main(String[] args) throws IOException {
		
		String fn1 = "C:\\iotest\\sungjuk_in.txt" ;
		String fn2 = "C:\\iotest\\sungjuk_out2.txt";
		File file1 = new File(fn1);
		File file2 = new File(fn2);
		
		if(!file1.exists()) {
			System.out.println("파일이 없습니다");
			System.exit(-1);
		}
		
		FileReader     fr = new FileReader( file1 );
		FileWriter     fw = new FileWriter( file2 );
		
		BufferedReader br = new BufferedReader( fr );
		BufferedWriter bw = new BufferedWriter( fw );
		
		String line = "";
		int    num  = 1;
		while ( (line = br.readLine()) != null ) {
			
			Sungjuk s = new Sungjuk( num, line );
			System.out.println(s.toString());
			bw.write(s.toString()+"\n");
			num++;
			
		}
		br.close();
		bw.close();
		fr.close();
		fw.close();
	}

}
