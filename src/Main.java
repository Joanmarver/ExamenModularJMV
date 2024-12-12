import java.time.Year;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //variables ejer1;
        int numpersonas, total;
        //variables ejer4
        int hora, minutos, segundos, huso;
        String cadena;
        Scanner userprint = new Scanner(System.in);
        System.out.println("(a) Mayores de edad\n" + "(b) Calculadora de ingresos de canal de Youtube\n" + "(c) calculo horario\n" + "(d) Salir");
        String respuesta = userprint.nextLine();
        //pasar a Mayusculas
        respuesta = respuesta.toUpperCase();
        char caracter= respuesta.charAt(0);
        //switch con las opciónes
        switch (caracter){
            //Mayores de edad
            case 'A' :{
                System.out.println("Has  elegido la opción Mayores de edad");
                System.out.println("Dime el numero de personas");
                numpersonas = userprint.nextInt();
                total = MayorDeEdad(numpersonas);
                System.out.println("Total mayores de edad : " + total);

                break;
            }
            //Calculadora de Ingresos
            case 'B':{
                System.out.println("has elegido la opción : Calculadora de ingresos de canal de youtube");
                double totalingresos = Ingresos();
                System.out.println("total ingresos: " + totalingresos + "€");
                break;
            }
            //calculo horario
            case 'C':{
                System.out.println("has elegido la opción : calculo horario ");
                do {
                System.out.println("dime la hora.");
                hora = userprint.nextInt();
                if (hora >12 || hora <0) System.out.println("hora invalida. tiene que ser una hora del 0 al 12");
                }while (hora >12 || hora < 0);
                do {
                System.out.println("dime los minutos del 0 al 59");
                minutos = userprint.nextInt();
                if (minutos >59 || minutos <0) System.out.println("Minutos invalidos. Numero del 0-59");
                }while (minutos >59 || minutos < 0);
                System.out.println("¿Es AM o PM?");
                userprint.nextLine();
                cadena = userprint.nextLine();
                cadena = cadena.toUpperCase();
                char horaa= cadena.charAt(0);
                do {
                    System.out.println("dime el huso horario entre el -11 y el 12");
                    huso = userprint.nextInt();
                    if (huso < -11 || huso > 12) System.out.println("huso horario invalido");
                }while (huso < -11 || huso > 12);
                CambiodeHoras(hora, minutos, horaa, huso);
                break;
            }
            case 'D':{
                //salir
                System.out.println("has salido del programa");
                break;
            }
            default:
                System.out.println("Opción invalida , vuelva a elegir la opción porfavor");
        }


    }
    public static int MayorDeEdad(int num){
        Scanner userprint = new Scanner(System.in);
        int mayoredad = 0;
        for (int i = 0; i < num; i++){
            System.out.println("Dime el año de nacimiento :");
            int respuesta = userprint.nextInt();
            int ano = Year.now().getValue();
            if (ano - respuesta > 18){
                mayoredad++;
            }

        }
       return mayoredad;


    }
    public static double Ingresos(){
        Scanner userprint = new Scanner(System.in);
        int visitasASMR, visitasDeportes, visitasAnimales, visitasTecnologia, visitasBbes;
        int visitasTotalASMR, visitasTotalDeportes, visitasTotalAnimales, visitasTotaltecnologia, visitasTotalBebes;
        visitasASMR = 0;
        visitasDeportes = 0;
        visitasAnimales = 0;
        visitasTecnologia = 0;
        visitasBbes = 0;
        visitasTotalASMR = 0;
        visitasTotalDeportes = 0;
        visitasTotaltecnologia = 0;
        visitasTotalAnimales =0;
        visitasTotalBebes =0;
        boolean bucle;
        bucle = true;
        while (bucle){


            System.out.println("tematica del video. Pulsa el numero asociado a la tematica");
            System.out.println("1.ASMR\n" + "2.Deportes\n" + "3.Animales\n" + "4 Tecnologia\n" + "5.bebes\n" + "6.salir");
            int respuesta = userprint.nextInt();
            switch (respuesta){
                // switch para saber la cantidad de visitas de cada tematica
                case 1:{
                    //ASMR
                    System.out.println("cantidad de visitas");
                    respuesta = userprint.nextInt();
                    visitasTotalASMR = visitasASMR + respuesta;
                    break;
                }
                case 2:{
                    //DEPORTES
                    System.out.println("cantidad de visitas");
                    respuesta = userprint.nextInt();
                    visitasTotalDeportes = visitasDeportes + respuesta;
                    break;
                }
                case 3:{
                    //ANIMALES
                    System.out.println("cantidad de visitas");
                    respuesta = userprint.nextInt();
                    visitasTotalAnimales = visitasAnimales + respuesta;
                    break;
                }
                case 4:{
                    //TECNOLOGIA
                    System.out.println("cantidad de visitas");
                    respuesta = userprint.nextInt();
                    visitasTotaltecnologia = visitasTecnologia + respuesta;
                    break;
                }
                case 5:{
                    //BEBES
                    System.out.println("cantidad de visitas");
                    respuesta = userprint.nextInt();
                    visitasTotalBebes = visitasBbes + respuesta;
                    break;
                }
                case 6:{
                    //SALIR
                    bucle = false;
                    break;
                }
                default:
                    System.out.println("opcion invalida. Vuelva elegir");

            }

        }
        //RESULTADO TOTAL
        double result = calculoTotales(visitasTotalASMR, visitasTotalDeportes, visitasTotalAnimales, visitasTotaltecnologia, visitasTotalBebes);
        return result;

    }
    public static double calculoTotales(int asmr, int deportes, int animales, int tecnologia, int bebes){
        //operaciones de cada tematica
        double asmrt = (asmr * 0.1) / 100;
        double deportest = (deportes * 1) /100;
        double animalest = (animales*0.2)/100;
        double tecnologiat= (tecnologia*0.5)/100;
        double bbsT= (bebes*0.5)/100;
        //operaciones de ingresos totales
        double TOTAL= asmrt + deportest + animalest + tecnologiat +bbsT;
        return TOTAL;
    }
    public static void CambiodeHoras(int hours, int minutes, char hora, int hus){
       int horacambiada = hours + hus;
       String horacom = "";

       if (horacambiada > 12){
           horacambiada = hours - 12;
           switch (hora){
               case 'A':{
                   horacom= "PM";
                   break;
               }
               case 'P':{
                   horacom="AM";
                   break;
               }
           }
       }else if(horacambiada< 0){
           horacambiada = horacambiada +12;
           switch (hora) {
               case 'A': {
                   horacom = "PM";
                   break;
               }
               case 'P': {
                   horacom = "AM";
                   break;
               }
           }
       } else {
           switch (hora){
               case 'A': {
                   horacom = "AM";
                   break;
               }
               case 'P': {
                   horacom = "pM";
                   break;
               }
           }
       }
       String result = " " + horacambiada+ ":"+ minutes+ " " + horacom;
        System.out.println("Serán las :" + result );

    }
}
