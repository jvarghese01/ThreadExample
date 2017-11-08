import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ProcessFileTask implements Runnable {

    private static final Logger logger = LogManager.getLogger(ProcessFileTask.class);

	String line;
	int count;
	
	public ProcessFileTask(String line,int count){
		this.line = line;		
		this.count = count;
		if(count%10000000==0)
			logger.info("C="+count);
	}
	public void run() {
		if(count%10000000==0)
			logger.info("D="+count);
		if(line.contains("jason")){
			logger.info("found it:"+line+ " -- LINE NUMBER:"+count);
		}
	}

}
