package com.ubs.opsit.interviews;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;

public class TimeConverterImpl implements TimeConverter {

    private BerlinClockHourDisplay hourDisplay;
    private BerlinClockMinuteDisplay minuteDisplay;
    private BerlinClockSecondDisplay secondDisplay;

    public TimeConverterImpl() {
        this.hourDisplay = new BerlinClockHourSimpleDisplay();
        this.minuteDisplay = new BerlinClockMinuteSimpleDisplay();
        this.secondDisplay = new BerlinClockSecondSimpleDisplay();
    }

    @Override
    public String convertTime(String aTime) {
        LocalTime time = convertToLocalTime(aTime);

        int hours = time.getHour();
        hours = reinitializeHoursIfSpecialCaseOccurs(aTime, hours);
        int minutes = time.getMinute();
        int seconds = time.getSecond();

        StringBuilder result = prepareClockDisplay(hours, minutes, seconds);

        return result.toString();
    }

    private StringBuilder prepareClockDisplay(int hours, int minutes, int seconds) {
        StringBuilder result = new StringBuilder();
        result.append(secondDisplay.display(seconds));
        result.append(hourDisplay.display(hours));
        result.append(minuteDisplay.display(minutes));
        return result;
    }

    private int reinitializeHoursIfSpecialCaseOccurs(String aTime, int hours) {
        String midnight = "24:00:00";
        if (midnight.equals(aTime)) {
            hours = 24;
        }
        return hours;
    }

    private LocalTime convertToLocalTime(String aTime) {
        LocalTime time = LocalTime.parse(aTime,
                DateTimeFormatter.ISO_LOCAL_TIME.withResolverStyle(ResolverStyle.SMART));
        return time;
    }


}
