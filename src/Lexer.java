public class Lexer {

    public static String linha;
    public static int indexOfLinha = 0;
    public static Character charAtIndex;
    public static String token;
    public static String lexema = "";
    public static int tokenID;

    public static void main(String[] args) {


    linha = "r1234+";

    while (indexOfLinha<linha.length()) {
        lex();
        System.out.println("Token: " + token + " - Lexema: " + lexema + " TokenID: " + tokenID);
        lexema="";

    }


    }

    public static void lex(){
        charAtIndex = linha.charAt(indexOfLinha);
        if (Character.isLetter(charAtIndex)){
            token = "IDENT";
            tokenID = 1;

            while (indexOfLinha < linha.length()-1 && (Character.isLetter(charAtIndex) || Character.isDigit(charAtIndex))){
                lexema = lexema + charAtIndex;
                indexOfLinha++;
                charAtIndex = linha.charAt(indexOfLinha);
            }
            lexema = lexema + charAtIndex;
            indexOfLinha++;
        }



        if (indexOfLinha < linha.length()-1) {
            charAtIndex = linha.charAt(indexOfLinha);
        }

        else charAtIndex = null;

        if (charAtIndex!=null) {
            if (Character.isDigit(charAtIndex)) {
                token = "INT_LIT";
                tokenID = 2;

                while (indexOfLinha < linha.length() - 1 && Character.isDigit(charAtIndex)) {
                    lexema = lexema + charAtIndex;
                    indexOfLinha++;
                    charAtIndex = linha.charAt(indexOfLinha);
                }

                lexema = lexema + charAtIndex;
                indexOfLinha++;

                if (indexOfLinha < linha.length()-1) {
                    charAtIndex = linha.charAt(indexOfLinha);
                }

                else {charAtIndex = null; indexOfLinha++;}

            } else {
                charAtIndex = linha.charAt(indexOfLinha);
                //se estiver em um espaço
                while (Character.isSpaceChar(charAtIndex)) {
                    indexOfLinha++;
                }

                if (linha.charAt(indexOfLinha) == '(') {
                    token = "LPAREN";
                    tokenID = 3;
                    lexema = lexema + charAtIndex;
                    indexOfLinha++;
                }

                if (linha.charAt(indexOfLinha) == ')') {
                    token = "RPAREN";
                    tokenID = 4;
                    lexema = lexema + charAtIndex;
                    indexOfLinha++;
                }

                if (linha.charAt(indexOfLinha) == '+') {
                    token = "ADD_OP";
                    tokenID = 5;
                    lexema = lexema + charAtIndex;
                    indexOfLinha++;
                }

                if (linha.charAt(indexOfLinha) == '-') {
                    token = "SUB_OP";
                    tokenID = 6;
                    lexema = lexema + charAtIndex;
                    indexOfLinha++;
                }

                if (linha.charAt(indexOfLinha) == '*') {
                    token = "MUL_OP";
                    tokenID = 7;
                    lexema = lexema + charAtIndex;
                    indexOfLinha++;
                }

                if (linha.charAt(indexOfLinha) == '/') {
                    token = "DIV_OP";
                    tokenID = 8;
                    lexema = lexema + charAtIndex;
                    indexOfLinha++;
                }

                if (linha.charAt(indexOfLinha) == '>') {
                    token = "GT_OP";
                    tokenID = 9;
                    lexema = lexema + charAtIndex;
                    indexOfLinha++;
                }

                if (linha.charAt(indexOfLinha) == '<') {
                    token = "LT_OP";
                    tokenID = 10;
                    lexema = lexema + charAtIndex;
                    indexOfLinha++;
                }

                if (linha.charAt(indexOfLinha) == '=' && linha.charAt(indexOfLinha + 1) == '=') {
                    token = "EQ_OP";
                    tokenID = 11;
                    lexema = lexema + charAtIndex + linha.charAt(indexOfLinha + 1);
                    indexOfLinha++;
                    indexOfLinha++;
                }

                if (linha.charAt(indexOfLinha) == ':' && linha.charAt(indexOfLinha + 1) == '=') {
                    token = "ASSIGN_OP";
                    tokenID = 12;
                    lexema = lexema + charAtIndex + linha.charAt(indexOfLinha + 1);
                    indexOfLinha++;
                    indexOfLinha++;
                }

            }
        }
    }

}
