package Assignment3;

import java.util.Vector;

public class RR {
	static int IndexOf(Vector<Process> Table, String Name){
        for(int i=0;i<Table.size();i++){
            if(Table.elementAt(i).getProcess_Name()==Name){
                return i;
            }
        }
        return -1;
    }
	
	public static void RRs(Vector<Process> Table,int Quantum){
        Vector<String> ProcessesOrder=new Vector<>();
        int CountTime=0;
        Vector<Process> CopyTable=Process.makeCpy(Table);
        while (!CopyTable.isEmpty()){
            for(int i=0;i<Quantum;i++){
                ProcessesOrder.add(CopyTable.elementAt(0).getProcess_Name());
                CopyTable.elementAt(0).setProcess_Burst_Time(CopyTable.elementAt(0).getProcess_Burst_Time()-1);
                if(CopyTable.elementAt(0).getProcess_Burst_Time()==0){
                    Table.elementAt(IndexOf(Table,CopyTable.elementAt(0).getProcess_Name())).setFinishTime(CountTime+1);
                    CountTime++;
                    break;
                }
                CountTime++;
            }
            // if Quantum_Time > Burst_TIme
            if(CopyTable.elementAt(0).getProcess_Burst_Time()!=0){
                CopyTable.add(CopyTable.elementAt(0));
            }
            CopyTable.remove(0);

        }

        for (int i=0;i<Table.size();i++){
            Table.elementAt(i).setWaiting_Time(Table.elementAt(i).getFinishTime()-Table.elementAt(i).getProcess_Arrival_Time()-Table.elementAt(i).getProcess_Burst_Time());
            Table.elementAt(i).setTurnaround_Time(Table.elementAt(i).getWaiting_Time()+Table.elementAt(i).getProcess_Burst_Time());
        }
        System.out.print("Process Order : ");
        for(int i=0;i<ProcessesOrder.size();i++){
            System.out.print(ProcessesOrder.elementAt(i)+" ");
        }
        System.out.println();
        System.out.println("Name " + "    | Burst Time " + " |Arrival Time" + "|Finish Time  " + "|Waiting Time " + "| Turnaround Time");
        for (int i=0;i<Table.size();i++){
            System.out.println(Table.elementAt(i).getProcess_Name()+"       |     "+Table.elementAt(i).getProcess_Burst_Time()+"       |      "+Table.elementAt(i).getProcess_Arrival_Time()+"     |    "+Table.elementAt(i).getFinishTime()+"        |    "+Table.elementAt(i).getWaiting_Time()+"        |    "+Table.elementAt(i).getTurnaround_Time());
        }
}
}
