package com.ubs.opsit.interviews;

public class BerlinClockHourSimpleDisplay implements BerlinClockHourDisplay {

    private static final String LIGHT_TURNED_RED = "R";
    private static final String LIGHT_TURNED_OFF = "O";
    private static final String ALL_LIGHTS_TURNED_OFF = "OOOO";
    private static final int AMOUNT_OF_HOURS_PER_ONE_TOP_LIGHT = 5;

    @Override
    public String display(int hours) {

        int numberOfLightsToBeTurnedOnForFirstRow = hours / AMOUNT_OF_HOURS_PER_ONE_TOP_LIGHT;
        int numberOfLightsToBeTurnedOnForSecondRow = hours % AMOUNT_OF_HOURS_PER_ONE_TOP_LIGHT;
        StringBuilder result = new StringBuilder();
        String topRow = ALL_LIGHTS_TURNED_OFF;
        String bottomRow = ALL_LIGHTS_TURNED_OFF;

        for (int i = 0; i < numberOfLightsToBeTurnedOnForFirstRow; i++) {
            topRow = topRow.replaceFirst(LIGHT_TURNED_OFF, LIGHT_TURNED_RED);
        }

        for (int i = 0; i < numberOfLightsToBeTurnedOnForSecondRow; i++) {
            bottomRow = bottomRow.replaceFirst(LIGHT_TURNED_OFF, LIGHT_TURNED_RED);
        }
        result.append(topRow);
        result.append("\r\n");
        result.append(bottomRow);
        result.append("\r\n");
        return result.toString();
    }
}

