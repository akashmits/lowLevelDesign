package com.lld.lowleveldesign.solidPrincipal.dependancyInversion;

public class CharCopier {

    public void copy(Reader reader, Writer writer){
        char c='a';
        while((c=reader.getChar())!='0'){
        writer.putchar(c);
        }
    }
}
