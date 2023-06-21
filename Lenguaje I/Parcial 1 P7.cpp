#include<iostream>
#include<iomanip>
using namespace std;

/*7.	Desarrollar un algoritmo que calcule e imprima el 15% de un número.*/

float N1,Ptg;
int main(){
	system("color FA");
	cout.precision(2);
	cout<<"Ingrese un valor para porcentar: "; cin>>N1;
	Ptg=(N1*0.15);
	cout<<"El 15% del valor es:  "<<fixed<<Ptg<<endl;
	return 0;
	cin.get();
}
