#include <cstdio>

int main(int argc, char *argv[])
{
  FILE * pFile;
  int c;
  pFile=fopen (" c.c  ","r");
  if (pFile==NULL) perror ("Error opening file");
  else
  {
    do {
      c = getc (pFile);
      printf("%c",c);
    } while (c != EOF);
    fclose (pFile);
  }
  return 0;

}
