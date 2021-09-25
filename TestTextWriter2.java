package io1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TestTextWriter2 {

	public static void main(String[] args) throws IOException {

		String filename = "c:\\iotest\\scannerwrite.txt";
		String [] names = new String [5];
	
		
		FileWriter      fw = new FileWriter( filename, true );
		BufferedWriter  bw = new BufferedWriter( fw );
		Scanner in = new Scanner(System.in);
		System.out.println("이름(종료:exit):");
	
		int i = 1;
		while(true) {
			String line = in.nextLine();
			if( line.toLowerCase().equals("exit") ) break;
			
			String fmt = "%04d.%-10s\n";
			String msg = String.format(fmt, i , line);
			bw.write( msg );
			i++;
			System.out.println("입력되었습니다.");
		}
		
		in.close();
		bw.close();
		fw.close();
		
		System.out.println(filename+"파일이 저장되었습니다.");
	}

}
