package io1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TestTextReaderWriter {

	public static void main(String[] args) throws IOException {
		//입력 : 이름,국어,영어,수학
		//출력 : 번호,이름,국어,영어,수학,총점,평균
		
		String infilename  = "c:\\iotest\\sungjuk_in.txt";
		String outfilename = "c:\\iotest\\sungjuk_out.txt";
		
		File inFile  = new File(infilename);
		File outFile = new File(outfilename);
		
		FileReader fr     = new FileReader( inFile );
		FileWriter fw     = new FileWriter( outFile );
		
		BufferedReader br = new BufferedReader( fr );
		BufferedWriter bw = new BufferedWriter( fw );
		
		String line = "";
		//파일 끝까지 반복 입력받아라
		String title = "번호    이름    국어    영어   수학   총점   평균\n";
		bw.write(title);
		
		int num = 1;
		while ( (line = br.readLine())!=null ) {
			String [] li = line.split(",");
			String name = li[0].trim();
			int    kor  = Integer.parseInt(li[1]);
			int    eng  = Integer.parseInt(li[2]);
			int    mat  = Integer.parseInt(li[3]);
			
			int    tot  = kor+eng+mat;
			int    avg  = tot / 3;
			
			String fmt = "%4d %6s %6d %6d %6d %6d %6d\n";
			String msg = String.format(fmt, num, name, kor, eng, mat, tot, avg);
			bw.write(msg);
			num++;
		}
		
		if( !inFile.exists() ) {
			System.out.println( infilename+"파일이 없습니다" );
			//return; //main함수 종료
			System.exit(0);//프로그램 강제종료
		}
		
		br.close();
		bw.close();
		fr.close();
		fw.close();
		
		System.out.println("Ok\n"+(num-1)+"개가 저장되었습니다.");
		

	}

}
