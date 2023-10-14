import javax.swing.JOptionPane;

public class solve {
    public static void main(String args[]){
        String choose;
        choose =  JOptionPane.showInputDialog(null,"Nhap: \n 1: giai p trinh bac 1 \n 2: He phuong trinh 2 an \n 3: Phuong tring bac 2 ", JOptionPane.INFORMATION_MESSAGE);
        switch(choose){
            case "1":
                FirstDegree(); break;
            case "2":
                SystemOfFirstDegree();break;
            case "3":
                SecondDegree();break;
            default:
                System.out.println("nhap sai");
        }

        System.exit(0);
    }
    private static void FirstDegree(){
        String a,b;
        a =  JOptionPane.showInputDialog(null,"a = " , JOptionPane.INFORMATION_MESSAGE);
        b =  JOptionPane.showInputDialog(null,"b = " , JOptionPane.INFORMATION_MESSAGE);
        if(Double.parseDouble(b)/Double.parseDouble(a)==0){
            JOptionPane.showMessageDialog(null, "vo nghiem!", "Show anwser", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            double s = -Double.parseDouble(b)/Double.parseDouble(a);
            JOptionPane.showMessageDialog(null, "x = "+s, "Show anwser", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private static void SystemOfFirstDegree(){
        String a11,a12,b11,b12,c12,c11;
        a11 =  JOptionPane.showInputDialog(null,"a11 = " , JOptionPane.INFORMATION_MESSAGE);
        a12 =  JOptionPane.showInputDialog(null,"a12 = " , JOptionPane.INFORMATION_MESSAGE);
        b11 =  JOptionPane.showInputDialog(null,"b11 = " , JOptionPane.INFORMATION_MESSAGE);
        b12 =  JOptionPane.showInputDialog(null,"b12 = " , JOptionPane.INFORMATION_MESSAGE);
        c11 =  JOptionPane.showInputDialog(null,"c11 = " , JOptionPane.INFORMATION_MESSAGE);
        c12 =  JOptionPane.showInputDialog(null,"c12 = " , JOptionPane.INFORMATION_MESSAGE);
        double a11n =Double.parseDouble(a11);
        double a12n =Double.parseDouble(a12);
        double b11n =Double.parseDouble(b11);
        double b12n =Double.parseDouble(b12);
        double c11n =Double.parseDouble(c11);
        double c12n =Double.parseDouble(c12);
        if((a11n/a12n) == (b11n/b12n) && (b11n/b12n) == (c11n/c12n)){
            JOptionPane.showMessageDialog(null, "Vo so nghiem", "Show anwser", JOptionPane.INFORMATION_MESSAGE);
        }
        else if((a11n/a12n) == (b11n/b12n) && (b11n/b12n) != (c11n/c12n)){
            JOptionPane.showMessageDialog(null, "Vo nghiem", "Show anwser", JOptionPane.INFORMATION_MESSAGE);
        }
        else {
            double x = (c12n -(b12n*c11n)/b11n)/(a12n-(b12n*a11n)/b11n);
            double y = (c11n-a11n*x)/b11n;
            JOptionPane.showMessageDialog(null, "x= "+ x +"\n"+"y= "+y, "Show anwser", JOptionPane.INFORMATION_MESSAGE);
        }

    }
    private static void SecondDegree(){
        String an,bn,cn;

        an =  JOptionPane.showInputDialog(null,"a = " , JOptionPane.INFORMATION_MESSAGE);
        bn =  JOptionPane.showInputDialog(null,"b = " , JOptionPane.INFORMATION_MESSAGE);
        cn =  JOptionPane.showInputDialog(null,"c = " , JOptionPane.INFORMATION_MESSAGE);
        double a = Double.parseDouble(an);
        double b = Double.parseDouble(bn);
        double c = Double.parseDouble(cn);

        double delta = b * b - 4 * a * c;

        if (delta > 0) {
            // Phương trình có hai nghiệm phân biệt
            double root1 = (-b + Math.sqrt(delta)) / (2 * a);
            double root2 = (-b - Math.sqrt(delta)) / (2 * a);
            JOptionPane.showMessageDialog(null, "x1 = "+root1 +"\n"+"x1 = "+root2, "Show anwser", JOptionPane.INFORMATION_MESSAGE);
        } else if (delta == 0) {
            // Phương trình có một nghiệm kép
            double root = -b / (2 * a);
            JOptionPane.showMessageDialog(null, "x = "+root , "Show anwser", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "vo nghiem", "Show anwser", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    }