package gyqw.playground.hanlp.demo;

import com.hankcs.hanlp.mining.cluster.ClusterAnalyzer;

/**
 * @author fred
 * 2019-03-21 4:35 PM
 */
public class DemoTextClusteringFMeasure {

    public static void main(String[] args) {
        String corpusFolder = "data/test/搜狗文本分类语料库迷你版";

        for (String algorithm : new String[]{"kmeans", "repeated bisection"}) {
            System.out.printf("%s F1=%.2f\n", algorithm, ClusterAnalyzer.evaluate(corpusFolder, algorithm) * 100);
        }
    }
}