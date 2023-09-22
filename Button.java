import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class Button extends JButton{
    protected abstract void handleClick();
    private int tag;

    public Button(String label){
        super(label);
        setBackground(Color.GRAY); 
        setForeground(Color.WHITE); 
        setFont(new Font("Arial", Font.PLAIN, 25));
        setTag(label);

        addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                handleClick();
            }
        });
    }

    int getTag(){
        return this.tag;
    }

    void setTag(String label){
        if(label == "0") this.tag = 0;
        else if(label == "1") this.tag = 1;
        else if(label == "2") this.tag = 2;
        else if(label == "3") this.tag = 3;
        else if(label == "4") this.tag = 4;
        else if(label == "5") this.tag = 5;
        else if(label == "6") this.tag = 6;
        else if(label == "7") this.tag = 7;
        else if(label == "8") this.tag = 8;
        else if(label == "9") this.tag = 9;
        else if(label == "+") this.tag = 10;
        else if(label == "-") this.tag = 11;
        else if(label == "x") this.tag = 12;
        else if(label == "/") this.tag = 13;
        else if(label == "sin") this.tag = 14;
        else if(label == "cos") this.tag = 15;
        else if(label == "log") this.tag = 16;
        else if(label == "1/x") this.tag = 17;
        else if(label == "sqrt") this.tag = 18;
        else if(label == "Clear") this.tag = 19;
        else if(label == "=") this.tag = 20;
        else if(label == "n!") this.tag = 21;
        else if(label == ".") this.tag = 22;
    }
}
