quine:
	@javac QuineGen.java
	@java QuineGen
	@g++ -ansi -Wall Final.c -o Final.o
	@g++ -ansi -Wall Final.cpp -o Final.out
	@javac Final.java
	@echo "Quine programs ready"
	@echo "Run the C-headed quine with"
	@echo "$$ make runc"
	@echo "Run the CPP-headed quine with"
	@echo "$$ make runcpp"
	@echo "Run the Java-headed quine with"
	@echo "$$ make runjava"

clean:
	@rm -rf *.o
	@rm -f *.out
	@rm -f *.class
	@rm -f uroboros.*
	@rm -f Final.*
	@rm -f *~ *.h.gch *#[
	@echo "Before trying to run anything, do"
	@echo "$$ make"

runc:
	@./Final.o c java py c

runjava:
	@java Final java c cpp py java

runpy:
	@python Final.py py c java py

runcpp:
	@./Final.out cpp c java py cpp

download:
	@rm Makefile
	@wget https://github.com/Final-JJZ/Final/archive/master.zip
	@unzip master.zip
	@rm master.zip
	@mv Final-master/* .
	@rm -rf Final-master
	@echo "Updated to latest"
