package org.example;

import java.util.Date;

public class Utilities {
    public static double dateReduction (Date date1, Date date2) {
        return (((date1.getYear() - date2.getYear()) * 365) +
                ((date1.getMonth()) - date2.getMonth() * 30) +
                (date1.getDate() - date2.getDate()));
    }
}
