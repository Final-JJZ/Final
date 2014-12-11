buildc: Final.c
	g++ -ansi -Wall Final.c -o Final.o

buildjava: Final.java
	javac Final.java

buildpy:
	echo "python does not need to be built"

buildcpp: Final.cpp
	g++ -ansi -Wall Final.cpp -o Final.out

stringer:
	java Stringer

clean:
	rm -rf *.o
	rm -f *.out
	rm -f *.class
	rm -f *~ *.h.gch *#[
	javac Stringer.java
    
runc:
	./Final.o c java py

runjava:
	java Final java c py

runpy:
	python Final.py py c java

runcpp:
	./Final.out cpp c java py
