package kodilla.exception.test;

public final class FirstChallenge{
    public double divide(double a,double b) throws ArithmeticException{
        if(b==0){
            throw new ArithmeticException();
        }
        return a/b;
    }
    public static void main(String[] args){
        FirstChallenge firstChallenge = new FirstChallenge();
        double result = 0.0;
        try{
            result = firstChallenge.divide(3,1);
        }
        catch(ArithmeticException e){
            System.out.println("Wrong"+e);
        }
        finally {
            System.out.println(result);
        }
    }
}
