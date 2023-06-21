#include<iostream>
using namespace std;

/*1.	Calcule la compra de computadoras según la siguiente tabla:

a.	1 a 5: $500 cada una
b.	6 a 10: $450 cada una
c.	Mas de 10: $350 cada una
Lea la cantidad e imprima el total según los precios por cantidades compradas*/
float Cmp,CmpF;
int main(){
	cout.precision(2);
	system("color FA");
	cout<<"Ingrese la cantidad de computadora a comprar:  "; cin>>Cmp;
	if (Cmp>1&&Cmp<=5){
		CmpF=Cmp*500;
	}else if(Cmp>=6&&Cmp<=10){
		CmpF=Cmp*450;
	}else{
		CmpF=Cmp*350;
	}
	cout<<" El total segun los precios por cantidades compradas es: "<<fixed<<CmpF<<endl;
	return 0;
	cin.get();
}
