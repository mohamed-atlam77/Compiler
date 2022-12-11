import org.example.LexicalAnalyzer;
import org.example.TokenClass;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LexicalAnalyzerTest {
    @Test
    void test1(){
        TokenClass expected = TokenClass.ARITHMETIC_OPERATOR;
        TokenClass actual = LexicalAnalyzer.lexicalAnalyze("+");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void test2(){
        TokenClass expected = TokenClass.ARITHMETIC_OPERATOR;
        TokenClass actual =  LexicalAnalyzer.lexicalAnalyze("-");
        Assertions.assertEquals(expected, actual);

    }

    @Test
    void test3(){
        TokenClass expected = TokenClass.ARITHMETIC_OPERATOR;
        TokenClass actual = LexicalAnalyzer.lexicalAnalyze("*");
        Assertions.assertEquals(expected, actual);

    }

    @Test
    void test4(){
        TokenClass expected = TokenClass.ARITHMETIC_OPERATOR;
        TokenClass actual =LexicalAnalyzer.lexicalAnalyze("/");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void test5(){
        TokenClass expected = TokenClass.KEYWORD;
        TokenClass actual =LexicalAnalyzer.lexicalAnalyze("if");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void test6(){
        TokenClass expected = TokenClass.FLOAT;
        TokenClass actual =LexicalAnalyzer.lexicalAnalyze("123.");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void test7(){
        TokenClass expected = TokenClass.FLOAT;
        TokenClass actual =LexicalAnalyzer.lexicalAnalyze("123.045");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void test8(){
        TokenClass expected = TokenClass.IDENTIFIER;
        TokenClass actual =LexicalAnalyzer.lexicalAnalyze("amo_123");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void test9(){
        TokenClass expected = TokenClass.INTEGER;
        TokenClass actual =LexicalAnalyzer.lexicalAnalyze("97864");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void test10(){
        Assertions.assertEquals(TokenClass.COMPARISON_OPERATOR, LexicalAnalyzer.lexicalAnalyze(">"));
    }

    @Test
    void test11(){
        Assertions.assertEquals(TokenClass.COMPARISON_OPERATOR, LexicalAnalyzer.lexicalAnalyze("=="));
    }

    @Test
    void test12(){
        Assertions.assertEquals(TokenClass.ASSIGNMENT_OPERATOR, LexicalAnalyzer.lexicalAnalyze("="));
    }

    @Test
    void test13(){
        Assertions.assertEquals(TokenClass.SPECIAL_CHARACTER, LexicalAnalyzer.lexicalAnalyze("?"));
    }

    @Test
    void test14(){
        Assertions.assertEquals(TokenClass.SEMICOLON, LexicalAnalyzer.lexicalAnalyze(";"));
    }
}
