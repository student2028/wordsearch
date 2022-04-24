
import com.spire.doc.*;
import com.spire.doc.documents.TextSelection;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class FindAndHighlightTextInPara {
    public static void main(String[] args) throws IOException {
        //接收两个参数  第一个是关键字列表 第二个是文件名 如果没有文件名，则扫描当前目录下的文件
        if (args.length < 1) {
            System.out.println("请输入关键字列表");
            System.out.println("请输入关键字列表 和 待处理的文件名");
            System.exit(0);
        }

        String keywords = args[0];
        String filePath = ".";
        if(args.length>1) filePath = args[1];
        File baseFile = new File(filePath);
        File[] files = null;
        String baseFolder = ".";
        if(baseFile.isDirectory()) {//如果传入的参数是目录 即处理当前目录下的所有docx文件
            files =  baseFile.listFiles((d,n)-> n.toLowerCase().endsWith(".docx"));
            baseFolder = baseFile.getParent();
        } else {
            files = new File[1];
            files[0] = baseFile; //假定只有一个文件
            baseFolder = baseFile.getParent();
         }
        //create new folder if not exists
        File newFolder = new File(baseFolder + "/new/");
        if(!newFolder.exists()) newFolder.mkdir();

        for(File file : files) {
            Document document = new Document();
            document.loadFromFile(file.getPath());
            System.out.println(file.getPath());
            setColorForKeyWord(document, keywords);
            document.saveToFile( baseFolder + "/new/" + file.getName(), FileFormat.Docx_2013);
            document.dispose();
        }

    }

    static void setColorForKeyWord(Document doc, String keywords) {
        String[] kws = keywords.split("[,|;]");
        int i = 0;
        Color[] colors = {Color.yellow, Color.cyan, Color.green, Color.magenta, Color.red, Color.gray, Color.BLUE};
        for (String kw : kws) {
            TextSelection[] textSelections = doc.findAllString(kw, false, false);
            for (TextSelection selection : textSelections) {
                selection.getAsOneRange().getCharacterFormat().setHighlightColor(colors[i]);
                selection.getAsOneRange().getCharacterFormat().setBold(true);
            }
            i++;
            i %= 7;
        }
    }
}

