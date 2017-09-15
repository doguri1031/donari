package movieTheme;

import java.io.File;
import java.util.ArrayList;


public class Main {

	public static void main(String[] args) throws Exception {

		imageList il = new imageList();
		imageResize imgresize = new imageResize();
		imagePathList ipl = new imagePathList();
		mkContentsList mkcl = new mkContentsList();
		
		// 이미지 리스트 불러오기
		ArrayList<File> imgs = il.getImg("jpg", ipl.ORIGIN_PAHT);
		
		//이미지 사이즈 체크
		int width = 640;
		int height = 360;
		if (!imgresize.sizeCheck(imgs, width, height)) {
			System.out.println("[wrong size] run resize");
		}
		
		//포맷 설정
		String format = "png";
		
		//리사이즈
		imgresize.resize(imgs, format, width, height);
		System.out.println("[resize complete]");
		
		//리스트 업데이트
		imgs = il.getImg(format, ipl.TO_PAHT);
		
		//imgresize.getInputs(imgs);
		
//		makeMV mk = new makeMV();
		
	}

}
