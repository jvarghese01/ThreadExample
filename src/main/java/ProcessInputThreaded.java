import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



public class ProcessInputThreaded {
	
    private static final Logger logger = LogManager.getLogger(ProcessInputThreaded.class);

	public static void main(String[] args) throws IOException, InterruptedException {
		BufferedReader br = new BufferedReader(new FileReader(new File("/Users/jasonv/Documents/workspace/ThreadExample/test.txt")));
		String line = null;
		int lineCount = 0;
		ExecutorService exe = Executors.newFixedThreadPool(4);
		while((line = br.readLine())!=null){
			lineCount++;
			if(lineCount%100000000==0)
				logger.info("A="+lineCount);
			exe.execute(new ProcessFileTask(line,lineCount));
			if(lineCount%100000000==0)
				logger.info("B="+lineCount);


		}
		
		br.close();
		exe.shutdown();
		
		if(exe.awaitTermination(10, TimeUnit.DAYS)){
			logger.info("DONE");
		}
		
	}

}
