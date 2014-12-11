#include<iostream>
#include <cstdio>
#include<fstream>

int main(int argc, char *argv[])
{
  ofstream outputFile;
  int c;
  outputFile.open(" c.c  ","r");
  if (outputfile==NULL) perror ("Error opening file");
  else
  {
    do {
      c = getc (outputfile);
      printf("%c",c);
    } while (c != EOF);
    fclose (outputfile);
  }
  return 0;

}
