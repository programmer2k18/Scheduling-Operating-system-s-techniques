package Assignment3;

import java.util.Vector;

public class Priority {
	
	static void bubbleSortPriority(Vector<Process> Table) {
        int n = Table.size();
        Process temp = new Process();
        for(int i=0; i < n; i++){
            for(int j=1; j < (n-i); j++){
                if(Table.elementAt(j-1).getProcess_priority() > Table.elementAt(j).getProcess_priority()){
                    temp=new Process(Table.elementAt(j-1));            
                    Table.elementAt(j-1).equalize(Table.elementAt(j));	//just swap them
                    Table.elementAt(j).equalize(temp);
                }
            }
        }
    }

	 static int IndexOf(Vector<Process> Table, String Name){
	        for(int i=0;i<Table.size();i++){
	            if(Table.elementAt(i).getProcess_Name()==Name){
	                return i;
	            }
	        }
	        return -1;
	    }

	public static void Prioritys(Vector<Process> Table){
        Vector<Process> CopyTable=new Vector<>();
        Vector<String> ProcessesOrder=new Vector<>();

        for (int i=0;i<Table.size();i++){
            CopyTable.add(new Process(Table.elementAt(i)));
        }

        while (!CopyTable.isEmpty()){
            bubbleSortPriority(CopyTable);
            ProcessesOrder.add(CopyTable.elementAt(0).getProcess_Name());
            CopyTable.elementAt(0).setProcess_Burst_Time(CopyTable.elementAt(0).getProcess_Burst_Time()-1);
            for(int i=1;i<CopyTable.size();i++){
                Table.elementAt(IndexOf(Table,CopyTable.elementAt(i).getProcess_Name())).setWaiting_Time(Table.elementAt(IndexOf(Table,CopyTable.elementAt(i).getProcess_Name())).getWaiting_Time()+1);
                if(Table.elementAt(i).getWaiting_Time()>=5){
                    CopyTable.elementAt(IndexOf(CopyTable,Table.elementAt(i).getProcess_Name())).setProcess_priority(CopyTable.elementAt(i).getProcess_priority()-1);
                }
            }
            if(CopyTable.elementAt(0).getProcess_Burst_Time()==0){
                CopyTable.remove(0);
            }
        }

        for (int i=0;i<Table.size();i++){
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
