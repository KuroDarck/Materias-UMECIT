#include<iostream>
using namespace std;

/* 1.	A un trabajador le pagan según sus horas trabajadas y la tarifa está a un valor por hora. Si la cantidad de horas trabajadas es mayor a 40 horas 
y menor e igual a 48, la tarifa por hora extra se incrementa en un el doble de una hora normal de las horas normal, de otro modo horas pasan de 48
 la tarifa de las horas extra incrementa al triple de las horas normal, Calcular el salario del trabajador dadas las horas trabajadas y la tarifa.  
 Recordar que las primeras 40 horas se consideran normales, el resto horas extras.*/
 float Horas,HorasX,SalHx,SalF;
 int main(){
 	cout.precision(2);
	system ("color FA");
 	cout<<"Ingrese las cantidad de horas trabajadas:  "; cin>>Horas;
 	cout<<"Ingrese las cantidad de horas extras trabajadas:  "  ;cin>>HorasX;
 	cout<<"Ingrese el salario por Hora :   "; cin>>SalHx;
 	
 	if(Horas+HorasX>40&&Horas+HorasX<=48){
 		SalF=(Horas*SalHx)+(HorasX*(SalHx*2));
	}
	 else if(Horas+HorasX>48){
	 SalF=(Horas*SalHx)+(HorasX*(SalHx*3));
	 }  
	 cout<<"El salario por Hora a pagar es: "<<fixed<<SalF; 
 	return 0;
 	cin.get();
 }
