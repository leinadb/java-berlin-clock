package com.ubs.opsit.interviews;

public class BerlinClockSecondSimpleDisplay implements BerlinClockSecondDisplay {

    private static final String LIGHT_TURNED_YELLOW = "Y";
    private static final String LIGHT_TURNED_OFF = "O";

    @Override
    public String display(int seconds) {
        if (seconds % 2 == 0)
            return LIGHT_TURNED_YELLOW + "\r\n";
        else
            return LIGHT_TURNED_OFF + "\r\n";
    }

}
