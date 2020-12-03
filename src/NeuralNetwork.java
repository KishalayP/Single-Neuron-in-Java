import java.util.*;
public class NeuralNetwork
{
    public static void main(String[] args) 
    {    
        double training_inputs[][]={ {0,0,1,1},
                                     {1,1,1,0},
                                     {1,0,1,0},
                                     {0,1,1,1},
                                     {1,0,0,1} };

        double training_outputs[][]={ {0},
                                      {1},
                                      {1},
                                      {0},
                                      {1}};

        Input_Output io=new Input_Output();
        char choice='y';
        System.out.println("Do you want to add your own training input and outputs to do so press 'y' or press 'n' to continue with default values ");
        Scanner input=new Scanner(System.in);
        char s=input.next().charAt(0);
        
        if(s==choice)
        {
        while(s==choice)
        {
            System.out.println("Enter Inputs for training");
            double training_inputs_user[][]=io.training_from_user();
            System.out.println("The Input Matrix for Training as Entered by you is as follows: ");
            io.printing(training_inputs_user);
            System.out.println("To continue using this input matrix for training press 'y' or to go back and change the matrix press 'n'");
            char ci=input.next().charAt(0);
            if (ci!=choice)
            {
                continue;
            }
            else
            {
                training_inputs=training_inputs_user;
                break;
            }
        }
        while(s==choice)
        {   
            System.out.println("Enter Outputs for training");
            System.out.println("The Dimensions for the Output Matrix are:"+training_inputs.length+"X"+1);
            double training_outputs_user[][]=new double [training_inputs.length][1];
            for(int i=0;i<training_inputs.length;i++){
                for(int j=0;j<1;j++)
                { 
                   training_outputs_user[i][j]=input.nextInt();
                }
            }
            System.out.println("The Output Matrix for Training as Entered by you is as follows: ");
            io.printing(training_outputs_user);
            System.out.println("To continue using this output matrix for training press 'y' or to go back and change the matrix press 'n'");
            char co=input.next().charAt(0);
            if(co!=choice)
            {
                continue;
            }
            else
            {
               training_outputs=training_outputs_user;
               break;
            }
        }
    }
        System.out.println("Enter the no of Iterations you want the training to run for (Recommended=50000):");
        int itr_m=input.nextInt();

        int ri=training_inputs.length;
        int ci=training_inputs[0].length;
        int ro=training_outputs.length;
        int co=training_outputs[0].length;

        double synaptic_weights[][]=new double[ci][co];       
        double error[][]=new double[ro][co];
        double adjustments[][]=new double[ro][co];
        double input_layer[][]=new double[ri][ci];
        double outputs[][]=new double[ro][co];
        double chk [][]=new double[co][ci];
        double result[][]=new double[1][1];       
       
        System.out.println("Input Layer for Training:");
        io.printing(training_inputs);
        System.out.println("Output Layer for Training:");
        io.printing(training_outputs);
        synaptic_weights=mm.random(ci,co);        
        System.out.println("Synaptic Weights before training:");
        io.printing(synaptic_weights);
        
    for (int itr=0;itr<itr_m;itr++)
    {

        input_layer=mm.copy(training_inputs);  
        
        outputs=mm.copy(mm.sigmoid(mm.dot(training_inputs,synaptic_weights)));
        
        error=mm.sub(outputs,training_outputs);
        
        adjustments=mm.multiply(error,(mm.sigmoid_derivative(mm.sigmoid(mm.dot(training_inputs,synaptic_weights)))));
        
        synaptic_weights=mm.add(synaptic_weights,(mm.dot(mm.transpose(input_layer),adjustments)));

    }

    //User Input and Result Printing Block
    System.out.println("Synaptic Weights after training:");
    io.printing(synaptic_weights);



    char chr='y';
    while(chr==choice)
    {
    System.out.println("Enter "+ci+" Inputs");
    chk=io.user_input(1,ci);
    result=mm.sigmoid(mm.dot(chk,synaptic_weights));
    io.rnd_result_printing(result);
    System.out.println("");
    System.out.println("To continue checking for more inputs press 'y' or to exit the program press 'n'");
    chr=input.next().charAt(0);
    if (chr=='y'){continue;}
    else{break;}
    }
    input.close();
    }
}

