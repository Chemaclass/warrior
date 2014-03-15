package utils;

import home.Str;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Utilidades globales para la aplicación
 *
 * @author chemaclass
 */
public class Global {

    /**
     * To write to console
     */
    public static final BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));

    /**
     * Imprime una salida por consola con el prompt out
     *
     * @param out String
     */
    public static void pOut(String out) {
        System.out.println(Str.out + out);
    }
    
    /**
     * Imprime una salida de error por consola con el prompt out
     *
     * @param out String
     */
    public static void pOutE(String out) {
        System.err.println(Str.out + out);
    }

    /**
     * Imprime una salida por consola con el prompt in
     *
     * @param in String
     */
    public static void pIn(String in) {
        System.out.println(Str.in + in);
    }
}
