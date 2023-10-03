package com.example.demo;

import lombok.Data;

@Data
public class MarsRover {
    private int x;
    private int y;
    private char direction;

    public MarsRover(int x, int y, char direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public void executeCommands(String commands) {
        for (char command : commands.toCharArray()) {
            executeCommand(command);
        }
    }

    private void executeCommand(char command) {
        switch (command) {
            case 'f':
                moveForward();
                break;
            case 'b':
                moveBackward();
                break;
            case 'r':
                rotateClockwise();
                break;
            case 'l':
                rotateAntiClockwise();
                break;
            default:
                // Ignore invalid commands
                break;
        }
    }

    private void moveForward() {
        switch (direction) {
            case 'N':
                y++;
                break;
            case 'S':
                y--;
                break;
            case 'E':
                x++;
                break;
            case 'W':
                x--;
                break;
        }
    }

    private void moveBackward() {
        switch (direction) {
            case 'N':
                y--;
                break;
            case 'S':
                y++;
                break;
            case 'E':
                x--;
                break;
            case 'W':
                x++;
                break;
        }
    }

    private void rotateClockwise() {
        switch (direction) {
            case 'N':
                direction = 'E';
                break;
            case 'S':
                direction = 'W';
                break;
            case 'E':
                direction = 'S';
                break;
            case 'W':
                direction = 'N';
                break;
        }
    }

    private void rotateAntiClockwise() {
        switch (direction) {
            case 'N':
                direction = 'W';
                break;
            case 'S':
                direction = 'E';
                break;
            case 'E':
                direction = 'N';
                break;
            case 'W':
                direction = 'S';
                break;
        }
    }

    public String getCurrentDirection() {
        switch (direction) {
            case 'N':
                return "North";
            case 'S':
                return "South";
            case 'E':
                return "East";
            case 'W':
                return "West";
            default:
                return "invalid current direction";
        }
    }
}

