quine:
	javac QuineGen.java
	java QuineGen

clean:
	rm -rf *.o
	rm -f *.out
	rm -f *.class
	rm -f uroboros.*
	rm -f *~ *.h.gch *#[
    
runc:
	./Final.o c java py c

runjava:
	java Final java c py java

runpy:
	python Final.py py c java py

runcpp:
	./Final.out cpp c java py cpp
