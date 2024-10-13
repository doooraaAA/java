package string;
import java.util.Scanner;

public class test1 {
public static void main(String[] args) {
	Scanner scanner=new Scanner(System.in);
	String str=scanner.next();
	int big=0,small=0,number=0;
	for(int i=0;i<str.length();i++) {
		char c=str.charAt(i);
		if(c>='a'&&c<='z')
			big++;
		else if(c>=48&&c<=57)
			number++;
		else
			small++;
	}
	System.out.println(big);
	System.out.println(small);
	System.out.println(number);
	scanner.close();
}
}
