#include<iostream>
using namespace std;

/*1.	Algoritmo que lea tres números distintos y nos diga cuál de ellos es el mayor (recuerda usar la estructura condicional Si y los operadores lógicos). */
int Nmero1,Nmero2,Nmero3;
int main(){
	cout<<"Ingrese un primer numero:  "; cin>>Nmero1;
	cout<<"Ingrese un segundo numero: "; cin>>Nmero2;
	cout<<"Ingrese un tercer numero:  "; cin>>Nmero3;
	if (Nmero1>Nmero2&&Nmero1>Nmero3){
		cout<<"El primer numero es mayor: "<<endl;
	}
	else if(Nmero2>Nmero1&&Nmero2>Nmero3){
		cout<<"El segundo numero es mayor: "<<endl;
	}else{
		cout<<"El tercer numero es mayor: "<<endl;
	}

	return 0;
	cin.get();
}
