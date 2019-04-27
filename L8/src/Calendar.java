import java.util.GregorianCalendar;

public class Calendar {
    private GregorianCalendar gregorianCalendar;
    public static int[] numberOfDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public Calendar() {
        gregorianCalendar = new GregorianCalendar();
    }

    public int daysInMonth(int month, int year) {
        if (month != 1) return numberOfDays[month];
        if (year > 1582) {
            if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) return 29;
            return 28;
        } else if (year % 2 == 0) return 29;
        else return 28;
    }

    public int monthToday() {
        return gregorianCalendar.getTime().getMonth();
    }

    public int yearToday() {
        return gregorianCalendar.getTime().getYear() + 1900;

    }

    public int getFirst(int month, int year) {
        if (year > 1582 || (year == 1582 && month >= 10)) {
            int YY = (year - 1) % 100;
            int C = (year - 1) - YY;
            int G = YY + YY / 4;
            int Jan = (((((C / 100) % 4) * 5) + G) % 7);
            switch (month) {
                case 11:
                    Jan += 30;
                case 10:
                    Jan += 31;
                case 9:
                    Jan += 30;
                case 8:
                    Jan += 31;
                case 7:
                    Jan += 31;
                case 6:
                    Jan += 30;
                case 5:
                    Jan += 31;
                case 4:
                    Jan += 30;
                case 3:
                    Jan += 31;
                case 2:
                    Jan += 28;
                case 1:
                    Jan += 31;
                    break;
                default:
                    break;
            }
            if (daysInMonth(1, year) == 29 && month > 1) Jan++;
            return (Jan) % 7;
        }
        else{
            int z=year;
            int c=0;
            if(month<2){
                z--;
                c=2;
            }
            return ((23*month/9 + 1 + 4 + year + z/4 + z/100 + z/400 - c)+1)%7;
        }
    }

}
