#include <stdint.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(int argc,char *argv[]) {

    system("rm -f uroboros.*");
    
    FILE *f = fopen("uroboros.java", "w");
    
    const char* c = ""
    const char* java = "public class uroboros {\n\tpublic static void main(String[] args) {\n\t\tSystem.out.println(\"%CCODE%\");\n\t}\n}";
    fprintf(f, java);
    
    fclose(f);
    
    system("javac uroboros.java");
    system("java uroboros");
    return 0;
}
