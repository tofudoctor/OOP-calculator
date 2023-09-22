import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class GUI extends JFrame{
    private JTextField operand2Field;
    private JTextField operand1Field;
    private JTextField operatorField;
    private JPanel panel;
    private Button[] btn; 
    private String[] label = new String[]{"sin", "cos", "log", "Clear", "sqrt", "n!", "1/x", "+", "7", "8", "9", "-", "4", "5", "6", "x", "1", "2", "3", "/", "0", "", ".", "="};

    public GUI(){
        setTitle("Calculator");
        setResizable(false);
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.BLACK);
        setContentPane(panel);

        // show
        operand1Field = new JTextField();
        operand1Field.setBounds(20, 20, 445, 50);
        operand1Field.setBorder(new EmptyBorder(0, 0, 0, 0));
        operand1Field.setEditable(false);
        operand1Field.setFont(new Font("Arial", Font.PLAIN, 40));
        operand1Field.setText("0");
        operand1Field.setHorizontalAlignment(SwingConstants.RIGHT);
        panel.add(operand1Field);

        operand2Field = new JTextField();
        operand2Field.setBounds(20, 70, 445, 50);
        operand2Field.setBorder(new EmptyBorder(0, 0, 0, 0));
        operand2Field.setEditable(false);
        operand2Field.setFont(new Font("Arial", Font.PLAIN, 40));
        operand2Field.setHorizontalAlignment(SwingConstants.RIGHT);
        panel.add(operand2Field);

        operatorField = new JTextField();
        operatorField.setBounds(20, 70, 50, 50);
        operatorField.setBorder(new EmptyBorder(0, 0, 0, 0));
        operatorField.setEditable(false);
        operatorField.setFont(new Font("Arial", Font.PLAIN, 40));
        panel.add(operatorField);

        // button
        btn = new Button[24];
        for(int i = 0; i < 24;i++){
            if(i == 21) continue;

            if(i == 3 || i == 23) btn[i] = new ManipulateButton(label[i]);
            else if((i >= 8 && i <= 10) || (i >= 12 && i <= 14) || (i >= 16 && i <= 18) || i == 20 || i == 22) btn[i] = new NumberButton(label[i]);
            else btn[i] = new OperatorButton(label[i]);
            
            btn[i].setBounds(20 + (i % 4) * 115, 130 + (i / 4) * 70, 100, 60);
            panel.add(btn[i]);
        }
    }

    public void renew_display(int f){ // f = 1 :show operand1   f = 2 :show operand2
        NumberFormat formatter_normal = new DecimalFormat("0.###############E0");
        NumberFormat formatter_extreme = new DecimalFormat("0.###############");
        String formattedNumber;
        if(f == 1) {
            if(Math.abs(Main.cal.getOperand1()) > 1e15)
                formattedNumber = formatter_normal.format(Main.cal.getOperand1());
            else
                formattedNumber = formatter_extreme.format(Main.cal.getOperand1());
            operand1Field.setText(formattedNumber);
        }
        else {
            if(Math.abs(Main.cal.getOperand2()) > 1e15)
                formattedNumber = formatter_normal.format(Main.cal.getOperand2());
            else
                formattedNumber = formatter_extreme.format(Main.cal.getOperand2());
            operand2Field.setText(formattedNumber);
        }
    }

    public void hide_num(){
        operand2Field.setText("");
    }

    public void renew_operator(){
        int f = Main.cal.getOperatorFlag();
        if(f == 0) operatorField.setText("");
        else if(f == 1) operatorField.setText("+");
        else if(f == 2) operatorField.setText("-");
        else if(f == 3) operatorField.setText("X");
        else if(f == 4) operatorField.setText("/");
    }

}
