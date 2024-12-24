package com.solvd.deliveryservice.utils;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;

public class TextParser {
    private final static Logger logger = LogManager.getLogger(TextParser.class.getName());

    public TextParser() {}

    public static void parse() {
        try {
            String content = FileUtils.readFileToString(new File("input.txt"), "UTF-8").toLowerCase().replaceAll(",","").replaceAll("\\.","");
            HashSet<String> unique = new HashSet<>();
            for(String str : StringUtils.split(content)) {
                if (unique.add(str)) {
                    int count = StringUtils.countMatches(content, str);
                    FileUtils.writeStringToFile(new File("output.txt"), str + " " + count + "\n", "UTF-8", true);
                }
            }
        } catch (IOException e) {
            logger.info(e.getMessage());
        }
    }
}
