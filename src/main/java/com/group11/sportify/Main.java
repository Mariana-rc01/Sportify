package com.group11.sportify;

import com.group11.sportify.views.main.MainView;

public class Main {
    public static void main(String[] args) {
        Sportify sportify;
        
        FileIO fileIO = new FileIO();

        try {
            sportify = (Sportify) fileIO.importBinary("sportify.bin");
        } catch(Exception ex) {
            sportify = new Sportify();
        }

        MainView mainView = new MainView(sportify);
        mainView.show();

        try {
            fileIO.exportBinary("sportify.bin", sportify);
        } catch (Exception ex) {
            throw new RuntimeException("Couldn't save the simulation data. " + ex.getMessage());
        }
    }
}