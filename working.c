#include <stdint.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

// Author: itsme86
// Source: http://www.linuxquestions.org/questions/programming-9/replace-a-substring-with-another-string-in-c-170076/
char* replace_str(char *str, char *orig, char *rep)
{
	static char buffer[4096];
	char *p;

	if(!(p = strstr(str, orig)))  // Is 'orig' even in 'str'?
		return str;

	strncpy(buffer, str, p-str); // Copy characters from 'str' start to 'orig' st$
	buffer[p-str] = '\0';

	sprintf(buffer+(p-str), "%s%s", rep, p+strlen(orig));

	return buffer;
}

char* generateContent(char* nextLang) {
    return replace_str(replace_str(replace_str(replace_str(nextLang, "%CCODE%", c), "%CPPCODE%", cpp), "%JAVACODE%", java), "%PYTHONCODE%", python);
}

char* generateList(int args, char* cmdLine[]) {
    char buffer[32];
    strcpy(buffer, cmdLine[1]);
    if (args > 3) {
        for (int i = 3; i < args; i++) {
            strcat(buffer, " ");
            strcat(buffer, cmdLine[i]);
        }
    }
    strcat(buffer, cmdLine);
    return buffer;
}

// Author: James Bilbrey (bilbrey1@umbc.edu)
// Usage: ./this firstLang nextLang [otherLangs...]
int main(int argc,char *argv[]) {

	system("rm -f uroboros.*");
	
	const char* c = "%CCODE%";
	const char* cpp = "%CPPCODE%";
	const char* java = "%JAVACODE%";
	const char* python = "%PYTHONCODE%";
    
    char* langList = generateList(argc, argv);
	
    // The following are generous estimates
	char nextLang[2048];
    char filename[32];
    char buildcmd[64];
    char runcmd[64];
    
    strcpy(filename, "uroboros.");
    strcat(filename, argv[2]);
    
    if (argv[2] == "c") {
        sprintf(buildcmd, "g++ -ansi -Wall %s -o uroboros.o", filename);
        sprintf(runcmd, "./uroboros.o %s", langList);
    } else if (argv[2] == "cpp") {
        sprintf(buildcmd, "g++ -ansi -Wall %s -o uroboros.o", filename);
        sprintf(runcmd, "./uroboros.o %s", langList);
    } else if (argv[2] == "java") {
        sprintf(buildcmd, "javac %s", filename);
        sprintf(runcmd, "java uroboros %s", langList);
    } else if (argv[2] == "py") {
        sprintf(buildcmd, "");
        sprintf(runcmd, "python %s %s", filename, langList);
    } else {
        printf("Not prepared for language: %s\n", argv[1]);
        return 1;
    }
    
    char* next = generateContent(nextLang);
	
    // if the next lang is the starting lang, print what we would have written
    if (argv[2] == argv[1]) {
        printf(next);
        return 0;
    }
    
	FILE *f = fopen(filename, "w");
	fprintf(f, next);
	fclose(f);
	
	system(buildcmd);
	system(runcmd);
	return 0;
}
