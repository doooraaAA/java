package gpa.cacualtor;
import java.util.Scanner;
/**
 * 引入scanner，读取输入的成绩
 * @author 31677
 *
 */
class Course{
	private String name;
	private double score;
	private double credit;
/**
 * 定义课程及其相关参数
 * @author 31677
 *
 */
    public Course(String name,double score,double credit) {
	       this.name=name;
	       this.credit=credit;
	       this.score=score;
           }
    /**
     * 传入相关参数
     */
    public double GetCredit() {
    	return credit;
    }
    /**
     * 设计getcredit函数，返回计算的credit
     */
    double GetScore() {
    	if(score>=90) {
    		return 4.0;
    	}else if(score>=85) {
    		return 3.7;
    	}else if(score>=80) {
    		return 3.3;
    	}else if(score>=76) {
    		return 3.0;
    	}else if(score>=73) {
    		return 2.7;
    	}else if(score>=70) {
    		return 2.3;
    	}else if(score>=66) {
    		return 2.0;
    	}else if(score>=63) {
    		return 1.7;
    	}else if(score>=61) {
    		return 1.3;
    	}else if(score==60) {
    		return 1.0;
    	}else {
    		return 0.0;
    	}
    }
    /**
     * 学分的获取函数
     */
}
public class gpa {
	private static Scanner sc= new Scanner (System.in);
	public static void main(String[] args) {
		System.out.print("请输入修读的课程总数量： ");
		int n=sc.nextInt();
		Course[] courses = new Course[n];
		for (int i=0;i<n;i++) {
			System.out.print("请输入第"+(i+1)+"门课程的名称： ");
			String name = sc.next();
			System.out.print("请输入第"+(i+1)+"门课程的分数： ");
			double score = sc.nextDouble();
			System.out.print("请输入第"+(i+1)+"门课程的学分： ");
			double credit =sc.nextDouble();
			courses[i]=new Course(name,score,credit);

		}
		double totalcredit = 0;
		double totalscore = 0;
		for(int i=0;i<n;i++) {
			totalscore += courses[i].GetCredit();
			totalcredit += courses[i].GetScore()*courses[i].GetCredit();        
		}
		double gpa = totalcredit/totalscore;
		System.out.printf("您的绩点为：%.2f",gpa);
	}

}
