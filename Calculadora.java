import java.util.Scanner;

public class Calculadora{
    static String numero_1, numero_2;
    static String s1, s2;
    public static void main(String[] args) {
        int opcion;
        try(Scanner in = new Scanner(System.in)){
            do{
                Funciones nb1;
                Funciones nb2;
                System.out.println("\t\t\t\t\t\t%----------------------------------------------------------------------%");
                System.out.println("\t\t\t\t\t\t\t\t%-- 1.Convertir de binario a decimal --%");
                System.out.println("\t\t\t\t\t\t\t\t%-- 2.Convertir de decimal a binario --%");
                System.out.println("\t\t\t\t\t\t\t\t%--       3.Suma de binarios         --%");
                System.out.println("\t\t\t\t\t\t\t\t%--       4.Resta de binarios        --%");
                System.out.println("\t\t\t\t\t\t\t\t%--   5.Multipliacion de binarios    --%");
                System.out.println("\t\t\t\t\t\t\t\t%--            6.Salir               --%");
                System.out.println("\t\t\t\t\t\t\t\t%--    Dime la opcion que deseas:    --%");
                System.out.println("\t\t\t\t\t\t%----------------------------------------------------------------------%");
                opcion = in.nextInt();
                while(opcion > 7){
                    System.out.println("\t\t\t\t\t\t\t\t\tOpcion incorrecta, vuelva a ingresar: ");
                    opcion = in.nextInt();
                }
                switch(opcion){
                    case 1:
                    int n, cifra, resultado=0, exp=0;
                    System.out.println("Ingre el numero binario: ");
                    n = in.nextInt();
                    do{
                        cifra=n%10;
                        resultado= resultado+cifra*(int)Math.pow(2, exp);
                        exp++;
                        n=n/10;
                    }while(n>0);
                    System.out.println("El numero decimal es: " + resultado);
                    new java.util.Scanner(System.in).nextLine();
                    break;

                    case 2:
                    int decimal, modulo;
                    String binario = "";
                    System.out.println("Ingresa el numero decimal: ");
                    decimal = in.nextInt();
                    while(decimal>0){
                        modulo = (decimal%2);
                        binario = modulo + binario;
                        decimal = decimal/2; 
                    }
                    System.out.print("El numero binario es: " + binario);
                    new java.util.Scanner(System.in).nextLine();
                    break;

                    case 3:
                        System.out.println("Ingresa un numero binario: ");
                        s1 = in.next();
                        System.out.println("Ingresa otro numero binario: ");
                        s2 = in.next();

    		            nb1 = new Funciones(s1);
    		            nb2 = new Funciones(s2);

    		            System.out.println();    	       
                        System.out.print("Suma:  "+ nb1.sumar(nb2).getNumero());
                        new java.util.Scanner(System.in).nextLine();  
                    break;

                    case 4:
                    System.out.println("Ingresa un numero binario: ");
                    s1 = in.next();
                    System.out.println("Ingresa otro numero binario: ");
                    s2 = in.next();

                    nb1 = new Funciones(s1);
                    nb2 = new Funciones(s2);

                    System.out.println();    	       
                    System.out.print("Resta:  "+ nb1.restar(nb2).getNumero());
                    new java.util.Scanner(System.in).nextLine();  
                    break;

                    case 5:
                    System.out.println("Ingresa un numero binario: ");
                    s1 = in.next();
                    System.out.println("Ingresa otro numero binario: ");
                    s2 = in.next();

                    nb1 = new Funciones(s1);
                    nb2 = new Funciones(s2);

                    System.out.println();    	       
                    System.out.print("Producto:  "+ nb1.multiplicar(nb2).getNumero());
                    new java.util.Scanner(System.in).nextLine();  
                    break;
                }
            }while(opcion != 6);
        }
        
    }
}