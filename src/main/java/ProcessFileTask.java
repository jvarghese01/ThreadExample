import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ProcessFileTask implements Runnable {

    private static final Logger logger = LogManager.getLogger(ProcessFileTask.class);

	String line;
	int count;
	
	public ProcessFileTask(String line,int count){
		this.line = line;		
		this.count = count;
	}
	public void run() {		
		if(line.contains("jason")){
			logger.info("found it:"+line+ " -- LINE NUMBER:"+count);
		}
	}

}
