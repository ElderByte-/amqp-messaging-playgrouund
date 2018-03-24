package com.elderbyte.example.demo;

public class SampleMessageDto {

    private transient static int SEED = 1;

    public int id;
    public String name;
    public int number;
    public double holy;

    public String mimeType;

    public SampleMessageDto(){}

    public SampleMessageDto(String name, int number, double holy, String mimeType) {
        this.id = SEED++;
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
