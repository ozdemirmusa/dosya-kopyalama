package yedek;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Ilk {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		deneme("kaynak", "hedef");

	}

	public static void deneme(String ana, String yedek) throws IOException {

		File f = new File(ana);
		File[] dizi = f.listFiles();
		for (File sira : dizi) {
			if (sira.canWrite()) {
				System.out.println("var");
			}
			else {
				System.out.println("yok");
			}
			if (sira.isDirectory()) {
				System.out.println(sira);
				File f2 = new File(yedek+sira.getName());
				f2.mkdir();
				deneme(ana+"/"+sira.getName(),yedek+sira.getName()+"/");
			}
			else if (sira.isFile()) {
				File f2=new File(yedek+sira.getName());
				//f2.createNewFile();
				BufferedReader br = null;
				PrintWriter pw = null;
				try {
					br = new BufferedReader(new FileReader(sira));
					pw = new PrintWriter(new FileWriter(f2));
					if (f2.createNewFile()) {
					System.out.println("Başarıyla dosya oluşturuldu");
					}
					 
					String satir;
					while ((satir = br.readLine()) != null) {
					pw.println(satir);
					System.out.println(satir);
					}
					} catch (IOException e1) {
					e1.printStackTrace();
					}
					 
					finally {
					pw.close();
					}
				
			}

		}
	}

}
