package main.java.controller;

public class CLIController {

    // Attributes
    private CLIView view;
    private BaieElectroniqueModel model;
    private static CLIController instance;

    // Constructor
    private CLIController() {
        this.view = new CLIView();
        this.model = BaieElectroniqueModel.getInstance();
    }


}
