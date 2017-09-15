package movieTheme;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class imageList {

	imagePathList ipl = new imagePathList();

	// 원하는 포맷의 이미지만 File ArrayList로 반환
	public ArrayList<File> getImg(String imgfmt, String path) {

		ArrayList<File> imgs = new ArrayList<>();

		// 전체파일 읽기
		File[] files = new File(path).listFiles();
		files = sortFileList(files);
		
		// 원하는 포맷의 이미지만 리스트에 담기
		for (int i = 0; i < files.length; i++) {
			if (files[i].toString().endsWith("." + imgfmt)) {
				imgs.add(files[i]);
			}
		}

		return imgs;
	}

	// 전체 파일 리스트
	public File[] sortFileList(File[] files) {
		Arrays.sort(files, new Comparator<Object>() {
			@Override
			public int compare(Object object1, Object object2) {

				String s1 = "";
				String s2 = "";

				s1 = ((File) object1).getName();
				s2 = ((File) object2).getName();

				return s1.compareTo(s2);
			}
		});
		return files;
	}

}
