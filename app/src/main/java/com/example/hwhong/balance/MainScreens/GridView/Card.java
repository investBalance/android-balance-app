package com.example.hwhong.balance.MainScreens.GridView;

/**
 * Created by hwhong on 7/28/17.
 */

public class Card {
    String name;
    int drawable;
    int color;

    public Card(String name, int drawable, int color) {
        this.name = name;
        this.drawable = drawable;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDrawable() {
        return drawable;
    }

    public void setDrawable(int drawable) {
        this.drawable = drawable;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}
