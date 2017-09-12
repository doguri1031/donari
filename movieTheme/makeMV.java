package movieTheme;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class makeMV {

	public static void main(String[] args) {

		makeMV mv = new makeMV();
	}
	

	public void movie() throws Exception{
		String ffmpeg = "C:/FFmpeg/bin/ffmpeg";
		String fmt = "-f";
		String concat = "concat";
		String safe = "-safe";
		String input = "-i";
		String inputdata1 = "C:/Users/SCITMaster/Desktop/pirate/png/input01.txt";
		String inputdata2 = "C:/Users/SCITMaster/Desktop/pirate/png/input02.txt";
		String inputdata3 = "C:/Users/SCITMaster/Desktop/pirate/png/input03.txt";
		String inputMusic = "C:/Users/SCITMaster/Desktop/pirate/heisPirate.mp3";
		String output = "C:/Users/SCITMaster/Desktop/pirate.mp4";
		
		String[] code = new String[] {
				ffmpeg, 
				input, inputdata1, 
				input, inputMusic,
				output};

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
