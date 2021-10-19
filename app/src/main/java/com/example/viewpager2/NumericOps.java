package com.example.viewpager2;

public class NumericOps {
    private int n;

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public NumericOps(int n){
        this.n = n;
    }

    public boolean isPerfect(){
        int c = 0;
        for(int i = 1; i<n; i++){
            if(n%i == 0)
                c += i;
        }
        if(c == n)
            return true;
        else
            return false;
    }

    public boolean isPrime(){
        for(int i = 2; i<n; i++){
            if(n%i == 0)
                return false;
        }
        return true;
    }

    public boolean isOdd(){
        if (n%2 == 0)
            return true;
        else
            return false;
    }

    public String sign(){
        if(n < 0)
            return "Negativo";
        else if (n > 0)
            return "Positivo";
        else
            return "Cero";
    }

    public int square(){
        return n*n;
    }

    public int cube(){
        return n*n*n;
    }
}
