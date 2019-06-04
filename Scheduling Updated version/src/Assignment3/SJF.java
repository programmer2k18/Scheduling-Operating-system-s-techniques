package Assignment3;

import java.util.Vector;

public class SJF {
	public SJF(){
		
	}
	static void bubbleSort(Vector<Process> Table,int CountTime) {
        int n = Table.size();
        Process temp = new Process();
        for(int i=0; i < n-1 && Table.elementAt(i+1).getProcess_Arrival_Time()<=CountTime; i++){

            for(int j=1; j < (n-i); j++){

                if(Table.elementAt(j-1).getProcess_Burst_Time() > Table.elementAt(j).getProcess_Burst_Time()){
                    temp=new Process(Table.elementAt(j-1));

                    Table.elementAt(j-1).equalize(Table.elementAt(j));
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
    public static void SJFs(Vector<Process> Table , int Context_Switch){
	        Vector<String> ProcessesOrder=new Vector<>();
	        int CountTime=0;
	        Vector<Process> CopyTable=Process.makeCpy(Table);
	        while (!CopyTable.isEmpty()){
	            bubbleSort(CopyTable,CountTime);
	            ProcessesOrder.add(CopyTable.elementAt(0).getProcess_Name());
	            CopyTable.elementAt(0).setProcess_Burst_Time(CopyTable.elementAt(0).getProcess_Burst_Time()-1);
	            if(CopyTable.elementAt(0).getProcess_Burst_Time()==0){
	                Table.elementAt(IndexOf(Table,CopyTable.elementAt(0).getProcess_Name())).setFinishTime(CountTime+1);
	                CopyTable.remove(0);
	            }
	            CountTime++;
	        }
	        //Context Switch
	        for(int i =0 ; i < ProcessesOrder.size() - 1 ; i++) {
	        	if(!ProcessesOrder.elementAt(i).equals(ProcessesOrder.elementAt(i+1))) {
	        		Table.elementAt(IndexOf(Table,ProcessesOrder.elementAt(i+1))).setFinishTime_Context_Switch(Context_Switch);
	        	}
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
