import javax.swing.JOptionPane;

public class HelloNameDialog {
    public static void main(String args[]){
        String result ;
        result =  JOptionPane.showInputDialog("Le The Ky - 2020 - Please enter your name !");
        JOptionPane.showMessageDialog(null,"Toi la MCKy , Hi "+result+"!");
        System.exit(0);
    }
}