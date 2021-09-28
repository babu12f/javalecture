package com.project.filehandle;

import java.io.*;
import java.util.Scanner;

public class FileLecture {

    private static final String PATH = "C:/temp/javafiles";

    public static void main(String[] args){
        File file = new File("C:/temp/javafiles/SumonVaiFile.java");
        /*if (file.exists()) {
            System.out.println("this file already present");
        }
        else {
            try {
                System.out.println("file not present new file created");
                file.createNewFile();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }*/
        /*if (file.isDirectory()) {
            System.out.println("it is a folder");
        }
        if (file.isFile()) {
            System.out.println("it is a file");
        }*/
        /*String presentWorkingDirectory = System.getProperty("user.dir");
        System.out.println(presentWorkingDirectory);*/

        /*File myDir = new File(PATH + File.separator + "kz");
        myDir.mkdir();
        String myDirPath = myDir.getPath();
        System.out.println(myDirPath);*/

        /*File sumonVaiFile = new File(PATH + File.separator + "kz");
        sumonVaiFile.delete();*/

        /*File sumonVaiFile = new File(PATH + File.separator + "SumonVaiFile.txt");
        File kzVaiFile = new File(PATH + File.separator + "kzFile.txt");

        if(sumonVaiFile.renameTo(kzVaiFile)){
            System.out.println("renamed");
        }
        else {
            System.out.println("not renamed");
        }*/

        /*File myFolder = new File(PATH);
        File[] files = myFolder.listFiles();

        int i = 1;
        for (File f : files) {
            System.out.println("file number : " + i);
            System.out.println(f.getPath());
            System.out.println(f.getName());
            i++;
        }*/

        /*try {
            File file1 = new File(PATH + File.separator + "kzFile.txt");

            Scanner sc = new Scanner(file1);
            while (sc.hasNextLine()) {
                String data = sc.nextLine();
                System.out.println(data);
            }
            sc.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }*//*try {
            File file1 = new File(PATH + File.separator + "kzFile.txt");

            Scanner sc = new Scanner(file1);
            while (sc.hasNextLine()) {
                String data = sc.nextLine();
                System.out.println(data);
            }
            sc.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }*/

        Scanner sc = new Scanner(System.in);
        String mydata = sc.nextLine();

        try {
            File file1 = new File(PATH + File.separator + "alivaiFile.txt");

            FileOutputStream fos = new FileOutputStream(file1);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

            //for (int i = 0; i < 10; i++) {
                bw.write(mydata);
            //}
            bw.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

}
