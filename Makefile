final: Final.c
	g++ -ansi -Wall Final.c -o Final.o

stringer:
	java Stringer c java

clean:
	rm -rf *.o
	rm -f *.out
	rm -f *.class
	rm -f *~ *.h.gch *#[
	javac Stringer.java
    
run:
	./Final.o
