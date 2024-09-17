package com.shaunwassell.filemanager;

import java.util.Scanner;

public class TextBasedInterface implements UserInterface {
    private UIEventHandler handler = null;

    @Override
    public void start() {
        System.out.println("File Manager Menu:");
        System.out.println("1. List files");
        System.out.println("2. Create a directory");
        System.out.println("3. Delete a file or directory");
        System.out.println("4. Exit program");
        System.out.println("Enter your choice: ");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            int choice = scanner.nextInt();

            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter directory path: ");
                    handler.onList(scanner.nextLine());
                    break;
                case 2:
                    System.out.println("Enter path of new directory: ");
                    handler.onCreate(scanner.nextLine());
                    break;
                case 3:
                    System.out.println("Enter path of file or directory to delete: ");
                    handler.onDelete(scanner.nextLine());
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Not a valid choice!");
            }
        }
    }

    @Override
    public void subscribe(UIEventHandler handler) {
        if (this.handler == null) {
            this.handler = handler;
        }
    }

    @Override
    public void display(String message) {
        System.out.println(message);
    }
}
