#include<iostream>
#include <cstdio>
#include<fstream>

int main(int argc, char *argv[])
{
  ofstream outputFile;
  int c;
  outputFile.open(" c.c  ","r");
  if (outputfile==NULL) 
  cout<<"Error opening file"<<endl;
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
