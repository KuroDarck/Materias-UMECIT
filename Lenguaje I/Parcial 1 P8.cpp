#include<iostream>
#include<iomanip>
using namespace std;
/*8.	Hacer un algoritmo que lea tres valores, sume e imprima el primer valor con el segundo valor,
 luego deberá multiplicar dicha suma por el tercer valor y mostrar también el resultado.*/
 
 int N1,N2,N3,Rsuma,Rmulti;
 int main(){
	system("color FA");
	cout<<"Ingrese el primer valor:  "; cin>>N1;
	cout<<"Ingrese el segundo valor: "; cin>>N2;
	cout<<"Ingrese el segundo valor: "; cin>>N3;
	Rsuma=N1+N2;
	cout<<"El resultado de la suma es: : "<<Rsuma<<endl;
	Rmulti=Rsuma*N3;
	cout<<"El resultado de la multiplicacion es: : "<<Rmulti<<endl;
	return 0;
	cin.get();
}
 
