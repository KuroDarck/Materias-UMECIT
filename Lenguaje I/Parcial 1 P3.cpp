#include<iostream>
#include<iomanip>
using namespace std;

/*3.	Tres personas deciden invertir su dinero para fundar una empresa. Cada una de ellas invierte una cantidad distinta.
 Obtener el porcentaje que cada uno invierte con respecto a la cantidad total.*/
 float Psona1,Psona2,Psona3,Ttal,Pcentage1,Pcentage2,Pcentage3;
 int main(){
	system("color FA");
	cout.precision(2);
	cout<<"Ingrese La Invercion de la primera persona:  "; cin>>Psona1;
	cout<<"Ingrese La Invercion de la segunda persona:  "; cin>>Psona2;
	cout<<"Ingrese La Invercion de la tercera persona:  "; cin>>Psona3;
	Ttal=Psona1+Psona2+Psona3;
	Pcentage1=(Psona1/Ttal)*100;
	Pcentage2=(Psona2/Ttal)*100;
	Pcentage3=(Psona3/Ttal)*100;
	cout<<"La invercion de la primera persona fue de: "<<fixed<<Pcentage1<<"%"<<endl;
	cout<<"La invercion de la primera segunda fue de: "<<fixed<<Pcentage2<<"%"<<endl;
	cout<<"La invercion de la primera tercera fue de: "<<fixed<<Pcentage3<<"%"<<endl;
	return 0;
	cin.get();
 }
