#include<iostream>
using namespace std;
/* Diseñar un algoritmo que pida por teclado tres números, si el primero es negativo, debe imprimir el producto de los tres y si no lo es, imprima la suma */

int Nmero1,Nmero2,Nmero3,Suma,Producto;
int main(){
	cout<<"Ingrese el primer valor:  "; cin>>Nmero1;
	cout<<"Ingrese el segundo valor: "; cin>>Nmero2;
	cout<<"Ingrese el tercero valor: "; cin>>Nmero3;	
	if(Nmero1<0){
		Producto=(Nmero1*Nmero2*Nmero3);
		cout<<"El producto es:  "<<Producto<<endl; 
	}else{
		Suma=(Nmero1+Nmero2+Nmero3);
		cout<<"la suma de los tres numeros es:  "<<Suma<<endl; 
	}
	return 0;
	cin.get();
}
