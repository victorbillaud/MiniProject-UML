package Model1;

import java.util.ArrayList;
import java.util.List;

public class Log {
    private static List<Log> LOGS;

    private final String message;
    private final LogType LogType;

    static {
        LOGS = new ArrayList<>();
    }

    private Log(String message, LogType logType){
        this.message = message;
        this.LogType = logType;
        LOGS.add(this);
    }

    public static Log newLog(String message, LogType type){
        Log logs = new Log(message, type);
        System.out.println(logs);
        return logs;
    }

    public static List<Log> getLogs(){return LOGS;}

    @Override
    public String toString() {
        return " | " + this.LogType.color() + this.LogType.toString() + ConsoleColors.RESET +  " | " + this.message;
    }
}
