package DZ_control;

import java.util.Objects;
public class Laptop {
    private int ram; // ОЗУ в ГБ
    private int hdd; // Объем ЖД в ГБ
    private String os; // Операционная система
    private String color; // Цвет

    public Laptop(int ram, int hdd, String os, String color) {
        this.ram = ram;
        this.hdd = hdd;
        this.os = os;
        this.color = color;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getHdd() {
        return hdd;
    }

    public void setHdd(int hdd) {
        this.hdd = hdd;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "ram: " + ram +
                ", hdd: " + hdd +
                ", os: '" + os + '\'' +
                ", color: '" + color + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        } 
        if (obj == null || getClass() != obj.getClass()){
            return false;
        } 
        Laptop laptop = (Laptop) obj;
        return ram == laptop.ram &&
                hdd == laptop.hdd &&
                os.equals(laptop.os) &&
                color.equals(laptop.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ram, hdd, os, color);
    }
}   