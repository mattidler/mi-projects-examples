#Matt Idler Particle Movement python part

import numpy as np 
import matplotlib.pyplot as plt

xdata = np.loadtxt("xt.dat", np.float64).T[0] #time t
ydata = np.loadtxt("xt.dat", np.float64).T[1] #position at t
zdata = np.loadtxt("xt.dat", np.float64).T[2] #speed at t
cdata = np.loadtxt("xt.dat", np.float64).T[3] #acceleration at t

plt.figure(figsize=(8,6), dpi=80)
plt.subplot(111)


plt.plot(xdata, ydata, color="blue" , label="Position")
plt.plot(xdata, zdata, color="green", label="Speed")
plt.plot(xdata, cdata, color="red", label="Acceleration")

plt.title("Position, Speed and Acceleration at time(t)")
plt.xlabel("Time(s)")


plt.legend(loc='lower left', frameon=False)

plt.savefig("Hmwk14.pdf", dpi=72)

plt.show()
