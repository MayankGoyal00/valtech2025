package day5;

import static org.junit.jupiter.api.Assertions.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;

class DateTimeTest {

	@Test
	void test() throws Exception {
		Date now = new Date();
		System.out.println(now);
		
		Date independenceDay = new Date(47,7,15); //debricated 
		System.out.println(independenceDay);
		//yyyy->year yy
		//MM-> numeric month MMM->alpha or more
		//dd-> day
		// hour -> hh
		// minute -> mm
		// second -> ss
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		System.out.println(df);
		Date republicDay =df.parse("26-01-1950");
		System.out.println(republicDay);
	}

}
