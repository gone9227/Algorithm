package algorithm.scofe;
import java.io.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class SoCarAvailableTime {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String peopleCount = br.readLine();

        LocalTime startTime = LocalTime.MIN;
        LocalTime endTime = LocalTime.MAX;

        for (int i = 0; i < Integer.parseInt(peopleCount); i++) {
            String availableTime = br.readLine();
            String[] tmpTime = availableTime.replaceAll("~", "").split("  ");
            LocalTime tmpStartTime = LocalTime.parse(tmpTime[0], DateTimeFormatter.ofPattern("HH:mm"));
            LocalTime tmpEndTime = LocalTime.parse(tmpTime[1], DateTimeFormatter.ofPattern("HH:mm"));
            if(tmpStartTime.isAfter(startTime)) startTime = tmpStartTime;
            if(tmpEndTime.isBefore(endTime)) endTime = tmpEndTime;
        }

        if(startTime.compareTo(endTime) >= 0) System.out.println(-1);
        else
            System.out.println(startTime + " ~ " + endTime);

    }
}
