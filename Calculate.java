import java.lang.Math;
import javax.swing.JOptionPane;

public class Calculate {
    private double operand1;
    private double operand2;
    private int enterFlag; // we are going to enter 1 = operand1  2 = operand2   
    private int operatorFlag; // 0 = nothing  1 = '+'  2 = '-'  3 = '*'  4 = '/' 
    private double[] factorial_memo = new double[170];
    private double eps = 1e-20;
    private int numberFlag; // "." is ckicked or not & (10^-numberFlag)

    public Calculate(){
        clear(1);
        factorial_memo[0] = 0.0;
        factorial_memo[1] = 1.0;
        numberFlag = 0;
    }

    public double getOperand1(){
        return operand1;
    }

    public double getOperand2(){
        return operand2;
    }

    public void setEnterFlag(int f){
        enterFlag = f;
    }

    public int getEnterFlag(){
        return enterFlag;
    }

    public void setOperatorFlag(int f){
        operatorFlag = f;
    }

    public int getOperatorFlag(){
        return operatorFlag;
    }

    public void setNumberFlag(int f){
        numberFlag = f;
    }

    public int getNumberFlag(){
        return numberFlag;
    }

    public void add_num(int added_num){
        double tmp = added_num;
        if(enterFlag == 1){
            if(numberFlag == 0){
                operand1 *= 10.0;
                operand1 += tmp;
            }
            else{
                for(int i = 0; i < numberFlag; i++) tmp /= 10;
                operand1 += tmp;
                numberFlag++;
            }
        }
        else{
            if(numberFlag == 0){
                operand2 *= 10.0;
                operand2 += tmp;
            }
            else{
                for(int i = 0; i < numberFlag; i++) tmp /= 10;
                operand2 += tmp;
                numberFlag++;
            }
        }
    }

    public void clear(int f){ // f = 1 :clear all    f = 2 : claer operand2
        if(f == 1){
            operand1 = 0.0;
            operand2 = 0.0;
            setEnterFlag(1);
            setOperatorFlag(0);
            setNumberFlag(0);
        }
        else{
            operand2 = 0.0;
            setEnterFlag(1);
            setNumberFlag(0);
        }
    }

    public void binary_operator_calculate(){
        int tmp = getOperatorFlag();

        if(tmp == 1) operand1 += operand2;
        else if(tmp == 2) operand1 -= operand2;
        else if(tmp == 3) operand1 *= operand2;
        else if(tmp == 4){
            if(Math.abs(operand2) < eps) JOptionPane.showMessageDialog(null, "Math Error!", "ERROR!", JOptionPane.ERROR_MESSAGE);
            else operand1 /= operand2;
        } 
    }

    public void sin(){
        operand1 = Math.sin(Math.toRadians(operand1));
    }

    public void cos(){
        operand1 = Math.cos(Math.toRadians(operand1));
    }

    public void log(){
        if(operand1 <= 0){
            JOptionPane.showMessageDialog(null, "Math Error!", "ERROR!", JOptionPane.ERROR_MESSAGE);
            clear(1);
        }
        else operand1 = Math.log10(operand1);
    }

    public void opposite(){  // 1/x
        if(Math.abs(operand1 - 0) < eps){
            JOptionPane.showMessageDialog(null, "Math Error!", "ERROR!", JOptionPane.ERROR_MESSAGE);
            clear(1);
        }
        else operand1 = 1.0 / operand1;
    }

    public void sqrt(){
        if(operand1 < 0){
            JOptionPane.showMessageDialog(null, "Math Error!", "ERROR!", JOptionPane.ERROR_MESSAGE);
            clear(1);
        }
        else operand1 = Math.sqrt(operand1);
    }

    public double factorial(double x){ // n! by DP
        int intX = (int)x;
        if(factorial_memo[intX] > eps || x < eps) return factorial_memo[intX];
        return factorial_memo[intX] = x * factorial(x - 1);
    } 

    public void getFactoral(){
        if((operand1 % (int)operand1) > eps || operand1 < 0){
            JOptionPane.showMessageDialog(null, "Math Error!", "ERROR!", JOptionPane.ERROR_MESSAGE);
            clear(1);
        }
        else operand1 = factorial(operand1);
    }

}
