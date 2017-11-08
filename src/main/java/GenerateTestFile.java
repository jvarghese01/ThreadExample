import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class GenerateTestFile {

	String[] alphabet = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
		
	public static void main(String[] args) throws IOException {
		GenerateTestFile gtf = new GenerateTestFile();
		gtf.createTestFile();
	}

	
	public void createTestFile() throws IOException{
		BufferedWriter br = new BufferedWriter(new FileWriter(new File("/Users/jasonv/Documents/workspace/ThreadExample/test.txt")));
		for (int count=0;count<1000000000;count++){
			br.write(createRandomLine()+"\n");
		}
		br.close();
	}
	
	public String createRandomLine(){
		Random r = new Random();
		StringBuilder sb = new StringBuilder();
		for (int a=0;a<(r.nextInt(25));a++){
			sb.append(alphabet[r.nextInt(25)]);
		}
		return sb.toString();
	}
}
