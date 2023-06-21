#include<iostream>
#include<iomanip>
#include<cmath>
using namespace std;
/*6.	Escribir un programa que le pregunte al usuario una cantidad de dinero, una tasa de interés y un número de años y muestre como resultado el monto final a obtener.
 La fórmula a utilizar es: Cn = C * (1 + x/100) ^ n Donde C es el capital inicial, x es la tasa de interés y n es el número de años a calcular.*/

float Cdinero,Tinteres,Ao,Mfin;
int main(){
	system("color FA");
	cout.precision(2);
	cout<<"Ingrese un Monto Monetario:  "; cin>>Cdinero;
	cout<<"Ingrese un porcentage de interes:  "; cin>>Tinteres;
	cout<<"Ingrese la cantidad de anos :  "; cin>>Ao;
	Mfin=Cdinero*(1+Tinteres/100)Ao;
	cout<<"El monto final es:  "<<fixed<<Mfin<<endl;
}