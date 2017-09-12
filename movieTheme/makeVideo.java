package movieTheme;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class makeVideo {

	imagePathList ipl = new imagePathList();
	
	public static void main(String[] args) throws Exception {

		String ffmpeg = "C:/FFmpeg/bin/ffmpeg";
		String fmt = "-f";
		String concat = "concat";
		String safe = "-safe";
		String input = "-i";
		String inputdata = "C:/Users/SCITMaster/Desktop/pirate/png/input.txt";
		String inputMusic = "C:/Users/SCITMaster/Desktop/pirate/heisPirate.mp3";
		String output = "C:/Users/SCITMaster/Desktop/pirate.mp4";

		String[] code = new String[] { ffmpeg, fmt, concat, safe, "0", input, inputdata, input, inputMusic,
				/*"-acodec","copy", "-vcodec","libx264", "-b:a","128k", "-b:v","500K",
				"-r", "24", "-crf", "23", "-ar"," 44100",*/
				"-pix_fmt","yuv420p",
				output };

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
