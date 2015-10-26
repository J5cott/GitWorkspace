import static org.junit.Assert.*;
import org.json.*;
import org.junit.Test;
import org.junit.Before;

public class AItest {

	AI ai;
	
	@Before
	public void setup() throws Exception{
		
        JSONArray ja = new JSONArray(new String[]{"-","w","-","-","-","-","-","-",

                								  "b","b","w","-","-","-","-","-",

                								  "-","b","b","w","w","-","-","-",

                								  "-","-","w","b","w","-","-","-",

                								  "-","w","-","b","w","-","-","-",

                								  "-","-","-","-","-","-","-","-",

                								  "-","-","-","-","-","-","-","-",

                								  "-","-","-","-","-","-","-","-"});



ai = new AI(8,8,63,ja,"black",7000);

		
	}
	@Test

    public void test() {


		System.out.println(ai.isValid(1, 2));
        ai.randomAI();
        System.out.println(ai.isValid(5, 3));
        

    }

}
