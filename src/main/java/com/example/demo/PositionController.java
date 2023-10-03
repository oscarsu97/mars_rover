package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rover")
public class PositionController {
    @GetMapping("/position")
    private RoverPositionResponse getUpdatedPosition(@RequestParam String currPosition, @RequestParam String commands) {
        String[] initialPosition = currPosition.split(",");
        int x = Integer.parseInt(initialPosition[0]);
        int y = Integer.parseInt(initialPosition[1]);
        char direction = initialPosition[2].charAt(0);

        MarsRover rover = new MarsRover(x, y, direction);
        rover.executeCommands(commands);

        RoverPositionResponse result = new RoverPositionResponse();
        result.setCoordinate(String.format("%d, %d", rover.getX(), rover.getY()));
        result.setDirection(String.valueOf(rover.getCurrentDirection()));
        return result;
    }
}
