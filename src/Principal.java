import com.sun.jdi.CharValue;

import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        int monedaDeCambio;
        int monedaDestino;
        String opcion;
        String opcion2;
        double monedaNueva;
        double monedaNueva2;


        Scanner lectura = new Scanner(System.in);
        System.out.println("****************************************");
        System.out.println("Bienvenido al convertidor de monedas a dolar");
        System.out.println("***********");
        System.out.println("Estas son todas las opciones de conversion");

        while (true) {
            System.out.println("""
                      1-"USD"
                           
                      2-"BRL"
                           
                      3-"COP"
                           
                      4-"EUR"
                            
                      5-"MXN"
                      
                      6-Salir
                            
                    """);
            System.out.println("¿Escoja el numero de la moneda a convertir?");


            monedaDeCambio = lectura.nextInt();
            //System.out.println(monedaDeCambio);

            try {


                ApiCambiodemoneda apiCambiodemoneda = new ApiCambiodemoneda();
                opcion = switch (monedaDeCambio) {

                    case 1 -> "USD";
                    case 2 -> "BRL";
                    case 3 -> "COP";
                    case 4 -> "EUR";
                    case 5 -> "MXN";
                    default -> "salir";
                };

                if (opcion.equalsIgnoreCase("salir")) {
                    System.out.println("Saliendo....");
                    break;


                }
               // System.out.println(opcion);

                Moneda moneda = apiCambiodemoneda.seleccionDeMonedas(opcion);

                Map<String, Double> tarifa = (Map<String, Double>) moneda.conversion_rates();
               // System.out.println("2" + tarifa);
                monedaNueva = tarifa.get(opcion);
                System.out.println("Esta es la moneda a convertir "+ opcion );


                //**************************************************************
                //**************************************************************
                //**************************************************************
                System.out.println("***********");
                System.out.println("A que moneda quieres convertir");

                while (true) {
                    System.out.println("""
                              1-"USD"
                                   
                              2-"BRL"
                                   
                              3-"COP"
                                   
                              4-"EUR"
                                    
                              5-"MXN"
                              
                              6-Salir
                                    
                            """);
                    System.out.println("Escoja el numero de la moneda destino");


                    monedaDestino = lectura.nextInt();
                    //System.out.println(monedaDestino);

                    try {


                        ApiCambiodemoneda apiCambiodemoneda2 = new ApiCambiodemoneda();
                        opcion2 = switch (monedaDestino) {

                            case 1 -> "USD";
                            case 2 -> "BRL";
                            case 3 -> "COP";
                            case 4 -> "EUR";
                            case 5 -> "MXN";
                            default -> "salir";
                        };

                        if (opcion.equalsIgnoreCase("salir")) {
                            System.out.println("Saliendo....");
                            break;


                        }
                        //System.out.println(opcion2);
                        //****************************************************************
                        //****************************************************************
                        //****************************************************************

                        Map<String, Double> tarifa2 = (Map<String, Double>) moneda.conversion_rates();
                       // System.out.println("2" + tarifa);
                        monedaNueva2 = tarifa.get(opcion2);
                        System.out.println("Esta es la moneda a la que se convertira " + opcion2);
                        System.out.println("ingrese la cantidad a convertir");
                        double cantidad = lectura.nextDouble();
                        double conversion = Conversion.convertirMoneda(cantidad, monedaNueva2);
                        System.out.println(cantidad+" "+opcion+" Es equivalente a "+conversion+" "+opcion2);

                        System.out.println("**************************************************************");
                        System.out.println("**************************************************************");
                        System.out.println("**************************************************************");
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }









                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    }

