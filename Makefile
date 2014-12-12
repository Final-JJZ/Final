quine:
	javac QuineGen.java
	java QuineGen
	g++ -ansi -Wall Final.c -o Final.o
	g++ -ansi -Wall Final.cpp -o Final.out
	javac Final.java

clean:
	rm -rf *.o
	rm -f *.out
	rm -f *.class
	rm -f uroboros.*
	rm -f Final.*
	rm -f *~ *.h.gch *#[
    
runc:
	./Final.o c java py c

runjava:
	java Final java c cpp py java

runpy:
	python Final.py py c java py

runcpp:
	./Final.out cpp c java py cpp
