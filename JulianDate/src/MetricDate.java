/**
 * @author Philip Daduna & Mario Schuetz 
 */
public class MetricDate extends JulianDate {

	public MetricDate(){
		
	}
	
	public int[] JD2MD(int date){		
		
		int years = date/1000;
		int month = (date - years*1000)/100;
		int weeks = (date - years*1000 - month*100)/10;
		int days = date - years*1000 - month*100 - weeks*10;
		
		int[] MD = {years, month, weeks, days};
		
		return MD;
	}
	
	public int MD2JD(int[] metricDate){		
		int JD = metricDate[0]*1000 + metricDate[1]*100 + metricDate[2]*10 + metricDate[3];
		return JD;
	}	
}
