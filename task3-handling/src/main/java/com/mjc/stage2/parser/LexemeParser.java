package com.mjc.stage2.parser;

import com.mjc.stage2.entity.AbstractTextComponent;
import com.mjc.stage2.entity.SymbolLeaf;
import com.mjc.stage2.entity.TextComponent;
import com.mjc.stage2.entity.TextComponentType;

public class LexemeParser extends AbstractTextParser {
    private static final String LEXEME_REGEX = "\\s+";
    private static final String WORD_REGEX = "\\(*\\w[\\w!=?():.,\\-']+";

    @Override
    public void parse(AbstractTextComponent sentenceComponent, String text) {
        if (sentenceComponent.getComponentType() == TextComponentType.SENTENCE) {
            String[] lexemes = text.split(LEXEME_REGEX);
            for (String lexeme : lexemes) {
                AbstractTextComponent component;
                if (lexeme.matches(WORD_REGEX)) {
                    component = new TextComponent(TextComponentType.WORD);
                } else {
                    component = new SymbolLeaf(lexeme.charAt(0));
                }
                sentenceComponent.add(component);
                doNextParse(component, lexeme);
            }
        } else {
            doNextParse(sentenceComponent, text);
        }
    }
}
