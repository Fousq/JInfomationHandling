package kz.zhanbolat.jinformation;

import static org.junit.Assert.assertTrue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }
    
    @Test
    public void Log4JTest() {
    	Logger logger = LogManager.getLogger(AppTest.class);
    	logger.debug("DEGUB");
    	logger.info("INFO");
    	logger.error("ERROR");
    	logger.fatal("FATAL");
    }
    
}
