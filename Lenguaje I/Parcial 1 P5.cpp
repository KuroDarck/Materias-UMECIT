#include<iostream>
#include<iomanip>
using namespace std;
/*5.	Desarrolle un algoritmo que lea el monto de una compra. Dicha compra tiene un descuento de 20%. El valor final para pagar se le ajusta el impuesto de 7%.
 Imprima El valor de la compra inicial, el valor de descuento, el valor de impuesto, la compra con el descuento y la compra final con el impuesto.*/

float Articulo,Dcuento, Mpagar;
int main(){
	system("color FA");
	cout.precision(2);
	cout<<"Ingrese valor del Articulo:  "; cin>>Articulo;
	Dcuento=Articulo-(Articulo*0.2);
	Mpagar=Dcuento+(Dcuento*0.07);
	cout<<"El monto a pagar es:  "<<fixed<<Mpagar<<endl;
	return 0;
	cin.get();
	
}
