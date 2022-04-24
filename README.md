#### 目标：
读取一个目录下的docx文件，并按一个或多个关键字搜索，
然后把搜索到的关键字用不同的颜色高亮并加粗显示。
然后新建一个文件夹，存储成同名的新的文档。
### 依赖：
安装有java的机器，可以直接安装jdk1.8.
https://www.oracle.com/java/technologies/downloads/
### 使用方式：
```bash
jar包地址：https://github.com/student2028/datahub/blob/main/jars/wordsearch-1.0-SNAPSHOT.jar
java -jar wordsearch-1.0-SNAPSHOT.jar style /Users/student2028/Downloads/doc/
可以接受两个参数
第一个参数是 关键字列表，支持|,;作为分隔符。 示例中是 style 可以是 Are|You|OK
第二个参数是文件名或者文件夹路径，如果不填写，就在当前路径中查找.docx文件
```
当前查找不区分大小写.
可以进一步封装成cmd 或者 bash命令，直接接收两个参数即可。
效果是会在Downloads下面生成一个名字为new的文件夹，然后把/doc里面的docx文件按要求处理后存储成同名
的文件。