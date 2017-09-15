package movieTheme;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;

public class makeMV {

	public static void main(String[] args) throws Exception {

		makeMV mv = new makeMV();
		//int cmd = 1;
		//mv.making(mv.movie(1));
		//mv.making(mv.movie(2));
		mv.making(mv.movie(3));
	}

	public String[] movie(int cmd) throws Exception {
		
		imageList il = new imageList();
		ArrayList<File> imgs = il.getImg("png", il.ipl.TO_PAHT);
		
		String ffmpeg = "C:/FFmpeg/bin/ffmpeg";
		String fmt = "-f";
		String concat = "concat";
		String safe = "-safe";
		String input = "-i";
		String inputdata = "C:/Users/SCITMaster/Desktop/pirate/png/input.txt";
		String inputMusic = "C:/Users/SCITMaster/Desktop/pirate/heisPirate.mp3";
		String origin = "C:/Users/SCITMaster/Desktop/pirate.mp4";
		String output = "C:/Users/SCITMaster/Desktop/output.mp4";
		String last = "C:/Users/SCITMaster/Desktop/final.mp4";
		
		//사진 배열+음악 => 영상
		String[] code1 = new String[] { 
				ffmpeg, 
				fmt, concat, //concat 처리
				safe, "0", //오류 무시
				input, inputdata, //input.txt 입력
				input, inputMusic, //음악 삽입
				"-pix_fmt", "yuv420p",
				"-shortest",
				origin };
		
		//자막처리
		String[] code2 = new String[] { 
				ffmpeg, 
				input, origin,
				"-pix_fmt", "yuv420p",
				"-filter_complex", 
				 "drawtext=fontsize=60:fontfile=/Windows/Fonts/Tahoma.ttf:text='Pirates of the Caribbean':fontcolor=white:shadowcolor=gray:x=(w-text_w)/2:y=(h-text_h)/2:box=1: boxcolor=black:boxborderw=640:line_spacing=360:enable='between(t,8,11)',"
		        + "drawtext=fontsize=30:fontfile=/Windows/Fonts/Tahoma.ttf:text='Real Fun':fontcolor=white:shadowcolor=gray:x=(w-text_w)/2:y=(h-text_h)/2:box=1: boxcolor=black:boxborderw=640:line_spacing=360:enable='between(t,23,25)',"
		        +"drawtext=fontsize=60:fontfile=/Windows/Fonts/Tahoma.ttf:text='Joachim Ronning & Espen Sandberg':fontcolor=white:shadowcolor=gray:x=(w-text_w)/2:y=(h-text_h)/2:box=1: boxcolor=black:boxborderw=640:line_spacing=360:enable='between(t,29,31)',"
		        +"drawtext=fontsize=60:fontfile=/Windows/Fonts/Tahoma.ttf:text='Johnny Depp':fontcolor=white:shadowcolor=orange:x=(w-text_w)/2:y=(h-text_h)/2:enable='between(t,33,35)',"
		        +"drawtext=fontsize=60:fontfile=/Windows/Fonts/Tahoma.ttf:text='Orlando Bloom':fontcolor=white:shadowcolor=pink:x=(w-text_w)/2:y=(h-text_h)/2:enable='between(t,36,38)',"
		        +"drawtext=fontsize=60:fontfile=/Windows/Fonts/Tahoma.ttf:text='Kaya Scodelario':fontcolor=white:shadowcolor=red:x=(w-text_w)/2:y=(h-text_h)/2:enable='between(t,39,41)'"
		        +"[sub],"
		        +"[0:a]acopy[ac]",
				"-map","[sub]",
				"-map","[ac]",
				output};
		
		//필터처리
		String[] code3 = new String[] { 
				ffmpeg, 
				input, output,
				"-pix_fmt", "yuv420p",//픽셀 고정
				"-filter_complex", //복합필터 사용
				"[0:v]fade=t=in:st=0:d=3:alpha=0,"
				+ "fade=t=out:st=8:d=1:alpha=1[f1];"
				+ "[0:v]fade=t=in:st=10:d=1:alpha=0,"
				+ "fade=t=out:st=23:d=0.5:alpha=1[f2];"
				+ "[0:v]fade=t=in:st=24.5:d=0.5:alpha=0,"
				+ "fade=t=out:st=29:d=0.5:alpha=1[f3];"
				+ "[0:v]fade=t=in:st=30.5:d=0.5:alpha=0[f4];"
				+ "[0:v]fade=t=out:st=41:d=1:alpha=0,"
				+ "fade=t=in:st=44:d=1:alpha=1[f5];"
				+"[f1][f2][f3][f4][f5]concat=n=5:v=1:a=0 [v]",
			//	"[0:a]acopy[ac]", //audio파일 복사
				"-map","[v]", //fade 원본 영상이랑 필터 merge
			//	"-map","[a]", //원본 영상의 오디오와 복사한 오디오 merge
				last };

		switch (cmd) {
		case 1: return code1;
		case 2: return code2;
		case 3: return code3;
		
		default: System.out.println("[making code : unselected]"); break;
		}
		
		return code1;
	}
	
	public void making(String[] code) throws Exception{
		Process processDuration = new ProcessBuilder(code).redirectErrorStream(true).start();
		StringBuilder strBuild = new StringBuilder();
		try (BufferedReader processOutputReader = new BufferedReader(
				new InputStreamReader(processDuration.getInputStream(), Charset.defaultCharset()));) {
			String line;
			while ((line = processOutputReader.readLine()) != null) {
				strBuild.append(line + System.lineSeparator());
			}
			processDuration.waitFor();
		}
		String outputJson = strBuild.toString().trim();
		System.out.println(outputJson);
	}

}
