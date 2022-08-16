public class NextDayCalculator {
    public static final String CONCATENATION = "/";
    public static final int FIRSTOFMONTH = 1;
    public static final int FIRSTOFYEAR = 1;
    public static final int LASTOFYEAR = 12;

    public static String getNextDay(int dayTest, int monthTest, int yearTest){
        int lastOfMonth = getLastOfMonth( monthTest,yearTest);
        if(dayTest== lastOfMonth){
            if(monthTest == LASTOFYEAR){
                return FIRSTOFMONTH+CONCATENATION+ FIRSTOFYEAR +CONCATENATION + ++yearTest;
            }
            return FIRSTOFMONTH +CONCATENATION+(monthTest+ 1)+CONCATENATION+yearTest;
        }
        return (dayTest+ 1)+ CONCATENATION +monthTest+ CONCATENATION +yearTest;
    }

    private static int getLastOfMonth(int monthTest, int yearTest) {
        int lastOfMonth = 0;
        switch (monthTest) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 4:
            case 6:
            case 9:
            case 11:
                return  30;
            case 2:
                if (checkLeapYear(yearTest)) {
                    return  29;

                } else {
                    return 28;
                }
            default:
                return  31;
        }

    }

    public static boolean checkLeapYear(int yearTest) {
        boolean isLeapYear = false;
        if (yearTest % 4 == 0) {
            if (yearTest % 100 == 0) {
                if (yearTest % 400 == 0) {
                    isLeapYear = true;
                }
            } else {
                isLeapYear = true;
            }
        }
        return isLeapYear;
    }
}
