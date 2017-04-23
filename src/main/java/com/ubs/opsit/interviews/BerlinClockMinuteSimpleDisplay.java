package com.ubs.opsit.interviews;

public class BerlinClockMinuteSimpleDisplay implements BerlinClockMinuteDisplay {
    private static final int AMOUNT_OF_MINUTES_PER_ONE_TOP_LIGHT = 5;
    private static final String LIGHT_TURNED_RED = "R";
    private static final String LIGHT_TURNED_OFF = "O";
    private static final String LIGHT_TURNED_YELLOW = "Y";
    private static final String FIRST_ROW_ALL_LIGHTS_TURNED_OFF = "OOOOOOOOOOO";
    private static final String SECOND_ROW_ALL_LIGHTS_TURNED_OFF = "OOOO";


    @Override
    public String display(int minutes) {
        int numberOfLightsToBeTurnedOnForFirstRow = minutes / AMOUNT_OF_MINUTES_PER_ONE_TOP_LIGHT;
        int numberOfLightsToBeTurnedOnForSecondRow = minutes % AMOUNT_OF_MINUTES_PER_ONE_TOP_LIGHT;
        StringBuilder result = new StringBuilder();
        String topRow = FIRST_ROW_ALL_LIGHTS_TURNED_OFF;
        String bottomRow = SECOND_ROW_ALL_LIGHTS_TURNED_OFF;

        for (int i = 0; i < numberOfLightsToBeTurnedOnForFirstRow; i++) {
            if (ifItIsQuarterOfTheHour(i))
                topRow = topRow.replaceFirst(LIGHT_TURNED_OFF, LIGHT_TURNED_RED);
            else
                topRow = topRow.replaceFirst(LIGHT_TURNED_OFF, LIGHT_TURNED_YELLOW);
        }

        for (int i = 0; i < numberOfLightsToBeTurnedOnForSecondRow; i++) {
            bottomRow = bottomRow.replaceFirst(LIGHT_TURNED_OFF, LIGHT_TURNED_YELLOW);
        }
        result.append(topRow);
        result.append("\r\n");
        result.append(bottomRow);
        return result.toString();
    }


    private boolean ifItIsQuarterOfTheHour(int i) {
        int _15minutes = 3;
        int _5minutes = 1;
        return (i + _5minutes) % _15minutes == 0;
    }

}
