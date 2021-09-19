package b16_io_file.thuc_hanh.b1_sum;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Sum {
    public static void main(String[] args) {
        try {
            readFileText("C:\\Users\\ACER\\IdeaProjects\\java8huy\\src\\b16_io_file\\thuc_hanh\\b1_sum\\numbers");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void readFileText(String path) throws IOException{
        FileReader reader1=null;
        BufferedReader bufferedReader=null;
        int sum=0;
        try {
            reader1=new FileReader(path);
            bufferedReader=new BufferedReader(reader1);
            String line=null;
            while ((line=bufferedReader.readLine())!=null){
                sum+=Integer.parseInt(line);
            }
        }catch (IOException e){
            e.printStackTrace();
        } finally {
            bufferedReader.close();
        }
        System.out.println(sum);
    }
}
