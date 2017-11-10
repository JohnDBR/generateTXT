/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generatetxt;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

/**
 *
 * @author john
 */
public class GenerateTXT {

    static String tab = "    ";
    static String me = "<";
    static String ma = ">";
    static String s = "/";
    static int lastX = 0;
    static int lastY = 0;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            File storer = new File("comptxt.txt");
            File fileModification = new File("modification.txt");
            fileModification.createNewFile();

            FileReader fr = new FileReader(storer);
            BufferedReader br = new BufferedReader(fr);

            FileWriter fw = new FileWriter(fileModification);
            PrintWriter pw = new PrintWriter(fw);

            //GENERATES CONTROLLERS...
            /*int controllers = 0;
            String line;
            while ((line = br.readLine()) != null) {
                pw.println(line);
                if (line.contains("ControladorDePantalla64x64")) {
                    String[] field = line.split("\\,");
                    String[] param = field[0].split("\\(");
                    lastX = Integer.valueOf(param[1]);
                    controllers++;
                }
            }
            for (int i = 0; i < 64-controllers; i++) {
               line = generateController();
               pw.println(line); 
            }*/
            //GENERATES PINS FOR CONTROLLERS...
            /*String line;
            while ((line = br.readLine()) != null) {
                pw.println(line);
                if (line.contains("ControladorDePantalla64x64")) {
                    String[] field = line.split("\\,");
                    String[] param = field[0].split("\\(");
                    lastX = Integer.valueOf(param[1]);
                    int pin1X = lastX - 20;
                    int pin2X = lastX - 30;
                    pw.println(tab + "<comp lib=\"0\" loc=\"(" + pin1X + ",1310)\" name=\"Pin\">");
                    pw.println(tab + "  <a name=\"facing\" val=\"north\"/>");
                    pw.println(tab + "  <a name=\"width\" val=\"6\"/>");
                    pw.println(tab + "  <a name=\"tristate\" val=\"false\"/>");
                    pw.println(tab + "</comp>");
                    pw.println(tab + "<comp lib=\"0\" loc=\"(" + pin2X + ",670)\" name=\"Pin\">");
                    pw.println(tab + "  <a name=\"width\" val=\"6\"/>");
                    pw.println(tab + "  <a name=\"tristate\" val=\"false\"/>");
                    pw.println(tab + "</comp>");
                }
            }*/
            //GENERATES TUNNELS...
            /*int controllers = 1;
            String line;
            while ((line = br.readLine()) != null) {
                pw.println(line);
                if (line.contains("ControladorDePantalla64x64")) {
                    String[] field = line.split("\\,");
                    String[] param = field[0].split("\\(");
                    String[] param1 = field[1].split("\\)");
                    lastX = Integer.valueOf(param[1]);
                    lastY = Integer.valueOf(param1[0]);
                    for (int i = 1; i <= 64; i++) {
                        pw.println(tab + "<comp lib=\"0\" loc=\"(" + lastX + "," + lastY + ")\" name=\"Tunnel\">");
                        pw.println(tab + "  <a name=\"width\" val=\"32\"/>");
                        pw.println(tab + "  <a name=\"label\" val=\"" + i + "-" + controllers + "\"/>");
                        pw.println(tab + "</comp>");
                        lastY = lastY + 10;
                    }
                    for (int i = 1; i <= 64; i++) {
                        pw.println(tab + "<comp lib=\"0\" loc=\"(" + lastX + "," + lastY + ")\" name=\"Tunnel\">");
                        pw.println(tab + "  <a name=\"width\" val=\"32\"/>");
                        pw.println(tab + "  <a name=\"label\" val=\"" + i + "-" + controllers + "p\"/>");
                        pw.println(tab + "</comp>");
                        lastY = lastY + 10;
                    }
                    controllers++;
                }
            }*/
            //GENERATES ORs WITH PINS AND EXITS!!!!!!...
            /*lastX = 8630;
            lastY = 200;
            String line;
            while ((line = br.readLine()) != null) {
                pw.println(line);
            }
            for (int i = 1; i <= 64; i++) {
                pw.println(tab + "<comp lib=\"1\" loc=\"(" + lastX + "," + lastY + ")\" name=\"OR Gate\">");
                pw.println(tab + "  <a name=\"width\" val=\"32\"/>");
                pw.println(tab + "  <a name=\"inputs\" val=\"32\"/>");
                pw.println(tab + "</comp>");
                pw.println(tab + "<comp lib=\"0\" loc=\"(" + lastX + "," + lastY + ")\" name=\"Tunnel\">");
                pw.println(tab + "  <a name=\"width\" val=\"32\"/>");
                pw.println(tab + "  <a name=\"label\" val=\"" + i + "o1\"/>");
                pw.println(tab + "</comp>");
                int tunnelY = lastY - 160;
                int tunnelX = lastX - 50;
                for (int j = 1; j <= 32; j++) {
                    pw.println(tab + "<comp lib=\"0\" loc=\"(" + tunnelX + "," + tunnelY + ")\" name=\"Tunnel\">");
                    pw.println(tab + "  <a name=\"facing\" val=\"east\"/>");
                    pw.println(tab + "  <a name=\"width\" val=\"32\"/>");
                    pw.println(tab + "  <a name=\"label\" val=\"" + i + "-" + j + "\"/>");
                    pw.println(tab + "</comp>");
                    if (j == 16) {
                        tunnelY = tunnelY + 20;
                    } else {
                        tunnelY = tunnelY + 10;
                    }
                }
                int o2 = lastY - (200 - 550);
                pw.println(tab + "<comp lib=\"1\" loc=\"(" + lastX + "," + o2 + ")\" name=\"OR Gate\">");
                pw.println(tab + "  <a name=\"width\" val=\"32\"/>");
                pw.println(tab + "  <a name=\"inputs\" val=\"32\"/>");
                pw.println(tab + "</comp>");
                pw.println(tab + "<comp lib=\"0\" loc=\"(" + lastX + "," + o2 + ")\" name=\"Tunnel\">");
                pw.println(tab + "  <a name=\"width\" val=\"32\"/>");
                pw.println(tab + "  <a name=\"label\" val=\"" + i + "o2\"/>");
                pw.println(tab + "</comp>");
                tunnelY = o2 - 160;
                for (int j = 1; j <= 32; j++) {
                    int newJ = j + 32;
                    pw.println(tab + "<comp lib=\"0\" loc=\"(" + tunnelX + "," + tunnelY + ")\" name=\"Tunnel\">");
                    pw.println(tab + "  <a name=\"facing\" val=\"east\"/>");
                    pw.println(tab + "  <a name=\"width\" val=\"32\"/>");
                    pw.println(tab + "  <a name=\"label\" val=\"" + i + "-" + newJ + "\"/>");
                    pw.println(tab + "</comp>");
                    if (j == 16) {
                        tunnelY = tunnelY + 20;
                    } else {
                        tunnelY = tunnelY + 10;
                    }
                }
                int o3x = lastX + 130;
                int o3y = lastY + 170;
                pw.println(tab + "<comp lib=\"1\" loc=\"(" + o3x + "," + o3y + ")\" name=\"OR Gate\">");
                pw.println(tab + "  <a name=\"width\" val=\"32\"/>");
                pw.println(tab + "  <a name=\"inputs\" val=\"2\"/>");
                pw.println(tab + "</comp>");
                int pinX = o3x + 10;
                pw.println(tab + "<comp lib=\"0\" loc=\"(" + pinX + "," + o3y + ")\" name=\"Pin\">");
                pw.println(tab + "  <a name=\"facing\" val=\"west\"/>");
                pw.println(tab + "  <a name=\"output\" val=\"true\"/>");
                pw.println(tab + "  <a name=\"width\" val=\"32\"/>");
                pw.println(tab + "</comp>");
                pw.println(tab + "<wire from=\"(" + o3x + "," + o3y + ")\" to=\"(" + pinX + "," + o3y + ")\"/>");
                tunnelX = o3x - 50;
                tunnelY = o3y - 20;
                pw.println(tab + "<comp lib=\"0\" loc=\"(" + tunnelX + "," + tunnelY + ")\" name=\"Tunnel\">");
                pw.println(tab + "  <a name=\"facing\" val=\"east\"/>");
                pw.println(tab + "  <a name=\"width\" val=\"32\"/>");
                pw.println(tab + "  <a name=\"label\" val=\"" + i + "o1\"/>");
                pw.println(tab + "</comp>");
                tunnelY = tunnelY + 40;
                pw.println(tab + "<comp lib=\"0\" loc=\"(" + tunnelX + "," + tunnelY + ")\" name=\"Tunnel\">");
                pw.println(tab + "  <a name=\"facing\" val=\"east\"/>");
                pw.println(tab + "  <a name=\"width\" val=\"32\"/>");
                pw.println(tab + "  <a name=\"label\" val=\"" + i + "o2\"/>");
                pw.println(tab + "</comp>");
                lastX = lastX + 380;
            }
            for (int i = 1; i <= 64; i++) {
                pw.println(tab + "<comp lib=\"1\" loc=\"(" + lastX + "," + lastY + ")\" name=\"OR Gate\">");
                pw.println(tab + "  <a name=\"width\" val=\"32\"/>");
                pw.println(tab + "  <a name=\"inputs\" val=\"32\"/>");
                pw.println(tab + "</comp>");
                pw.println(tab + "<comp lib=\"0\" loc=\"(" + lastX + "," + lastY + ")\" name=\"Tunnel\">");
                pw.println(tab + "  <a name=\"width\" val=\"32\"/>");
                pw.println(tab + "  <a name=\"label\" val=\"" + i + "o1p\"/>");
                pw.println(tab + "</comp>");
                int tunnelY = lastY - 160;
                int tunnelX = lastX - 50;
                for (int j = 1; j <= 32; j++) {
                    pw.println(tab + "<comp lib=\"0\" loc=\"(" + tunnelX + "," + tunnelY + ")\" name=\"Tunnel\">");
                    pw.println(tab + "  <a name=\"facing\" val=\"east\"/>");
                    pw.println(tab + "  <a name=\"width\" val=\"32\"/>");
                    pw.println(tab + "  <a name=\"label\" val=\"" + i + "-" + j + "p\"/>");
                    pw.println(tab + "</comp>");
                    if (j == 16) {
                        tunnelY = tunnelY + 20;
                    } else {
                        tunnelY = tunnelY + 10;
                    }
                }
                int o2 = lastY - (200 - 550);
                pw.println(tab + "<comp lib=\"1\" loc=\"(" + lastX + "," + o2 + ")\" name=\"OR Gate\">");
                pw.println(tab + "  <a name=\"width\" val=\"32\"/>");
                pw.println(tab + "  <a name=\"inputs\" val=\"32\"/>");
                pw.println(tab + "</comp>");
                pw.println(tab + "<comp lib=\"0\" loc=\"(" + lastX + "," + o2 + ")\" name=\"Tunnel\">");
                pw.println(tab + "  <a name=\"width\" val=\"32\"/>");
                pw.println(tab + "  <a name=\"label\" val=\"" + i + "o2p\"/>");
                pw.println(tab + "</comp>");
                tunnelY = o2 - 160;
                for (int j = 1; j <= 32; j++) {
                    int newJ = j + 32;
                    pw.println(tab + "<comp lib=\"0\" loc=\"(" + tunnelX + "," + tunnelY + ")\" name=\"Tunnel\">");
                    pw.println(tab + "  <a name=\"facing\" val=\"east\"/>");
                    pw.println(tab + "  <a name=\"width\" val=\"32\"/>");
                    pw.println(tab + "  <a name=\"label\" val=\"" + i + "-" + newJ + "p\"/>");
                    pw.println(tab + "</comp>");
                    if (j == 16) {
                        tunnelY = tunnelY + 20;
                    } else {
                        tunnelY = tunnelY + 10;
                    }
                }
                int o3x = lastX + 130;
                int o3y = lastY + 170;
                pw.println(tab + "<comp lib=\"1\" loc=\"(" + o3x + "," + o3y + ")\" name=\"OR Gate\">");
                pw.println(tab + "  <a name=\"width\" val=\"32\"/>");
                pw.println(tab + "  <a name=\"inputs\" val=\"2\"/>");
                pw.println(tab + "</comp>");
                int pinX = o3x + 10;
                pw.println(tab + "<comp lib=\"0\" loc=\"(" + pinX + "," + o3y + ")\" name=\"Pin\">");
                pw.println(tab + "  <a name=\"facing\" val=\"west\"/>");
                pw.println(tab + "  <a name=\"output\" val=\"true\"/>");
                pw.println(tab + "  <a name=\"width\" val=\"32\"/>");
                pw.println(tab + "</comp>");
                pw.println(tab + "<wire from=\"(" + o3x + "," + o3y + ")\" to=\"(" + pinX + "," + o3y + ")\"/>");
                tunnelX = o3x - 50;
                tunnelY = o3y - 20;
                pw.println(tab + "<comp lib=\"0\" loc=\"(" + tunnelX + "," + tunnelY + ")\" name=\"Tunnel\">");
                pw.println(tab + "  <a name=\"facing\" val=\"east\"/>");
                pw.println(tab + "  <a name=\"width\" val=\"32\"/>");
                pw.println(tab + "  <a name=\"label\" val=\"" + i + "o1p\"/>");
                pw.println(tab + "</comp>");
                tunnelY = tunnelY + 40;
                pw.println(tab + "<comp lib=\"0\" loc=\"(" + tunnelX + "," + tunnelY + ")\" name=\"Tunnel\">");
                pw.println(tab + "  <a name=\"facing\" val=\"east\"/>");
                pw.println(tab + "  <a name=\"width\" val=\"32\"/>");
                pw.println(tab + "  <a name=\"label\" val=\"" + i + "o2p\"/>");
                pw.println(tab + "</comp>");
                lastX = lastX + 380;
            }*/
            //TUNNELS FOR THE SNAKE WINDOW...
            String line;
            while ((line = br.readLine()) != null) {
                pw.println(line);
            }
            lastX = 120;
            lastY = 350;
            for (int i = 1; i <= 64; i++) {
                pw.println(tab + "<comp lib=\"0\" loc=\"(" + lastX + "," + lastY + ")\" name=\"Tunnel\">");
                pw.println(tab + "  <a name=\"facing\" val=\"east\"/>");
                pw.println(tab + "  <a name=\"width\" val=\"6\"/>");
                pw.println(tab + "  <a name=\"label\" val=\"x" + i + "\"/>");
                pw.println(tab + "</comp>");
                lastY = lastY + 10;
            }
            lastX = 130;
            lastY = 1310;
            for (int i = 1; i <= 64; i++) {
                pw.println(tab + "<comp lib=\"0\" loc=\"(" + lastX + "," + lastY + ")\" name=\"Tunnel\">");
                pw.println(tab + "  <a name=\"facing\" val=\"north\"/>");
                pw.println(tab + "  <a name=\"width\" val=\"6\"/>");
                pw.println(tab + "  <a name=\"label\" val=\"y" + i + "\"/>");
                pw.println(tab + "</comp>");
                lastX = lastX + 10;
            }
            lastX = 770;
            lastY = 30;
            for (int i = 1; i <= 64; i++) {
                pw.println(tab + "<comp lib=\"0\" loc=\"(" + lastX + "," + lastY + ")\" name=\"Tunnel\">");
                pw.println(tab + "  <a name=\"width\" val=\"32\"/>");
                pw.println(tab + "  <a name=\"label\" val=\"" + i + "\"/>");
                pw.println(tab + "</comp>");
                lastY = lastY + 10;
            }
            for (int i = 1; i <= 64; i++) {
                pw.println(tab + "<comp lib=\"0\" loc=\"(" + lastX + "," + lastY + ")\" name=\"Tunnel\">");
                pw.println(tab + "  <a name=\"width\" val=\"32\"/>");
                pw.println(tab + "  <a name=\"label\" val=\"" + i + "p\"/>");
                pw.println(tab + "</comp>");
                lastY = lastY + 10;
            }
            lastX = 1170;
            lastY = 170;
            for (int i = 1; i < 64; i++) {
                pw.println(tab + "<comp lib=\"0\" loc=\"(" + lastX + "," + lastY + ")\" name=\"Tunnel\">");
                pw.println(tab + "  <a name=\"facing\" val=\"east\"/>");
                pw.println(tab + "  <a name=\"width\" val=\"32\"/>");
                pw.println(tab + "  <a name=\"label\" val=\"" + i + "\"/>");
                pw.println(tab + "</comp>");
                lastY = lastY + 10;
            }
            lastX = 1490;
            lastY = 170;
            for (int i = 1; i < 64; i++) {
                pw.println(tab + "<comp lib=\"0\" loc=\"(" + lastX + "," + lastY + ")\" name=\"Tunnel\">");
                pw.println(tab + "  <a name=\"facing\" val=\"east\"/>");
                pw.println(tab + "  <a name=\"width\" val=\"32\"/>");
                pw.println(tab + "  <a name=\"label\" val=\"" + i + "p\"/>");
                pw.println(tab + "</comp>");
                lastY = lastY + 10;
            }

            pw.close();
            fw.close();

            br.close();
            fr.close();

            boolean delete;
            boolean rename;
            do {
                delete = storer.delete();
                rename = fileModification.renameTo(storer);
                System.out.println(delete + " " + rename);
            } while (!(delete && rename));
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    static String generateController() {
        lastX = lastX + 130;
        return tab + "<comp loc=\"(" + lastX + ",40)\" name=\"ControladorDePantalla64x64\"/>";
    }
}
