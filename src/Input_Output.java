import java.util.*;
public class Input_Output {

    //I/O Functions

    double [][] user_input()
    {
        double chk [][]=new double[1][3];
        Scanner sc=new Scanner(System.in);
      
        for(int i=0;i<1;i++){
            for(int j=0;j<3;j++)
            {               
                chk[i][j]=sc.nextInt();
            }
        }
        sc.close();
        return chk;
    }

    void printing(double [][]a)
    {
        int r=a.length;
        int c=a[0].length;

        System.out.print("Dimensions = ");
        System.out.print(+r);
        System.out.println(" X "+c);
        System.out.println("Matrix: ");

        for(int i=0;i<a.length;i++)
        {
            for(int j=0;j<a[0].length;j++)
            {
               System.out.print("  "+a[i][j]);
            }
            System.out.println();
        }
    }

    void rnd_result_printing(double [][]a)
    {
        System.out.println();
        System.out.print("The Output is: ");
        for(int i=0;i<1;i++)
        {
         for(int j=0;j<1;j++)
          {
             long x;
             x=Math.round(a[i][j]);
             System.out.print(x);
          }
        }
    }    
    
}
