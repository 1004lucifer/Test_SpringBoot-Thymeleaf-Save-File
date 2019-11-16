package kr.co._1004lucifer.test.tymeleaf.savefile;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

@SpringBootTest
class ThymeleafFileWriterTest {

    @Autowired
    TemplateEngine templateEngine;

    /**
     * Thymeleaf를 이용해서 HTML 파일을 저장시키는 테스트
     */
    @Test
    public void writeThymeleaf2HtmlFile() throws IOException {
        String filepath = System.getProperty("user.home") + "/hello-thymeleaf.html";

        Context context = new Context();
        context.setVariable("title", "User Page");
        context.setVariable("name", "John Doe");
        Writer writer = new FileWriter(filepath);
        writer.write(templateEngine.process("sample.html", context));
        writer.close();

        File file = new File(filepath);
        Assertions.assertTrue(file.length() > 0);
        Assertions.assertTrue(file.delete());
    }
}
