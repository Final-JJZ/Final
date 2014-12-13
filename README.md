Final
=====

Final Project for CMSC331 (https://github.com/Final-JJZ/Final)
<br>James Bilbrey (bilbrey1@umbc.edu)
<br>Zain Syed (syed10@umbc.edu)
<br>John Gordon (gordon8@umbc.edu)

The intention of this fileset is to provide the user with
a set of runnable files, giving the choice of which to run.

The intention was that each runnable would be a self-sustaining quine,
with a flexible order of progression, but do to time constraints and
lack of manpower, this fails in the case of the 

QuineGen.java is the original work of James Bilbrey.

To run the quine, enter the following commands:
<br>$ make clean
<br>$ make
<br>$ make runX where X is an extension such as c, java

To update from the latest source, run the following in a folder
WITH NO CONTENTS OTHER THAN THIS PROJECT:
<br>$ make update
<br>I take no responsibility for any data lost from running that command.
By using it you acknowledge that you have been warned of its affects,
and agree not to hold James Bilbrey accountable for any data
lost due to misuse.


Credit for the function with signature
<br>"char* replace_str(char *str, char *orig, char *rep)"
<br>used in C and CPP files goes to itsme86
(http://www.linuxquestions.org/questions/programming-9/replace-a-substring-with-another-string-in-c-170076/). 
The comments for this function can be viewed at the source.

I learned the @ trick for Makefiles at http://stackoverflow.com/questions/8610799/what-does-at-symbol-colon-mean-in-a-makefile 
I was taught that for Batch files, but didn't know it worked in other systems

Comments in source.java:
Line 13: "translate to human-readable code"
Line 14: "inject source code into the next file"

Comments in source.c and source.cpp:
Line 28: "C does not like comma declarations of pointers to characters"
Line 28: "C is obnoxious"
Line 35: "Compile the patterns. These are broken up incase some language tries to
replace more than just the first instance of each"
Line 42: "translate to human-readable code"
Line 45: "inject source code into the next file"
Line 51: "this takes the list of arguments, and reorders them for the next language"
Line 67: "the following four lines are generous estimates"

Comments in source.py
Line 1: "Everything here I learned from re-reading my group's project 1"
