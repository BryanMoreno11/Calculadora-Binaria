/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora.binaria;

import javax.swing.JOptionPane;

/**
 *
 * @author Steven
 */
public class binario {

    private static String n1;
    private static String n2;

    public binario() {
    }

    public binario(String n1, String n2) {
        this.n1 = n1;
        this.n2 = n2;
    }

    public String getN1() {
        return n1;
    }

    public void setN1(String n1) {
        this.n1 = n1;
    }

    public String getN2() {
        return n2;
    }

    public void setN2(String n2) {
        this.n2 = n2;
    }

    public static String Suma(String n1, String n2) {
        String a = "";
        String b = "";
        String respuesta = "";
        String llevar = "";
        int diferencia = 0;
        if (n1.length() >= n2.length()) {
            a = n1;
            b = n2;
            diferencia = a.length() - b.length();
        }
        if (n2.length() >= n1.length()) {
            a = n2;
            b = n1;
            diferencia = a.length() - b.length();
        }
        for (int i = a.length() - 1; i >= 0; i--) {
            if (i - diferencia >= 0) {
                if (llevar.equals("1")) {
                    if (a.charAt(i) == '1' && b.charAt(i - diferencia) == '1') {
                        respuesta += "1";
                        llevar = "1";
                    } else if (a.charAt(i) == '0' && b.charAt(i - diferencia) == '0') {
                        respuesta += "1";
                        llevar = "0";

                    } else if (a.charAt(i) == '1' || b.charAt(i - diferencia) == '1') {
                        respuesta += "0";
                        llevar = "1";
                    }

                } else {
                    if (a.charAt(i) == '1' && b.charAt(i - diferencia) == '1') {
                        respuesta += "0";

                        llevar = "1";

                    } else if (a.charAt(i) == '0' && b.charAt(i - diferencia) == '0') {
                        respuesta += "0";
                        llevar = "0";

                    } else if (a.charAt(i) != '1' || b.charAt(i - diferencia) != '1') {
                        respuesta += "1";
                        llevar = "0";
                        System.err.println(respuesta);

                    }
                }
            } 
            else if (i >= 0) {
                if (llevar.equals("1")) {
                    if (a.charAt(i) == '1') {
                        llevar = "1";
                        respuesta += "0";
                    } else {
                        llevar = "0";
                        respuesta += "1";
                    }
                } else {
                    respuesta += a.charAt(i);
                    llevar = "0";
                }
            }
        }
        if (llevar.equals("1")) {
            respuesta += "1";
            System.err.println("XD");
        }
        StringBuilder sbr = new StringBuilder(respuesta);
        respuesta = sbr.reverse().toString();
        respuesta=zero(respuesta);
        return respuesta;
    }
     public static String zero(String n){
            if(conversion(n)!=0){
            int cont=0;
            do{
                if(n.charAt(cont)=='1'){
                    n=n.substring(cont);
                }
                 cont++;
            }while(n.charAt(0)=='0');
        }
        if(conversion(n)==0){
            n="0";
        }
         
         
         return n;
        }

    public static void main(String[] args) {
        n1 = JOptionPane.showInputDialog(null, "Ingrese el número 1");
        n2 = JOptionPane.showInputDialog(null, "Ingrese el número 2");
        //division(n1, n2);
        //JOptionPane.showMessageDialog(null, multiplicacion(n1, n2));
         //JOptionPane.showMessageDialog(null, conversion(n1));
          //JOptionPane.showMessageDialog(null, zero(n1));
    }

    public static String Resta(String n1, String n2) {
        n1=zero(n1);
        n2=zero(n2);
        String a = "";
        String b = "";
        String respuesta = "";
        int diferencia = 0;
        if (n1.length() >= n2.length()) {
            a = n1;
            b = n2;
            diferencia = a.length() - b.length();
        }
        else if (n2.length() >= n1.length()) {
            a = n2;
            b = n1;
            diferencia = a.length() - b.length();
        }
        for (int i = a.length() - 1; i >= 0; i--) {
            if (i - diferencia >= 0) {
                if (a.charAt(i) == '1' && b.charAt(i - diferencia) == '1') {
                    respuesta += "0";
                } else if (a.charAt(i) == '0' && b.charAt(i - diferencia) == '0') {
                    respuesta += "0";
                } else if (a.charAt(i) == '1' || b.charAt(i - diferencia) == '0') {
                    respuesta += "1";

                } else if (a.charAt(i) == '0' || b.charAt(i - diferencia) == '1') {
                    String aux = "";
                    respuesta += "1";
                    int cont = i;
                    do {
                        System.err.println(cont);
                        cont--;
                        if (a.charAt(cont) == '1') {
                            aux += "0";
                        }
                        if (a.charAt(cont) == '0') {
                            aux += "1";
                        }
                    } while (a.charAt(cont) == '0');
                    StringBuilder sbr = new StringBuilder(aux);
                    aux = sbr.reverse().toString();
                    System.err.println(cont);
                    if (cont != 0) {
                        a = a.substring(0, cont) + aux + a.substring(i, a.length());

                    } else {
                        a = aux + a.substring(i, a.length());
                    }
                    
                }
            } 
            else if (i >= 0) {

                respuesta += a.charAt(i);

            }
        }
        StringBuilder sbr = new StringBuilder(respuesta);
        respuesta = sbr.reverse().toString();
         respuesta=zero(respuesta);
        return respuesta;

    }

    public static String multiplicacion(String n1, String n2) {
        String r1 = "";
        String r2 = "";
        String contador = "";
          if(n1.charAt(0)== '1'||n1.charAt(0)== '0'&&n2.charAt(0)== '1'||n2.charAt(0)== '0'){
             for (int i = n2.length() - 1; i >= -1; i--) {
            StringBuilder sbr = new StringBuilder(r2);
            r2 = sbr.reverse().toString();
            if (r1.equals("")) {
                r1 = r2;
                r2 = "";
                 //System.err.println(r1);
            }

            if (!r1.equals("") && !r2.equals("")) {
                contador += "0";
                r2 += contador;
                r1 = Suma(r1, r2);
            }
            r2 = "";
            if (i >= 0) {
                for (int j = n1.length() - 1; j >= 0; j--) {
                    if (n1.charAt(j) == '1' && n2.charAt(i) == '1') {
                        r2 += "1";
                    } else if (n1.charAt(j) == '0' || n2.charAt(i) == '0') {
                        r2 += "0";
                    }

                }
            }
        }
           r1=zero(r1); 
        }
        return r1;
    }

    public static double conversion(String num1) {
        double respuesta = 0;
        int cont = 0;
        int cont1=-1;
        int a=0;
        String aux=num1;
        for (int i = 0; i <= num1.length() - 1; i++) {
            if(num1.charAt(i)=='.'){
             a=i;
             aux=num1.substring(0, a);
             for (int j = aux.length() - 1; j >= 0; j--) {
                 respuesta += Double.parseDouble(Character.toString(aux.charAt(j))) * Math.pow(2, cont);   
             cont++;
             }
            }
            if(aux.equals(num1)&& i==num1.length()-1){
               for (int j = aux.length() - 1; j >= 0; j--) {
                 respuesta += Double.parseDouble(Character.toString(aux.charAt(j))) * Math.pow(2, cont);   
             cont++;
             } 
            }
            if(i>=a+1 && a!=0){
                respuesta += Double.parseDouble(Character.toString(num1.charAt(i))) * Math.pow(2, cont1);   
             cont1--;
            }
             
        
    }
        return respuesta;
    }
    public static void division(String n1, String n2) {
        String num1 = "0";
        String respuesta = "";
         n1=zero(n1);
         n2=zero(n2);
         System.err.println(n1+" "+n2);
        for (int i = 0; i <= n1.length() - 1; i++) {
            //ojo
            if(n1.charAt(i)!='.'){
                 num1 += n1.charAt(i);
            }
            //as
            if (conversion(num1) < conversion(n2) && i > n2.length() - 1 && n1.charAt(i)!='.') {
                respuesta += "0";
            }
            if (conversion(num1) >= conversion(n2)) {
                respuesta += "1";

                num1 = Resta(num1, n2);
                System.err.println(num1);
            }
            if(n1.charAt(i)=='.'){
                respuesta+=".";
            }
        }
        num1=zero(num1);
         JOptionPane.showMessageDialog(null, "Cociente: "+respuesta+"\n"
         +"Residuo: "+num1);
    }
}
