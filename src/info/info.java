package info;

import java.io.Serializable;

public class info implements Serializable {

	private static final long serialVersionUID = 8683452581334592189L;
	public String name;
	public String id;
	public String password;
	public int state;//200 -- ������   302 --δ��¼   404 --�˳�
	public String msg;
	public info(){
		this.state=302;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "name:" + name;
	}
}
/* msg �洢��ѯ��Ϣ
 * <FIND>(msg)[code]   msg �����������/������/����       100 ��ʾ��������   200��������ѯ  300 ���Ͳ�ѯ 
 * <CHANGEBOOK>(msg)[code]		ID �������    msg ����ֵ     code  �������� 100 ɾ��   200 ���  300 �޸�  301 �޸�����   302 �޸��鱾����  303 �޸�������   400 �鱾���� 401 ����  402 ���飨�˴�msg��¼����ID�� 
 * 
 * 
 */