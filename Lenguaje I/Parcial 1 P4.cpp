#include<iostream>
#include<iomanip>
using namespace std;

/*4.	Escriba un programa que calcule cuanto se generara de interés para un capital inicialsi el mismo se 
incrementa en 2%,  2.5%,  3%, 3.5% y 4%  respetivamente por 5 meses sobre el último saldo.Imprima cuanto habrá en depósito (capital e interés). 
 Después de 5 meses. Recuerde que el interés se genera sobre el último capital. Imprima el total acumulado (capital + interés).*/
float CapitalA,CapitalB;
int main(){
	system("color FA");
	cout.precision(2);
	cout<<"Ingrese el capital Inicial:  ";  cin>>CapitalA;
	CapitalB=CapitalA+(CapitalA*0.02);
	CapitalA=CapitalB+(CapitalB*0.025);
	CapitalB=CapitalA+(CapitalA*0.03);
	CapitalA=CapitalB+(CapitalB*0.035);
	CapitalB=CapitalA+(CapitalA*0.04);
	cout<<"El capital se incrementa en 5 meses en:  "<<fixed<<CapitalB<<"$"<<endl;
	return 0;
	cin.get();
}
