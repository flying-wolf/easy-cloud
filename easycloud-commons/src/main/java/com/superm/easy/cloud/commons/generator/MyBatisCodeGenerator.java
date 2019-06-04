package com.superm.easy.cloud.commons.generator;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.apache.velocity.context.Context;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @program: easy-cloud
 * @description:
 * @author: Chao.Ma
 * @create: 2019-05-13 18:36
 **/
@Component
@ConditionalOnProperty(
        prefix = "spring.datasource",
        name = {"url", "username", "password", "driver-class-name"}
)
@ConditionalOnClass({AutoGenerator.class, Context.class})
public class MyBatisCodeGenerator {
    /**
     * JDBC相关配置
     */
    @Value("${spring.datasource.url}")
    private String URL;
    @Value("${spring.datasource.username}")
    private String USER_NAME;
    @Value("${spring.datasource.password}")
    private String PASSWORD;
    @Value("${spring.datasource.driver-class-name}")
    private String DRIVER;


    /**
     * 输出文件的路径
     */
    private static final String OUT_PATH = System.getProperty("user.dir") + "/src/main/java";
    /**
     * 代码生成者
     */
    private static final String AUTHOR = "Chao.Ma";

    /**
     * 表前缀
     */
    private static final String[] TABLE_PREFIXS = {"tb_", "unionpay_"};

    /**
     * @description: 根据数据表生成code
     * @param: [packageName, tableNames]
     * @return: void
     * @author: Chao.Ma
     * @date: 2019-05-14
     **/
    public void generateByTables(String packageName, String tableNames) {
        this.generateByTables(packageName, null, tableNames);
    }

    /**
     * @description: 根据数据表生成code
     * @param: [packageName, moduleName, tableNames]
     * @return: void
     * @author: Chao.Ma
     * @date: 2019-05-14
     **/
    public void generateByTables(String packageName, String moduleName, String... tableNames) {
        if (null == packageName || packageName.trim().length() == 0) {
            System.err.println("package name must not be empty");
            return;
        }
        if (null == tableNames || tableNames.length == 0){
            System.err.println("at least one table needs to be generated");
            return;
        }

        // 自定义需要填充的字段
        List<TableFill> tableFillList = new ArrayList<TableFill>();
        //如 每张表都有一个创建时间、修改时间
        //而且这基本上就是通用的了，新增时，创建时间和修改时间同时修改
        //修改时，修改时间会修改，
        //虽然像Mysql数据库有自动更新几只，但像ORACLE的数据库就没有了，
        //使用公共字段填充功能，就可以实现，自动按场景更新了。
        //如下是配置
        TableFill createField = new TableFill("gmt_create", FieldFill.INSERT);
        TableFill modifiedField = new TableFill("gmt_modified", FieldFill.INSERT_UPDATE);
        tableFillList.add(createField);
        tableFillList.add(modifiedField);

        // 代码生成器
        new AutoGenerator().setGlobalConfig(
                // 全局配置
                new GlobalConfig()
                        .setOutputDir(OUT_PATH)// 输出目录
                        .setFileOverride(false)// 是否覆盖文件
                        .setActiveRecord(true)// 开启 activeRecord 模式
                        .setEnableCache(false)// XML 二级缓存
                        .setBaseResultMap(false)// XML ResultMap
                        .setBaseColumnList(true)// XML columList
                        .setAuthor(AUTHOR)
                        //.setSwagger2(true)
                        // 自定义文件命名，注意 %s 会自动填充表实体属性！
                        .setXmlName("%sMapper")
                        .setMapperName("I%sDao")
                        .setServiceName("I%sService")
                        .setServiceImplName("%sServiceImpl")
                        .setControllerName("%sController")
        ).setDataSource(
                // 数据源配置
                new DataSourceConfig()
                        .setDbType(DbType.MYSQL)// 数据库类型
                        .setTypeConvert(new MySqlTypeConvert())
                        .setDriverName(DRIVER)
                        .setUsername(USER_NAME)
                        .setPassword(PASSWORD)
                        .setUrl(URL)
        ).setStrategy(
                // 策略配置
                new StrategyConfig()
                        // .setCapitalMode(true)// 全局大写命名
                        //.setDbColumnUnderline(true)// 全局下划线命名
                        .setTablePrefix(TABLE_PREFIXS)// 此处可以修改为您的表前缀
                        .setNaming(NamingStrategy.underline_to_camel)// 表名生成策略
                        .setInclude(tableNames) // 需要生成的表
                        .setEntityTableFieldAnnotationEnable(true)
                        // .setExclude(new String[]{"test"}) // 排除生成的表
                        // 自定义实体，公共字段
                        // .setSuperEntityColumns(new String[]{"test_id"})
                        //.setTableFillList(tableFillList)
                        // 自定义实体父类
                        // .setSuperEntityClass("com.baomidou.demo.base.BsBaseEntity")
                        // // 自定义 mapper 父类
                        // .setSuperMapperClass("com.baomidou.demo.base.BsBaseMapper")
                        // // 自定义 service 父类
                        // .setSuperServiceClass("com.baomidou.demo.base.BsBaseService")
                        // // 自定义 service 实现类父类
                        // .setSuperServiceImplClass("com.baomidou.demo.base.BsBaseServiceImpl")
                        // 自定义 controller 父类
                        // .setSuperControllerClass("com.baomidou.demo.TestController")
                        // 【实体】是否生成字段常量（默认 false）
                        // public static final String ID = "test_id";
                        .setEntityColumnConstant(true)
                        // 【实体】是否为构建者模型（默认 false）
                        // public User setName(String name) {this.name = name; return this;}
                        .setEntityBuilderModel(true)
                        // 【实体】是否为lombok模型（默认 false）<a href="https://projectlombok.org/">document</a>
                        .setEntityLombokModel(true)
                // Boolean类型字段是否移除is前缀处理
                // .setEntityBooleanColumnRemoveIsPrefix(true)
                // .setRestControllerStyle(true)
                // .setControllerMappingHyphenStyle(true)
        ).setPackageInfo(
                // 包配置
                new PackageConfig()
                        .setModuleName(moduleName)
                        .setParent(packageName)// 自定义包路径
                        .setController("controller")// 这里是控制器包名，默认 web
                        .setXml("mapper")
                        .setMapper("dao")

        ).setCfg(
                // 注入自定义配置，可以在 VM 中使用 cfg.abc 设置的值
                new InjectionConfig() {
                    @Override
                    public void initMap() {
                        /*Map<String, Object> map = new HashMap<String, Object>();
                        map.put("abc", this.getConfig().getGlobalConfig().getAuthor() + "-mp");
                        this.setMap(map);*/
                    }
                }.setFileOutConfigList(
                        Collections.<FileOutConfig>singletonList(new FileOutConfig("/templates/mapper.xml.vm") {
                            // 自定义输出文件目录
                            @Override
                            public String outputFile(TableInfo tableInfo) {
                                return OUT_PATH + "/../resources/mapper/" + tableInfo.getEntityName() + "Mapper.xml";
                            }
                        })
                )
        ).setTemplate(
                // 关闭默认 xml 生成，调整生成 至 根目录
                new TemplateConfig().setXml(null)
                // 自定义模板配置，模板可以参考源码 /mybatis-plus/src/main/resources/template 使用 copy
                // 至您项目 src/main/resources/template 目录下，模板名称也可自定义如下配置：
                // .setController("...");
                // .setEntity("...");
                // .setMapper("...");
                // .setXml("...");
                // .setService("...");
                // .setServiceImpl("...");
        ).execute();
    }
}
