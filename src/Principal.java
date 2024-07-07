import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        Scanner lectura = new Scanner(System.in);
        ApiConsulta consulta = new ApiConsulta();

        byte alternativa = 0;

        do{
            menu();
            alternativa = lectura.nextByte();
            if (alternativa>=1 && alternativa <=8){
                conversion(alternativa, consulta, lectura);
            } else if (alternativa == 9){
                System.out.println("Finalizando programa");
            } else {
                System.out.println("Opción no válida, intente de nuevo");
            }

        } while (alternativa !=9);

    }
    public static void menu(){
        System.out.println("----------------------------------------------------");
        System.out.println(" ");
        System.out.println("**Conversor de monedas**");
        System.out.println(" ");
        System.out.println("Por favor, elija una de las siguientes opciones:");
        System.out.println(" ");
        System.out.println("1) Dólar --> Euro");
        System.out.println("2) Euro --> Dólar");
        System.out.println("3) Dólar --> Peso Mexicano");
        System.out.println("4) Peso Mexicano --> Dolar");
        System.out.println("5) Dólar --> Real Brasileño");
        System.out.println("6) Real Brasileño --> Dólar");
        System.out.println("7) Dólar --> Peso Chileno");
        System.out.println("8) Peso Chileno --> Dólar");
        System.out.println("9) Salir.");
        System.out.println(" ");
        System.out.println("----------------------------------------------------");
    }

    public static void conversion(byte alternativa, ApiConsulta consulta, Scanner lectura){
        System.out.println("Ingrese la cantidad a convertir");

        var cantidad = lectura.nextDouble();

        String monedaOrigen ="";
        String monedaDestino ="";

        switch (alternativa){
            case 1:
                monedaOrigen = "USD";
                monedaDestino = "EUR";
                break;
            case 2:
                monedaOrigen = "EUR";
                monedaDestino = "USD";
                break;
            case 3:
                monedaOrigen = "USD";
                monedaDestino = "MXN";
                break;
            case 4:
                monedaOrigen = "MXN";
                monedaDestino = "USD";
                break;
            case 5:
                monedaOrigen = "USD";
                monedaDestino = "BRL";
                break;
            case 6:
                monedaOrigen = "BRL";
                monedaDestino = "USD";
                break;
            case 7:
                monedaOrigen = "USD";
                monedaDestino = "CLP";
                break;
            case 8:
                monedaOrigen = "CLP";
                monedaDestino = "USD";
                break;
        }
        try{
            Monedas monedas = consulta.busquedaMonedas(monedaOrigen, monedaDestino, cantidad);

            System.out.println("El valor de $" + cantidad + " " + monedas.toString());
        }catch (RuntimeException e) {
            System.out.println(e.getMessage());
            System.out.println("Saliendo de la aplicación");
        }
    }
}
