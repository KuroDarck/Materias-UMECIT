#include<iostream>
using namespace std;
/* 1.Algoritmo que lea dos números y nos diga cuál de ellos es mayor. 
Recuerda usar la estructura condicional SI)  */
int Nmero1,Nmero2;
int main(){
	cout<<"Ingrese un primer numero:  "; cin>>Nmero1;
	cout<<"Ingrese un segundo numero: "; cin>>Nmero2;
	if(Nmero1>Nmero2){
	
	cout<<"El primer numero es mayor:  "<<endl;
	}else{
		
	cout<<"El segundo valor es mayor: "<<endl;
	}
return 0;
cin.get();	
}
