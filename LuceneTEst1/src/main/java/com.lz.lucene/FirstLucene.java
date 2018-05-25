package com.lz.lucene;

import com.sun.org.apache.xerces.internal.impl.io.UTF8Reader;
import org.apache.commons.io.Charsets;
import org.apache.commons.io.FileUtils;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.*;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;


/**
 * 入门
 */
public class FirstLucene {
    @Test
    public void testIndex() throws Exception {
        //创建索引
        Directory directory = FSDirectory.open(Paths.get("D:\\temp\\index"));
        //分词器 官方推荐
        StandardAnalyzer analyzer = new StandardAnalyzer();
        IndexWriterConfig config = new IndexWriterConfig(analyzer);
        IndexWriter indexWriter = new IndexWriter(directory, config);
        //document类
        File f = new File("D:\\temp\\document");
        Document doc = new Document();
        File[] files = f.listFiles();
        for (File file : files) {
            //文件名称
            String name = file.getName();
            Field filename = new TextField("filename", name, Field.Store.YES);
            //文件大小
            long size = FileUtils.sizeOf(file);
            Field filesize = new LongField("filesize", size, Field.Store.YES);
            //文件路径
            String path = file.getPath();
            Field filepath = new StoredField("filepath", path);
            //文件内容
            String content = FileUtils.readFileToString(file, Charsets.toCharset("utf-8"));
            Field filecontent = new TextField("filecontent", content, Field.Store.YES);
            doc.add(filename);
            doc.add(filesize);
            doc.add(filepath);
            doc.add(filecontent);
            indexWriter.addDocument(doc);
        }
        indexWriter.close();
    }


}
