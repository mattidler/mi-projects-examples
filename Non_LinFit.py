#!/opt/local/bin/python

import numpy as np
import numpy.random as ran
import matplotlib.pyplot as plt
from scipy.optimize import curve_fit

datax = np.loadtxt("nonLinearFit.dat", np.float64).T[0]
datay = np.loadtxt("nonLinearFit.dat", np.float64).T[1]


plt.figure(figsize=(8,6), dpi=80)
plt.subplot(111)
plt.scatter(datax, datay, 5, color="blue", label="data")


def g( x, a, b, c, d ):
	return a * np.cos(2.5*x - 0.5*b) + c * np.sin(2.5*x - x*d) 

(popt, pcov) = curve_fit(g, datax, datay, p0=None,sigma=None)

print(popt)

xfitted = datax
yfitted = g(xfitted,popt[0],popt[1],popt[2],popt[3])
plt.plot(xfitted, yfitted, color="red", linewidth=1.0, linestyle="-", label="fitted")

plt.legend(loc='lower left', frameon=False)
plt.savefig("NonLinFit.pdf", dpi=72)

plt.show()
