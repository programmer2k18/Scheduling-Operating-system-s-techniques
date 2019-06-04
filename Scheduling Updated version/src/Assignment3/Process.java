
package Assignment3;

import java.util.Vector;

public class Process {
    private String Name;
    private int Arrival_Time;
    private int Burst_Time;
    private int Waiting_Time;
    private int Turnaround_Time;
    private int Priority;
    private int FinishTime;
    private int Quantum;

public Process(){
    Name="";
    Arrival_Time=0;
    Burst_Time=0;
    Waiting_Time=0;
    Turnaround_Time=0;
    Priority = 0;
    FinishTime=0;
    Quantum=0;
}

public Process(Process p){
    Name=p.Name;
    Arrival_Time=p.Arrival_Time;
    Burst_Time=p.Burst_Time;
    Waiting_Time=p.Waiting_Time;
    Turnaround_Time=p.Turnaround_Time;
    Priority=p.Priority;
    FinishTime=p.FinishTime;
    Quantum=p.Quantum;
}

public String getProcess_Name() {
    return Name;
}

public void setProcess_Name(String process_Name) {
    Name = process_Name;
}

public int getProcess_Arrival_Time() {
    return Arrival_Time;
}

public void setProcess_Arrival_Time(int process_Arrival_Time) {
    Arrival_Time = process_Arrival_Time;
}

public int getProcess_Burst_Time() {
    return Burst_Time;
}

public void setProcess_Burst_Time(int process_Burst_Time) {
    Burst_Time = process_Burst_Time;
}

public int getWaiting_Time() {
    return Waiting_Time;
}

public void setWaiting_Time(int waiting_Time) {
    Waiting_Time = waiting_Time;
}

public int getTurnaround_Time() {
    return Turnaround_Time;
}

public void setTurnaround_Time(int turnaround_Time) {
    Turnaround_Time = turnaround_Time;
}

public int getProcess_priority() {
    return Priority;
}

public void setProcess_priority(int process_priority) {
    this.Priority = process_priority;
}

public int getFinishTime() {
    return FinishTime;
}

public void setFinishTime(int finishTime) {
    FinishTime = finishTime;
}

public void setFinishTime_Context_Switch(int Context_Switch) {
	FinishTime +=Context_Switch ;
	
}

public int getQuantum() {
    return Quantum;
}

public void setQuantum(int quantum) {
    Quantum = quantum;
}
public void equalize(Process p)
{
	this.Name=p.Name;
     this.Arrival_Time=p.Arrival_Time;
    this.Burst_Time=p.Burst_Time;
    this.Waiting_Time=p.Waiting_Time;
    this.Turnaround_Time=p.Turnaround_Time;
    this.Priority=p.Priority;
    this.FinishTime=p.FinishTime;
    
}

public static Vector<Process> makeCpy(Vector<Process> Org)
{
    Vector<Process> CopyTable=new Vector<>();
    for (int i=0;i<Org.size();i++){
        CopyTable.add(new Process(Org.elementAt(i)));
    }
    return CopyTable;
}

}
