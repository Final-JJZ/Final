#include <stdint.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

const char* c = "%CCODE%";
const char* cpp = "%CPPCODE%";
const char* java = "%JAVACODE%";
const char* python = "%PYTHONCODE%";

void replace_str(char *str, char *orig, const char *rep)
{
	static char buffer[8192];
	char *p;

	if(!(p = strstr(str, orig)))
		return;

	strncpy(buffer, str, p-str);
	buffer[p-str] = '\0';

	sprintf(buffer+(p-str), "%s%s", rep, p+strlen(orig));

	strcpy(str, buffer);
}

void generateContent(char* nextLang) {
	char* cID;
	char* cppID;
	char* javaID;
	char* pythonID;
	sprintf(cID, "%s%s%s", "%", "CCODE", "%");
	sprintf(cppID, "%s%s%s", "%", "CPPCODE", "%");
	sprintf(javaID, "%s%s%s", "%", "JAVACODE", "%");
	sprintf(pythonID, "%s%s%s", "%", "PYTHONCODE", "%");
	replace_str(replace_str(replace_str(replace_str(nextLang, cID, c), cppID, cpp), javaID, java), pythonID, python);
    replace_str(replace_str(nextLang, "%N", "\n"), "%T", "\t");
}

void generateList(char buffer[], int args, char* cmdLine[]) {
	strcpy(buffer, cmdLine[1]);
	if (args > 3) {
		for (int i = 3; i < args; i++) {
			strcat(buffer, " ");
			strcat(buffer, cmdLine[i]);
		}
	}
	strcat(buffer, cmdLine[2]);
}

int main(int argc,char *argv[]) {

	char langList[32];
	generateList(langList, argc, argv);
	
	// The following are generous estimates
	char nextLang[8192];
	char filename[32];
	char buildcmd[64];
	char runcmd[64];
	
	strcpy(filename, "uroboros.");
	strcat(filename, argv[2]);
	
	if (strcmp(argv[2], "c") == 0) {
		strcpy
		sprintf(buildcmd, "g++ -ansi -Wall %s -o uroboros.o", filename);
		sprintf(runcmd, "./uroboros.o %s", langList);
	} else if (strcmp(argv[2], "cpp") == 0) {
		sprintf(buildcmd, "g++ -ansi -Wall %s -o uroboros.o", filename);
		sprintf(runcmd, "./uroboros.o %s", langList);
	} else if (strcmp(argv[2], "java") == 0) {
		sprintf(buildcmd, "javac %s", filename);
		sprintf(runcmd, "java uroboros %s", langList);
	} else if (strcmp(argv[2], "py") == 0) {
		sprintf(buildcmd, "echo");
		sprintf(runcmd, "python %s %s", filename, langList);
	} else {
		printf("Not prepared for language: %s\n", argv[1]);
		return 1;
	}
	
	generateContent(nextLang);
	
	// if the next lang is the starting lang, print what we would have written
	if (strcmp(argv[2], argv[1]) == 0) {
		printf(nextLang);
		return 0;
	}
	
	FILE *f = fopen(filename, "w");
	fprintf(f, nextLang);
	fclose(f);
	
	system(buildcmd);
	system(runcmd);
	return 0;
}
