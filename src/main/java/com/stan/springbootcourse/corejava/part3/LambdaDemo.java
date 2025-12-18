package com.stan.springbootcourse.corejava.part3;

public class LambdaDemo {
    static String  prifix = "--";
    public static void main(String[] args) {

       // Printer printer = new ConsolePrinter();
       // sayHi(printer);
//        sayHi(new Printer() {
//            @Override
//            public void print(String message) {
//              System.out.println("YOUR Annonimous Console message is::: "+message);
//            }
//        });
        Printer p = message-> System.out.println("YOUR Annonimous inner variable Console message is::: "+prifix+message);

//        sayHi(message-> System.out.println("YOUR Annonimous inner Console message is::: "+prifix+message)
//          );
        sayHi(p);

    }

    public static void sayHi(Printer printer) {
        String message = "Hi dear user!";
        printer.print(message);
    }
}
