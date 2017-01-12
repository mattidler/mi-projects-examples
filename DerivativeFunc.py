#Matt Idler Hmwk13 part 1, python part for graph of data points

import numpy as np
import matplotlib.pyplot as plt

#loading the data into X/Y array and transpose
datax1 = np.loadtxt("derive.dat", np.float64).T[0]
datay1 = np.loadtxt("derive.dat", np.float64).T[1]

#Creating plots and scale
plt.subplot(111)
plt.xscale('log')
plt.scatter(datax1,datay1, color='blue', lw=2)

#Labeling
plt.title("Derivative of x^3", size = 20)
plt.xlabel("delta(x)", size = 16)
plt.ylabel("y-axis", size = 20)

plt.savefig("FirstDer.pdf", dpi=72)

plt.show()
