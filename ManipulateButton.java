public class ManipulateButton extends Button{
    public ManipulateButton(String label){
        super(label);
    }

    protected void handleClick() {
        int tag = getTag();
        
        if(tag == 19){ // clear
            Main.cal.clear(1);
            Main.calculatorGUI.renew_display(1);
            Main.calculatorGUI.hide_num();
            Main.cal.setNumberFlag(0);
        }
        else if(tag == 20) { // =
            Main.cal.binary_operator_calculate();
            Main.calculatorGUI.renew_display(1);         
            Main.cal.setEnterFlag(1);
            System.out.print(Main.cal.getOperatorFlag());
            Main.calculatorGUI.hide_num();
            Main.cal.setNumberFlag(0);
        }
    }
}
