package b16_io_file.bai_tap.b2_;

import b16_io_file.bai_tap.b2_.Country;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadFileCSV {
    public static void main(String[] args) {
        List<Country> countryList=null;
        try {
            countryList= readFileCSV("C:\\Users\\ACER\\IdeaProjects\\java8huy\\src\\b16_io_file\\bai_tap\\b2_\\country.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }
//        try {
//            writeFileCSV("C:\\Users\\ACER\\IdeaProjects\\java8huy\\src\\b16_io_file\\bai_tap\\b2_\\Clone",countryList);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
    public static List<Country> readFileCSV(String path) throws IOException {
        List<Country> countryList =new ArrayList<>();
        FileReader fileReader=null;
        BufferedReader bufferedReader=null;
        String line=null;
        try {
            fileReader=new FileReader(path);
            bufferedReader=new BufferedReader(fileReader);
            while ((line=bufferedReader.readLine())!=null){
                if(line.isEmpty()){
                    continue;
                }
                String []data=line.split(",");
                int id=Integer.parseInt( data[0]);
                String code=data[1];
                String name=data[2];
                countryList.add(new Country(id,code,name));
            }
        }finally {
            bufferedReader.close();
            return countryList;
        }
    }
    public static void writeFileCSV(String path, List<Country>countryList) throws IOException{
        FileWriter fileWriter=null;
        BufferedWriter bufferedWriter=null;
        try {
            fileWriter=new FileWriter(path);
            bufferedWriter=new BufferedWriter(fileWriter);
            for (Country country:countryList){
                bufferedWriter.write(country.toString());
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }
        }finally {
            bufferedWriter.close();
        }
    }
}
