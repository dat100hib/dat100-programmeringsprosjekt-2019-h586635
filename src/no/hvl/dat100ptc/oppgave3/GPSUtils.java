package no.hvl.dat100ptc.oppgave3;

import static java.lang.Math.*;

import java.util.Locale;

import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class GPSUtils {

	public static double findMax(double[] da) {

		double max; 
		
		max = da[0];
		
		for (double d : da) {
			if (d > max) {
				max = d;
			}
		}
		
		return max;
	}

	public static double findMin(double[] da) {

		double min;

		// TODO - START
		min = da[0];
		
		for (double m : da) {
			if (m < min) {
				min = m;
			}
		}
		
		return min;

		// TODO - SLUTT

	}

	public static double[] getLatitudes(GPSPoint[] gpspoints) {

		// TODO - START
		
		double[] breddegrad = new double [gpspoints.length];
		for (int i = 0; i < gpspoints.length; i++) {
			breddegrad [i]= gpspoints[i].getLatitude();
		}
		return breddegrad;
		
		// TODO - SLUTT
	}

	public static double[] getLongitudes(GPSPoint[] gpspoints) {

		// TODO - START

		double [] lengdegrad = new double [gpspoints.length];
		for (int i = 0; i < gpspoints.length; i++) {
			lengdegrad [i] = gpspoints[i].getLongitude();
		}
		return lengdegrad;
		
		// TODO - SLUTT

	}

	private static int R = 6371000; // jordens radius

	public static double distance(GPSPoint gpspoint1, GPSPoint gpspoint2) {

		double a,c,d;
		double latitude1, longitude1, latitude2, longitude2;

		// TODO - START

		latitude1 =Math.toRadians(gpspoint1.getLatitude());
		longitude1 = Math.toRadians(gpspoint1.getLongitude());
		latitude2 = Math.toRadians(gpspoint2.getLatitude());
		longitude2 = Math.toRadians(gpspoint2.getLongitude());
		
		double latitudeDiff = latitude2 - latitude1;
		double longitudeDiff = longitude2 - longitude1;
		
		a = pow(sin(latitudeDiff / 2), 2) + cos(latitude1) * cos(latitude2) * (pow(sin(longitudeDiff / 2),2));
		c = 2 * atan2(sqrt(a), sqrt(1-a));
		d = R * c;
		
		return d; 
		// TODO - SLUTT

	}

	public static double speed(GPSPoint gpspoint1, GPSPoint gpspoint2) {

		int secs;
		double speed;

		// TODO - START

		double avstand = distance(gpspoint1, gpspoint2);
		double avstandKm= avstand/1000;
			secs = gpspoint2.getTime()- gpspoint1.getTime();		
			double timer = secs/3600.0;
			double fart;
			
			return fart = avstandKm/timer;
			
			// TODO - SLUTT

	}

	public static String formatTime(int secs) {

		String timestr;
		String TIMESEP = ":";

		// TODO - START
		int time = secs/3600;
		int rest = secs % 3600;
		int min = rest / 60;
		int sek = rest % 60;
		
		//Gjør om int til String:
		
		String ttStr = String.format("%02d", time);
		String minStr = String.format("%02d", min);
		String sekStr = String.format("%02d", sek);
		
		timestr = String.format("%10s", ttStr + TIMESEP + minStr + TIMESEP + sekStr);
		
		return timestr;
		// TODO - SLUTT

	}
	private static int TEXTWIDTH = 10;

	public static String formatDouble(double d) {

		String str;

		// TODO - START

		d = Math.round(d*100)/100.0;
		
		str = String.format(Locale.US, "%"+ TEXTWIDTH + ".2f", d);
		                                                                                                                                                            
		System.out.print(str);

		return str;
		// TODO - SLUTT
		
	}
}
