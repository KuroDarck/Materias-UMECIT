#include<iostream>
using namespace std;
/*2.	Escriba un programa que lea un valor numérico entero, positivo o negativo e imprima el valor con el signo opuesto.
 Es decir, si lea un numero negativo lo imprime positivo y viceversa.*/
 int Vble;
 int main(){
	system("color FA");
	cout<<"Ingrese la variable: "; cin>>Vble;
	Vble=Vble*-1;
	cout<<"El signo de la variable canbio:  "<<Vble<<endl; 
	
	return 0;
	cin.get(); 
 }
