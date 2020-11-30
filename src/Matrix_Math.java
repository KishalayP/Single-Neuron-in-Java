public class Matrix_Math {

    //Maths and Matrix Manipulation Functions

    
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
