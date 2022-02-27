package com.company;

import java.awt.*;

public class CustomGridbag extends GridBagConstraints {


    public CustomGridbag(int positionX, int positionY, int anchor ){
        gridx = positionX;
        gridy = positionY;
        this.anchor = anchor;
    }

    public CustomGridbag(int positionX, int positionY, int anchor, int fill ){
        gridx = positionX;
        gridy = positionY;
        this.anchor = anchor;
        this.fill = fill;
    }

}
