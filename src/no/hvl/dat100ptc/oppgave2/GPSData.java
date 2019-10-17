package no.hvl.dat100ptc.oppgave2;

import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class GPSData {

	private GPSPoint[] gpspoints;  // brukes til å peke på referansetabellen av GPS punkter 
	protected int antall = 0;  // Skal brukes til innsetelse i tabellen (holder kontroll på hvor neste punkt settes inn)

	public GPSData(int n) {

		// OPPGAVE - START
		
		
		gpspoints = new GPSPoint [n];
	

		// OPPGAVE - SLUTT

	}

	public GPSPoint[] getGPSPoints() {
		return this.gpspoints;
	}
	
	protected boolean insertGPS(GPSPoint gpspoint) {

		boolean inserted = false;

		// TODO - START
		
		if (this.antall < gpspoints.length) {
			gpspoints [this.antall]= gpspoint;
		this.antall ++;
		
		inserted = true;
		} 
		
		return inserted;
			

		// TODO - SLUTT
	}

	public boolean insert(String time, String latitude, String longitude, String elevation) {

		GPSPoint gpspoint;

		// TODO - START
		
	gpspoint = GPSDataConverter.convert(time, latitude, longitude, elevation);
	return this.insertGPS(gpspoint);
		}
	

		// TODO - SLUTT
		
	
	public void print() {

		System.out.println("====== Konvertert GPS Data - START ======");

		// TODO - START
		
		for (GPSPoint gpspoint : gpspoints) {
			System.out.println(gpspoint.toString());
			
		}
		// TODO - SLUTT
		System.out.println("====== Konvertert GPS Data - SLUTT ======");

	}
}
