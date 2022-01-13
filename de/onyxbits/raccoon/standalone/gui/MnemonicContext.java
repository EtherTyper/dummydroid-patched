package de.onyxbits.raccoon.standalone.gui;

import javax.swing.AbstractButton;

public class MnemonicContext {
   private boolean[] taken = new boolean[128];

   public void assign(AbstractButton ab) {
      char[] name = ab.getText().toCharArray();
      char[] var3 = name;
      int var4 = name.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         char c = var3[var5];
         int kc = this.toKeyCode(c);
         if (kc > -1 && !this.taken[c]) {
            this.strikeOut(c);
            ab.setMnemonic(kc);
            break;
         }
      }

   }

   private int toKeyCode(char c) {
      switch(c) {
      case '0':
         return 48;
      case '1':
         return 49;
      case '2':
         return 50;
      case '3':
         return 51;
      case '4':
         return 52;
      case '5':
         return 53;
      case '6':
         return 54;
      case '7':
         return 55;
      case '8':
         return 56;
      case '9':
         return 57;
      case ':':
      case ';':
      case '<':
      case '=':
      case '>':
      case '?':
      case '@':
      case '[':
      case '\\':
      case ']':
      case '^':
      case '_':
      case '`':
      default:
         return -1;
      case 'A':
      case 'a':
         return 65;
      case 'B':
      case 'b':
         return 66;
      case 'C':
      case 'c':
         return 67;
      case 'D':
      case 'd':
         return 68;
      case 'E':
      case 'e':
         return 69;
      case 'F':
      case 'f':
         return 70;
      case 'G':
      case 'g':
         return 71;
      case 'H':
      case 'h':
         return 72;
      case 'I':
      case 'i':
         return 73;
      case 'J':
      case 'j':
         return 74;
      case 'K':
      case 'k':
         return 75;
      case 'L':
      case 'l':
         return 76;
      case 'M':
      case 'm':
         return 77;
      case 'N':
      case 'n':
         return 78;
      case 'O':
      case 'o':
         return 79;
      case 'P':
      case 'p':
         return 80;
      case 'Q':
      case 'q':
         return 81;
      case 'R':
      case 'r':
         return 82;
      case 'S':
      case 's':
         return 83;
      case 'T':
      case 't':
         return 84;
      case 'U':
      case 'u':
         return 85;
      case 'V':
      case 'v':
         return 86;
      case 'W':
      case 'w':
         return 87;
      case 'X':
      case 'x':
         return 88;
      case 'Y':
      case 'y':
         return 89;
      case 'Z':
      case 'z':
         return 90;
      }
   }

   private void strikeOut(char c) {
      switch(c) {
      case '0':
         this.taken[48] = true;
         break;
      case '1':
         this.taken[49] = true;
         break;
      case '2':
         this.taken[50] = true;
         break;
      case '3':
         this.taken[51] = true;
         break;
      case '4':
         this.taken[52] = true;
         break;
      case '5':
         this.taken[53] = true;
         break;
      case '6':
         this.taken[54] = true;
         break;
      case '7':
         this.taken[55] = true;
         break;
      case '8':
         this.taken[56] = true;
         break;
      case '9':
         this.taken[57] = true;
      case ':':
      case ';':
      case '<':
      case '=':
      case '>':
      case '?':
      case '@':
      case '[':
      case '\\':
      case ']':
      case '^':
      case '_':
      case '`':
      default:
         break;
      case 'A':
      case 'a':
         this.taken[65] = true;
         this.taken[97] = true;
         break;
      case 'B':
      case 'b':
         this.taken[66] = true;
         this.taken[98] = true;
         break;
      case 'C':
      case 'c':
         this.taken[67] = true;
         this.taken[99] = true;
         break;
      case 'D':
      case 'd':
         this.taken[68] = true;
         this.taken[100] = true;
         break;
      case 'E':
      case 'e':
         this.taken[69] = true;
         this.taken[101] = true;
         break;
      case 'F':
      case 'f':
         this.taken[70] = true;
         this.taken[102] = true;
         break;
      case 'G':
      case 'g':
         this.taken[71] = true;
         this.taken[103] = true;
         break;
      case 'H':
      case 'h':
         this.taken[72] = true;
         this.taken[104] = true;
         break;
      case 'I':
      case 'i':
         this.taken[73] = true;
         this.taken[105] = true;
         break;
      case 'J':
      case 'j':
         this.taken[74] = true;
         this.taken[106] = true;
         break;
      case 'K':
      case 'k':
         this.taken[75] = true;
         this.taken[107] = true;
         break;
      case 'L':
      case 'l':
         this.taken[76] = true;
         this.taken[108] = true;
         break;
      case 'M':
      case 'm':
         this.taken[77] = true;
         this.taken[109] = true;
         break;
      case 'N':
      case 'n':
         this.taken[78] = true;
         this.taken[110] = true;
         break;
      case 'O':
      case 'o':
         this.taken[79] = true;
         this.taken[111] = true;
         break;
      case 'P':
      case 'p':
         this.taken[80] = true;
         this.taken[112] = true;
         break;
      case 'Q':
      case 'q':
         this.taken[81] = true;
         this.taken[113] = true;
         break;
      case 'R':
      case 'r':
         this.taken[82] = true;
         this.taken[114] = true;
         break;
      case 'S':
      case 's':
         this.taken[83] = true;
         this.taken[115] = true;
         break;
      case 'T':
      case 't':
         this.taken[84] = true;
         this.taken[116] = true;
         break;
      case 'U':
      case 'u':
         this.taken[85] = true;
         this.taken[117] = true;
         break;
      case 'V':
      case 'v':
         this.taken[86] = true;
         this.taken[118] = true;
         break;
      case 'W':
      case 'w':
         this.taken[87] = true;
         this.taken[119] = true;
         break;
      case 'X':
      case 'x':
         this.taken[88] = true;
         this.taken[120] = true;
         break;
      case 'Y':
      case 'y':
         this.taken[89] = true;
         this.taken[121] = true;
         break;
      case 'Z':
      case 'z':
         this.taken[90] = true;
         this.taken[122] = true;
      }

   }
}
