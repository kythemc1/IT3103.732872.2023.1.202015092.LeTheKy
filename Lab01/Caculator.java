import javax.swing.JOptionPane;

public class Caculator {
    public static void main(String args[]){
        String strNum1,strNum2;
        double sum,difference,product,quotient;
        strNum1 =  JOptionPane.showInputDialog(null,"Please inout the first number :","input the first number ", JOptionPane.INFORMATION_MESSAGE);
        strNum2 =  JOptionPane.showInputDialog(null,"Please inout the second number :","input the second number ", JOptionPane.INFORMATION_MESSAGE);
        double num1 = Double.parseDouble(strNum1);
        double num2 = Double.parseDouble(strNum2);
        sum = num1+num2;
        difference= num1-num2;
        product=num1*num2;
        quotient=num1/num2;
        JOptionPane.showMessageDialog(null, "sum: "+sum+"\n"+"difference: "+ difference+"\n"+"product: "+product+"\n"+"quotient: "+quotient, "Show anwser", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
}