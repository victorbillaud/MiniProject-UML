package Model1;

public enum LogType {
    ERROR (ConsoleColors.RED),
    WARNING (ConsoleColors.YELLOW),
    INFO (ConsoleColors.GREEN);

    private final String color;

    LogType(String color) {this.color = color;}

    public String color() {return color;}

}
