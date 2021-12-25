package com.company;

import java.awt.*;

public class CustomGridbag extends GridBagConstraints {
    private GridBagConstraints k;

    public CustomGridbag(int positionX, int positionY, int anchor ){
        k = new GridBagConstraints();
        k.gridx = positionX;
        k.gridy = positionY;
        k.anchor = anchor;
    }

    public GridBagConstraints getContraints(){
        return k;
    }
}
