import java.util.ArrayList;

enum Status {
    ONLINE("Online and Ready to Print"),
    IDLE("Idle and Ready to Scan"),
    DISPLAYING("Displaying Output");

    private final String message;

    Status(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

class Device {
    private String name;
    private String type;
    private Status status;

    public Device(String name, String type, Status status) {
        this.name = name;
        this.type = type;
        this.status = status;
    }

    public void displayStatus() {
        System.out.printf("%-10s %-20s : %s%n", type, name, status.getMessage());
    }
}

public class DeviceStatusReport {
    public static void main(String[] args) {
        ArrayList<Device> devices = new ArrayList<>();
        devices.add(new Device("HP LaserJet", "Printer", Status.ONLINE));
        devices.add(new Device("Canon Lide 300", "Scanner", Status.IDLE));
        devices.add(new Device("Dell UltraSharp", "Monitor", Status.DISPLAYING));

        System.out.println("📊 Device Status Report");
        System.out.println("----------------------------");
        for (Device device : devices) {
            device.displayStatus();
        }
    }
}
