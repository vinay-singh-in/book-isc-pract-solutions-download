import java.util.*;

class UserLog {
    private int id[];
    private String loginTime[], loginDate[], logoutTime[], logoutDate[];
    int duration[], maxIndex;
    private static int month[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

    public UserLog(int id[], String loginTime[], String loginDate[], String logoutTime[], String logoutDate[]) {
        this.id = id;
        this.loginTime = loginTime;
        this.loginDate = loginDate;
        this.logoutTime = logoutTime;
        this.logoutDate = logoutDate;
        duration = new int[id.length];
        process();
    }

    private void process() {
        String temp[];
        int hr, min, dd, mm, finalMinutes, initialMinutes, delta, maxDelta = 0;
        for (int i = 0; i < id.length; i++) {
            temp = loginTime[i].split(":");
            hr = Integer.parseInt(temp[0]);
            min = Integer.parseInt(temp[1]);

            temp = loginDate[i].split("-");
            dd = Integer.parseInt(temp[0]);
            mm = Integer.parseInt(temp[1]);

            initialMinutes = getMinutes(dd, mm, hr, min);

            temp = logoutTime[i].split(":");
            hr = Integer.parseInt(temp[0]);
            min = Integer.parseInt(temp[1]);

            temp = logoutDate[i].split("-");
            dd = Integer.parseInt(temp[0]);
            mm = Integer.parseInt(temp[1]);

            finalMinutes = getMinutes(dd, mm, hr, min);
            delta = finalMinutes - initialMinutes;
            duration[i] = delta;
            if (delta > maxDelta) {
                maxDelta = delta;
                maxIndex = i;
            }

        }
    }

    private static int getMinutes(int dd, int mm, int hr, int min) {
        int days = dd;
        for (int i = 0; i < mm - 1; i++) {
            days += month[i];
        }
        return (days * 24 * 60) + (hr * 60) + min;
    }

    public String toString() {
        String output = "";
        output += "USER\t\tLOGIN\t\tLOGOUT\tDURATION\n";
        output += "IDENTIFICATION\tTIME & DATE\tTIME & DATE\tHOURS:MINS\n";
        for (int i = 0; i < id.length; i++) {
            output += id[i] + "\t\t" + loginTime[i] + " " + loginDate[i] + "\t" + logoutTime[i] + " " + logoutDate[i]
                    + "\t" + formatTime(duration[i]) + "\n";
        }
        output += "THE USER WHO LOGGED IN FOR THE LONGEST DURATION\n";
        output += id[maxIndex] + "\t\t" + loginTime[maxIndex] + " " + loginDate[maxIndex] + "\t" + logoutTime[maxIndex]
                + " " + logoutDate[maxIndex] + "\t" + formatTime(duration[maxIndex]) + "\n";
        return output;
    }

    private String formatTime(int minutes) {
        int hr = minutes / 60;
        int min = minutes % 60;
        return hr + ":" + min + (min < 10 ? "0" : "");
    }
}

public class ISC2004Q3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("INPUT:");
        System.out.print("Number of users: ");
        int users = in.nextInt();
        int id[] = new int[users];
        String loginTime[] = new String[users];
        String loginDate[] = new String[users];
        String logoutTime[] = new String[users];
        String logoutDate[] = new String[users];
        System.out.println("USER\t\tLOGIN\t\tLOGOUT");
        System.out.println("IDENTIFICATION\tTIME & DATE\tTIME & DATE");
        for (int user = 0; user < users; user++) {
            id[user] = in.nextInt();
            loginTime[user] = in.next();
            loginDate[user] = in.next();
            logoutTime[user] = in.next();
            logoutDate[user] = in.next();
        }
        UserLog log = new UserLog(id, loginTime, loginDate, logoutTime, logoutDate);

        System.out.println("OUTPUT:\n" + log);

        in.close();
    }
}
