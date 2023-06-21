#include<iostream>
using namespace std;

/*4. Escriba un programa que determine el porcentaje de cada gasto según el salario.
 Para determinar debe conocer el salario mensual del trabajador y conociendo los siguientes gastos fijos:
"	Agua: $70
"	Luz:$75
"	Teléfono: $50
"	Comida: 200
"	Gasolina:$ 50*/
float Pagua,Pluz,Ptfono,Pcomida,Pgaso;
float Smensual;
int agua=70;
int Luz=75;
int Tlefono=50;
int Comida=200;
int Gasolina=50;
int main(){
	system("color FA");
	cout.precision(2);
	cout<<"digite salario mensual:  "; cin>>Smensual;
	Pagua=(agua/Smensual)*100;
	cout<<fixed<<"El porcentaje en agua es: "<<Pagua<<"%"<<endl;
	Pluz=(Luz/Smensual)*100;
	cout<<fixed<<"El porcentaje en Luz es: "<<Pluz<<"%"<<endl;
	Ptfono=(Tlefono/Smensual)*100;
	cout<<fixed<<"El porcentaje en Telefono es: "<<Ptfono<<"%"<<endl;
	Pcomida=(Comida/Smensual)*100;
	cout<<fixed<<"El porcentaje en Comida es: "<<Pcomida<<"%"<<endl;
	Pgaso=(Gasolina/Smensual)*100;
	cout<<fixed<<"El porcentaje en Gasolina es: "<<Pgaso<<"%"<<endl;
	return 0;
	cin.get();
	}
	
	
	

