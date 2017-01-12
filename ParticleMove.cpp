//Matt Idler Hmwk#14 C++ part

#include <cstdlib>
#include <iostream>
#include <cmath>
#include <fstream>

using std::cout;
using std::cin;
using std::endl;

double f(double t)
{
		return 3.4*cos(0.15*t)-(0.9*sqrt(t)*pow(sin(0.25*t),2));
}

double v(double t, double Dt)

{
	return (f(t+Dt)-f(t))/Dt;
}

double a(double t, double Dt )
{
	return (f(t+Dt)+f(t-Dt)-2*f(t))/pow(Dt,2);
	
}
	int main(int argc, char** argv)
{

	
	std::ofstream Output("xt.dat");
 	
	double t, Dt, tmin, tmax, n, deltaT;
	tmin=0.0;
	tmax=50.0;
	n=1001;
	deltaT= (tmax-tmin)/(n-1);
	Dt=0.0001;
	for (int i=0; i<n; i++)
	{
		t = tmin+i*deltaT;
		cout << "The time t is " << t << endl; 
		cout << "The position between 0 and 50 sec is " << f(t) << endl;
		cout << "The speed between 0 and 50 sec is " << v(t,Dt) << endl;
		cout << "The acceleration between 0 and 50 sec is " << a(t,Dt) << endl;
		Output << t << " " << f(t) << " " << v(t,Dt) << " " << a(t,Dt) << endl;
		
	} 
	
	Output.open("xt.dat");
	
    if(Output.is_open())
    {
        cout << "Output stream opened successfully." << endl;
    }
      else
    {
        cout << "Output stream failed to open!" << endl;
        return EXIT_FAILURE;
    }
	Output.close();
	return EXIT_SUCCESS;
}
