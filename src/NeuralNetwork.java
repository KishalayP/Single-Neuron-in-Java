import java.util.*;

public class NeuralNetwork
{
    
    public static void main(String[] args) 
    {
        double output_layer[][]={ {0},
                          {1},
                          {1},
                          {0} };

        double input_layer[][]={{0,0,1},
                          {1,1,1},
                          {1,0,1},
                           {0,1,1}};

        double synaptic_weights[][]={{-0.16595599},{0.44064899},{-0.99977125}};                                  
     
        
        double error[][]=new double[4][1];
        double adjustments[][]=new double[4][1];
        double training_inputs[][]=new double[4][3];
        double training_outputs[][]=new double[4][1];
        double toto[][]=new double[4][1];
        double toad[][]=new double[4][1];
        double tosy[][]=new double[4][1];
        double input_layer_transposed[][]=new double[3][4];
        double chk [][]=new double[1][3];
        double result[][]=new double[1][1];

        
        System.out.println("Synaptic Weights before training:");
        printing(synaptic_weights);
        System.out.println("Enter 3 Inputs");

    for (int itr=0;itr<1000000;itr++)
    {
        for(int i=0;i<4;i++)
        {
            for(int j=0;j<3;j++)
            {
              training_inputs[i][j]=input_layer[i][j];
            }
        }

        toto=sigmoid(dot(input_layer,synaptic_weights));
                

        for(int i=0;i<output_layer.length;i++)
        {
            for(int j=0;j<output_layer[0].length;j++)
            {
        
              training_outputs[i][j]=toto[i][j];
            }
        }
        

        for(int i=0;i<output_layer.length;i++)
        {
            for(int j=0;j<output_layer[0].length;j++)
            {
              error[i][j]=training_outputs[i][j]-output_layer[i][j];
              
            }

        }

        toad=sigmoid_derivative(toto);

        for(int i=0;i<output_layer.length;i++)
        {
            for(int j=0;j<output_layer[0].length;j++)
            {              
              adjustments[i][j]=error[i][j]*toad[i][j];

            }

        }

        input_layer_transposed=transpose(training_inputs);
        tosy=dot(input_layer_transposed,adjustments);

        for(int i=0;i<tosy.length;i++)
            {
            for(int j=0;j<tosy[0].length;j++)
            { 
              synaptic_weights[i][j] = synaptic_weights[i][j]+tosy[i][j];
            }
        }
    }

    //Input Block
    Scanner sc=new Scanner(System.in);
      
    for(int i=0;i<1;i++)
            {
            for(int j=0;j<3;j++)
            {
                
                chk[i][j]=sc.nextInt();
                
            }
        }
    
    
    result=sigmoid(dot(chk,synaptic_weights));
    sc.close();
    System.out.println("Synaptic Weights after training:");
    printing(synaptic_weights);
    

    //Result Output Block
    System.out.print("The Result is:");
    for(int i=0;i<1;i++)
    {
        for(int j=0;j<1;j++)
        {
            long x;
            x=Math.round(result[i][j]);
            System.out.print(x);
        }
    }

}

    static void printing(double [][]a)
    {
        int r=a.length;
        int c=a[0].length;

        System.out.println("Dimensions=");
        System.out.println("Rows: "+r);
        System.out.println("Columns: "+c);
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


    static double[][] sigmoid(double [][] x)
     {
         double eu [][]=new double[4][1];
         double e [][]=new double[4][1];

        for(int i=0;i<x.length;i++){
            for(int j=0;j<x[i].length;j++){ 
                eu[i][j]=Math.exp(-x[i][j]);
                e[i][j]=1/(1+eu[i][j]);
            }
        }
        return e;
    }
    static double [][] sigmoid_derivative(double [][]arr)
    {
        //Matrix Input each element function to be applied
        double d [][]=new double[4][1];
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
              for(int k=0;k<a[i].length;k++){
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

}