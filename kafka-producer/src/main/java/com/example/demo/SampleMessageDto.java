package com.example.demo;

public class SampleMessageDto {

    public String name;
    public int number;
    public double holy;

    public String mimeType;

    public SampleMessageDto(){}

    public SampleMessageDto(String name, int number, double holy, String mimeType) {
        this.name = name;
        this.number = number;
        this.holy = holy;
        this.mimeType = mimeType;
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
