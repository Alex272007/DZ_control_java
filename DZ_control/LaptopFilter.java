package DZ_control;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class LaptopFilter {
    public static void main(String[] args) {
        Set<Laptop> laptops = new HashSet<>(Arrays.asList(
                new Laptop(8, 256, "Windows", "Black"),
                new Laptop(16, 512, "Windows", "White"),
                new Laptop(16, 256, "MacOS", "Gray"),
                new Laptop(32, 1024, "Linux", "Black"),
                new Laptop(8, 128, "Windows", "Blue")));

        Scanner scanner = new Scanner(System.in);
        Map<String, String> filters = new HashMap<>();

        System.out.println("Введите цифру, соответствующую необходимому критерию:");
        System.out.println("1 - ОЗУ (в ГБ)");
        System.out.println("2 - Объем ЖД (в ГБ)");
        System.out.println("3 - Операционная система");
        System.out.println("4 - Цвет");

        int criterion = scanner.nextInt();
        scanner.nextLine(); 

        switch (criterion) {
            case 1:
                System.out.print("Введите минимальное значение ОЗУ (в ГБ): ");
                filters.put("ram", scanner.nextLine());
                break;
            case 2:
                System.out.print("Введите минимальное значение объема ЖД (в ГБ): ");
                filters.put("hdd", scanner.nextLine());
                break;
            case 3:
                System.out.print("Введите операционную систему: ");
                filters.put("os", scanner.nextLine());
                break;
            case 4:
                System.out.print("Введите цвет: ");
                filters.put("color", scanner.nextLine());
                break;
            default:
                System.out.println("Неверный критерий.");
                return;
        }

        Set<Laptop> filteredLaptops = filterLaptops(laptops, filters);
        if (filteredLaptops.isEmpty()) {
            System.out.println("Нет ноутбуков, соответствующих критериям.");
        } else {
            filteredLaptops.forEach(System.out::println);
        }
    }

    public static Set<Laptop> filterLaptops(Set<Laptop> laptops, Map<String, String> filters) {
        Set<Laptop> filteredLaptops = new HashSet<>(laptops);

        if (filters.containsKey("ram")) {
            int minRam = Integer.parseInt(filters.get("ram"));
            filteredLaptops.removeIf(laptop -> laptop.getRam() < minRam);
        }
        if (filters.containsKey("hdd")) {
            int minHdd = Integer.parseInt(filters.get("hdd"));
            filteredLaptops.removeIf(laptop -> laptop.getHdd() < minHdd);
        }
        if (filters.containsKey("os")) {
            String os = filters.get("os").toLowerCase();
            filteredLaptops.removeIf(laptop -> !laptop.getOs().toLowerCase().contains(os));
        }
        if (filters.containsKey("color")) {
            String color = filters.get("color").toLowerCase();
            filteredLaptops.removeIf(laptop -> !laptop.getColor().toLowerCase().contains(color));
        }

        return filteredLaptops;
    }
}
