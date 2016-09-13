package com.violin.qlcode;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;
//获取已知路径下面最大的文件
public class 求路径下面最大的文件 {
	public static void main(String[] args) {
		File file = new File("D://root");
		File[] files;
		search(file);
		System.out.println("搜索结束");
	}

	class myfilefileter implements FileFilter {

		public boolean accept(File file) {
			// TODO Auto-generated method stub
			if (file.isDirectory()) {
				return false;
			} else {
				return true;
			}
		}
	}
	public static  File search(File file){
		if(file.isFile()){
			if(file.length()>=Long.valueOf("24")){
				System.out.println(file+":"+file.length());
			}
		}else{
			File[] list;
			list = file.listFiles();
			for(int i=0;i<list.length;i++){
				search(list[i]);
			}
		}
		return null;
	}
}
