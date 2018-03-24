package com.elderbyte.example.demo;

public class SampleMessageDto {

    public String name;
    public int number;
    public double holy;

    public SampleMessageDto(){}

    public SampleMessageDto(String name, int number, double holy) {
        this.name = name;
        this.number = number;
        this.holy = holy;
    }


    @Override
    public String toString() {
        return "SampleMessageDto{" +
                "name='" + name + '\'' +
                ", number=" + number +
                ", holy=" + holy +
                '}';
    }
}
