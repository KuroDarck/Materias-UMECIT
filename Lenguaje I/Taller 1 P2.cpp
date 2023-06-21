#include<iostream>
#include<iomanip>
using namespace std;
//2. Escribir un algoritmo que convierta una temperatura expresada en grados Fahrenheit a grados Celsius, sabiendo que Celsius=5/9*(Fahrenheit-32).

float Temperatura1,Temperatura2;
int main()
{
	system("color FA");
	cout<<"ingrese la temperatura en Fahrenheit: "; cin>>Temperatura1;
	Temperatura2=(Temperatura1-32)*5/9;
	cout.precision(2);
	cout<<"La temperatura en Celciun es: "<<fixed<<Temperatura2<<"C";
	
	return 0;
	cin.get();
}
