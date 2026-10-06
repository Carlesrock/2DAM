import java.io.BufferedReader;
import java.io.InputStreamReader;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        /**
         * Programa que reciba un comando
         * de parámetros en args  y lo
         * ejecute la clase Runtime
         */


        //Si no se ejecuta ningún argumento, mostramos un mensaje
        if (args.length == 0) {
            System.out.println("No se ha recibido ningún comando.");
            return ;
        }

        //Asignamos a arsg[0] para un comando
        String comando = String.join(" ", args);
        //Mostrarmos el número de procesadores disponibles y la memoria libre
        int nProcesadores = Runtime.getRuntime().availableProcessors();
        long memoriaLibre = Runtime.getRuntime().freeMemory();

        System.out.println("Procesadores disponibles: "+nProcesadores);
        System.out.println("Memoria libre de la JVM: "+memoriaLibre+" bytes");
        System.out.println("Comando ejecutado: "+comando);


        try{
            //Creamos un procesos Runtime
            Process proceso = Runtime.getRuntime().exec(args);


            //Leemos el comando
            BufferedReader salida = new BufferedReader(
                    new InputStreamReader(proceso.getInputStream())
            );

            //Si sale error pasa lo siguiente
            BufferedReader error = new BufferedReader(
                    new InputStreamReader(proceso.getErrorStream())
            );

            String linea;

            while((linea = salida.readLine())!=null){
                System.out.println(linea);
            }

            //Mostramos el error si hay

            while((linea = error.readLine())!=null){
                System.out.println(linea);
            }

            //Código de salida
            int codigoSalida = proceso.exitValue();
            System.out.println("Wait...");
            System.out.println("Código de salida : "+codigoSalida);


        }catch(Exception e){
            System.out.println("El error es el siguiente "+e.getMessage());
        }

    }
}