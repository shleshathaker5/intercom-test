package intercom.utility;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public final class CalculateDistanceUtilities {
	
	private static final Logger logger = LoggerFactory.getLogger(CalculateDistanceUtilities.class);
	
	/**
     * Radius of Earth in Kilometers (KM).
     */
    private static final int EARTH_RADIUS = 6371;
	
	/**
     * <p>
     * This method uses the great-circle distance formula to calculate distance
     * between two points by the latitude and longitude coordinates.</p>
     *
     * @param initLati Initial latitude
     * @param initLong Initial longitude
     * @param finallati Final latitude
     * @param finalLong Final longitude
     * @return The distance in Kilometers (Km)
     */
    public static double distanceInKiloMetres(double initLati, double initLong, double finallati, double finalLong) {

    	logger.info("Calculating distance between Start and end coordinates");
    	
        double diffLati = Math.toRadians(finallati - initLati);
        double diffLong = Math.toRadians(finalLong - initLong);
        
        double radiusInitLati = Math.toRadians(initLati);
        double radiusFinalLati = Math.toRadians(finallati);

        // p and q are the 'sides' from the spherical triangle.
        double p = Math.pow(Math.sin(diffLati / 2), 2) + Math.pow(Math.sin(diffLong / 2), 2) * Math.cos(radiusInitLati) * Math.cos(radiusFinalLati);
        double q = 2 * Math.asin(Math.sqrt(p));

        return EARTH_RADIUS * q;
    }

}
