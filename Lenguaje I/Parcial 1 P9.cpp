#include<iostream>
#include<iomanip>
using namespace std;
/*9.	Hacer un algoritmo que lea el sueldo de dos empleados, luego le calcule una retención del 10% a cada uno de ellos. 
Se pide que imprima el sueldo neto de cada empleado.*/
float Sdo1,Sdo2,R1,R2;
int main(){
	system("color FA");
	cout.precision(2);
	cout<<"ingrese el salario del primer empleado:  "; cin>>Sdo1;
	cout<<"ingrese el salario del segundo empleado: "; cin>>Sdo2;
	R1=Sdo1-(Sdo1*0.10);
	R2=Sdo2-(Sdo2*0.10);
	cout<<fixed<<"El Salario neto del primer empleado es   :  "<<R1<<endl;
	cout<<fixed<<"El salario neto del segundo empleado es :  "<<R2<<endl; 
	return 0;
	cin.get();
}
