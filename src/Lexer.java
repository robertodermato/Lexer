public class Lexer {

    public static String linha;
    public static int indexOfLinha = 0;
    public static String token;
    public static String lexema = "";
    public static int tokenID;

    public static void main(String[] args) {

    linha = "1234 123 +-";

    while (indexOfLinha<linha.length()) {
        lex();
        if (lexema=="") lex();
        System.out.println("Token: " + token + " - Lexema: " + lexema + " TokenID: " + tokenID);
        lexema="";
    }


    }

    public static void lex(){

        //Crias os ident
        if (Character.isLetter(linha.charAt(indexOfLinha))){
            token = "IDENT";
            tokenID = 1;

            while (indexOfLinha < linha.length() && (Character.isLetter(linha.charAt(indexOfLinha)) || Character.isDigit(linha.charAt(indexOfLinha)))){
                lexema = lexema + linha.charAt(indexOfLinha);
                indexOfLinha++;
            }
            return;
        }

        //cria os int
        if (Character.isDigit(linha.charAt(indexOfLinha))) {
            token = "INT_LIT";
            tokenID = 2;

            while (indexOfLinha < linha.length() && Character.isDigit(linha.charAt(indexOfLinha))) {
                lexema = lexema + linha.charAt(indexOfLinha);
                indexOfLinha++;
            }

            return;
        }

        //se estiver em um espaço
        while (Character.isSpaceChar(linha.charAt(indexOfLinha))) {
            indexOfLinha++;

        }

        if (linha.charAt(indexOfLinha) == '(') {
            token = "LPAREN";
            tokenID = 3;
            lexema = lexema + linha.charAt(indexOfLinha);
            indexOfLinha++;
            return;
        }

        if (linha.charAt(indexOfLinha) == ')') {
            token = "RPAREN";
            tokenID = 4;
            lexema = lexema + linha.charAt(indexOfLinha);
            indexOfLinha++;
            return;
        }

        if (linha.charAt(indexOfLinha) == '+') {
            token = "ADD_OP";
            tokenID = 5;
            lexema = lexema + linha.charAt(indexOfLinha);
            indexOfLinha++;
            return;
        }

        if (linha.charAt(indexOfLinha) == '-') {
            token = "SUB_OP";
            tokenID = 6;
            lexema = lexema + linha.charAt(indexOfLinha);
            indexOfLinha++;
            return;
        }

        if (linha.charAt(indexOfLinha) == '*') {
            token = "MUL_OP";
            tokenID = 7;
            lexema = lexema + linha.charAt(indexOfLinha);
            indexOfLinha++;
            return;
        }

        if (linha.charAt(indexOfLinha) == '/') {
            token = "DIV_OP";
            tokenID = 8;
            lexema = lexema + linha.charAt(indexOfLinha);
            indexOfLinha++;
            return;
        }

        if (linha.charAt(indexOfLinha) == '>') {
            token = "GT_OP";
            tokenID = 9;
            lexema = lexema + linha.charAt(indexOfLinha);
            indexOfLinha++;
            return;
        }

        if (linha.charAt(indexOfLinha) == '<') {
            token = "LT_OP";
            tokenID = 10;
            lexema = lexema + linha.charAt(indexOfLinha);
            indexOfLinha++;
            return;
        }

        if (linha.charAt(indexOfLinha) == '=' && linha.charAt(indexOfLinha + 1) == '=') {
            token = "EQ_OP";
            tokenID = 11;
            lexema = lexema + linha.charAt(indexOfLinha) + linha.charAt(indexOfLinha + 1);
            indexOfLinha++;
            indexOfLinha++;
            return;
        }

        if (linha.charAt(indexOfLinha) == ':' && linha.charAt(indexOfLinha + 1) == '=') {
            token = "ASSIGN_OP";
            tokenID = 12;
            lexema = lexema + linha.charAt(indexOfLinha) + linha.charAt(indexOfLinha + 1);
            indexOfLinha++;
            indexOfLinha++;
            return;
        }

    }

}


