package intercom.utility;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalculateDistanceUtilitiesTest {
	
	private double initLati;
    private double initLong;
    private double finalLati;
    private double finalLong;


    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * <code>assertNotEquals</code> test using empty variables to verify the
     * result returned by the distanceInKm method.
     */
    @Test
    public void testDistanceInKmEmptyVars() {
        double expResult = 0.0;
        double result = CalculateDistanceUtilities.distanceInKiloMetres(initLati, initLong, finalLati, finalLong);
        assertEquals(expResult, result, 0.0);
    }
    
    /**
     * Test of distanceInKm method for more than 100 KM example.
     */
    @Test
    public void testDistanceBsbForInKm() {
    	initLati = 53.339428;
        initLong = -6.257664;
        finalLati = 51.92893;
        finalLong = -10.27699;
        double expResult = 313.2556337814157;
        double result = CalculateDistanceUtilities.distanceInKiloMetres(initLati, initLong, finalLati, finalLong);

        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of distanceInKm method for less than 100 KM example.
     */
    @Test
    public void testDistanceMadBarInKm() {
        initLati = 53.339428;
        initLong = -6.257664;
        finalLati = 52.986375;
        finalLong = -6.043701;
        double expResult = 41.7687255008362;
        double result = CalculateDistanceUtilities.distanceInKiloMetres(initLati, initLong, finalLati, finalLong);

        assertEquals(expResult, result, 0.0);
    }
}
