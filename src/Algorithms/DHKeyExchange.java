package Algorithms;

import java.math.BigInteger;
import java.util.Random;
import java.util.Vector;

public class DHKeyExchange {
        private long n;
        long pr, p, phi;
        public DHKeyExchange(){}
        public DHKeyExchange(long p){
            this.p = p;
            this.phi = this.p - 1;
            Vector<Long> primitiveRoots =  this.getPrimitiveRoot(this.p, this.phi);
            this.pr = primitiveRoots.get(new Random().nextInt(primitiveRoots.size()));
        }
        public long getPr() {
            return pr;
        }
        private Vector<Long> getPrimitiveRoot(long p, long phi){
            Vector<Long> primeFactors = this.genPrimesFactorsList(phi);
            Vector<Long> primitiveRoots = new Vector<>();
            for(long i = 2;i<p;i++){
                boolean flg = false;
                for(Long l: primeFactors){
                    BigInteger iBig = BigInteger.valueOf(i);
                    BigInteger phiBig = BigInteger.valueOf(phi/l);
                    BigInteger pBig = BigInteger.valueOf(p);
                    BigInteger pRootBig = iBig.modPow(phiBig, pBig);
                    if(pRootBig.compareTo(BigInteger.valueOf(1))==0){
                        flg = true;
                        break;
                    }
                }
                if(!flg)primitiveRoots.add(i);
            }
            return primitiveRoots;
        }
        private Vector<Long> genPrimesFactorsList(long phi){
            Vector<Long> primesFactors = new Vector<>();
            while(phi % 2 == 0){
                primesFactors.add((long) 2);
                phi /= 2;
            }
            for(long i=3;i<=Math.sqrt(phi);i+=2){
                if(phi % i == 0){
                    primesFactors.add(i);
                    phi /= i;
                }
            }
            if(phi > 2)
            {
                primesFactors.add(phi);
            }
            return primesFactors;
        }

    public long getPrimeNumber(){
        this.n = (int)(new Random().nextDouble()*100)+250;
        long l = 0;
        l = (long) ((this.n)*(Math.log(this.n) + (Math.log(Math.log(this.n)) -1) + ((Math.log(Math.log(this.n))-2)/(Math.log(this.n))) - ((Math.log(Math.log(this.n)) -21.0/10.0)/Math.log(this.n)) ));
        for(long i=l;;i++){
            if(isPrime(i)){
                return i;
            }
        }
    }
    private boolean isPrime(long n){
        if(n%2 == 0 || n%3 == 0) return false;
        for(int i=5; i*i<=n; i+=6){
            if(n%i == 0 || n%(i+2)==0) return false;
        }
        return true;
    }

}


