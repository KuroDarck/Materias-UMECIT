#include<iostream>
#include<iomanip>

using namespace std;

/* 5. Un alumno desea saber su promedio final en la materia de Programación Estructurada. Dicha calificación se compone de la siguiente manera:
"	55% del promedio de 3 calificaciones parciales
"	30% de la calificación del examen final
"	15% del promedio de 2 proyectos*/

int nota1,nota2,nota3;
int nortEx;
int proyto1,proyto2;
float NC,NX,NP,NeFinal;
int main(){
	system("color FA");
	cout.precision(2);
	cout<<"Ingrese las calificaciones Parciales:  "; cin>>nota1;
	cout<<"Ingrese las calificaciones Parciales:  "; cin>>nota2;
	cout<<"Ingrese las calificaciones Parciales:  "; cin>>nota3;
	NC=((nota1+nota2+nota3)/3)*0.55;
	
	
	cout<<"Ingrese la calificacion Examen Final:  "; cin>>nortEx;
	NX=(nortEx*0.30);
	
	
	cout<<"Ingrese la calificacion Proyecto 1:  "; cin>>proyto1;
	cout<<"Ingrese la calificacion Proyecto 2:  "; cin>>proyto2;
	NP=((proyto1+proyto2)/2)*0.15;
	
	
	NeFinal=(NC+NX+NP);
	
	cout<<"El porcentage de la nota final es:  "<<fixed<<NeFinal;
	return 0;
	cin.get();
}
