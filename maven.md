#### Apache Maven
Maven是一个用于构建项目,管理项目以及下载依赖的工具，类似Maven的工具还有Ant，nodejs的npm，gnu make等等。Maven提供了开发人员构建一个完整的生命周期框架。开发团队可以自动完成项目的基础工具建设，Maven使用标准的目录结构和默认构建生命周期。Maven让开发人员的工作更轻松，同时创建报表，检查，构建和测试自动化设置。Maven简化和标准化项目建设过程。处理编译，分配，文档，团队协作和其他任务的无缝连接。
#### Maven的生命周期
maven的生命周期分为clean生命周期，default生命周期和site生命周期。
#### default生命周期

|  生命周期名称   | 生命周期描述描述  |
|  ----  | ----  |
|validate|验证整个工程的正确性以及必要信息是否可用|
|initialize|初始化构建状态，设置属性以及创建目录|
|generate-sources|生成应用需要的额外源代码|
|process-resources|处理源代码，如过滤一些值|
|generate-resources|生成打包过程中的资源文件|
|compile|编译项目的源码|
|process-class|后处理编译的文件，如字节码增强|
|generate-test-sources|生成测试的资源文件|
|process-test-resource|复制资源文件到目标文件夹|
|test-compile|编译测试代码|
|process-test-class|后处理编译的测试文件,如字节码增强|
|test|运行测试|
|prepare-package|做一些打包钱的准备|
|package|打包项目到执行的格式，如jar，war|
|integration-test|如果有必要的话，处理包并发布至集成测试可以运行的环境|
|verify|执行所有检查，验证包是有效的|
|install|将最终的包安装到本地仓库|
|deploy|复制最终的包到远程仓库以便其他开发者使用|

#### clean生命周期
|  生命周期名称   | 生命周期描述描述  |
|  ----  | ----  |
|pre-clean|执行清理前需要运行的进程|
|clean|清除上次构建生成的所有文件|
|post-clean|执行清除的后处理操作|

#### site生命周期
|  生命周期名称   | 生命周期描述描述  |
|  ----  | ----  |
|pre-site|执行生成site前所需运行的进程|
|site|生成site文档|
|post-site|执行site生成后操作|
|site-deploy|将生成的文档复制到远程服务器|

#### Maven常用命令
* mvn clean：清除项目上一次构建生成的所有文件，通常在target文件夹下。
* mvn compile： 编译项目。
* mvn package： 打包项目，通常指定打包为jar，war等。
* mvn install:  打包项目，并安装到本地仓库。