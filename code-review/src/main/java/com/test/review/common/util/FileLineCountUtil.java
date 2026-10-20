package com.test.review.common.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileLineCountUtil {

    /**
     * 统计目录下所有文件代码总行数
     *
     * @param directory
     * @return
     */
    public static Integer countLinesInDirectory(File directory) {
        Integer totalLines = 0;
        // 获取目录中的所有文件和子目录
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    // 递归调用，处理子目录
                    totalLines += countLinesInDirectory(file);
                } else if (file.isFile()) {
                    // 统计文件的行数
                    int sum = countLinesInFile(file);
                    totalLines += sum;
                }
            }
        }
        return totalLines;
    }


    /**
     * 统计文件行数
     *
     * @param file
     * @return
     */
    public static Integer countLinesInFile(File file) {
        if (!file.exists()) {
            return null;
        }
        Integer lines = 0;
        // 读取文件并统计行数
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            while (reader.readLine() != null) {
                lines++;
            }
        } catch (IOException e) {
            System.err.println("无法读取文件: " + file.getAbsolutePath());
            e.printStackTrace();
        }

        return lines;
    }

}
