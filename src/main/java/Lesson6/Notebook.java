package Lesson6;

import java.util.Objects;

public class Notebook {
    private Double Screen;
    private Integer CPU;
    private Integer RAM;
    private String color;
    private String objectName;

    public Notebook(Double screen, Integer CPU, Integer RAM, String color) {
        this.Screen = screen;
        this.CPU = CPU;
        this.RAM = RAM;
        this.color = color;
    }

    public Double getScreen() {
        return Screen;
    }

    public Integer getCPU() {
        return CPU;
    }

    public Integer getRAM() {
        return RAM;
    }

    public String getColor() {
        return color;
    }

    public String getObjectName() {
        return objectName;
    }

    public void setScreen(Double screen) {
        Screen = screen;
    }

    public void setCPU(Integer CPU) {
        this.CPU = CPU;
    }

    public void setRAM(Integer RAM) {
        this.RAM = RAM;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Notebook notebook = (Notebook) o;
        return Objects.equals(Screen, notebook.Screen) && Objects.equals(CPU, notebook.CPU) && Objects.equals(RAM, notebook.RAM) && Objects.equals(color, notebook.color) && Objects.equals(objectName, notebook.objectName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Screen, CPU, RAM, color, objectName);
    }

    @Override
    public String toString() {
        return "Notebook{" +
                "Screen=" + Screen +
                ", CPU=" + CPU +
                ", RAM=" + RAM +
                ", color='" + color + '\'' +
                ", objectName='" + objectName + '\'' +
                '}';
    }
}
