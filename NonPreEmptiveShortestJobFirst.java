/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package platechproject;

import java.util.Scanner;

/**
 *
 * @author Nitro5
 */
public class NonPreEmptiveShortestJobFirst 
{
    
    public static void main(String[] args) 
    {
        
        int temp, limit, total = 0;
        float avg = 0;
        Scanner kb = new Scanner(System.in);
        System.out.println("Enter Number of Processes:");
        limit = kb.nextInt();
        int process[] = new int[limit];
        int processtime[] = new int[limit];
        int waitingtime[] = new int[limit];

        for(int i = 0; i < limit; i++)
        {
            System.out.println("Enter Process "+(i+1)+" ID: ");
            process[i] = kb.nextInt();
            System.out.println("Enter Process "+(i+1)+" Burst Time: ");
            processtime[i] = kb.nextInt();
        }
 
        for(int i = 0; i < limit - 1; i++)
        {
            for(int j = i + 1; j < limit; j++)           
            {
                if(processtime[i]>processtime[j])
                {
                    temp = processtime[i];
                    processtime[i] = processtime[j];
                    processtime[j] = temp;
                    temp = process[i];
                    process[i] = process[j];
                    process[j] = temp;
                }
            }
        }
 
        waitingtime[0] = 0;
        for(int i = 1; i < limit; i++)
        {
            waitingtime[i] = waitingtime[i-1]+processtime[i-1];
            total = total + waitingtime[i];
        }
        avg = (float)total/limit;
        System.out.println("Process\t\t Burst Time\t Waiting Time");
        for(int i = 0; i < limit; i++)
        {
            System.out.println(process[i]+"\t\t "+processtime[i]+"\t\t "+waitingtime[i]);
        }
        System.out.println("Total Waiting Time: "+total);
        System.out.println("Average Waiting Time: "+avg);
    }
}
