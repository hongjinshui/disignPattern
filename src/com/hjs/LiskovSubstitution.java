package com.hjs;

import java.util.HashMap;
import java.util.Map;

interface Person{

}

class Father implements Person{
    public void doSomething(Map param){
        System.out.println("父类方法执行了");
    }
}

class Son extends Father{
    public void doSomething(HashMap param){ // 替换成Object再试试
        System.out.println("子类方法执行了");
    }
}
public class LiskovSubstitution {

    public static void main(String[] args) {
        Father father = new Father();
        Son son = new Son();
        HashMap p = new HashMap();
        father.doSomething(p);
        son.doSomething(p);
    }
}
