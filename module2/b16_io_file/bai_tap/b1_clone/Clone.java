package b16_io_file.bai_tap.b1_clone;

import java.io.*;

public class Clone {
    public static void main(String[] args) {
        try {
            cloneFile("C:\\Users\\ACER\\IdeaProjects\\java8huy\\src\\b16_io_file\\bai_tap\\b1_clone\\Origin","C:\\Users\\ACER\\IdeaProjects\\java8huy\\src\\b16_io_file\\bai_tap\\b1_clone\\Clone");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            countChar("C:\\Users\\ACER\\IdeaProjects\\java8huy\\src\\b16_io_file\\bai_tap\\b1_clone\\Clone");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static void countChar(String path) throws IOException{
        FileReader fileReader=null;
        BufferedReader bufferedReader=null;
        String line=null;
        int count=0;
        try {
            fileReader=new FileReader(path);
            bufferedReader=new BufferedReader(fileReader);
            while ((line=bufferedReader.readLine())!=null){
                for (int i=0;i<line.length();i++){
                    count++;
                }
            }

        }finally {
            bufferedReader.close();
            System.out.println(count);
        }
    }
    public static void cloneFile(String pathInput, String pathOutput) throws IOException {
        FileReader fileReader=null;
        BufferedReader bufferedReader=null;
        String line=null;
        try {
            fileReader=new FileReader(pathInput);
            bufferedReader=new BufferedReader(fileReader);
            while ((line=bufferedReader.readLine())!=null){
                writeFile("C:\\Users\\ACER\\IdeaProjects\\java8huy\\src\\b16_io_file\\bai_tap\\b1_clone\\Clone",line);
            }

        }finally {
            bufferedReader.close();
        }
    }
    public static void writeFile(String path,String data) throws IOException{
        FileWriter fileWriter=null;
        BufferedWriter bufferedWriter=null;
        try {
            fileWriter=new FileWriter(path,true);
            bufferedWriter=new BufferedWriter(fileWriter);
            bufferedWriter.write(data);
            bufferedWriter.newLine();
        }finally {
            bufferedWriter.close();
        }
    }
}
