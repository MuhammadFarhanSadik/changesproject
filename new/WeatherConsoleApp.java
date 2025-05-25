
package farhans.weatherconsolapp;

import java.util.Scanner;

public class WeatherConsoleApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        WeatherApp weatherApp = new WeatherApp();

        while (true) {
            System.out.println("Enter weather info for two countries.");
            System.out.print("Country 1 code (e.g., BD) or 'exit' to quit: ");
            String country1 = scanner.nextLine().trim();
            if (country1.equalsIgnoreCase("exit")) {
                System.out.println("Exiting weather app. Goodbye!");
                break;
            }

            System.out.print("City in " + country1 + ": ");
            String city1 = scanner.nextLine().trim();
            if (city1.equalsIgnoreCase("exit")) {
                System.out.println("Exiting weather app. Goodbye!");
                break;
            }

            System.out.print("Country 2 code (e.g., US) or 'exit' to quit: ");
            String country2 = scanner.nextLine().trim();
            if (country2.equalsIgnoreCase("exit")) {
                System.out.println("Exiting weather app. Goodbye!");
                break;
            }

            System.out.print("City in " + country2 + ": ");
            String city2 = scanner.nextLine().trim();
            if (city2.equalsIgnoreCase("exit")) {
                System.out.println("Exiting weather app. Goodbye!");
                break;
            }

           
            System.out.println("\n Weather Report ");
            weatherApp.displayWeather(city1, country1);
            System.out.println(); 
            weatherApp.displayWeather(city2, country2);
            System.out.println(); 
        }

        scanner.close();
    }
}



