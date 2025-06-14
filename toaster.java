import java.util.Scanner;

public class TalkingToaster {

    private boolean isOn = false;
    private int slicesToasted = 0;

    public void turnOn() {
        isOn = true;
        System.out.println("Toaster: I'm awake! Let's toast some dreams!");
    }

    public void insertBread(String breadType, String toastLevel) {
        if (!isOn) {
            System.out.println("Toaster: I'm off! You can't feed me carbs while I'm sleeping!");
            return;
        }

        System.out.println("Toaster: Mmm... " + breadType + "? Bold choice.");
        System.out.println("Toaster: Toast level set to " + toastLevel + ".");
        System.out.println("Toaster: Toasting in 3... 2... 1... *sizzle*");
        slicesToasted++;
    }

    public void ejectToast() {
        if (!isOn) {
            System.out.println("Toaster: I can't eject what I never toasted!");
            return;
        }

        if (slicesToasted == 0) {
            System.out.println("Toaster: No toast in the chamber! Try feeding me first.");
        } else {
            System.out.println("Toaster: Here's your toast. I hope it's as golden as your dreams.");
            slicesToasted--;
        }
    }

    public void turnOff() {
        isOn = false;
        System.out.println("Toaster: Powering down... Remember me when you butter that toast.");
    }

    public static void main(String[] args) {
        TalkingToaster toaster = new TalkingToaster();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Talking Toaster Experience!");
        String command;

        do {
            System.out.println("\nEnter a command (on, off, insert, eject, exit): ");
            command = scanner.nextLine().trim().toLowerCase();

            switch (command) {
                case "on":
                    toaster.turnOn();
                    break;
                case "off":
                    toaster.turnOff();
                    break;
                case "insert":
                    System.out.print("Enter bread type: ");
                    String breadType = scanner.nextLine();
                    System.out.print("Enter toast level (light, medium, dark): ");
                    String toastLevel = scanner.nextLine();
                    toaster.insertBread(breadType, toastLevel);
                    break;
                case "eject":
                    toaster.ejectToast();
                    break;
                case "exit":
                    System.out.println("Toaster: Farewell, toast lover!");
                    break;
                default:
                    System.out.println("Toaster: I don't understand that command!");
            }

        } while (!command.equals("exit"));

        scanner.close();
    }
}
