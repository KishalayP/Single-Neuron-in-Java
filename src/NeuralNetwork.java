public class NeuralNetwork
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
                                  {1},
                                  {0},
                                  {1}  };

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

        Input_Output io=new Input_Output();
        synaptic_weights=Matrix_Math.random(3,1);
        System.out.println("Synaptic Weights before training:");
        io.printing(synaptic_weights);
        System.out.println("Enter 3 Inputs");


    for (int itr=0;itr<1000000;itr++)
    {

        training_inputs=Matrix_Math.copy(input_layer);

        toto=Matrix_Math.sigmoid(Matrix_Math.dot(input_layer,synaptic_weights));   
        
        training_outputs=Matrix_Math.copy(toto);
        
        error=Matrix_Math.sub(training_outputs,output_layer);

        toad=Matrix_Math.sigmoid_derivative(toto);
        
        adjustments=Matrix_Math.multiply(error,toad);

        input_layer_transposed=Matrix_Math.transpose(training_inputs);

        tosy=Matrix_Math.dot(input_layer_transposed,adjustments);
        
        synaptic_weights=Matrix_Math.add(synaptic_weights,tosy);

    }

    //User Input and Result Printing Block
    chk=io.user_input();
    result=Matrix_Math.sigmoid(Matrix_Math.dot(chk,synaptic_weights));
    System.out.println("Synaptic Weights after training:");
    io.printing(synaptic_weights);
    io.rnd_result_printing(result);

}
}

