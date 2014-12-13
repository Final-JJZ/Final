import sys

c = "%CCODE%";
cpp = "%CPPCODE%";
java = "%JAVACODE%";
python = "%PYTHONCODE%";

print 'Arguments: ', sys.argv

def main(argv)

#TODO: Check command line arguments, if 1 and 2 are the same, it is the last file so print code for first language.

print "Hello, world!"

# Writing CPP code to file.
file = open('newfile.txt', 'w')
file.write(cpp)

# TODO: Compile and run CPP code with sys command.


# Source: http://cs.lmu.edu/~ray/notes/quineprograms/
s='s=%r;print s%%s,';print s%s,

file.close()

if __name__ == "__main__":
   main(sys.argv[1:])
