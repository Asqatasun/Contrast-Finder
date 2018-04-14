/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.asqatasun.contrastfinder.hsv;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import static junit.framework.Assert.assertEquals;
import junit.framework.TestCase;
import org.junit.Test;  // Junit 4 anotation @Test

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.asqatasun.contrastfinder.result.ColorCombinaison;
import org.asqatasun.utils.colorconvertor.ColorConverter;

/**
 *
 * @author alingua
 */
public class ColorFinderHsvPsychoTest extends TestCase {
    private static final float STEP_HUE = (1.0f/360.0f);
    private static final Logger LOGGER = LoggerFactory.getLogger(ColorFinderHsvPsychoTest.class);

    public ColorFinderHsvPsychoTest(String testName) {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    @Test
    public void testFindColorsNearColorOrange() {
        System.out.println("FindColorsNearColor");
        Color foregroundColor = new Color(255, 165, 0);
        Color backgroundColor = new Color(255, 255, 255);
        Float coefficientLevel = 3f;
        ColorFinderHsvPsycho instance = new ColorFinderHsvPsycho();
        List<ColorCombinaison> colorCombinaison = new ArrayList<ColorCombinaison>();
        instance.getColorFinderKey();
        instance.setHueBounder(15.0f);
        instance.setMaxCoefficient(0.01f);
        instance.setMaxBlue(60.0f);
        instance.setMaxGreen(60.0f);
        instance.setMaxRed(60.0f);
        instance.findColors(foregroundColor, backgroundColor, false, coefficientLevel);
        LOGGER.info("Nb SuggestedColors:" + instance.getColorResult().getSuggestedColors().size());
        Float initialHue = ColorConverter.getHue(foregroundColor);
        int counter = 0;
        for (ColorCombinaison combinaisons : instance.getColorResult().getSuggestedColors()) {
            LOGGER.info("Color found " + combinaisons.getHexaColor());
        }
//            if ((ColorConverter.getHue(combinaisons.getColor()) - initialHue) > (10.0f * STEP_HUE)) {
//                LOGGER.debug("Color :" + combinaisons.getColor() + "    COLOR : " + combinaisons.getContrast());
//                counter++;
//            }
//            else if ((initialHue - ColorConverter.getHue(combinaisons.getColor())) > (10.0f * STEP_HUE)) {
//                LOGGER.debug("Color :" + combinaisons.getColor() + "    COLOR : " + combinaisons.getContrast());
//                counter++;
//            }
////            LOGGER.debug("HashCode :" + colorCombinaison.hashCode() + "    COLOR : " + combinaisons.getContrast());
////            colorCombinaison.add(combinaisons);
//        }
//        LOGGER.debug("Out of bound values " + counter );
    }

//    @Test
//    public void testFindColorsNearColor() {
//        System.out.println("FindColorsNearColor");
//        Color foregroundColor = new Color(127, 127, 127);
//        Color backgroundColor = new Color(128, 128, 128);
//        Float coefficientLevel = 4.5f;
//        ColorFinderHsvPsycho instance = new ColorFinderHsvPsycho();
//        List<ColorCombinaison> colorCombinaison = new ArrayList<ColorCombinaison>();
//        instance.getColorFinderKey();
//        instance.findColors(foregroundColor, backgroundColor, false, coefficientLevel);
//        LOGGER.debug(instance.getColorResult().getSuggestedColors().size());
//        for (ColorCombinaison combinaisons : instance.getColorResult().getSuggestedColors()) {
//            LOGGER.debug("HashCode :" + colorCombinaison.hashCode() + "    COLOR : " + combinaisons.getContrast());
//            colorCombinaison.add(combinaisons);
//        }
//    }

    /**
     * Test of getColorFinderKey method, of class ColorFinderHsvPsycho.
     */
    @Test
    public void testGetColorFinderKey() {
        System.out.println("Key");
        ColorFinderHsv instance = new ColorFinderHsv();
        String result = instance.getColorFinderKey();
        assertEquals("HSV".toString(), result);
    }
}
