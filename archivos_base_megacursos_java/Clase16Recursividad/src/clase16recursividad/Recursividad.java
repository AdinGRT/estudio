/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clase16recursividad;

/**
 *
 * @author Kisko
 */
public class Recursividad {
    
    public double Factorial(int n){
        //caso base
        if(n==0){
            return 1;
        }  
        //caso recursivo
        else{
            return n*Factorial(n-1);
        }
        
    }
    
    public int SumaLenta(int a,int b){
        if(a==0){
            return b;
        }else{
            return SumaLenta(a-1,b+1);
        }
    }
    
    public int Fibonacci(int n){
        
        if(n==0){
            return 0;
        }else if(n==1){
            return 1;
        }else{
            return Fibonacci(n-2)+Fibonacci(n-1);
        }
    }
    
    public int Factorialit(int n){
    /*
       //caso base
        if(n==0){
            return 1;
        }  
        //caso recursivo
        else{
            return n*Factorial(n-1);
        }
        */
        
        int num=n;
        int f =1;
        while(num>0){
            f=f*num;
            num--;
        }
        return f;
    }
    
}
