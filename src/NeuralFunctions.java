 import java.util.*;
 class NeuralFunctions {

    static double [][] prodOfInputLayerSynapticWeights(double[][]input_layer,double[][]synaptic_weights){
       
         double c[][]=new double[4][1];
        
             for(int i=0;i<input_layer.length;i++){    //4x3 3*1
             
                 for(int j=0;j<synaptic_weights[0].length;j++){
                   
             for(int k=0;k<input_layer[i].length;k++){
         
          
           c[i][j]=c[i][j]+(input_layer[i][k]*synaptic_weights[k][j]); 
         }  
               }
                  }
                
         
         for(int i=0;i<c.length;i++) {
                for(int j=0;j<c[i].length;j++) {
                    System.out.print(c[i][j]+" "); }
                System.out.println(" ");}
return c;
    }
    static double[][]synapticWeights(){
        Random r= new Random();
        double[][] synaptic_weights= new double [3][1];
        for(int i=0;i<synaptic_weights.length;i++){
            for(int j=0;j<synaptic_weights[i].length;j++) {
                synaptic_weights[i][j]=Math.random()*100;                                  
            }
        }
return  synaptic_weights;
    }
}
