/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package platechproject;
import java.util.Scanner;

public class PreEmptiveShortestJobFirst 
{
    
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of processes: ");
        int num = sc.nextInt();
        int burst[] = new int[num];
        int arrival[] = new int[num];
        for(int i = 0; i < num; i++)
        {
            System.out.println("Process "+(i+1));
            System.out.println("Enter Burst Time: ");
            burst[i] = sc.nextInt();
            System.out.println("Enter Arrival Time: ");
            arrival[i] = sc.nextInt();
        }
        int curTime = 0;
        int top = -1;
        int curJob = 0;
        while(CheckEmptyJobs(burst,num) == true)
        {
            for(int i = 0; i < num; i++)
                if(arrival[i] ==  curTime)
                    if(burst[i] < burst[curJob])
                        curJob = i;
            burst[curJob]--;
            if(burst[curJob] == 0)
            {
                System.out.println("Process "+ (curJob+1)+ " is Finished!");
                int shortest = 0;
                for(int i = 0; i < burst.length; i++)
                {
                    
                    if(burst[i] != 0)
                    {
                        if(i != 0)
                        {
                           if(arrival[i] <= curTime)
                            {
                                if(burst[shortest] > burst[i])
                                    shortest = i;
                            } 
                        }
                        else if(i == 0 && arrival[i] <= curTime)
                        {
                            shortest = i;
                        }
                        
                    }
                }
                curJob = shortest;
            }
                
            curTime++;
        }
    }
    public static boolean CheckEmptyJobs(int burst[], int num)
    {
        boolean check = false;
        for(int i = 0; i < num; i++)
            if(burst[i] > 0)
            {
                check = true;
                break;
            }
        return check;
    }
}
