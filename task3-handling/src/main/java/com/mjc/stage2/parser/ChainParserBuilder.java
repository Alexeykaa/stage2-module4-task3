package com.mjc.stage2.parser;

import java.util.LinkedList;

public class ChainParserBuilder {
    private LinkedList<AbstractTextParser> parsers = new LinkedList<>();

    public ChainParserBuilder() {
    }

    public ChainParserBuilder setParser(AbstractTextParser abstractTextParser) {
        parsers.add(abstractTextParser);
        return this;
    }

    public AbstractTextParser build() {
        parsers.stream().reduce((a, i) -> {
            a.setNextParser(i);
            return i;
        });
        return parsers.getFirst();
    }
}
