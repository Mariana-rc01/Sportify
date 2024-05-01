package com.group11.sportify;

import com.group11.sportify.views.main.MainView;

public class Main {
    public static void main(String[] args) {
        Sportify sportify = new Sportify();
        // TODO: Remove this, just for testing purposes
        sportify.getController().getUserController().insertUserCasual(
            "Joaquim Torres", 
            "Avenida da Liberdade, nº 4", 
            "joaquim.torres@gmail.com",
            70,
            65,
            180);

        MainView mainView = new MainView(sportify);
        mainView.show();
    }
}