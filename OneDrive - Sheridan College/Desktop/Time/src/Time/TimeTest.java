package Time;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class TimeTest {

	@Test
	public void testGetTotalSecondsGood() 
	{
	int seconds = 
	Time.getTotalSeconds("08:08:08");
	assertTrue("The seconds were not calculated properly", seconds==29288);
	}
	@Test
	public void testGetTotalMinutesGood() 
	{
	int minutes = 
	Time.getTotalMinutes("08:08:08");
	assertTrue("The minutes were not calculated properly", minutes==8);
	}
	@Test
	public void testGetTotalHoursGood()
	{
	int hours =
	Time.getTotalMinutes("08:08:08");
	assertTrue("The hours not calculated properly", hours==8);
	}
	
	
	

	@Test
	public void testGetTotalSecondsBad() 
	{
	assertThrows(
	 StringIndexOutOfBoundsException.class, 
	 ()-> {Time.getTotalSeconds("12:00");});
	
	}
	@Test
	public void testGetTotalMinutesBad() 
	{
	assertThrows(
	 StringIndexOutOfBoundsException.class, 
	 ()-> {Time.getTotalMinutes("12");});
	}
	@Test
	public void testGetTotalHoursBad() 
	{
	assertThrows(
	 StringIndexOutOfBoundsException.class, 
	 ()-> {Time.getTotalHours("");});
	}
	
	

	@Test
	public void testGetTotalSecondsBoundary() 
	{
	int seconds = 
	Time.getTotalSeconds("23:59:59");
	assertTrue("The seconds were not calculated properly", seconds==86399);
	}
	@Test
	public void testGetTotalMinutesBoundary() 
	{
	int minutes = 
	Time.getTotalMinutes("23:59:59");
	assertTrue("The minutes were not calculated properly", minutes==59);
	}
	@Test
	public void testGetTotalHoursBoundary() 
	{
	int hours = 
	Time.getTotalHours("23:59:59");
	assertTrue("The hours were not calculated properly", hours==23);
	}
	@Test
	public void testGetSecondsBoundary() 
	{
	int seconds = 
	Time.getSeconds("23:59:59");
	assertTrue("The seconds were not calculated properly", seconds==59);
	}
	
	@Test
	void testGetMilliseconds() {
		int milliseconds = Time.getMilliseconds("10:59:59:005");
		assertTrue("The milliseconds were not calculated properly", 
		milliseconds ==5);}
	
	@Test
	public void testGetMillisecondsGood() 
	{
	int Milliseconds = 
	Time.getMilliseconds("10:10:10:005");
	assertTrue("The milliseconds were not calculated properly", Milliseconds==5);
	}
	
	@Test
	public void testGetMillisecondsBad() 
	{
	assertThrows(
	 StringIndexOutOfBoundsException.class, 
	 ()-> {Time.getMilliseconds("10:10:10");});
	}
	
	@Test
	public void testGetMillisecondsBoundary() 
	{
	int Milliseconds = 
	Time.getMilliseconds("23:59:59:099");
	assertTrue("The milliseconds were not calculated properly", Milliseconds==99);
	}
	
	
	
	
	
	
		@ParameterizedTest
		@ValueSource(strings = { "05:00:00", "05:15:15", "05:59:59" })
		void testGetTotalHours(String candidate) {
		int hours = Time.getTotalHours(candidate);
		assertTrue("The hours were not calculated properly", 
		hours ==5);
		}
}

