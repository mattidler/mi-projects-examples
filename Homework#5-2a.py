#Matt Idler
#Homework #5 Problem 2

import numpy as np
import matplotlib.pyplot as plt

plt.figure(figsize=(8,6), dpi=80)
ax = plt.subplot(111)

#Constants
h0 = 1.54 		#meters
g = 9.8 		#meters per sec^2

#Define variables
def y( x, v, th0 ):
	th0rad = th0 * np.pi/180
	return h0 + np.tan(th0rad) * x - g * x**2 / (2 * v**2 * np.cos(th0rad)**2)

#Domain 
xmin = 0.0
xmax = 100.0
xrange = xmax - xmin

#Set discretization 
dx = 0.1

numpoints = xrange/dx + 1

#x-values
xdata = np.linspace(xmin,xmax,numpoints,endpoint=True)

#Ground data
def ground( x ):
	gd = np.loadtxt("ground.dat")
	x = gd.T[0]
	y = gd.T[1]
	plt.plot(x,y, color="black", linewidth=2.0)

ydata = []
for x in xdata:
	ydata.append(ground(x))

#Values of v
th0 = 30 
v1 = [13.2,18,21,25] 
colors = ['red','blue','purple','green']

#Title
plt.title(r'Landing places for different $v_0$ and angle $\theta_0=%.2f^\circ$' % (th0),fontsize=18,color='black')

ymin = 0 
ymax = 8

#Make loop
for i in range(len(v1)):
	v = v1[i]
	
	ydata = y(xdata,v,th0)
	if( np.max(ydata) > ymax):
		ymax = np.max(ydata)
	

	plt.plot(xdata,ydata,color=colors[i], linewidth=1.0, label=r'$v_0=%.2f$ m/s' % (v))

yrange = ymax - ymin

#Axis labels
plt.xlabel(r'$Distance(m)$',fontsize=16)
plt.ylabel(r'$Height(m)$',fontsize=16)

#Margin
margin = 0.1
plt.xlim(xmin, xmax)
plt.ylim(ymin-0.025, ymax + yrange * margin)

#Legend
plt.legend(loc='upper right',frameon=True)

plt.annotate('x=11.5\ny=3.2', (11.5, 3.2), xytext=(15, 2), arrowprops=dict(arrowstyle="->",connectionstyle="arc3, rad=.3"),)
plt.annotate('x=24.4\ny=3.6', (24.4, 3.6), xytext=(29, 2), arrowprops=dict(arrowstyle="->", connectionstyle="arc3, rad=.3"),)
plt.annotate('x=35.7\ny=3.3', (35.7, 3.3), xytext=(45, 2), arrowprops=dict(arrowstyle="->", connectionstyle="arc3, rad=.3"),)
plt.annotate('x=47.2,y=5.4', (47.2, 5.4), xytext=(60, 6.1), arrowprops=dict(arrowstyle="->", connectionstyle="arc3, rad=.3"),)


#Save to file
plt.savefig("Homework#5-2.pdf",dpi=72)

print('For theta0 = 30 degrees, we have four plots where they hit the valleys where the annotations are.')


plt.show()
