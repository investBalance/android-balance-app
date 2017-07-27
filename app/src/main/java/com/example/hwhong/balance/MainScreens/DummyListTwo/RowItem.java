package com.example.hwhong.balance.MainScreens.DummyListTwo;

/**
 * Created by hwhong on 7/25/17.
 */

public class RowItem {

    String name;
    String value;
    int image;

    public RowItem(String name, String value, int image) {
        this.name = name;
        this.value = value;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
