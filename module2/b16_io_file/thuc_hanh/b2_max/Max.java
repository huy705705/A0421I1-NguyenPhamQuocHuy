package b16_io_file.thuc_hanh.b2_max;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Max {
    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>();
        try {
            list=readFile("C:\\Users\\ACER\\IdeaProjects\\java8huy\\src\\b16_io_file\\thuc_hanh\\b1_sum\\numbers");
        } catch (IOException e) {
            e.printStackTrace();
        }
        int max=list.get(0);
        for(int i=0;i<list.size();i++){
            if(max<list.get(i)){
                max=list.get(i);
            }
        }
        try {
            writeFile("C:\\Users\\ACER\\IdeaProjects\\java8huy\\src\\b16_io_file\\thuc_hanh\\b1_sum\\result.txt",max);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static List<Integer>  readFile(String path) throws IOException {
        List<Integer> list=new ArrayList<>();
        FileReader fileReader=null;
        BufferedReader bufferedReader=null;
        String line=null;

        try {
            fileReader=new FileReader(path);
            bufferedReader= new BufferedReader(fileReader);
            while ((line=bufferedReader.readLine())!=null){
                list.add(Integer.parseInt(line));
            }
        }finally {
            bufferedReader.close();
            return list;
        }
    }
    public static void writeFile(String path,int max) throws IOException{
        FileWriter fileWriter=null;
        BufferedWriter bufferedWriter=null;
        try {
            fileWriter= new FileWriter(path);
            bufferedWriter=new BufferedWriter(fileWriter);
            bufferedWriter.write("Max la: "+max);
        }finally {
            bufferedWriter.close();
        }
    }
}
