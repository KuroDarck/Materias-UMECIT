#include<iostream>
#include<iomanip>
//Hacer un algoritmo que lea tres valores, calcule el promedio e imprima la diferencia de cada valor comparado con el promedio resultante.
using namespace std;
//Se definen las variables
float nota1,nota2,nota3,Resultado,Dferencia1,Dferencia2,Dferencia3;
int main(){
	system("color FA");
	cout<<"ingrese la primera nota:  "; cin>>nota1;
	cout<<"ingrese la segunda nota:  "; cin>>nota2;
	cout<<"ingrese la tercera nota:  "; cin>>nota3;	
	
	Resultado=((nota1+nota2+nota3)/3);
	cout.precision(1);
	cout<<"El promedio es: "<<fixed<<Resultado<<endl;
	Dferencia1=nota1-Resultado;
	cout<<"La diferencia de la primera nota es: "<<fixed<<Dferencia1<<endl;
	Dferencia2=nota2-Resultado;
	cout<<"La diferencia de la segunda nota es: "<<fixed<<Dferencia2<<endl;
	Dferencia3=nota3-Resultado;	
	cout<<"La diferencia de la tercera nota es: "<<fixed<<Dferencia3<<endl;

	return 0;
	cin.get();
}

