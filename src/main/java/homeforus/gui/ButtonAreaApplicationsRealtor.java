package main.java.homeforus.gui;

import main.java.homeforus.core.ApplicationListObject;

public class ButtonAreaApplicationsRealtor extends ButtonArea {


    private ApplicationListObject applicationListObject;

    public ButtonAreaApplicationsRealtor(BaseWindow window, ApplicationListObject appO) {
        super(window);
        this.applicationListObject = appO;
    }
}
