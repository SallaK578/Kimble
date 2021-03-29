package fi.utu.tech.gui.javafx;


import javafx.application.Application;

public class Main {

    /**
     * The main() method is ignored in correctly deployed JavaFX application. main()
     * serves only as fallback in case the application can not be launched through
     * deployment artifacts, e.g., in IDEs with limited FX support. NetBeans ignores
     * main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        if (args.length == 1 && args[0].equals("--test"))
            return;

        int exercise = 1;
        if (args.length == 1) exercise = Integer.parseInt(args[0]);

        MainApp.launch(MainApp.class, args);


    }

}
