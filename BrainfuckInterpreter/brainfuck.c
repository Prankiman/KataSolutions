// void brainfuck(const char *code, const char *input, char *output)
// code - The Brainfuck program to be executed
// input - A stream of input bytes to the Brainfuck program being executed
// output - A writable character buffer large enough to hold the expected output of the
//          Brainfuck program being executed
// Your task: Execute the Brainfuck program with the given input, writing the program output
// to the output buffer provided as a NUL-terminated C-string
#include <stdlib.h>
#include <stdio.h>


void brainfuck(const char *code, const char *input, char *output) {
  
  char *output_start = output;
          
  unsigned char* dp = (unsigned char*)malloc(10000 * sizeof(char));

  while (*code){
    switch (*code){
      case ',':
        *dp = *input;
        input++;
        break;
      case '.':
        *output = *dp;
        output++;
        break;
      case '>':
        dp++;
        break;
      case '<':
        dp--;
        break;
      case '+':
        (*dp)++;
        break;
      case '-':
        (*dp)--;
        break;
      case '[':
        if (*dp == 0){
          int open_count = 1;
          int closed_count = 0;
          while (open_count != closed_count){
            if (*++code == '[')
              open_count++;
            else if (*code == ']')
              closed_count++;
          }
        }
        break;
      case ']':
        if (*dp != 0){
          int open_count = 0;
          int closed_count = 1;
          while (open_count != closed_count){
            if (*--code == '[')
              open_count++;
            else if (*code == ']')
              closed_count++;
          }
        }
      break;
    }
    code++;
  }
  *output = '\0';
  printf("output %s\n", output_start);
}
