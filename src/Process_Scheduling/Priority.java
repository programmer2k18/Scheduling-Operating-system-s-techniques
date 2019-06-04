package Process_Scheduling;

import java.util.Vector;

public class Priority {
    Vector<Process> myProcesses=new Vector<Process>();
    Vector<Process> copy=new Vector<Process>();
    Vector<String> names=new Vector<String>();
    String arr[];
	public Priority() {}
	public Priority(Vector<Process> myProcesses) {
		this.myProcesses=myProcesses;
		for(int i=0;i<myProcesses.size();i++) {
			Process p=new Process();
			p.process_name=myProcesses.get(i).process_name;
			p.arrival_time=myProcesses.get(i).arrival_time;
			p.burst_time=myProcesses.get(i).burst_time;
			p.priority=myProcesses.get(i).priority;
			copy.add(p);
		}
	}
	public void Sort(){
    	Process value=new Process();
    	int hole;
    	for(int i=1;i<this.myProcesses.size();i++) {
    		value=this.myProcesses.get(i);
    		hole=i;
    		while(hole>0 && this.myProcesses.get(hole-1).arrival_time>value.arrival_time) {
    			this.myProcesses.set(hole, this.myProcesses.get(hole-1));
    			hole--;
    		}
    		this.myProcesses.set(hole, value);
    	}
    }
	public void Solve_Algorithm() {
	
		int counter=myProcesses.get(0).arrival_time;
		Vector<Process> waiting=new Vector<Process>();
		int excuted=0;
		int position=0;
		for(int i=0;i<myProcesses.size()-1;i++) {
			Process p= myProcesses.get(i);
			p.left=counter;
			position=i+1;
			while(true) {
				excuted++;
				if(p.burst_time==0)
					break;
				if(excuted+p.arrival_time==myProcesses.get(position).arrival_time&&p.burst_time>0) {
					if(myProcesses.get(position).priority<p.priority) {
						p.right=myProcesses.get(position).arrival_time;
						counter=p.right;
						waiting.add(p);
						excuted=0;
						break;
					}
					else {
						
						p.burst_time--;
						excuted++;
						waiting.add(myProcesses.get(position));
						myProcesses.remove(position);
						position++;
					}
				}
				else {
					p.burst_time--;
				}
				
			}
	}
}
	 
	public void calculate_time() {
	
		double average_waiting_time=0,average_turn_arround_time=0;
		
		for(int i=0;i<myProcesses.size();i++)
			names.add(myProcesses.get(i).process_name);
		for(int i=0;i<copy.size();i++) {
			int index= names.lastIndexOf(copy.get(i).process_name);
			Process p=myProcesses.get(index);
			int aroundTime=p.right-copy.get(i).arrival_time;
			average_turn_arround_time+=aroundTime;
			int wait_Time=aroundTime-copy.get(i).burst_time;
			average_waiting_time+=wait_Time;
			System.out.println("Waiting time for process >>>> " +p.process_name + " : " + wait_Time);
			System.out.println("Turn around time for process >>>> " +p.process_name + " : " + aroundTime);
			System.out.println();
		}
		System.out.println("Average Waiting time for all processes >>>> " + average_waiting_time/copy.size());
		System.out.println("Average turn around time for all processes >>>> " + average_turn_arround_time/copy.size());
	}
}
