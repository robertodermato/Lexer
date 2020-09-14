/**
 * This is the example lexical analyzer code in pages 173 - 177 of the
 * textbook, Sebesta, R. W. (2012). Concepts of Programming Languages.
 * Pearson, 10th edition.
 *
 * This was translated to Java by Roberto Rezende and Lucas Cardoso
 */

/* front.c - a lexical analyzer system for simple arithmetic expressions */

public class Main {

    /* Global declarations */
    /* Variables */
    public static int charClass;
    public static String lexeme = "";
    public static String line = "";
    public static Character nextChar;
    public static int lexemaLength;
    public static int nextToken;
    public static char [] lineToChars;
    public static int indexOfLine = 0;


    /* Character classes */
    public static int LETTER =  0;
    public static int DIGIT = 1;
    public static int UNKNOWN = 99;

    /* Token codes */
    public static int INT_LIT = 10;
    public static int IDENT = 11;
    public static int ASSIGN_OP = 20;
    public static int ADD_OP = 21;
    public static int SUB_OP = 22;
    public static int MULT_OP = 23;
    public static int DIV_OP = 24;
    public static int LEFT_PAREN = 25;
    public static int RIGHT_PAREN = 26;

    public static void main(String[] args) {
        String arquivo = "arquivo.txt";
        line="Roberto";
        lineToChars = line.toCharArray();
        nextToken=99;
        if (arquivo == null) {
            System.out.println("ERROR - cannot open front.in \n");
        } else {
            System.out.println("Lexycal analyser");
            nextChar = lineToChars[0];
            //System.out.println(nextChar);
            getCharClass();
            //System.out.println(charClass);
            //executes lexycal analysis while the line has characters
            for (int i=0; i<line.length(); i++){
                lex();
            };
        }

    }
    /*****************************************************/
    /* getChar - a function to get the next character of input and determine its
     * character class */
    public static void getCharClass() {
        if (nextChar != null) {
            if (Character.isLetter(nextChar)){
                charClass = LETTER;
            System.out.println("Charclass is letter");}
            else if (Character.isDigit(nextChar)) {
                charClass = DIGIT;
                System.out.println("charclass is digit");
            }
            else {charClass = UNKNOWN;
                System.out.println("charclass is unkknown");}
        } else {
            charClass = 100;
            System.out.println("charclass is 100");
        }
    }

    /*****************************************************/
    /* lex - a simple lexical analyzer for arithmetic expressions */
    public static int lex() {
        lexemaLength = 0;
        getNonBlank();

        switch (charClass) {
            /* Parse identifiers */
            // Case 0 is for LETTER
            case 0:
                addChar();
                getCharClass();
                while (charClass == LETTER || charClass == DIGIT) {
                    indexOfLine ++;
                    if (indexOfLine < line.length()) {
                        nextChar = lineToChars[indexOfLine];
                        addChar();
                        getCharClass();
                    }
                }
                nextToken = IDENT;
                break;

            /* Parse integer literals */
            // Case 1 is for DIGIT
            case 1:
                //System.out.println("é número");
                addChar();
                //System.out.println("saiu");
                indexOfLine ++;
                if (indexOfLine < line.length()) nextChar = lineToChars[indexOfLine];
                getCharClass();
                while (charClass == DIGIT) {
                    indexOfLine ++;
                    if (indexOfLine < line.length()) {nextChar = lineToChars[indexOfLine];
                    addChar();
                    getCharClass();}
                    else break;
                }
                nextToken = INT_LIT;
                break;

            /* Parentheses and operators */
            // Case 99 is for UNKNOWN
            case 99:
                System.out.println("case 99");
                lookup(nextChar);
                getCharClass();
                break;

            case 100:
                break;

            /* EOF */
            //default:
              //  nextToken = 0;
                //lexeme[0] = 'E';
                //lexeme[1] = 'O';
                //lexeme[2] = 'F';
                //lexeme[3] = 0;
                //break;
        } /* End of switch */

        System.out.println("Next token is: " + nextToken + " Next lexeme is " + lexeme);
        return nextToken;
    }

    /*****************************************************/
    /* getNonBlank - a function to call getChar until it returns a non-whitespace
     * character */
    public static void getNonBlank() {
        while (Character.isSpaceChar(nextChar)) {getCharClass();
            System.out.println("pulando espaçõ branco");};
        System.out.println("getnonblasnk" + nextChar);
    }

    /*****************************************************/
    /* addChar - a function to add nextChar to lexeme */
    public static void addChar() {
        if (lexemaLength <= 100) {
            lexeme = lexeme + nextChar;
            System.out.println("Lexema do addchar: " + lexeme);
        } else {
            System.out.println("Error - lexeme is too long \n");
        }
    }

    /*****************************************************/
    /* lookup - a function to lookup operators and parentheses and return the
     * token */
    public static int lookup(char ch) {
        System.out.println("look");
        switch (ch) {
            case '(':
                addChar();
                nextToken = LEFT_PAREN;
                break;
            case ')':
                addChar();
                nextToken = RIGHT_PAREN;
                break;
            case '+':
                addChar();
                nextToken = ADD_OP;
                break;
            case '-':
                addChar();
                nextToken = SUB_OP;
                break;
            case '*':
                addChar();
                nextToken = MULT_OP;
                break;
            case '/':
                addChar();
                nextToken = DIV_OP;
                break;
            default:
                addChar();
                nextToken = 0;
                break;
        }
        return nextToken;
    }


}
