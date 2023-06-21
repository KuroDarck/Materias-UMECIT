#include<iostream>
#include<iomanip>
using namespace std;

/*3. Escriba un programa que calcule cuanto se generara de interés para un capital inicial 
si el mismo se incrementa en 2% mensual sobre el último saldo.  Imprima cuanto habrá en depósito (capital e interés) después de 3 meses.*/

float Cinicial,Cmedi,C3mese;
 int main(){
	cout.precision(2);
	system("color FA");
	cout<<"Digite el Capital Inicial:  "; cin>>Cinicial;
	
	C3mese=((Cinicial)+Cinicial*0.02);
	Cmedi=((C3mese)+C3mese*0.02);
	C3mese=((Cmedi)+Cmedi*0.02);
	
	cout<<"El saldo final es:  "<<fixed<<C3mese;


	return 0;
	cin.get();
}
