package movieTheme;

import java.io.File;
import java.util.ArrayList;

public class imageList {

	imagePathList ipl = new imagePathList();

	public ArrayList<File> getImg(String imgfmt, String path) {
		
		ArrayList<File> imgs = new ArrayList<>();

		//전체파일 읽기
		File[] files = new File(path).listFiles();

		//원하는 포맷의 이미지만 리스트에 담기
		for (int i = 0; i < files.length; i++) {
			if (files[i].toString().endsWith("."+imgfmt)) {
				imgs.add(files[i]);
			}
		}

		return imgs;
	}
	
	//전체 파일 리스트
	public File[] fileList(){
		File[] files = new File(ipl.TO_PAHT).listFiles();
		return files;
	}

}

