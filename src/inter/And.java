package inter;

import lexer.Token;

public class And extends Logical{
	public And(Token tok, Expr x1, Expr x2) { super(tok,x1,x2);}

	// B = B1 && B2
	// t��f��ʾB��true���ں�false����
	public void jumping(int t, int f){
		// ����t��f������������0 ��B1Ϊ�� ��BΪ�� B1��false����Ϊf��true���ڶ�ӦB2��һ��ָ��
		// һ�������B��false����f����Ϊ0 ����label��֤B1��false���ڱ�����ΪB�Ĵ���Ľ�β��
		int label = f != 0 ? f : newlabel();
		expr1.jumping(0,label);
		expr2.jumping(t,f);
		if ( f == 0 ) emitlabel(label); // fΪ������0 ����label
	}

}
