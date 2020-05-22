package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Lexer {

    void report(String path)
    {
        try {
            File file = new File(path);
            FileReader fileReader = new FileReader(file);
            int ch = 0;
            String s = "";
            for (int i = 0; i <= file.length(); i++ )
            {
                ch = fileReader.read();
                s += (char)ch;
            }

            StringTokenizer st = new StringTokenizer(s);
            while (st.hasMoreTokens()) {
                String token = st.nextToken();
                if(token.equals("+"))
                {
                    System.out.println(token + " Token Number : 6");
                }
                else if(token.equals("-"))
                {
                    System.out.println(token + " Token Number : 7");
                }
                else if(token.equals("*"))
                {
                    System.out.println(token + " Token Number : 8");
                }
                else if(token.equals("/"))
                {
                    System.out.println(token + " Token Number : 9");
                }
                else if(token.equals("="))
                {
                    System.out.println(token + " Token Number : 10");
                }
                else if(token.equals(";"))
                {
                    System.out.println(token + " Token Number : 12");
                }
                else if(token.equals("("))
                {
                    System.out.println(token + " Token Number : 13");
                }
                else if(token.equals(")"))
                {
                    System.out.println(token + " Token Number : 14");
                }
                else if(isInt(token))
                {
                    System.out.println(token + " Token Number : 4");
                }else
                {
                    System.out.println(token + " Token Number : 2");
                }
            }

            fileReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public boolean isInt(String str)
    {
        try{
            Double.parseDouble(str);
            return true;
        }catch (Exception e)
        {
            return false;
        }
    }


    public static void main(String[] args) {
        Lexer l = new Lexer();
        l.report("D:\\MyCode\\Algorithm\\TestProgram.smt");
    }

}
