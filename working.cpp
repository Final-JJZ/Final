#include<iostream>
#include <cstdio>
#include<fstream>

int main(int argc, char *argv[])
{
  ofstream outputFile;
  int c;
  outputFile.open(" c.c  ");
  if (outputFile==NULL) 
  cout<<"Error opening file"<<endl;
  else
  {
    do {
      outputFile<<c;
    } while (c != EOF);
    outputFile.close();
  }
  return 0;

}
