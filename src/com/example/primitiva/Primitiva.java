package com.example.primitiva;
import java.util.Random;


public class Primitiva {
	static int [] numeros=new int[6];
	
	
	public static void generar(){
	Random numaleatorio=new Random();
		for(int i=0; i<6; i++){
			numeros[i]=numaleatorio.nextInt(48)+1;
		if(i>=1){	
			for(int j=0;j<i;j++){
				if (numeros[i]==numeros[j]){
					i--;
				}
			}
		
			}
		
		}
		
	}
	
	public static String getNum(){
		String cadena="";
		
		for(int i=0;i<6;i++){
			cadena=cadena+"-"+String.valueOf(numeros[i]);
			
		}
		return cadena;
	}

}
