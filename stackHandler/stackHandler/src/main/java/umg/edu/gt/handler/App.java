package umg.edu.gt.handler;

import umg.edu.gt.data_structure.SymbolValidator;

public class App {

    public static void main(String[] args) {

        SymbolValidator validator = new SymbolValidator();

        // Si el usuario pasa una expresión por consola
        if (args.length > 0) {
            String expr = args[0];
            boolean result = validator.validate(expr);
            System.out.println("Expresión: " + expr);
            System.out.println("Válida: " + result);
            return;
        }

        // Casos obligatorios
        String valid = "(a+b) * [c-d]";
        String invalid = "([)]";

        System.out.println("Expresión: " + valid);
        System.out.println("Válida: " + validator.validate(valid));

        System.out.println("Expresión: " + invalid);
        System.out.println("Válida: " + validator.validate(invalid));
    }
}
