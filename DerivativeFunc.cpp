//Matt Idler Hmwk #13 part 1

#include <cstdlib>
#include <iostream>
#include <cmath>
#include <fstream>


using std::cout;
using std::cin;
using std::endl;

double f(double x)
	{
		return pow(x,3);
	}
	

int main(int argc, char** argv)
{
    std::ofstream Derivative ("derive.dat");
    
	
	double x, Dx; // Making a varible X and function of X
	cout << "Please enter the X value" << endl;
	cin >> x;
	
	
	// Making the variable input for the Standard Deviation
	cout << "Please enter starting Delta X for the derivative." << endl;
	cin >> Dx;
	
	for (double i=100; i>0; i--)
	{
	
		cout << "The Derivative of x^3 with Delta X of " << Dx << " is: " << (pow(x+Dx,3.0)-pow(x,3.0))/(Dx) << endl;
		Dx = Dx * 0.7; // Shorthand: Dx *= 0.7;
		Derivative << Dx << " " << (pow(x+Dx,3.0)-pow(x,3.0))/(Dx) << endl;
	}
    
    
    cout << "The actual derivative for " << x << " in the function x^3 is: " << pow(x,2)*3 << endl;


    Derivative.open("derive.dat");
    if(Derivative.is_open())
    {
        cout << "Derivative stream opened successfully." << endl;
		cout << Derivative << endl;
	
    }
      else
    {
        cout << "Derivative stream failed to open!" << endl;
        return EXIT_FAILURE;
    }
	

	Derivative.close();
	return EXIT_SUCCESS;
}
