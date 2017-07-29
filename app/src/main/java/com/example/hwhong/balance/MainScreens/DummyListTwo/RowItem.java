package com.example.hwhong.balance.MainScreens.DummyListTwo;

/**
 * Created by hwhong on 7/25/17.
 */

public class RowItem {

    String name;
    String value;
    String compName;
    int image;

    public RowItem(String name, String value, String comp, int image) {
        this.name = name;
        this.value = value;
        this.compName = comp;
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

    public String getCompName() {
        return compName;
    }

    public void setCompName(String compName) {
        this.compName = compName;
    }
}
