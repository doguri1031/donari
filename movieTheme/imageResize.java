package movieTheme;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class imageResize {
	imagePathList ipl = new imagePathList();
	imageList il = new imageList();

	public boolean sizeCheck(ArrayList<File> imgs, int width, int height) throws Exception {
		boolean result = false;
		for (File f : imgs) {
			BufferedImage img = ImageIO.read(f);
			if (img.getWidth() == width && img.getHeight() == height) {
				result = true;
			}
		}
		return result;
	}

	public void resize(ArrayList<File> imgs, String format, int width, int height) throws Exception {

		// 폴더생성 유무 확인
		if (ipl.TO_PAHT.isEmpty()) {
			File f = new File(ipl.TO_PAHT);
			System.out.println("[make a empty folder]");
		}

		int count = 1;
		for (File in : imgs) {
			// 이미지 읽어오기
			BufferedImage inputImage = ImageIO.read(in);

			// String[] ext = { "bmp", "gif", "jpg", "jpeg", "png" };

			// for (String format : ext) {
				
			
			BufferedImage outputImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
			Graphics2D g = outputImage.createGraphics();
			g.drawImage(inputImage, 0, 0, width, height, null);

			File out = new File(ipl.TO_PAHT + "/" + count + ".png");
			FileOutputStream fos = new FileOutputStream(out);
			ImageIO.write(outputImage, format, fos);
			// }
			count++;
		}
		System.out.println("[get imgs again]");
		imgs = il.getImg("png", ipl.TO_PAHT);
		getTxt(imgs);
		System.out.println("[make input.txt complete]");
	}

	public void getTxt(ArrayList<File> imgs) throws IOException {
		File file = new File(ipl.TO_PAHT + "/input.txt");
		
		// true 지정시 파일의 기존 내용에 이어서 작성
		FileWriter fw = new FileWriter(file, true);

		// 파일안에 문자열 쓰기
		String txt = new String();
		txt += "file '" + imgs.get(0).getName() + "'";
		txt += "\r\n";
		txt += "duration 00:00:04.000";
		txt += "\r\n";
		//System.out.println("[txt 1] "+txt);
		fw.write(txt);
		fw.flush();
		txt="";
		
		for (int i = 1; i < 4; i++) {
			txt += "file '" + imgs.get(i).getName() + "'";
			txt += "\r\n";
			txt += "duration 00:00:01.000";
			txt += "\r\n";
			//System.out.println("[txt 2-4] "+txt);
		}
		fw.write(txt);
		fw.flush();
		txt="";
		
		for (int i = 4; i < 6; i++) {
			txt += "file '" + imgs.get(i).getName() + "'";
			txt += "\r\n";
			txt += "duration 00:00:02.500";
			txt += "\r\n";
			//System.out.println("[txt 5-6] "+txt);
		}
		fw.write(txt);
		fw.flush();
		txt="";
		
		for (int i = 6; i < 11; i++) {
			txt += "file '" + imgs.get(i).getName() + "'";
			txt += "\r\n";
			txt += "duration 00:00:01.500";
			txt += "\r\n";
			//System.out.println("[txt 7-11] "+txt);
		}
		fw.write(txt);
		fw.flush();
		txt="";
		
		for (int i = 11; i < 18; i++) {
			txt += "file '" + imgs.get(i).getName() + "'";
			txt += "\r\n";
			txt += "duration 00:00:00.500";
			txt += "\r\n";
			//System.out.println("[txt 12-18] "+txt);
		}
		fw.write(txt);
		fw.flush();
		txt="";
		
		txt += "file '" + imgs.get(18).getName() + "'";
		txt += "\r\n";
		txt += "duration 00:00:03.000";
		txt += "\r\n";
		//System.out.println("[txt 19] "+txt);
		fw.write(txt);
		fw.flush();
		txt="";
		
		for (int i = 19; i < 22; i++) {
			txt += "file '" + imgs.get(i).getName() + "'";
			txt += "\r\n";
			txt += "duration 00:00:01.000";
			txt += "\r\n";
			//System.out.println("[txt 20-22] "+txt);
		}
		fw.write(txt);
		fw.flush();
		txt="";
		
		txt += "file '" + imgs.get(22).getName() + "'";
		txt += "\r\n";
		txt += "duration 00:00:03.000";
		txt += "\r\n";
		//System.out.println("[txt 23] "+txt);
		fw.write(txt);
		fw.flush();
		txt="";

		for (int i = 23; i < 26; i++) {
			txt += "file '" + imgs.get(i).getName() + "'";
			txt += "\r\n";
			txt += "duration 00:00:01.000";
			txt += "\r\n";
			//System.out.println("[txt 24-26] "+txt);
		}
		fw.write(txt);
		fw.flush();
		txt="";
		
		txt += "file '" + imgs.get(26).getName() + "'";
		txt += "\r\n";
		txt += "duration 00:00:03.000";
		txt += "\r\n";
		//System.out.println("[txt 27] "+txt);
		
		fw.write(txt);
		fw.flush();
		txt="";

		// 객체 닫기
		fw.close();

	}
	
}
