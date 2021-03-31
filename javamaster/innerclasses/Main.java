package innerclasses;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Button btnPrint = new Button("Print");

    public static void main(String[] args) {

    }

    /**
     * Local class
     */
    public static void clase_declarada_dentro_metodo(){

        class ClickListener implements Button.OnClickListener {
            public ClickListener() {
                System.out.println("I've been attached");
            }

            @Override
            public void onClick(String title) {
                System.out.println(title + " was clicked");
            }
        }

        btnPrint.setOnClickListener(new ClickListener());
        listen();
    }

    /**
     *  Clase anonima
     */
    public static void clase_declarada_dentro_metodo_dos(){

        btnPrint.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(String title) {
                System.out.println(title + " was clicked");
            }
        });
        listen();

    }

    /**
     * clase anonima con lambda
     */
    public static void clase_declarada_dentro_metodo_tres(){

        btnPrint.setOnClickListener(title -> System.out.println(title + " was clicked"));
        listen();

    }

    private static void listen() {
        boolean quit = false;
        while(!quit) {
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch(choice) {
                case 0:
                    quit = true;
                    break;
                case 1:
                    btnPrint.onClick();

            }
        }
    }
}
