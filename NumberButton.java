import javax.swing.JOptionPane;

public class NumberButton extends Button{
    public NumberButton(String label){
        super(label);
    }

    protected void handleClick() {
        int tag = getTag();

        if(tag == 0) Main.cal.add_num(0);
        else if(tag == 1) Main.cal.add_num(1);
        else if(tag == 2) Main.cal.add_num(2);
        else if(tag == 3) Main.cal.add_num(3);
        else if(tag == 4) Main.cal.add_num(4);
        else if(tag == 5) Main.cal.add_num(5);
        else if(tag == 6) Main.cal.add_num(6);
        else if(tag == 7) Main.cal.add_num(7);
        else if(tag == 8) Main.cal.add_num(8);
        else if(tag == 9) Main.cal.add_num(9);
        else if(tag == 22){
            if(Main.cal.getNumberFlag() != 0){
                JOptionPane.showMessageDialog(null, "Math Error!", "ERROR!", JOptionPane.ERROR_MESSAGE);
                Main.cal.clear(1);
            } 
            else 
                Main.cal.setNumberFlag(1);
        }
        Main.calculatorGUI.renew_display(Main.cal.getEnterFlag());
        Main.calculatorGUI.renew_operator();
    }
}
