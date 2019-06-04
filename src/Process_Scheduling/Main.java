package Process_Scheduling;

import java.util.Scanner;
import java.util.Vector;
public class Main {

	public static void main(String[] args) {
		Vector<Process> myProcesses=new Vector<Process>();
		int num=0;
		System.out.println("Enter number of processes : ");
		num=new Scanner(System.in).nextInt();
		Process p=new Process();
		for(int i=0;i<num;i++) {
			p=new Process();
			System.out.println("Enter data about process number " + (i+1) + " >>>>>");
			System.out.print("Enter process name >>>> ");
			p.process_name=new Scanner(System.in).nextLine();
			System.out.print("Enter process arrival time >>>> ");
			p.arrival_time=new Scanner(System.in).nextInt();
			System.out.print("Enter process burst time >>>> ");
			p.burst_time=new Scanner(System.in).nextInt();
			System.out.print("Enter process priority >>>> ");
			p.priority=new Scanner(System.in).nextInt();
			myProcesses.add(p);
			System.out.println();
		}
		Priority obj=new Priority(myProcesses);
		obj.Sort();
		obj.Solve_Algorithm();
		//obj.calculate_time();
	}

}
