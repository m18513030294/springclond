package com.lz.lucene;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.junit.jupiter.api.Test;

/**
 * 增、删、改、查
 */
public class SolrJ {
    @Test
    public void testAdd() throws Exception {
        String baseUrl = "http://localhost:8080/solr/";
        SolrServer solrServer = new HttpSolrServer(baseUrl);

        //添加
        SolrInputDocument doc = new SolrInputDocument();
        doc.setField("id", "hah");
        solrServer.add(doc);
        solrServer.commit();
    }

    @Test
    public void testSearch() throws Exception {
        String baseUrl = "http://localhost:8080/solr/";
        SolrServer solrServer = new HttpSolrServer(baseUrl);
        SolrQuery solrQuery = new SolrQuery();
        solrQuery.set("q", "*:*");
        QueryResponse response = solrServer.query(solrQuery);
        SolrDocumentList results = response.getResults();
        long numFound = results.getNumFound();
        System.out.println(numFound);
        for (SolrDocument doc : results
                ) {
            System.out.println(doc.get("id"));
        }
    }

}
