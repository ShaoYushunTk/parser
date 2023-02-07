package inter;

import symbols.Type;
import lexer.Num;
import lexer.Token;
import lexer.Word;
// ����
public class Constant extends Expr {

	   public Constant(Token tok, Type p) { super(tok, p); }
	   public Constant(int i) { super(new Num(i), Type.Int); } // ����һ����������һ����������

	   // ���徲̬����True��False
	   public static final Constant
	      True  = new Constant(Word.True,  Type.Bool),
	      False = new Constant(Word.False, Type.Bool);

	   public void jumping(int t, int f) {
		   // ����ó���Ϊ��̬����True �� t����������0 ��ô�ͻ�����һ��Ŀ��Ϊt����תָ��
		   if ( this == True && t != 0) emit("goto L" + t);
		   // ����ó���Ϊ��̬����False �� f����������0 ��ô�ͻ�����һ��Ŀ��Ϊf����תָ��
		   else if (this == False && f != 0) emit("goto L" + f);
	   }
	}

