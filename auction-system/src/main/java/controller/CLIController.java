package main.java.controller;

public class CLIController {

    // Attributes
    private CLIView view;
    private BaieElectroniqueModel model;
    private static CLIController instance;

    // Constructor
    private CLIController() {
        this.view = new CLIView();
    }

    // Functions
    public static CLIController getInstance() {
        if (instance == null) {
            instance = new CLIController();
        }
        return instance;
    }
}
