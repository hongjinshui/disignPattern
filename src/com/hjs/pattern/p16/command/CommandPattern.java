package com.hjs.pattern.p16.command;

/**
 * ���Command��ģʽ�Ķ������£���һ�������װΪһ������ʹ������������κ�ִ����������ηָ��
 * ��������֮��ͨ�����������й�ͨ���������㽫���������д��桢���ݡ����á����������
 *
 ** ����ģʽ����Ҫ�ŵ����£�
 *     1.ͨ�������м��������ӿڣ�����ϵͳ����϶ȡ�
 *     2.��չ�����ã����ӻ�ɾ������ǳ����㡣��������ģʽ������ɾ�������Ӱ�������࣬�����㡰����ԭ�򡱡�
 *     3.����ʵ�ֺ��������ģʽ���������ģʽ��ϣ����������װ���һ���������������
 *     4.����ʵ�� Undo �� Redo ����������ģʽ�����������ܵı���¼ģʽ��ϣ�ʵ������ĳ�����ָ���
 *     5.��������������Ļ����ϣ����Ӷ��⹦�ܡ�������־��¼�����װ����ģʽ�������
 * 
 * ��ȱ���ǣ�
 *     1.���ܲ�����������������ࡣ��Ϊÿһ�������������Ҫ���һ�����������࣬�������ϵͳ�ĸ����ԡ�
 *     2.����ģʽ�Ľ����ʵ���ǽ��շ���ִ�н��������Ϊ�����������ʽ���мܹ�������������ʵ�֣������˶������ͽṹ���������������������ӿڣ�������������ϵ����ѡ�������Ҳ�����ģʽ��ͨ���������Ȼ�������������������������϶��ȴ���ۺϸ�������⡣
 * 
 */
public class CommandPattern {
    public static void main(String[] args) {
        Command cmd = new ConcreteCommand();
        Invoker ir = new Invoker(cmd);
        System.out.println("�ͻ����ʵ����ߵ�call()����...");
        ir.call();
    }
}

//������
class Invoker {
    private Command command;

    public Invoker(Command command) {
        this.command = command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public void call() {
        System.out.println("������ִ������command...");
        command.execute();
    }
}

//��������
interface Command {
    public abstract void execute();
}

//��������
class ConcreteCommand implements Command {
    private Receiver receiver;

    ConcreteCommand() {
        receiver = new Receiver();
    }

    public void execute() {
        receiver.action();
    }
}

//������
class Receiver {
    public void action() {
        System.out.println("�����ߵ�action()����������...");
    }
}


