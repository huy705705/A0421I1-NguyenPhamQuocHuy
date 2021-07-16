package b3_mang_va_phuong_thuc_java.thuc_hanh;
import java.util.Scanner;
public class _2 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String[] students = {"Christian", "Michael", "Camila", "Sienna", "Tanya", "Connor", "Zachariah", "Mallory", "Zoe", "Emily"};
        System.out.print("Enter a name’s student:");
        String input_name = scanner.nextLine();

        boolean flag=false;
        int index=-1;
        for (int i=0;i<students.length;i++){
            if(students[i].equals(input_name)){
                flag=true;
                 index=i;
                System.out.println("dung");
            }
        }
        System.out.println(flag);
        if(flag==true){
            System.out.println("Position of the students in the list: " +index);
        }else {
            System.out.println("Not found "+input_name+" in the list");
        }
    }
}
