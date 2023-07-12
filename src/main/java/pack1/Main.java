package pack1;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args){
        System.out.println("Enter one of the planets name " + Arrays.asList(Arrays.stream(SolarSystem.values()).
                map(SolarSystem::name).collect(Collectors.toList())));
        Scanner scanner = new Scanner(System.in);
        SolarSystem solarSystem = SolarSystem.valueOf(scanner.nextLine());

        switch (solarSystem) {
            case MERCURY:
            case VENUS:
            case EARTH:
            case MARS:
            case JUPITER:
            case SATURN:
            case URANUS:
            case NEPTUNE:
                System.out.println(solarSystem);
                break;
            default:
                System.out.println("You have entered incorrect planet name!");
        }
    }
}
