package houzz;


/**
 * Project Name : Company Algorithm Solution
 * Package Name : houzz
 * File Name : CalendarAddDay
 * Creator : Edward
 * Date : Aug, 2017
 * Description : TODO
 */
public class CalendarAddDay {
    static class Calendar {
        int year;
        int month;
        int date;

        public Calendar(int year, int month, int date) {
            this.year = year;
            this.month = month;
            this.date = date;
        }

        public void addDate(int curAddDate) {
            int addYear = curAddDate / 365;
            int addMonth = curAddDate % 365 / 30;
            int addDate = curAddDate % 365 % 30;
            year += addYear;
            month += addMonth;
            helperMonth(month);
            date += addDate;
            helperDate(date);

        }
        public void helperMonth(int curMonth) {
            if (curMonth > 12){
                year++;
                month %= 12;
            }
        }

        public void helperDate(int curDate) {
            if (date > 30) {
                month++;
                helperMonth(month);
                date %= 30;
            }
        }

        public void print() {
            System.out.println("The current date is : "+ year +"年" + month + "月" + date+"日");
        }
    }
    public static void main(String[] args) {
        // create a calendar
        Calendar cal = new Calendar(2017,11,20);
        cal.print();
        cal.addDate(54);
        cal.print();
    }
}
