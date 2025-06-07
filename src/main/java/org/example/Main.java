package org.example;

import org.example.domain.FileSystem;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FileSystem fs = new FileSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print( fs.getPrompt() + "$ ");
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) continue;

            String[] parts = line.split(" ");
            String cmd = parts[0];
            String arg = parts.length > 1 ? parts[1] : null;

            switch (cmd) {
                case "mkdir":
                    if (arg != null) fs.mkdir(arg);
                    else System.out.println("Usage: mkdir <dirName>");
                    break;
                case "touch":
                    if (arg != null) fs.touch(arg);
                    else System.out.println("Usage: touch <fileName>");
                    break;
                case "cd":
                    fs.cd(arg);
                    break;
                case "ls":
                    fs.ls();
                    break;
                case "pwd":
                    fs.pwd();
                    break;
                case "exit":
                    return;
                default:
                    System.out.println("Unknown command");
            }
        }
    }
}