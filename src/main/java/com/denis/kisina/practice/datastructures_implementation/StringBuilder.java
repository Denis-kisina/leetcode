package com.denis.kisina.practice.datastructures_implementation;

public class StringBuilder {
    private static final int BUFFER_SIZE_MULTIPLIER = 2;
    private static final int DEFAULT_BUFFER_SIZE = 16;

    private char[] str;
    private int size;
    private int charCount;

    public StringBuilder() {
        this.size = BUFFER_SIZE_MULTIPLIER;
        this.str = new char[DEFAULT_BUFFER_SIZE];
    }

    /**
     *
     * @param str a charach array
     */
    public StringBuilder(char[] str) {
        this.str = str;
    }

    /**
     *
     * @param size a string containing the initial size of the buffer
     */
    public StringBuilder(int size) {
        this.size = size;
    }

    /**
     *
     * @param str
     */
    public StringBuilder(String str) {
        this.str = str.toCharArray();
    }

    public StringBuilder append(String str){
        while(resizeRequired(str)){
            resizeBuffer(str);
        }
        addString(str);
        updateCharCount(str.length());
        return this;
    }

    private void updateCharCount(int length) {
        this.charCount += length;
    }

    private void addString(String str) {
        System.arraycopy(str.toCharArray(), 0, this.str, this.charCount, str.length());
    }


    private void resizeBuffer(String str) {
        int oldSize = this.size;
        this.size *= BUFFER_SIZE_MULTIPLIER;
         char[] newStr = new char[this.size];
         System.arraycopy(this.str, 0, newStr, 0, oldSize);
         this.str = newStr;
    }

    private boolean resizeRequired(String newInput) {
        return this.charCount + newInput.length() > this.size;
    }

}
