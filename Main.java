public class Main{
    public static Calculate cal;
    public static GUI calculatorGUI;
    public static void main(String[] args){
        cal = new Calculate();
        calculatorGUI = new GUI();
        calculatorGUI.setVisible(true);
    }
}