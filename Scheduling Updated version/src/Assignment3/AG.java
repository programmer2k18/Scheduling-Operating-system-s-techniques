package Assignment3;

import java.util.Vector;

public class AG {
	static int IndexOf(Vector<Process> Table, String Name){
        for(int i=0;i<Table.size();i++){
            if(Table.elementAt(i).getProcess_Name()==Name){
                return i;
            }
        }
        return -1;
    }
	
	static int Exist(Process obj,Vector<Process> Table,int CountTime){
	        for (int i=0;i<Table.size();i++){
	            if(Table.elementAt(i).getProcess_Burst_Time()<obj.getProcess_Burst_Time() && Table.elementAt(i).getProcess_Arrival_Time()<=CountTime){
	                return i;
	            }
	        }
	        return -1;
	    }
	 
	public static void AGs(Vector<Process> Table){
		Vector<Process> CopyTable=Process.makeCpy(Table);
        Vector<String> ProcessesOrder=new Vector<>();
        int CountTime=0;
        while (!CopyTable.isEmpty()){
            for (int i=0;i<CopyTable.size();i++){
               System.out.println(CopyTable.elementAt(i).getProcess_Name()+" "+CopyTable.elementAt(i).getQuantum());
            }
            int Quantum=CopyTable.elementAt(0).getQuantum();
            
            for(int i=0;i<Math.ceil(Quantum/2.0) && CopyTable.elementAt(0).getProcess_Burst_Time()!=0;i++){
                ProcessesOrder.add(CopyTable.elementAt(0).getProcess_Name());
                CopyTable.elementAt(0).setProcess_Burst_Time(CopyTable.elementAt(0).getProcess_Burst_Time()-1);
                CopyTable.elementAt(0).setQuantum(CopyTable.elementAt(0).getQuantum()-1);
                for(int j=1;j<CopyTable.size();j++){
                    Table.elementAt(IndexOf(Table,CopyTable.elementAt(j).getProcess_Name())).setWaiting_Time(Table.elementAt(IndexOf(Table,CopyTable.elementAt(j).getProcess_Name())).getWaiting_Time()+1);
                }
                CountTime++;
            }

            while(Exist(CopyTable.elementAt(0),CopyTable,CountTime)==-1 && CopyTable.elementAt(0).getProcess_Burst_Time()!=0){
                if(CopyTable.elementAt(0).getQuantum()==0){
                    CopyTable.elementAt(0).setQuantum(Table.elementAt(IndexOf(Table,CopyTable.elementAt(0).getProcess_Name())).getQuantum()+1);
                    break;
                }
                ProcessesOrder.add(CopyTable.elementAt(0).getProcess_Name());
                CopyTable.elementAt(0).setProcess_Burst_Time(CopyTable.elementAt(0).getProcess_Burst_Time()-1);
                CopyTable.elementAt(0).setQuantum(CopyTable.elementAt(0).getQuantum()-1);
                for(int j=1;j<CopyTable.size();j++){
                    Table.elementAt(IndexOf(Table,CopyTable.elementAt(j).getProcess_Name())).setWaiting_Time(Table.elementAt(IndexOf(Table,CopyTable.elementAt(j).getProcess_Name())).getWaiting_Time()+1);
                }
                CountTime++;
            }
            int index=Exist(CopyTable.elementAt(0),CopyTable,CountTime);
            if(CopyTable.elementAt(0).getProcess_Burst_Time()==0){
                Table.elementAt(IndexOf(Table,CopyTable.elementAt(0).getProcess_Name())).setFinishTime(CountTime+1);
                CopyTable.remove(0);

            }
            else if(index !=-1){
                CopyTable.elementAt(0).setQuantum(Table.elementAt(IndexOf(Table,CopyTable.elementAt(0).getProcess_Name())).getQuantum()+CopyTable.elementAt(0).getQuantum());
                CopyTable.add(CopyTable.elementAt(0));
                Process temp=new Process(CopyTable.elementAt(index));
                CopyTable.remove(index);
                CopyTable.remove(0);
                CopyTable.insertElementAt(temp,0);

            }
            else {
                int i;
                Process temp=null;
                for( i=1;i<CopyTable.size();i++){
                    if(CopyTable.elementAt(i).getProcess_Arrival_Time()<=CountTime){
                        temp=new Process(CopyTable.elementAt(i));
                        break;

                    }
                }
                CopyTable.add(CopyTable.elementAt(0));
                CopyTable.remove(i);
                CopyTable.remove(0);
                CopyTable.insertElementAt(temp,0);
            }

        }

        for (int i=0;i<Table.size();i++){
            Table.elementAt(i).setTurnaround_Time(Table.elementAt(i).getWaiting_Time()+Table.elementAt(i).getProcess_Burst_Time());
        }
        for(int i=0;i<ProcessesOrder.size();i++){
            System.out.print(ProcessesOrder.elementAt(i)+" ");
        }
        System.out.println();
    }
}
