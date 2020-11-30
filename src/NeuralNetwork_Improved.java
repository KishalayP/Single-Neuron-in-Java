import java.util.*;

public class NeuralNetwork_Improved
{
    
    public static void main(String[] args) 
    {
        double input_layer[][]={ {0,0,1},
                                 {1,1,1},
                                 {1,0,1},
                                 {0,1,1},
                                 {1,0,0} };

        double output_layer[][]={ {0},
                                  {1},
                                  {0},
                                  {1},
                                  {0}  };

        int ri=input_layer.length;
        int ci=input_layer[0].length;
        int ro=output_layer.length;
        int co=output_layer[0].length;

        double synaptic_weights[][]=new double[ci][co];       
        double error[][]=new double[ro][co];
        double adjustments[][]=new double[ro][co];
        double training_inputs[][]=new double[ri][ci];
        double training_outputs[][]=new double[ro][co];
        double toto[][]=new double[ro][co];
        double toad[][]=new double[ro][co];
        double tosy[][]=new double[ro][co];
        double input_layer_transposed[][]=new double[ro][co];
        double chk [][]=new double[co][ci];
        double result[][]=new double[1][1];


        synaptic_weights=random(3,1);
        System.out.println("Synaptic Weights before training:");
        printing(synaptic_weights);
        System.out.println("Enter 3 Inputs");


    for (int itr=0;itr<1000000;itr++)
    {

        training_inputs=copy(input_layer);

        toto=sigmoid(dot(input_layer,synaptic_weights));   
        
        training_outputs=copy(toto);
        
        error=sub(training_outputs,output_layer);

        toad=sigmoid_derivative(toto);
        
        adjustments=multiply(error,toad);

        input_layer_transposed=transpose(training_inputs);

        tosy=dot(input_layer_transposed,adjustments);
        
        synaptic_weights=add(synaptic_weights,tosy);

    }

    //User Input and Result Printing Block
    chk=user_input();
    result=sigmoid(dot(chk,synaptic_weights));
    System.out.println("Synaptic Weights after training:");
    printing(synaptic_weights);
    rnd_result_printing(result);

}

//Methods Coming Up

//I/O Functions
    static double [][] user_input()
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

    static void printing(double [][]a)
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

    static void rnd_result_printing(double [][]a)
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

//Mathematical Operations Functions

    static double[][] sigmoid(double [][] x)
     {
         double eu [][]=new double[x.length][x[0].length];
         double e [][]=new double[x.length][x[0].length];

        for(int i=0;i<x.length;i++){
            for(int j=0;j<x[0].length;j++){ 
                eu[i][j]=Math.exp(-x[i][j]);
                e[i][j]=1/(1+eu[i][j]);
            }
        }
        return e;
    }

    static double [][] sigmoid_derivative(double [][]arr)
    {
        double d [][]=new double[arr.length][arr[0].length];
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++)
            { 
                d[i][j]=(arr[i][j])*(arr[i][j]-1); 
            }
        }
        
        return d;

    }

    static double[][] dot(double [][]a,double [][]b)
    {           
    
    double c[][]=new double[a.length][b[0].length];
      for(int i=0;i<a.length;i++){
          for(int j=0;j<b[0].length;j++){
              for(int k=0;k<a[i].length;k++)
              {
                c[i][j]=c[i][j]+(a[i][k]*b[k][j]);    
              }
    
          }
        }
    return c;
    }

    static double[][] transpose(double[][]a)
    {
        double t[][]=new double[3][4];
        for(int i=0;i<3;i++)
        {
            for(int j=i+1;j<4;j++)
            {
                t[i][j]=a[j][i];
            }
        }
    return t;
    }

    static double[][] add(double[][]a ,double[][] b)
    {
    double c[][]=new double[a.length][b[0].length];
      for(int i=0;i<a.length;i++){
          for(int j=0;j<a[0].length;j++)
          {            
                c[i][j]=a[i][j]+b[i][j];    
          }
      }
    return c;
    }

    static double[][] sub(double[][]a ,double[][] b)
    {
    double s[][]=new double[a.length][b[0].length];
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[0].length;j++)
            {
               s[i][j]=a[i][j]-b[i][j];    
            }
        }
    return s;
    }

    static double[][] copy(double[][] a)
    {
        double c[][]=new double[a.length][a[0].length];
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[0].length;j++)
            {                    
              c[i][j]=a[i][j];    
            }
        }
    return c;
    }

    static double[][] multiply(double[][] a,double [][]b)
    {
        double c[][]=new double[a.length][a[0].length];
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[0].length;j++)
            {
                c[i][j]=a[i][j]*b[i][j];    
            }
        }
    return c;
    }  

    static double[][] random(int r,int c)
    {   
        double o[][]=new double[r][c];
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++)
            {
                o[i][j] = (2*Math.random())-1;
            }
        }
    return o;
    }
    
}