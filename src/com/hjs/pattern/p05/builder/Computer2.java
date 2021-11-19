package com.hjs.pattern.p05.builder;

import java.util.HashMap;

public class Computer2 {

	private final String cpu;//必须
    private final String ram;//必须
    private final int usbCount;//可选
    private final String keyboard;//可选
    private final String display;//可选

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
        private String cpu;//必须
        private String ram;//必须
        private int usbCount;//可选
        private String keyboard;//可选
        private String display;//可选

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
  //省略getter方法
}
