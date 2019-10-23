package NewOffer;

public class NewOffer12 {
    public double Power(double base, int exponent) {
        if(exponent < 0){
            exponent = -exponent;
            base  = 1/base;
        }
        return fastPower(base,exponent);
    }

    public double fastPower(double pBase, int exponent){
        if(exponent == 0){
            return 1;
        }
        if(exponent == 1){
            return pBase;
        }
        double half = fastPower(pBase,exponent/2);
        if(exponent % 2 == 0){
            return half * half;
        }else{
            return  half * half * pBase;
        }
    }
}
