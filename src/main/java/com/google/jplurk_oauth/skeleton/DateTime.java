package com.google.jplurk_oauth.skeleton;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DateTime {

    private static Log logger = LogFactory.getLog(DateTime.class);

    public final static SimpleDateFormat OFFSET_OUTPUT_FORMAT = createFormat("yyyy-M-d'T'HH:mm:ss");
    public final static SimpleDateFormat JS_INPUT_FORMAT = createFormat("E, dd MMM yyyy HH:mm:ss z");
    public final static SimpleDateFormat BIRTHDAY_FORMAT = createFormat("yyyy-MM-dd");

    private static SimpleDateFormat createFormat(String pattern){
        SimpleDateFormat fmt = new SimpleDateFormat(pattern, Locale.US);
        fmt.setTimeZone(TimeZone.getTimeZone("GMT"));
        return fmt;
    }
    
    protected static class TimeUtil {
        public static void setYear(Calendar time, int year) {
            time.set(Calendar.YEAR, year);
        }

        public static void setMonth(Calendar time, int month) {
            time.set(Calendar.MONTH, month -1);
        }

        public static void setDate(Calendar time, int date) {
            time.set(Calendar.DATE, date);
        }

        public static void setHour(Calendar time, int hour) {
            time.set(Calendar.HOUR_OF_DAY, hour);
        }

        public static void setMinute(Calendar time, int minute) {
            time.set(Calendar.MINUTE, minute);
        }
        public static void setSecond(Calendar time, int second) {
            time.set(Calendar.SECOND, second);
        }
    }

	private Calendar time = createGmtCalendar();

    private static Calendar createGmtCalendar() {
        return Calendar.getInstance(TimeZone.getTimeZone("GMT"));
    }

    private DateTime(int year, int month, int day) {
        time.clear();
        TimeUtil.setYear(time, year);
        TimeUtil.setMonth(time, month);
        TimeUtil.setDate(time, day);
    }

    private DateTime(int year, int month, int day, int hour, int minute, int second) {
        this(year, month, day);
        TimeUtil.setHour(time, hour);
        TimeUtil.setMinute(time, minute);
        TimeUtil.setSecond(time, second);
    }
    
    private DateTime(Calendar time){
        this.time = time;
    }
    
    private DateTime(Date time){
        this.time.setTime(time);
    }

    public static DateTime create(long offset) {
        Calendar calendar = createGmtCalendar();
        Date date = new Date(calendar.getTimeInMillis() + offset);
        calendar.setTime(date);
        return create(calendar);
    }
    
    public static DateTime create(Calendar calendar){
        logger.info("create DateTime from Calendar: " + calendar.getTime());
        return new DateTime(calendar);
    }

    public static DateTime create(String offset) {
        DateTime dateTime = null;
        Date date = null;

        try {
            date = OFFSET_OUTPUT_FORMAT.parse(offset);
            logger.info("create date time from[" + offset + "] by: "
                    + OFFSET_OUTPUT_FORMAT);
            logger.info("date is " + date);
        } catch (Exception e) {
            logger.debug(e.getMessage());
        }

        if (date == null) {
            try {
                date = JS_INPUT_FORMAT.parse(offset);
                logger.info("create date time from[" + offset + "] by: "
                        + JS_INPUT_FORMAT);
                logger.info("date is " + date);
            } catch (Exception e) {
                logger.debug(e.getMessage());
            }
        }

        if (date == null) {
            logger.warn("cannot parse date string: " + offset
                    + ". we will use now instead");
            return DateTime.now();
        }

        try {
            dateTime = new DateTime(date);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            dateTime = now();
        }

        logger.info("create date time from string: " + dateTime.toTimeOffset());
        return dateTime;
    }

    public static DateTime create(int year, int month, int day) {
        return new DateTime(year, month, day);
    }

    public static DateTime create(int year, int month, int day, int hour,
            int minute, int second) {
        return new DateTime(year, month, day, hour, minute, second);
    }

    public static DateTime now() {
        return create(createGmtCalendar());
    }

    protected String birthday() {
        return BIRTHDAY_FORMAT.format(time.getTime());
    }

    public String toTimeOffset() {
        return OFFSET_OUTPUT_FORMAT.format(toCalendar().getTime());
    }

    public Calendar toCalendar() {
        return time;
    }

    public static boolean isValidTimeOffset(String offset) {
        try {
            OFFSET_OUTPUT_FORMAT.parse(offset);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    
    @Override
    public int hashCode() {
        return time.hashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        if (other instanceof DateTime) {
            DateTime time = (DateTime) other;
            return time.toCalendar().equals(((DateTime) other).toCalendar());
        }
        return false;
    }

}
