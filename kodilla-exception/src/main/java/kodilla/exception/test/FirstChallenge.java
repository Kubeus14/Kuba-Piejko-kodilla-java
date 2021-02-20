package kodilla.exception.test;

public class FirstChallenge{
   public double divide(double a,double b)throws ArithmeticException{
       if(b==0){
           throw new ArithmeticException();
       }
       return a/b;
   }
   public static void main(String[] args){
       FirstChallenge firstChallenge = new FirstChallenge();
       double result = 0;
       try{
           System.out.println(firstChallenge.divide(3,2));
       }
       catch (ArithmeticException e){
           System.out.println("Exception occured"+e);
       }
       finally {
           System.out.println(result);
       }

   }
}
