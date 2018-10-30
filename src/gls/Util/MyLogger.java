/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gls.Util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Fredy Arciniegas
 */
public class MyLogger {

    private static final String RUTALOG = "";
    public static final ArrayList<String> RESPUESTAS = new ArrayList<>();
    
    public static void escribirLog(String mensaje) {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(RUTALOG, true));
            Date myDate = Date.from(Instant.now());
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            writer.newLine();
            writer.write("[" + formatter.format(myDate) + "]  ");
            for (String string : mensaje.split("\n")) {
                writer.write(string);
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println(e);
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    System.err.println(e);
                }
            }
        }
    }

    public static void escribirLog(Exception ex) {
        String txt = ">> " + ex.getMessage() + "\n";
        for (StackTraceElement stackTraceElement : ex.getStackTrace()) {
            txt += ("      " + stackTraceElement) + "\n";
        }
        escribirLog(txt);
    }        
}
