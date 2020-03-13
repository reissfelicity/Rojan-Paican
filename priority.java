import java.util.Scanner;
 
public class priority
{        
     public static void main(String args[]) 
    {
                    Scanner s = new Scanner(System.in);
         
                    int x,n,process[],processPriority[],burstTime[],waitTime[],turnTime[],averageWaitingTime,averageTurnTime,i;
         
                    process = new int[10];
                    processPriority = new int[10];
                    burstTime = new int[10];
                    waitTime = new int[10];
                    turnTime = new int[10];
                 
                   //n is number of process
                   //p is process
                   //processPriority is process priority
                   //burstTime is process burst time
                   //w is wait time
                   // t is turnaround time
                   //averageWaitingTime is average waiting time
                   //averageTurnTime is average turnaround time
     
             
               System.out.print("Enter the number of process : ");
               n = s.nextInt();
               System.out.print("\n\t Enter burst time : time priorities \n");
     
                  for(i=0;i<n;i++)
                  {
                  System.out.print("\nProcess["+(i+1)+"]:");
                  burstTime[i] = s.nextInt();
                  processPriority[i] = s.nextInt();
                  process[i]=i+1;
                 }
 
                //sorting on the basis of priority
                  for(i=0;i<n-1;i++)
                   {
                     for(int j=i+1;j<n;j++)
                     {
                       if(processPriority[i]>processPriority[j])
                       {
                     x=processPriority[i];
                     processPriority[i]=processPriority[j];
                     processPriority[j]=x;
                     x=burstTime[i];
                     burstTime[i]=burstTime[j];
                     burstTime[j]=x;
                     x=process[i];
                     process[i]=process[j];
                     process[j]=x;
                      }
                   }
                  }
            
                waitTime[0]=0;
                averageWaitingTime=0;
                turnTime[0]=burstTime[0];
                averageTurnTime=turnTime[0];
                    
                for(i=1;i<n;i++)
                 {
                   waitTime[i]=turnTime[i-1];
                   averageWaitingTime+=waitTime[i];
                   turnTime[i]=waitTime[i]+burstTime[i];
                   averageTurnTime+=turnTime[i];
                }
         
            //Displaying the process
             
              System.out.print("\n\nProcess \t Burst Time \t Wait Time \t Turn Around Time   Priority \n");
              for(i=0;i<n;i++)
              System.out.print("\n   "+process[i]+"\t\t   "+burstTime[i]+"\t\t     "+waitTime[i]+"\t\t     "+turnTime[i]+"\t\t     "+processPriority[i]+"\n");
              averageWaitingTime/=n;
              averageTurnTime/=n;
              System.out.print("\n Average Wait Time : "+averageWaitingTime);
              System.out.print("\n Average Turn Around Time : "+averageTurnTime);
             
     }
    }