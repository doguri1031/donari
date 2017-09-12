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
		txt += "duration 00:00:02.111";
		txt += "\r\n";

		for (int i = 0; i < imgs.size(); i++) {
			txt += "file '" + imgs.get(i).getName() + "'";
			txt += "\r\n";
			txt += "duration 00:00:02.111";
			txt += "\r\n";
		}

		fw.write(txt);
		fw.flush();

		// 객체 닫기
		fw.close();

	}
}
