import java.util.Scanner;

class ClockStrikes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] startTime = scanner.nextLine().split(" ");
        int startHour = Integer.parseInt(startTime[0]);
        int startMinute = Integer.parseInt(startTime[1]);

        String[] endTime = scanner.nextLine().split(" ");
        int endHour = Integer.parseInt(endTime[0]);
        int endMinute = Integer.parseInt(endTime[1]);

        // Преобразуем время в минуты
        int startTotalMinutes = startHour * 60 + startMinute;
        int endTotalMinutes = endHour * 60 + endMinute;

        // Если конечное время меньше начального, это значит, что прошло через полночь
        if (endTotalMinutes < startTotalMinutes) {
            endTotalMinutes += 24 * 60; // добавляем сутки
        }

        int totalStrikes = 0;

        // Подсчет ударов
        for (int currentTime = startTotalMinutes; currentTime < endTotalMinutes; currentTime++) {
            int hour = (currentTime / 60) % 24; // текущий час
            int minute = currentTime % 60; // текущая минута

            // Удары в начале часа
            if (minute == 0) {
                totalStrikes += (hour % 12 == 0) ? 12 : hour % 12; // Удары в начале часа
            }

            // Удары в середине часа
            if (minute == 30) {
                totalStrikes += 1; // Удары в середине часа
            }
        }

        System.out.println(totalStrikes);
    }
}
