public class OperatorButton extends Button{
    public OperatorButton(String label){
        super(label);
    }

    protected void handleClick() {
        int tag = getTag();

        if(tag >= 10 && tag <= 13) { // + - * /
            Main.cal.binary_operator_calculate();
            Main.calculatorGUI.renew_display(1);
            Main.cal.clear(2);
            Main.calculatorGUI.renew_display(2);
            Main.cal.setNumberFlag(0);
            Main.cal.setOperatorFlag(tag - 9);
            Main.calculatorGUI.renew_operator();
            Main.cal.setEnterFlag(2); // enter operand2
        }
        else if(tag == 14){ // sin
            Main.cal.setNumberFlag(0);
            Main.cal.sin();
            Main.calculatorGUI.renew_display(1);
        }
        else if(tag == 15){ // cos
            Main.cal.setNumberFlag(0);
            Main.cal.cos();
            Main.calculatorGUI.renew_display(1);
        }
        else if(tag == 16){ // log
            Main.cal.setNumberFlag(0);
            Main.cal.log();
            Main.calculatorGUI.renew_display(1);
        }
        else if(tag == 17){ // 1/x
            Main.cal.setNumberFlag(0);
            Main.cal.opposite();
            Main.calculatorGUI.renew_display(1);
        }
        else if(tag == 18){ // sqrt
            Main.cal.setNumberFlag(0);
            Main.cal.sqrt();
            Main.calculatorGUI.renew_display(1);
        }
        else if(tag == 21){ // n!
            Main.cal.setNumberFlag(0);
            Main.cal.getFactoral();
            Main.calculatorGUI.renew_display(1);
        }
    }
}
