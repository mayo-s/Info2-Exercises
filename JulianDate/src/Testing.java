
public class Testing {
	
	JulianDate jd = new JulianDate();
	MetricDate md = new MetricDate();
	Converter c = new Converter();
	
	public void test1(int currentDay){
		int date[] = {1991, 11, 29};
		int test1jd = jd.GD2JD(date);
		int[] test1md = md.JD2MD(currentDay - test1jd);	
		String weekday = c.weekday(test1jd);
		System.out.println("\nTest Case #1");
		System.out.println("Given gregorian date: " + date[2] + "-" + date[1] + "-" + date[0]);	
		System.out.println("Expected Julian Date:  2448590 \nCalculated Julian Date: " + test1jd);
		System.out.println("Expected Metric Date:          \nCalculated Metric Date: " + test1md[0] + " years " + test1md[1] + " month " + test1md[2]
				+ " weeks " + test1md[3] + " days");
		System.out.println("This should be a Friday. \nCalulated a: " + weekday);
	}
	
	public void test2(int currentDay){
		int date[] = {1984, 1, 15};
		int test2jd = jd.GD2JD(date);
		int[] test2md = md.JD2MD(currentDay - test2jd);	
		String weekday = c.weekday(test2jd);
		System.out.println("\nTest Case #2");		
		System.out.println("Given gregorian date: " + date[2] + "-" + date[1] + "-" + date[0]);
		System.out.println("Expected Julian Date: 2445716 \nCalculated Julian Date: " + test2jd);
		System.out.println("Expected Metric Date:          \nCalculated Metric Date: " + test2md[0] + " years " + test2md[1] + " month " + test2md[2]
				+ " weeks " + test2md[3] + " days");		
		System.out.println("This should be a Sunday. \nCalulated a: " + weekday);
	}
	
	public void test3(int currentDay){
		int date[] = {2016, 5, 10};
		int test3jd = jd.GD2JD(date);
		int[] test3md = md.JD2MD(currentDay - test3jd);
		String weekday = c.weekday(test3jd);
		System.out.println("\nTest Case #3");		
		System.out.println("Given gregorian date: " + date[2] + "-" + date[1] + "-" + date[0]);
		System.out.println("Expected Julian Date: 2457519 \nCalculated Julian Date: " + test3jd);
		System.out.println("Expected Metric Date:          \nCalculated Metric Date: " + test3md[0] + " years " + test3md[1] + " month " + test3md[2]
				+ " weeks " + test3md[3] + " days");		
		System.out.println("This should be a Tuesday. \nCalulated a: " + weekday);
	}
}
