import java.io.*;
class Apriori
{ 
public static void main(String []arg)throws IOException
{
int i,j,m=0;
int t1=0;
ArrayList<ArrayList<String>> ds = fpg.readFile("Apriori/src/fpset.txt", ",");
#BufferedReader b=new BufferedReader(new InputStreamReader(System.in));
#System.out.println("Enter the number of transaction :");
#int n=Integer.parseInt(b.readLine());
#System.out.println("items :1--I1 2--I2 3--I3 4--I4 5--I5 6--I6");
int item[][]=new int[5][6];
for(i=0;i<n;i++)
 for(j=0;j<6;j++)
   item[i][j]=0;
String[] itemlist={"I1","I2","I3","I4","I5","I6"};
int nt[]=new int[6];
int q[]=new int[6];
for(i=0;i<n;i++)
{ System.out.println("Transaction "+(i+1)+" :");
  for(j=0;j<6;j++)
  {  //System.out.println(itemlist[j]);
     System.out.println("Is Item "+itemlist[j]+" present in this transaction(1/0)? :");
     item[i][j]=Integer.parseInt(b.readLine()); 
  }
}
 for(j=0;j<6;j++) 
  { for(i=0;i<n;i++)
    {if(item[i][j]==1)
      nt[j]=nt[j]+1;
    }
    System.out.println("Number of Item "+itemlist[j]+" :"+nt[j]);
  }

for(j=0;j<6;j++)
{ if(((nt[j]/(float)n)*100)>=50)
    q[j]=1;
  else
    q[j]=0;

  if(q[j]==1)
   {t1++;
    System.out.println("Item "+itemlist[j]+" is selected "); 
   
   }
}
 for(j=0;j<6;j++) 
  { for(i=0;i<n;i++)
   {
     
     if(q[j]==0)
       { 
        item[i][j]=0;
       }
   }
   }

int nt1[][]=new int[6][6];
 for(j=0;j<6;j++) 
    {  for(m=j+1;m<6;m++) 
       { for(i=0;i<n;i++)
         { if(item[i][j]==1 &&item[i][m]==1)
           { nt1[j][m]=nt1[j][m]+1;
           }
         }
    if(nt1[j][m]!=0)
         System.out.println("Number of Items of  "+itemlist[j]+"& "+itemlist[m]+" :"+nt1[j][m]);
    }
  
   }
for(j=0;j<6;j++)
{ for(m=j+1;m<6;m++) 
  {
  if(((nt1[j][m]/(float)n)*100)>=50)
    q[j]=1;
  else
    q[j]=0;

  if(q[j]==1)
   {
    System.out.println("Item "+itemlist[j]+"& "+itemlist[m]+" is selected "); 
   
   }
}
}
int nt2[][]=new int[6][6];
for(j=0;j<6;j++) 
   {  for(m=j+1;m<6;m++) 
      {
	for(int k=j+2;k<6;k++)
	{
	   for(i=0;i<n;i++)
        { if(item[i][j]==1 &&item[i][m]==1&&item[i][k]==1)
          { nt2[j][m]=nt2[j][m]+1;
          nt2[m][k]=nt2[m][k]+1;
          nt2[j][k]=nt2[j][k]+1;
          }
        }
   if(nt2[j][m]!=0 && nt2[m][k]!=0 && nt2[j][k]!=0)
        System.out.println("Number of Items of  "+itemlist[j]+"& "+itemlist[m]+"& "+itemlist[k]+" :"+nt2[j][m]);
   }
   }
  }
for(j=0;j<6;j++)
{ for(m=j+1;m<6;m++) 
  {
	for(int k=j+2;k<6;k++)
	{
  if(((nt2[j][m]/(float)n)*100)>=50 && ((nt2[m][k]/(float)n)*100)>=50 && ((nt2[j][k]/(float)n)*100)>=50)
    q[j]=1;
  else
    q[j]=0;

  if(q[j]==1)
   {
    System.out.println("Item "+itemlist[j]+"& "+itemlist[m]+"& "+itemlist[k]+" is selected "); 
   
   }
}
}
}

} 
}
