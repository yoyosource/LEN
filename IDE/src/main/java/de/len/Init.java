package de.len;

import yapion.annotations.registration.YAPIONAccessGenerator;
import yapion.hierarchy.types.YAPIONValue;
import yapion.parser.YAPIONParser;

import java.util.ArrayList;
import java.util.List;

public class Init {

    @YAPIONAccessGenerator(lombokToString = true)
    private static final String flavour = "src/main/resources/flavour.yapion";

    public static List<Flavour> flavourList = new ArrayList<>();

    public static void main(String[] args) {
        YAPIONParser.parse(Init.class.getResourceAsStream("/flavours.yapion")).getArray("").forEach(yapionAnyType -> {
            String flavour = ((YAPIONValue<String>) yapionAnyType).get();
            flavourList.add(new Flavour(YAPIONParser.parse(Init.class.getResourceAsStream("/flavours/" + flavour + ".flavour"))));
        });
        flavourList.forEach(System.out::println);

        IDE ide = new IDE();
    }
}
