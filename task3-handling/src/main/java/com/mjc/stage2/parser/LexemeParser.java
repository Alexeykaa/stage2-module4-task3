package com.mjc.stage2.parser;

import com.mjc.stage2.entity.AbstractTextComponent;
import com.mjc.stage2.entity.TextComponent;
import com.mjc.stage2.entity.TextComponentType;

public class LexemeParser extends AbstractTextParser {
    private static final String LEXEME_REGEX = "\\s+";
    private static final String WORD_REGEX = "\\w[\\w!=?():]+";

    @Override
    public void parse(AbstractTextComponent component, String text) {
        if (component.getComponentType() == TextComponentType.SENTENCE) {
            String[] lexemes = text.split(LEXEME_REGEX);
            for (String lexeme : lexemes) {
                String[] words = lexeme.split(WORD_REGEX);
                for (String word : words) {
                    AbstractTextComponent wordComponent = new TextComponent(TextComponentType.WORD);
                    component.add(wordComponent);
                    doNextParse(component, word);
                }
            }
        } else {
            doNextParse(component, text);
        }
    }
}
