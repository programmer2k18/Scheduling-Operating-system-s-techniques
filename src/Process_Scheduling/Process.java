package Process_Scheduling;

import java.util.Vector;

public class Process {
	public String process_name;
	public int priority;
	public int arrival_time;
	public int burst_time;
    public int left;
    public int right;
    public Process() {}
    public Process(String name,int prio,int arrival ,int burst) {
    	this.process_name=name;
    	this.priority=prio;
    	this.burst_time=burst;
    	this.arrival_time=arrival;
    	this.left=0;
    	this.right=0;
    }
}
