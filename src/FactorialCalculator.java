import java.math.BigInteger;

public class FactorialCalculator extends Thread {

    private static int result;
    private static BigInteger resultBig;
    private String[] cmdArgs;
    private int argNumber;

    public FactorialCalculator(String[] myArgs, int i) {
        this.cmdArgs = myArgs;
        this.argNumber = i;
    }


    public static void main(String[] args) {
        for(int i=0; i < args.length; i++){
            FactorialCalculator myThread = new FactorialCalculator(args,i);
            try{
                myThread.start();
                myThread.join();
            }catch (Exception e){
                System.out.println(e);
            }
            if (Integer.parseInt( args[i]) < 13){
                System.out.println(args[i] + " , " + result);
            } else{
                System.out.println(args[i] + " , " + resultBig);
            }

        }

    }

    public void run() {
        int myArg = Integer.parseInt(cmdArgs[argNumber]);
        if(myArg < 13){
            result = calcFact(myArg);
        } else {
            resultBig = calBigFact(myArg);
        }

    }

    private static int calcFact(int x){
        int y = 1;
        for(int i=1; i<x+1; i++){
            y *=i;
        }
        return y;
    }

    private static BigInteger calBigFact(int x){
        BigInteger y = new BigInteger("1");
        BigInteger z = new BigInteger("0");
        for( int i=1; i<x+1; i++){
            z = z.add(new BigInteger("1"));
            y = y.multiply(z);
        }
        return y;
    }


}
