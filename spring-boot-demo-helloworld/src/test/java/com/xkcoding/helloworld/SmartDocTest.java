package com.xkcoding.helloworld;

import com.power.common.util.DateTimeUtil;
import com.power.doc.builder.ApiDocBuilder;
import com.power.doc.builder.HtmlApiDocBuilder;
import com.power.doc.constants.DocGlobalConstants;
import com.power.doc.constants.DocLanguage;
import com.power.doc.model.ApiConfig;
import com.power.doc.model.ApiDataDictionary;
import com.power.doc.model.RevisionLog;
import com.xkcoding.helloworld.controller.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SmartDocTest {

    @Test
    public void testBuilderControllersApiSimple() {
        ApiConfig config = new ApiConfig();
        //服务地址
        config.setServerUrl("http://localhost:8080");
        //生成到一个文档
        config.setAllInOne(true);
        config.setProjectName("helloworld");
        config.setLanguage(DocLanguage.CHINESE);


        //采用严格模式
        config.isStrict();

        //变更记录
        config.setRevisionLogs(
            RevisionLog.getLog().setRevisionTime("2019/10/15").setAuthor("yf").setRemarks("测试1").setStatus("创建").setVersion("V1.0"),
            RevisionLog.getLog().setRevisionTime("2019/11/16").setAuthor("yf").setRemarks("测试2").setStatus("修改").setVersion("V2.0")
        );

        //文档输出路径
        config.setOutPath("D:\\workspace\\spring-boot-demo\\spring-boot-demo-helloworld\\doc");
        ApiDocBuilder.builderControllersApi(config); //生成markdown 使用ApiDocBuilder
        HtmlApiDocBuilder.builderControllersApi(config);//生成html 使用HtmlApiDocBuilder



        long start = System.currentTimeMillis();

        long end = System.currentTimeMillis();
        DateTimeUtil.printRunTime(end, start);



    }

}
