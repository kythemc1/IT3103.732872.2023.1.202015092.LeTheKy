import javax.swing.JOptionPane;

public class ShowTwoNumber {
    public static void main(String args[]){
        String strNum1,strNum2;
        String strnotification ="You've just entered: ";
        strNum1 =  JOptionPane.showInputDialog(null,"Please inout the first number :","input the first number ", JOptionPane.INFORMATION_MESSAGE);
        strnotification +=strNum1+"and";
        strNum2 =  JOptionPane.showInputDialog(null,"Please inout the second number :","input the second number ", JOptionPane.INFORMATION_MESSAGE);
        strnotification +=strNum2;
        JOptionPane.showMessageDialog(null,strnotification,"Show two numbers", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
}