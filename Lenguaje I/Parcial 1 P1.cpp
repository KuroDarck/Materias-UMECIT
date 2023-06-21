#include<iostream>
using namespace std;

/*1.	Desarrollar un algoritmo que lea dos números utilizando dos variables, intercambie los valores de las variables e imprímalas.
 Debe imprimir la misma variable que leyó.*/
int N1,N2,N3;
int main(){
	system("color FA");
	cout<<"Ingrese la priera variable:  "; cin>>N1;
	cout<<"Ingrese la segunda variable: "; cin>>N2;
	N3=N1;
	N1=N2;
	N2=N3;
	cout<<"Al intercanbiar valores la priera variable: quedo:  "<<N1<<endl;
	cout<<"Al intercanbiar valores la segunda variable quedo:  "<<N2<<endl;
	return 0;
	cin.get();
}
