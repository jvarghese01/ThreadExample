import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;




public class ProcessInput {
	
    private static final Logger logger = LogManager.getLogger(ProcessInput.class);

	public static void main(String[] args) throws IOException {
		long start = System.currentTimeMillis();
		ProcessInput pi = new ProcessInput();
		pi.processFile();
		long end = System.currentTimeMillis();
		logger.info("total time: "+(end-start)+" milliseconds");

	}

	public void processFile() throws IOException{
		BufferedReader br = new BufferedReader(new FileReader(new File("/Users/jasonv/Documents/workspace/ThreadExample/test.txt")));
		String line = null;
		int lineCount = 0;
		while((line = br.readLine())!=null){
			lineCount++;
			if(lineCount%100000000==0)
				logger.info(lineCount);
			if(line.contains("jason")){
				logger.info("found it:"+line+ " -- LINE NUMBER:"+lineCount);
				break;
			}
		}
		br.close();
	}
}
