package PlayWithCompiler.chap02;

import java.io.*;

import static org.glassfish.grizzly.http.util.Ascii.isAlpha;
import static org.glassfish.grizzly.http.util.Ascii.isDigit;

/**
 * @description:
 * @author: LiYuan
 * @version: 1.0
 * @create: 2019-10-26
 **/
public class LexicalAnalysis {
    public enum DfaState {
        Initial,
        Id,
        IntLiteral,
        GT,
        GE,
        Id_int1,
        Id_int2,
        Id_int3,
        Assignment,
        Op,
        SemiColon
    }

    public enum TokenType {
        Initial,
        Identifier,
        IntLiteral,
        GT,
        GE,
        Int,
        Assignment,
        Plus,
        Minus,
        Star,
        Slash,
        SemiColon
    }

    public static class Token {
        TokenType type;
        StringBuffer text = new StringBuffer();

        public Token() {
            type = TokenType.Initial;
        }
    }

    DfaState state = DfaState.Initial;
    Token token = new Token();

    public static void main(String[] args) throws Exception {
        LexicalAnalysis lex = new LexicalAnalysis();
        lex.readLinesAndParse();
    }

    public void readLinesAndParse() throws Exception {
        BufferedReader br = null;

        String path = System.getProperty("user.dir");
        String file = path + File.separator + "src/main/java/PlayWithCompiler/chap02/aa.txt";

        try
        {
            FileInputStream fis = new FileInputStream(file);

            //��Sytem.in����ת����Reader����
            InputStreamReader reader = new InputStreamReader(fis);
            //����ͨReader��װ��BufferedReader
            br = new BufferedReader(reader);

            String buffer = null;
            //����ѭ����ʽ��һ��һ�еĶ�ȡ
            while ((buffer = br.readLine()) != null)
            {
                //�����ȡ���ַ���Ϊ"exit"�������˳�
                if (buffer.equals("exit"))
                {
                    System.exit(1);
                }
                //��ӡ��ȡ������
                System.out.println("��������Ϊ:" + buffer);
                parseLine(buffer);
                System.out.println();
            }
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
        }
        //�ر�������
        finally
        {
            try
            {
                br.close();
            }
            catch (IOException ioe)
            {
                ioe.printStackTrace();
            }
        }
    }

    public DfaState initToken(char ch) {
        DfaState newState = DfaState.Initial;
        token.text = new StringBuffer();
        if (isAlpha(ch)) {
            if (ch == 'i') {
                newState = DfaState.Id_int1;
            } else {
                newState = DfaState.Id;
            }
            token.type = TokenType.Identifier;
            token.text.append(ch);
        } else if (isDigit(ch)) {
            newState = DfaState.IntLiteral;
            token.type = TokenType.Initial;
            token.text.append(ch);
        } else if (ch == '>') {
            newState = DfaState.GT;
            token.type = TokenType.GT;
            token.text.append(ch);
        } else if (ch == '=') {
            newState = DfaState.Assignment;
            token.type = TokenType.Assignment;
            token.text.append(ch);
        } else if (ch == '+') {
            newState = DfaState.Op;
            token.type = TokenType.Plus;
            token.text.append(ch);
        } else if (ch == '-') {
            newState = DfaState.Op;
            token.type = TokenType.Minus;
            token.text.append(ch);
        } else if (ch == '*') {
            newState = DfaState.Op;
            token.type = TokenType.Star;
            token.text.append(ch);
        } else if (ch == '/') {
            newState = DfaState.Op;
            token.type = TokenType.Slash;
            token.text.append(ch);
        } else if (ch == ';') {
            newState = DfaState.SemiColon;
            token.type = TokenType.SemiColon;
            token.text.append(ch);
        }

        state = newState;
        return newState;
    }

    public void parseLine(String line) {
     //   line = line + "\n";
        token = new Token();

        for (int i = 0; i < line.length(); i++ ) {
            char ch = line.charAt(i);
            switch (state) {
                case Initial:
                    initToken(ch);
                    break;
                case Id:
                    if (isAlpha(ch) || isDigit(ch)) {
                        // ���ֱ�ʶ��״̬
                        token.text.append(ch);
                    } else {
                        System.out.println(token.type + "    " + token.text.toString());
                        state = initToken(ch);
                    }
                    break;
                case GT:
                    if (ch == '=') {
                        // ת����GE
                        token.type = TokenType.GE;
                        state = DfaState.GE;
                        token.text.append(ch);
                    } else {
                        System.out.println(token.type + "    " + token.text.toString());
                        state = initToken(ch);
                    }
                    break;
                case GE:
                    System.out.println(token.type + "    " + token.text.toString());
                    state = initToken(ch);
                    break;
                case IntLiteral:
                    if (isDigit(ch)) {
                        token.text.append(ch);
                    } else {
                        System.out.println(token.type + "    " + token.text.toString());
                        state = initToken(ch);
                    }
                    break;
                case Id_int1:
                    if (ch == 'n') {
                        state = DfaState.Id_int2;
                        token.text.append(ch);
                    } else if (isDigit(ch) || isAlpha(ch)) {
                        state = DfaState.Id;
                        token.text.append(ch);
                    } else {
                        System.out.println(token.type + "    " + token.text.toString());
                        state = initToken(ch);
                    }
                    break;
                case Id_int2:
                    if (ch == 't') {
                        state = DfaState.Id_int3;
                        token.text.append(ch);
                    } else if (isDigit(ch) || isAlpha(ch)) {
                        state = DfaState.Id;
                        token.text.append(ch);
                    } else {
                        System.out.println(token.type + "    " + token.text.toString());
                        state = initToken(ch);
                    }
                    break;
                case Id_int3:
                    if (isBlank(ch)) {
                        token.type = TokenType.Int;
                        System.out.println(token.type + "    " + token.text.toString());
                        state = initToken(ch);
                    } else {
                        state = DfaState.Id;
                        token.text.append(ch);
                    }
                    break;
                case Assignment:
                    System.out.println(token.type + "    " + token.text.toString());
                    state = initToken(ch);
                    break;
                case Op:
                    System.out.println(token.type + "    " + token.text.toString());
                    state = initToken(ch);
                    break;
                case SemiColon:
                    System.out.println(token.type + "    " + token.text.toString());
                    state = initToken(ch);
                    break;
            }
        }

        if (token.text.length() > 0) {
            System.out.println(token.type + "    " + token.text.toString());
        }


    }

    private Boolean isBlank(char ch) {
        if (ch == ' ' || ch == '\t' || ch == '\n') {
            return true;
        } else {
            return false;
        }
    }

}












