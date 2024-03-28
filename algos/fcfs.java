package algos;
import java.util.*; 

public class fcfs{
    Scanner sc = new Scanner(System.in);

    public static void FindAvgWT(int n, int at[], int bt[], int wt[]){
        wt[0] = 0;
        for(int i=1; i<n; i++){
            wt[i] = wt[i-1] + bt[i-1];
        }
    }
    public static void FindAvgTAT(int n, int at[], int bt[], int wt[], int tat[]){
        for(int i=0; i<n; i++){
            tat[i] = wt[i] + bt[i];
        }
    }

    public static void FindAvgTime(int n, int at[], int bt[]){
        int WaitingTime[] = new int[n], TurnAroundTime[] = new int[n];
        int total_wt = 0, total_tat = 0;

        FindAvgWT(n, at, bt, WaitingTime);
        FindAvgTAT(n, at, bt, WaitingTime, TurnAroundTime);
        for(int i=0; i<n; i++){
            total_wt += WaitingTime[i];
        }
        for(int i=0; i<n; i++){
            total_tat += TurnAroundTime[i];
        }
        float avgwt = total_wt / n;
        float avgtat = total_tat / n;
        System.out.println("avg waiting time = "+avgwt);
        System.out.println("avg turn around time = "+avgtat);
    }
    public static void main(String[] args){
        System.out.println("Enter the number of processes: ");
        int arrivalTime[] = {1,2,3,4,5};
        int n = arrivalTime.length;
        int burstTime[] = {4,2,3,5,8};
        FindAvgTime(n, arrivalTime, burstTime);
    }
}