import eu.mihosoft.vrl.v3d.CSG
import eu.mihosoft.vrl.v3d.Cube
double kerf = 5
double length  = 200
double width = 50
double holeDiam = 3
double thickness = 5
CSG core = new Cube(length+kerf*2,width,thickness).toCSG()
CSG side =  new Cube(length,width+kerf,thickness).toCSG()
				.toYMax()
				.movey(-width/2)
CSG side2 =  new Cube(length,width+kerf,thickness).toCSG()
				.toYMin()
				.movey(width/2)
CSG end = new Cube(width,width*3+kerf*2,thickness).toCSG()
			.toXMin()
			.movex(length/2+kerf)			
CSG otherEnd = 	end		.toXMax()
			.movex(-length/2-kerf)			
core=core.union(side)
core=core.union(side2)
core=core.union(end)
core=core.union(otherEnd)
core.addExportFormat("svg")
return core
