package com.hjs.pattern.p17.chain_of_responsibility;

public class LeaveApprovalTest {
    public static void main(String[] args) {
        //��װ������
        Leader teacher1 = new ClassAdviser();
        Leader teacher2 = new DepartmentHead();
        Leader teacher3 = new Dean();
        //Leader teacher4=new DeanOfStudies();
        teacher1.setNext(teacher2);
        teacher2.setNext(teacher3);
        //teacher3.setNext(teacher4);
        //�ύ����
        teacher1.handleRequest(8);
    }
}

//�������ߣ��쵼��
abstract class Leader {
    private Leader next;

    public void setNext(Leader next) {
        this.next = next;
    }

    public Leader getNext() {
        return next;
    }

    //��������ķ���
    public abstract void handleRequest(int LeaveDays);
}

//���崦����1����������
class ClassAdviser extends Leader {
    public void handleRequest(int LeaveDays) {
        if (LeaveDays <= 2) {
            System.out.println("��������׼�����" + LeaveDays + "�졣");
        } else {
            if (getNext() != null) {
                getNext().handleRequest(LeaveDays);
            } else {
                System.out.println("�������̫�࣬û������׼�ü�����");
            }
        }
    }
}

//���崦����2��ϵ������
class DepartmentHead extends Leader {
    public void handleRequest(int LeaveDays) {
        if (LeaveDays <= 7) {
            System.out.println("ϵ������׼�����" + LeaveDays + "�졣");
        } else {
            if (getNext() != null) {
                getNext().handleRequest(LeaveDays);
            } else {
                System.out.println("�������̫�࣬û������׼�ü�����");
            }
        }
    }
}

//���崦����3��Ժ����
class Dean extends Leader {
    public void handleRequest(int LeaveDays) {
        if (LeaveDays <= 10) {
            System.out.println("Ժ����׼�����" + LeaveDays + "�졣");
        } else {
            if (getNext() != null) {
                getNext().handleRequest(LeaveDays);
            } else {
                System.out.println("�������̫�࣬û������׼�ü�����");
            }
        }
    }
}

//���崦����4�����񴦳���
class DeanOfStudies extends Leader {
    public void handleRequest(int LeaveDays) {
        if (LeaveDays <= 20) {
            System.out.println("���񴦳���׼�����" + LeaveDays + "�졣");
        } else {
            if (getNext() != null) {
                getNext().handleRequest(LeaveDays);
            } else {
                System.out.println("�������̫�࣬û������׼�ü�����");
            }
        }
    }
}

