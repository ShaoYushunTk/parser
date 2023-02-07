package inter;

import symbols.Type;
import lexer.Token;

public class Expr extends Node{ //���ʽ�ڵ�

	public Token op;  // ������
	public Type type; //����
	
	Expr(Token tok, Type p) { op = tok; type = p; }
	
	public Expr gen() { return this;} //��������ַ����Ҳ� ���� E = E1+E2������return x1+x2 ��x1,x2�ֱ��ӦE1��E2��ֵ�ĵ�ַ��
	public Expr reduce() { return this;} //���ر��ʽ��ַ��������id����ʱ��������������t��hold the value of E��
	
	/* boolean���ʽ����ת����ʵ�֣����ʽB��true���ں�false���ڷֱ�Ϊt��f
	 * ����t��ʾlabel true��f��ʾ label false
	 * label 0 ��ʾ�������ʽ��ĵ�һ��ָ�������
	 * B��ֵΪ�棬�����оͰ���һ��Ŀ��Ϊt����תָ�Ϊ�٣�����һ��Ŀ��Ϊf����תָ��
	 * ������0��ʾ��������B��Խ ����B�Ĵ���֮�����һ��ָ��
	 */
	public void jumping(int t, int f) {
		emitjumps(toString(),t,f);
	}
	public void emitjumps(String test, int t, int f){
		if ( t != 0 && f != 0){
			emit("if " + test + " goto L" + t);
			emit("goto L" + f);
		}
		else if ( t != 0){
			emit("if " + test + " goto L" + t);
		}
		else if ( f != 0){
			emit("iffalse " + test + " goto L" + f);
		}
		else ; //������ָ���Ϊt��f��ֱ�Ӵ�Խ
	}
	public String toString() { return op.toString(); }
	
}
