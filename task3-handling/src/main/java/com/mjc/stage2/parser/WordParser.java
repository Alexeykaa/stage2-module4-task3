package com.mjc.stage2.parser;


import com.mjc.stage2.entity.AbstractTextComponent;
import com.mjc.stage2.entity.SymbolLeaf;
import com.mjc.stage2.entity.TextComponentType;

public class WordParser extends AbstractTextParser {
    @Override
    public void parse(AbstractTextComponent component, String text) {
        if (component.getComponentType() == TextComponentType.WORD) {
            char[] symbols = text.toCharArray();
            for (char symbol : symbols) {
                SymbolLeaf symbolComponent = new SymbolLeaf(symbol);
                component.add(symbolComponent);
            }
        } else {
            doNextParse(component, text);
        }
    }
}
