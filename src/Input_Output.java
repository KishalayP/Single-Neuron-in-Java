import java.util.*;
public class Input_Output {

    //I/O Functions

    double [][] training_from_user()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter no. of rows");
        int r=sc.nextInt();
        System.out.println("Enter no. of columns");
        int c=sc.nextInt();
        double training_matrix_user[][]=new double[r][c];
        for(int i=0;i<r;i++){
            System.out.println("Enter Elements for "+(i+1)+" Row");
            for(int j=0;j<c;j++)
            {   
                training_matrix_user[i][j]=sc.nextInt();
            }
        }
        return training_matrix_user;
    }
    double [][] user_input(int r,int c)
    {
        double chk [][]=new double[r][c];
        Scanner sc=new Scanner(System.in);
      
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++)
            {               
                chk[i][j]=sc.nextInt();
            }
        }
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
