final: Final.c
	g++ -ansi -Wall Final.c -o Final.o

stringer: Stringer.java
	javac Stringer.java

clean:
	rm -rf *.o
	rm -f *.out
	rm -f *.class
	rm -f *~ *.h.gch *#[
    
runfinal:
	./Final.o
	
runstringer:
	java Stringer
