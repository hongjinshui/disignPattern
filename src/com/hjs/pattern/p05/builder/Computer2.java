package com.hjs.pattern.p05.builder;

import java.util.HashMap;

public class Computer2 {

	private final String cpu;//����
    private final String ram;//����
    private final int usbCount;//��ѡ
    private final String keyboard;//��ѡ
    private final String display;//��ѡ

    @Override
	public String toString() {
		return "Computer [cpu=" + cpu + ", ram=" + ram + ", usbCount=" + usbCount + ", keyboard=" + keyboard
				+ ", display=" + display + "]";
	}

    private Computer2(Builder builder){
        this.cpu=builder.cpu;
        this.ram=builder.ram;
        this.usbCount=builder.usbCount;
        this.keyboard=builder.keyboard;
        this.display=builder.display;
    }
    
    static class Builder{
        private String cpu;//����
        private String ram;//����
        private int usbCount;//��ѡ
        private String keyboard;//��ѡ
        private String display;//��ѡ

        public Builder(String cup,String ram){
            this.cpu=cup;
            this.ram=ram;
        }

        public Builder setUsbCount(int usbCount) {
            this.usbCount = usbCount;
            return this;
        }
        public Builder setKeyboard(String keyboard) {
            this.keyboard = keyboard;
            return this;
        }
        public Builder setDisplay(String display) {
            this.display = display;
            return this;
        }        
        public Computer2 build(){
            return new Computer2(this);
        }
    }

    public static Builder builder(String cup, String ram){
        return new Builder(cup,ram);
    }
  //ʡ��getter����
}
