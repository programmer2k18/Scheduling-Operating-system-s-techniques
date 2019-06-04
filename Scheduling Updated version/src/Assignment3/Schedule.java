
package Assignment3;

import java.util.Scanner;
import java.util.Vector;

public class Schedule {
    static float Average_Waiting_Time(Vector<Process> Table){
        int sum=0;
        float result;
        for (int i=0;i<Table.size();i++){
            sum+=Table.elementAt(i).getWaiting_Time();
        }
        result= sum/(float)Table.size();
        return result;
    }

    static float Average_Turnaround_Time(Vector<Process> Table){
        int sum=0;
        float result;
        for (int i=0;i<Table.size();i++){
            sum+=Table.elementAt(i).getTurnaround_Time();
        }
        result= sum/(float)Table.size();
        return result;
    }

    @SuppressWarnings("static-access")
	public static void main(String[] args){
        int Number_of_processes;
        int Type;
        int Round_robin_Time_Quantum;
        Vector<Process> Table=new Vector<Process>();
        Scanner InputInt=new Scanner(System.in);
        Scanner InputString=new Scanner(System.in);
        int Context_Switch = 0;
        System.out.println("Choose Schedule Method \n 1) SJF  \n 2) RR \n 3) Priority \n 4) for AG \n");
        Type=InputInt.nextInt();
        System.out.println("Enter # of processes");
        Number_of_processes=InputInt.nextInt();

        if(Type==1){
        	SJF Execute = new SJF();
        	System.out.println("Enter Context Switch Value : ");
            Context_Switch = InputInt.nextInt();
            for (int i=0;i<Number_of_processes;i++){
                Process object=new Process();
                System.out.println("Enter the process name : ");
                object.setProcess_Name(InputString.nextLine());
                System.out.println("Enter the process Burst Time : ");
                object.setProcess_Burst_Time(InputInt.nextInt());
                System.out.println("Enter the process Arrival Time : ");
                object.setProcess_Arrival_Time(InputInt.nextInt());
                Table.add(object);

            }
            Execute.SJFs(Table , Context_Switch);
        }
        else if(Type==2){
        	RR Execute = new RR();
            for (int i=0;i<Number_of_processes;i++){
                Process object=new Process();
                System.out.println("Enter the process name : ");
                object.setProcess_Name(InputString.nextLine());
                System.out.println("Enter the process Burst Time : ");
                object.setProcess_Burst_Time(InputInt.nextInt());
                System.out.println("Enter the process Arrival Time : ");
                object.setProcess_Arrival_Time(InputInt.nextInt());
                Table.add(object);

            }
            System.out.println("Enter the Round robin Time Quantum");
            Round_robin_Time_Quantum=InputInt.nextInt();
            Execute.RRs(Table,Round_robin_Time_Quantum);
        }
        else if(Type==3){
        	Priority Execute = new Priority();
            for (int i=0;i<Number_of_processes;i++){
                Process object=new Process();
                System.out.println("Enter the process name : ");
                object.setProcess_Name(InputString.nextLine());
                System.out.println("Enter the process Burst Time : ");
                object.setProcess_Burst_Time(InputInt.nextInt());
                System.out.println("Enter the process priority : ");
                object.setProcess_priority(InputInt.nextInt());
                Table.add(object);
            }
            Execute.Prioritys(Table);

        }
        else if(Type==4){
        	AG Execute = new AG();
            for (int i=0;i<Number_of_processes;i++){
                Process object=new Process();
                System.out.println("Enter the process name : ");
                object.setProcess_Name(InputString.nextLine());
                System.out.println("Enter the process Burst Time : ");
                object.setProcess_Burst_Time(InputInt.nextInt());
                System.out.println("Enter the process Arrival Time : ");
                object.setProcess_Arrival_Time(InputInt.nextInt());
                System.out.println("Enter the process quantum : ");
                object.setQuantum(InputInt.nextInt());
                Table.add(object);
            }
            Execute.AGs(Table);
        }
        System.out.println("Average_Waiting_Time : "+Average_Waiting_Time(Table));
        System.out.println("Average_Turnaround_Time : "+Average_Turnaround_Time(Table));

        InputInt.close();
        InputString.close();

    }
    
}
