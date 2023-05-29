package Guldin;
import java.lang.Math;
//Nama : Maulana Yusuf Ikhsan Robbani
//NRP  : 5002211167
//Kelas: PBO (D)
public class Guldin {
    public static void main(String[] args) {
      sumbuX obj1 = new sumbuX(0, 1);
      sumbuY obj2 = new sumbuY(0, 1);
      obj1.display(0,2);        //Volume x^2 diputar thd smb x dr 0-2
      obj2.display(0,2);        //Volume x^2 diputar thd smb y dr 0-2
    }
}
class BendaPutar{
    double a,b,d,L,x,y,v,xbar, ybar;
    int i,n;
    
    BendaPutar(double a, double b){
        a=a;
        b=b;
        
    }

    public double LuasX(double a, double b){   //luas = integral fungsi dari a ke b
        L= 0;
        d= (b-a)/10000;                       //Pencarian Luas menggunakan metode midpoint, dipartisi jadi seribu
        for (i=1 ; i<=10000 ; i++){
            x = a + (i-1)*d;
            L+=d*(x*x);                        //L= deltax x f(x)= x^2
        }
        return L;
    }
    public double LuasY(double a, double b){   //luas = integral fungsi dari a ke b
        L= 0;
        d= (b-a)/10000;                       //Pencarian Luas menggunakan metode midpoint, dipartisi jadi seribu
        for (i=1 ; i<=10000 ; i++){
            y = a + (i-1)*d;
            L+=d*(Math.sqrt(y));              //L= deltax x f(x)= x^2
        }
        return L;
    }
    public double Ybar(double a, double b){
        d=(b-a)/10000;
        double L1=0;
        double L2=0;
        for (i=1 ; i<=10000 ; i++){
            x = a + (i-1)*d;
            L1+=0.5*d*Math.pow((x),4);        //L= deltax x f(x)= x^2
        }
        for (i=1 ; i<=10000 ; i++){
            x = a + (i-1)*d;
            L2+=d*(x*x);                        //L= deltax x f(x)= x^2
        }
        ybar= L1/L2;
        return ybar;
    }
    public double Xbar(double a, double b){
        d=(b-a)/10000;
        double L1=0;
        double L2=0;
        for (i=1 ; i<=10000 ; i++){
            x = a + (i-1)*d;
            L1+=d*x*(x*x);                       //L= deltax x f(x)= x^2
        }
        for (i=1 ; i<=10000 ; i++){
            x = a + (i-1)*d;
            L2+=d*(x*x);                        //L= deltax x f(x)= x^2
        }
        xbar= L1/L2;
        return xbar;
    } 
}
class sumbuX extends BendaPutar{
    sumbuX(double a, double b){
        super(a,b);
    }
    void display(double a, double b){
        System.out.println(VolumeDiputarSmbX(a, b)); 
    }
    public double VolumeDiputarSmbX(double a, double b){
        v = 2*(Math.PI)*Xbar(a,b)*LuasX(a, b); 
        return v;
    }
}
class sumbuY extends BendaPutar{
    sumbuY(double a, double b){
        super(a,b);
    }
    void display(double a, double b){
        System.out.println(VolumeDiputarSmbY(a, b));
    }
    public double VolumeDiputarSmbY(double a, double b){
        v = 2*(Math.PI)*Ybar(a,b)*LuasY(a, b); 
        return v;
    }
}